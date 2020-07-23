package org.truenewx.tnxsample.facade.web.view.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.springframework.context.annotation.Configuration;
import org.truenewx.tnxjee.web.view.config.WebViewMvcConfigurerSupport;

@Configuration
public class WebMvcConfig extends WebViewMvcConfigurerSupport {

    @Override
    protected void buildSiteMeshFilter(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPaths("/*", "/public/decorator/default.jsp", "/static/libs.jsp");
    }

}
