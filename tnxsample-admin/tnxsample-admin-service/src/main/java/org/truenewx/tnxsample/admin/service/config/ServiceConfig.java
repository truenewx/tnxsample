package org.truenewx.tnxsample.admin.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.truenewx.tnxjee.core.util.concurrent.DefaultThreadPoolExecutor;
import org.truenewx.tnxjeex.fss.service.config.OwnFssServiceConfig;

import java.util.concurrent.Executor;

/**
 * 服务层配置
 *
 * @author jianglei
 */
@Configuration
@EnableTransactionManagement
@Import(OwnFssServiceConfig.class)
public class ServiceConfig {

    @Bean(name = "defaultExecutor")
    @Primary
    public Executor defaultExecutor() {
        return new DefaultThreadPoolExecutor(4, 16);
    }

}
