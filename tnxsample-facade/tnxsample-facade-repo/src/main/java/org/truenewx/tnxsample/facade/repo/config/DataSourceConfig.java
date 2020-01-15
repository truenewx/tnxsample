package org.truenewx.tnxsample.facade.repo.config;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.truenewx.tnxjee.repo.jpa.config.JpaDataSourceConfigurationSupport;
import org.truenewx.tnxjee.repo.support.DataAccessTemplate;

/**
 * 数据源配置
 *
 * @author jianglei
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "org.truenewx.tnxsample.facade.repo")
public class DataSourceConfig extends JpaDataSourceConfigurationSupport {

    @Override
    @Bean
    @Profile({ "local", "dev", "test", "product" })
    public DataSource dataSource() {
        return super.dataSource();
    }

    @Bean
    @Profile("junit")
    public DataSource embeddedDataSource() throws Exception {
        return super.embeddedDataSource("/META-INF/sql/junit/schema.sql", "/META-INF/sql/junit/data.sql");
    }

    @Override
    protected String[] getMappingResources() {
        List<String> resources = scanDefaultMappingResources();
        return resources.toArray(new String[resources.size()]);
    }

    @Override
    @Bean
    public FactoryBean<EntityManagerFactory> entityManagerFactory(EntityManagerFactoryBuilder builder) {
        return super.entityManagerFactory(builder);
    }

    @Override
    @Bean
    public DataAccessTemplate dataAccessTemplate(EntityManagerFactoryBuilder builder) throws Exception {
        return super.dataAccessTemplate(builder);
    }

}
