package org.truenewx.tnxsample.admin.repo.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.truenewx.tnxjee.repo.mongo.config.MongoConfigSupport;
import org.truenewx.tnxjee.repo.mongo.support.MongoAccessTemplate;
import org.truenewx.tnxsample.admin.LocalApplication;

/**
 * MongoDB数据源配置
 *
 * @author jianglei
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.mongo")
@EnableMongoRepositories(basePackages = "org.truenewx.tnxsample.admin.repo.mongo")
public class MongoDataSourceConfig extends MongoConfigSupport {

    @Override
    protected Collection<String> getMappingBasePackages() {
        return Arrays.asList(LocalApplication.class.getPackage().getName());
    }

    @Override
    @Bean
    public MongoAccessTemplate mongoAccessTemplate() throws Exception {
        return super.mongoAccessTemplate();
    }

}
