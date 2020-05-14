package org.truenewx.tnxsample.admin.web.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.truenewx.tnxjee.Framework;
import org.truenewx.tnxjeex.cas.client.CasClientModule;
import org.truenewx.tnxsample.admin.AppRoot;

/**
 * 管理端Web应用
 *
 * @author jianglei
 */
@EnableCaching
@SpringBootApplication(scanBasePackageClasses = { Framework.class, CasClientModule.class, AppRoot.class })
public class AdminApiApp {

    public static void main(String[] args) {
        SpringApplication.run(AdminApiApp.class, args);
    }

}
