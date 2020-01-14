package org.truenewx.tnxsample.facade.repo.domain;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.truenewx.tnxjee.core.caption.Caption;
import org.truenewx.tnxsample.facade.model.domain.User;
import org.truenewx.tnxsample.facade.repo.test.RepoTestSupport;

/**
 * UserRepoTest
 *
 * @author jianglei
 */
public class UserRepoTest extends RepoTestSupport {

    @Autowired
    private UserRepo repo;

    @Test
    @Caption("测试：根据手机号码查找用户")
    public void findByMobilePhoneTest() {
        String mobilePhone = getFirstData(User.class).getMobilePhone();
        User user = this.repo.findByMobilePhone(mobilePhone);
        Assert.assertEquals(mobilePhone, user.getMobilePhone());
    }

}
