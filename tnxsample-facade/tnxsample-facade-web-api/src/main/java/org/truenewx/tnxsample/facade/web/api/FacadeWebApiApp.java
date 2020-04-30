package org.truenewx.tnxsample.facade.web.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.mongo.config.annotation.web.http.EnableMongoHttpSession;
import org.truenewx.tnxjee.Framework;
import org.truenewx.tnxsample.common.CommonConstants;
import org.truenewx.tnxsample.facade.AppRoot;

/**
 * 门户Web应用
 *
 * @author jianglei
 */
@EnableCaching
@EnableMongoHttpSession(maxInactiveIntervalInSeconds = 900, collectionName = CommonConstants.SESSION_COLLECTION_NAME)
@SpringBootApplication(scanBasePackageClasses = { Framework.class, AppRoot.class })
public class FacadeWebApiApp {

    public static void main(String[] args) {
        SpringApplication.run(FacadeWebApiApp.class, args);
    }

}
