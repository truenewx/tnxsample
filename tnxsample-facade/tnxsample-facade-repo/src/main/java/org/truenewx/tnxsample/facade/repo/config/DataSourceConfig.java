package org.truenewx.tnxsample.facade.repo.config;

import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.truenewx.tnxjee.repo.jpa.config.JpaConfigSupport;
import org.truenewx.tnxjee.repo.jpa.support.JpaAccessTemplate;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * 数据源配置
 *
 * @author jianglei
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "org.truenewx.tnxsample.facade.repo")
public class DataSourceConfig extends JpaConfigSupport {

    @Bean
    @Profile({"local", "test", "product"})
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariDataSource hikariDataSource() {
        return new HikariDataSource();
    }

    @Override
    @Primary
    @Bean("dataSource")
    @DependsOn("springUtils")
    @Profile({"local", "test", "product"})
    public DataSource dataSource() {
        return new DataSourceProxy(hikariDataSource());
    }

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
