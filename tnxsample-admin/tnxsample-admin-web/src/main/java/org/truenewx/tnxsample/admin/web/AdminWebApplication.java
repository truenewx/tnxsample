package org.truenewx.tnxsample.admin.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.truenewx.tnxjee.Framework;
import org.truenewx.tnxsample.admin.AdminApp;

/**
 * 管理端Web应用
 *
 * @author jianglei
 */
@EnableCaching
@SpringBootApplication(scanBasePackageClasses = { Framework.class, AdminApp.class })
@EnableDiscoveryClient // 开启Eureka客户端发现功能
public class AdminWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminWebApplication.class, args);
    }

}
