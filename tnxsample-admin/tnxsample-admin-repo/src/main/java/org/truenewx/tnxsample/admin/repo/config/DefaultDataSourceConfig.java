package org.truenewx.tnxsample.admin.repo.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.truenewx.tnxjee.repo.jpa.config.JpaConfigSupport;
import org.truenewx.tnxjee.repo.jpa.support.JpaAccessTemplate;

/**
 * 默认数据源配置
 *
 * @author jianglei
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "org.truenewx.tnxsample.admin.repo")
public class DefaultDataSourceConfig extends JpaConfigSupport {

    @Bean
    @Profile("junit")
    public DataSource embeddedDataSource() throws Exception {
        return super.embeddedDataSource("/META-INF/sql/junit/schema.sql", "/META-INF/sql/junit/data.sql");
    }

    @Override
    @Bean
    public FactoryBean<EntityManagerFactory> entityManagerFactory(EntityManagerFactoryBuilder builder) {
        return super.entityManagerFactory(builder);
    }

    @Override
    @Bean
    public JpaAccessTemplate jpaAccessTemplate(EntityManagerFactory entityManagerFactory) {
        return super.jpaAccessTemplate(entityManagerFactory);
    }

}
