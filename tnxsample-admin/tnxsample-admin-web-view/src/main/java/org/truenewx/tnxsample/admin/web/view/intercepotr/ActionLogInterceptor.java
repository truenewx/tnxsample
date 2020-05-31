package org.truenewx.tnxsample.admin.web.view.intercepotr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;
import org.truenewx.tnxjee.web.security.util.SecurityUtil;
import org.truenewx.tnxjee.web.util.WebUtil;
import org.truenewx.tnxjee.web.menu.model.Menu;
import org.truenewx.tnxsample.admin.model.entity.Action;
import org.truenewx.tnxsample.admin.web.view.annotation.LogExcluded;
import org.truenewx.tnxsample.admin.web.view.rpc.ManagerActionLogClient;

/**
 * 操作日志拦截器
 *
 * @author jianglei
 */
public class ActionLogInterceptor<K extends Serializable> implements HandlerInterceptor {

    @Autowired
    private Executor executor;
    @Autowired
    private ManagerActionLogClient managerActionLogClient;

    private List<RequestMatcher> excludedUrlPatterns = new ArrayList<>();

    public void setExcludedUrlPatterns(List<RequestMatcher> excludedUrlPatterns) {
        this.excludedUrlPatterns.clear();
        this.excludedUrlPatterns.addAll(excludedUrlPatterns);
    }

    public void addExcludedUrlPattern(String pattern, HttpMethod method) {
        this.excludedUrlPatterns.add(new AntPathRequestMatcher(pattern, method.name()));
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // 请求失败或为include请求则忽略当前拦截器
        if (response.getStatus() != HttpServletResponse.SC_OK
                || WebUtils.isIncludeRequest(request)) {
            return;
        }
        // 未登录的请求不需要记录日志，忽略
        if (SecurityUtil.getAuthorizedUserIdentity() == null) {
            return;
        }
        // 包含在排除清单中则忽略
        for (RequestMatcher matcher : this.excludedUrlPatterns) {
            if (matcher.matches(request)) {
                return;
            }
        }
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            LogExcluded logExcluded = handlerMethod.getMethodAnnotation(LogExcluded.class);
            if (logExcluded != null && logExcluded.value()) { // 整个方法都被排除
                return;
            }
            String url = WebUtil.getRelativeRequestUrl(request);
            String httpMethod = request.getMethod();
            String caption = getActionCaption(url, httpMethod, handlerMethod);
            // 无法取得操作的显示名称也忽略
            if (caption == null) {
                return;
            }
            Map<String, Object> params;
            if (logExcluded != null) {
                params = WebUtil.getRequestParameterMap(request, logExcluded.excluded());
            } else {
                params = WebUtil.getRequestParameterMap(request);
            }
            Action action = new Action(caption, url, httpMethod, params);
            // 在创建线程提交执行之前获取菜单和请求参数，以免线程执行环境无法获取
            this.executor.execute(() -> {
                ActionLogInterceptor.this.managerActionLogClient.add(action);
            });
        }
    }

    private String getActionCaption(String url, String httpMethod, HandlerMethod handlerMethod) {
        Menu menu = getMenu();
        if (menu != null) {

        }
        return null;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
            Object handler, Exception ex) throws Exception {
    }

    protected Menu getMenu() {
        return null;
    }
}
