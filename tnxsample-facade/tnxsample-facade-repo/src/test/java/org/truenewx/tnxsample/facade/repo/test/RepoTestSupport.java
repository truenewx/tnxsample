package org.truenewx.tnxsample.facade.repo.test;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.truenewx.tnxjee.Framework;
import org.truenewx.tnxjee.test.repo.support.RepoSpringTestSupport;
import org.truenewx.tnxsample.facade.FacadeApp;

/**
 * Repo测试支持
 *
 * @author jianglei
 */
@ActiveProfiles("junit")
@ContextConfiguration(classes = { Framework.class, FacadeApp.class })
public abstract class RepoTestSupport extends RepoSpringTestSupport {
}
