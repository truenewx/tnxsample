package org.truenewx.tnxsample.fss.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.truenewx.tnxjee.webmvc.security.config.WebMvcSecurityConfigurerSupport;
import org.truenewx.tnxjeex.cas.client.config.CasClientProperties;

@Configuration
public class WebSecurityConfig extends WebMvcSecurityConfigurerSupport {

    @Autowired
    private CasClientProperties casClientProperties;

    @Override
    public String getLoginFormUrl() {
        return this.casClientProperties.getLoginFormUrl();
    }

    @Override
    protected String getLogoutSuccessUrl() {
        return this.casClientProperties.getLogoutProcessUrl(); // 本地登出后跳转到CAS服务端执行登出
    }
}
