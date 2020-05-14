package org.truenewx.tnxsample.fss.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.truenewx.tnxjee.Framework;
import org.truenewx.tnxjeex.fss.FssModule;
import org.truenewx.tnxsample.fss.AppRoot;

/**
 * 文件存储服务应用
 *
 * @author jianglei
 */
@EnableCaching
@SpringBootApplication(scanBasePackageClasses = { Framework.class, AppRoot.class, FssModule.class })
public class FssWebApp {

    public static void main(String[] args) {
        SpringApplication.run(FssWebApp.class, args);
    }

}
