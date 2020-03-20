package org.truenewx.tnxsample.admin.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.truenewx.tnxjee.Framework;
import org.truenewx.tnxsample.admin.AdminApp;

/**
 * 管理端Web应用
 *
 * @author jianglei
 */
@SpringBootApplication(scanBasePackageClasses = { Framework.class, AdminApp.class })
public class AdminWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminWebApplication.class, args);
    }

}
