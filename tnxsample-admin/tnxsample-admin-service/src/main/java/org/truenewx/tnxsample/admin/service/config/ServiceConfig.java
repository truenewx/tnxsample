package org.truenewx.tnxsample.admin.service.config;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.truenewx.tnxjee.core.util.concurrent.DefaultThreadPoolExecutor;
import org.truenewx.tnxjeex.fss.service.FssAuthorizer;
import org.truenewx.tnxjeex.fss.service.FssLocalAccessor;
import org.truenewx.tnxjeex.fss.service.FssProviderAccessor;
import org.truenewx.tnxjeex.fss.service.own.OwnFssAccessor;
import org.truenewx.tnxjeex.fss.service.own.OwnFssAuthorizer;

/**
 * 服务层配置
 *
 * @author jianglei
 */
@Configuration
public class ServiceConfig {

    @Bean(name = "defaultExecutor")
    @Primary
    public Executor defaultExecutor() {
        return new DefaultThreadPoolExecutor(4, 16);
    }

    @Bean
    public FssLocalAccessor localAccessor(@Value("${tnxjeex.fss.accessor.local_root}") String root) {
        return new FssLocalAccessor(root);
    }

    @Bean
    public FssProviderAccessor accessor(FssLocalAccessor localAccessor) {
        OwnFssAccessor accessor = new OwnFssAccessor();
        accessor.setLocalAccessor(localAccessor);
        return accessor;
    }

    @Bean
    public FssAuthorizer authorizer() {
        return new OwnFssAuthorizer();
    }

}
