package org.truenewx.tnxsample.admin.web.view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.mongo.config.annotation.web.http.EnableMongoHttpSession;
import org.truenewx.tnxjee.Framework;
import org.truenewx.tnxsample.admin.AppRoot;
import org.truenewx.tnxsample.common.CommonConstants;

@EnableCaching
@EnableMongoHttpSession(maxInactiveIntervalInSeconds = 900, collectionName = CommonConstants.SESSION_COLLECTION_NAME)
@SpringBootApplication(scanBasePackageClasses = { Framework.class, AppRoot.class })
public class AdminWebViewApp {

    public static void main(String[] args) {
        SpringApplication.run(AdminWebViewApp.class, args);
    }

}
