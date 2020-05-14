package org.truenewx.tnxsample.facade.web.view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.truenewx.tnxjee.Framework;
import org.truenewx.tnxsample.facade.AppRoot;

@EnableCaching
@SpringBootApplication(scanBasePackageClasses = { Framework.class, AppRoot.class })
public class FacadeWebViewApp {

    public static void main(String[] args) {
        SpringApplication.run(FacadeWebViewApp.class, args);
    }

}
