package org.truenewx.tnxsample.admin.repo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.truenewx.tnxjee.repo.jpa.config.JpaConfigSupport;
import org.truenewx.tnxjee.repo.jpa.support.JpaAccessTemplate;
import org.truenewx.tnxsample.admin.repo.RepoAnchor;

import javax.persistence.EntityManagerFactory;

/**
 * 默认数据源配置
 *
 * @author jianglei
 */
@Configuration
@EnableJpaRepositories(basePackageClasses = RepoAnchor.class)
public class JpaDataSourceConfig extends JpaConfigSupport {

    @Override
    @Bean
    public JpaAccessTemplate jpaAccessTemplate(EntityManagerFactory entityManagerFactory) {
        return new JpaAccessTemplate(entityManagerFactory);
    }

}
