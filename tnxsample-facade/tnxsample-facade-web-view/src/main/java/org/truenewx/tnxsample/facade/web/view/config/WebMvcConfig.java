package org.truenewx.tnxsample.facade.web.view.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.springframework.context.annotation.Configuration;
import org.truenewx.tnxjee.web.view.config.WebViewMvcConfigurationSupport;

@Configuration
public class WebMvcConfig extends WebViewMvcConfigurationSupport {

    @Override
    protected void buildSiteMeshFilter(SiteMeshFilterBuilder builder) {
        builder.addExcludedPath("**/*.json");
        builder.addDecoratorPath("**/*.win", "/decorator/win.jsp");
        builder.addDecoratorPath("/*", "/decorator/default.jsp");
    }

}
