package org.truenewx.tnxsample.facade.web.view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.mongo.config.annotation.web.http.EnableMongoHttpSession;
import org.truenewx.tnxjee.Framework;
import org.truenewx.tnxjeex.cas.client.CasClientModule;
import org.truenewx.tnxsample.common.CommonConstants;
import org.truenewx.tnxsample.facade.AppRoot;

@EnableCaching
@EnableFeignClients
@EnableMongoHttpSession(maxInactiveIntervalInSeconds = CommonConstants.SESSION_TIMEOUT, collectionName = CommonConstants.SESSION_COLLECTION_NAME)
@SpringBootApplication(scanBasePackageClasses = { Framework.class, CasClientModule.class, AppRoot.class })
public class FacadeViewApp {

    public static void main(String[] args) {
        SpringApplication.run(FacadeViewApp.class, args);
    }

}
