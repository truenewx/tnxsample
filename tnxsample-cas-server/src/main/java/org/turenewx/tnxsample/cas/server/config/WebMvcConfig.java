package org.turenewx.tnxsample.cas.server.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.springframework.context.annotation.Configuration;
import org.truenewx.tnxjeex.cas.server.config.CasServerMvcConfigSupport;

@Configuration
public class WebMvcConfig extends CasServerMvcConfigSupport {

    @Override
    protected void buildSiteMeshFilter(SiteMeshFilterBuilder builder) {
        super.buildSiteMeshFilter(builder);
        builder.addExcludedPath("**/*.json");
        // 先装饰头部和脚部，再装饰依赖组件和样式
        builder.addDecoratorPaths("/*", "/public/decorator/default.jsp", "/index.html");
    }

}
