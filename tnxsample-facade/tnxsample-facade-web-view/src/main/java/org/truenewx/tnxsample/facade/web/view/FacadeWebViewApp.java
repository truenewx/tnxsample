package org.truenewx.tnxsample.facade.web.view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.mongo.config.annotation.web.http.EnableMongoHttpSession;
import org.truenewx.tnxjee.Framework;
import org.truenewx.tnxsample.facade.FacadeApp;

@EnableCaching
@EnableMongoHttpSession(maxInactiveIntervalInSeconds = 900, collectionName = "customer_session")
@SpringBootApplication(scanBasePackageClasses = { Framework.class, FacadeApp.class })
public class FacadeWebViewApp {

    public static void main(String[] args) {
        SpringApplication.run(FacadeWebViewApp.class, args);
    }

}
