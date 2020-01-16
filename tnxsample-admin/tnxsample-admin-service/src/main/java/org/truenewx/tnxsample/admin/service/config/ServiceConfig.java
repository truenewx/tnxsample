package org.truenewx.tnxsample.admin.service.config;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.truenewx.tnxjee.core.util.concurrent.DefaultThreadPoolExecutor;
import org.truenewx.tnxjeex.unstructured.service.UnstructuredAuthorizer;
import org.truenewx.tnxjeex.unstructured.service.UnstructuredLocalAccessor;
import org.truenewx.tnxjeex.unstructured.service.UnstructuredProviderAccessor;
import org.truenewx.tnxjeex.unstructured.service.own.OwnUnstructuredAccessor;
import org.truenewx.tnxjeex.unstructured.service.own.OwnUnstructuredAuthorizer;

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
    public UnstructuredLocalAccessor localAccessor(
            @Value("${tnxjeex.unstructured.accessor.local_root}") String root) {
        return new UnstructuredLocalAccessor(root);
    }

    @Bean
    public UnstructuredProviderAccessor accessor(UnstructuredLocalAccessor localAccessor) {
        OwnUnstructuredAccessor accessor = new OwnUnstructuredAccessor();
        accessor.setLocalAccessor(localAccessor);
        return accessor;
    }

    @Bean
    public UnstructuredAuthorizer authorizer() {
        return new OwnUnstructuredAuthorizer();
    }

}
