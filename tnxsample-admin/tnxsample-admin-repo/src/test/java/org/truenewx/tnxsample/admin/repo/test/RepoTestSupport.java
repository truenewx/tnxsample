package org.truenewx.tnxsample.admin.repo.test;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.truenewx.tnxjee.Framework;
import org.truenewx.tnxjee.test.repo.support.RepoSpringTestSupport;
import org.truenewx.tnxsample.admin.AdminApp;

/**
 * Repo测试支持
 *
 * @author jianglei
 */
@ActiveProfiles("junit")
@ContextConfiguration(classes = { Framework.class, AdminApp.class })
public abstract class RepoTestSupport extends RepoSpringTestSupport {
}
