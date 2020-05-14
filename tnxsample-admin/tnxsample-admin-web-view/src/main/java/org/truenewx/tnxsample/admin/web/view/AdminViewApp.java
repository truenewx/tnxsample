package org.truenewx.tnxsample.admin.web.view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.truenewx.tnxjee.Framework;
import org.truenewx.tnxjeex.cas.client.CasClientModule;
import org.truenewx.tnxsample.admin.AppRoot;

@EnableCaching
@EnableFeignClients
@SpringBootApplication(scanBasePackageClasses = { Framework.class, CasClientModule.class, AppRoot.class })
public class AdminViewApp {

    public static void main(String[] args) {
        SpringApplication.run(AdminViewApp.class, args);
    }

}
