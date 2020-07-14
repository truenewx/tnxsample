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
        builder.addDecoratorPaths("/*", "/public/decorator/default.jsp", "/static/libs.jsp");
    }

}
