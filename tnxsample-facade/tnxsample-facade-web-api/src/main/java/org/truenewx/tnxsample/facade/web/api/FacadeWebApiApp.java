package org.truenewx.tnxsample.facade.web.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.mongo.config.annotation.web.http.EnableMongoHttpSession;
import org.truenewx.tnxjee.Framework;
import org.truenewx.tnxsample.core.util.CommonConstants;
import org.truenewx.tnxsample.facade.FacadeApp;

/**
 * 门户Web应用
 *
 * @author jianglei
 */
@EnableMongoHttpSession(maxInactiveIntervalInSeconds = 900, collectionName = CommonConstants.SESSION_COLLECTION_NAME)
@SpringBootApplication(scanBasePackageClasses = { Framework.class, FacadeApp.class })
public class FacadeWebApiApp {

    public static void main(String[] args) {
        SpringApplication.run(FacadeWebApiApp.class, args);
    }

}
