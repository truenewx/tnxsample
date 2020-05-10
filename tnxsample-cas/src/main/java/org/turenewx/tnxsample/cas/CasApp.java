package org.turenewx.tnxsample.cas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.truenewx.tnxjee.Framework;
import org.truenewx.tnxjeex.cas.server.CasServerModule;

@EnableCaching
@EnableFeignClients
@SpringBootApplication(scanBasePackageClasses = { Framework.class, CasServerModule.class, CasApp.class })
public class CasApp {

    public static void main(String[] args) {
        SpringApplication.run(CasApp.class, args);
    }

}
