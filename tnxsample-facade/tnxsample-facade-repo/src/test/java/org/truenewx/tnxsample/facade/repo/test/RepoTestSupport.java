package org.truenewx.tnxsample.facade.repo.test;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.truenewx.tnxjee.test.repo.support.RepoSpringTestSupport;
import org.truenewx.tnxsample.facade.AppRoot;

/**
 * Repo测试支持
 *
 * @author jianglei
 */
@ActiveProfiles("junit")
@ContextConfiguration(classes = AppRoot.class)
public abstract class RepoTestSupport extends RepoSpringTestSupport {
}
