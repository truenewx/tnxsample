package org.truenewx.tnxsample.fss.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.truenewx.tnxjeex.fss.service.config.OwnFssServiceConfig;

/**
 * 服务层配置
 *
 * @author jianglei
 */
@Configuration
@Import(OwnFssServiceConfig.class)
public class ServiceConfig {

}
