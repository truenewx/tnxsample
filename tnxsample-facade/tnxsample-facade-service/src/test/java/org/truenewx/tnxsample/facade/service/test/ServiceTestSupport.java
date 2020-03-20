package org.truenewx.tnxsample.facade.service.test;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.truenewx.tnxjee.Framework;
import org.truenewx.tnxjee.test.service.support.ServiceSpringTestSupport;
import org.truenewx.tnxsample.facade.FacadeApp;

/**
 * Service测试支持
 *
 * @author jianglei
 */
@ActiveProfiles("junit")
@ContextConfiguration(classes = { Framework.class, FacadeApp.class })
public abstract class ServiceTestSupport extends ServiceSpringTestSupport {
}
