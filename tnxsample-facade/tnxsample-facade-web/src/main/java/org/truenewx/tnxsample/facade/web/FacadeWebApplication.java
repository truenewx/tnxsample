package org.truenewx.tnxsample.facade.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.truenewx.tnxjee.Framework;
import org.truenewx.tnxsample.facade.LocalApplication;

/**
 * 门户Web应用
 *
 * @author jianglei
 */
@SpringBootApplication(scanBasePackageClasses = { Framework.class, LocalApplication.class })
public class FacadeWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacadeWebApplication.class, args);
    }

}
