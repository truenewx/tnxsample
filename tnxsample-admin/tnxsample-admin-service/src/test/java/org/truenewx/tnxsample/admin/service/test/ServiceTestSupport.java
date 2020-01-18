package org.truenewx.tnxsample.admin.service.test;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.truenewx.tnxjee.test.service.support.ServiceSpringTestSupport;
import org.truenewx.tnxsample.admin.AppRoot;

/**
 * Service测试支持
 *
 * @author jianglei
 */
@ActiveProfiles("junit")
@ContextConfiguration(classes = AppRoot.class)
public abstract class ServiceTestSupport extends ServiceSpringTestSupport {
}
