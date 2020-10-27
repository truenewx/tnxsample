package org.truenewx.tnxsample.admin.web.config;

import org.springframework.context.annotation.Configuration;
import org.truenewx.tnxjee.webmvc.api.swagger.SwaggerConfigSupport;
import org.truenewx.tnxsample.admin.web.controller.MainController;

@Configuration
public class SwaggerConfig extends SwaggerConfigSupport {

    @Override
    protected String getBasePackage() {
        return MainController.class.getPackageName();
    }

}
