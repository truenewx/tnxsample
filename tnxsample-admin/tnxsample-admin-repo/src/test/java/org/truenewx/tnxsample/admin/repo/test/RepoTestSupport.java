package org.truenewx.tnxsample.admin.repo.test;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.truenewx.tnxjee.test.repo.support.RepoSpringTestSupport;
import org.truenewx.tnxsample.admin.LocalApplication;

/**
 * Repo测试支持
 *
 * @author jianglei
 */
@ActiveProfiles("junit")
@ContextConfiguration(classes = LocalApplication.class)
public abstract class RepoTestSupport extends RepoSpringTestSupport {
}
