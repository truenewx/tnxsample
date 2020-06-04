package org.truenewx.tnxsample.admin.web.view.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.springframework.context.annotation.Configuration;
import org.truenewx.tnxjee.web.view.config.WebViewMvcConfigurerSupport;

@Configuration
public class WebMvcConfig extends WebViewMvcConfigurerSupport {

    @Override
    protected void buildSiteMeshFilter(SiteMeshFilterBuilder builder) {
        builder.addExcludedPath("**/*.json");
        builder.addExcludedPath("**/*.html");
        builder.addExcludedPath("**/*.htm");
        builder.addDecoratorPath("**/*.win", "/decorator/win.jsp");
        builder.addDecoratorPath("/*", "/decorator/default.jsp");
    }

}
