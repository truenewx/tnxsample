package org.truenewx.tnxsample.facade.web.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.truenewx.tnxjee.Framework;
import org.truenewx.tnxsample.facade.AppRoot;

/**
 * 门户Web应用
 *
 * @author jianglei
 */
@EnableCaching
@SpringBootApplication(scanBasePackageClasses = { Framework.class, AppRoot.class })
public class FacadeWebApiApp {

    public static void main(String[] args) {
        SpringApplication.run(FacadeWebApiApp.class, args);
    }

}
