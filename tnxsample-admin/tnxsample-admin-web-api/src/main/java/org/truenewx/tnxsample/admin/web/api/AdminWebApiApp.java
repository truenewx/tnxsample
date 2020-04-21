package org.truenewx.tnxsample.admin.web.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.mongo.config.annotation.web.http.EnableMongoHttpSession;
import org.truenewx.tnxjee.Framework;
import org.truenewx.tnxsample.admin.AppRoot;
import org.truenewx.tnxsample.core.util.CommonConstants;

/**
 * 管理端Web应用
 *
 * @author jianglei
 */
@EnableCaching
@EnableMongoHttpSession(maxInactiveIntervalInSeconds = 900, collectionName = CommonConstants.SESSION_COLLECTION_NAME)
@SpringBootApplication(scanBasePackageClasses = { Framework.class, AppRoot.class })
public class AdminWebApiApp {

    public static void main(String[] args) {
        SpringApplication.run(AdminWebApiApp.class, args);
    }

}
