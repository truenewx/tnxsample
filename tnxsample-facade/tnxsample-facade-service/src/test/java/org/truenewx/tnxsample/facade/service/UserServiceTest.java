package org.truenewx.tnxsample.facade.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.truenewx.tnxjee.core.caption.Caption;
import org.truenewx.tnxjee.test.service.annotation.TestBusinessException;
import org.truenewx.tnxsample.facade.model.User;
import org.truenewx.tnxsample.facade.service.test.ServiceTestSupport;

/**
 * UserServiceTest
 *
 * @author jianglei
 */
public class UserServiceTest extends ServiceTestSupport {
    @Autowired
    private UserService service;

    @Test
    @Caption("测试：根据手机号码加载用户")
    public void loadByMobilePhoneTest() {
        User user0 = getData(User.class, 0);
        String mobilePhone = user0.getMobilePhone();
        User user = this.service.loadByMobilePhone(mobilePhone);
        assertEquals(mobilePhone, user.getMobilePhone());
        assertEquals(user0.getId(), user.getId());
    }

    @Test
    @Caption("测试：根据不存在的手机号码加载用户")
    @TestBusinessException(UserExceptionCodes.NO_MOBILE_PHONE)
    public void loadByNoMobilePhoneTest() {
        this.service.loadByMobilePhone("12312345678");
        fail();
    }

    @Test
    @Caption("测试：修改用户禁用状态")
    public void updateDisabledTest() {
        User user0 = getData(User.class, 0);
        boolean disabled = !user0.isDisabled();
        User user = this.service.updateDisabled(user0.getId(), disabled);
        assertEquals(disabled, user.isDisabled());
    }
}
