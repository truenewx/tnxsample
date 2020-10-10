package org.truenewx.tnxsample.root.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.truenewx.tnxjee.core.caption.Caption;
import org.truenewx.tnxjee.test.service.annotation.TestBusinessException;
import org.truenewx.tnxsample.root.model.entity.Customer;
import org.truenewx.tnxsample.root.service.test.ServiceTestSupport;

/**
 * CustomerServiceTest
 *
 * @author jianglei
 */
public class CustomerServiceTest extends ServiceTestSupport {
    @Autowired
    private CustomerService service;

    @Test
    @Caption("测试：根据手机号码加载客户")
    public void loadByMobilePhoneTest() {
        Customer customer0 = getData(Customer.class, 0);
        String mobilePhone = customer0.getMobilePhone();
        Customer customer = this.service.loadByMobilePhone(mobilePhone);
        assertEquals(mobilePhone, customer.getMobilePhone());
        assertEquals(customer0.getId(), customer.getId());
    }

    @Test
    @Caption("测试：根据不存在的手机号码加载客户")
    @TestBusinessException(CustomerExceptionCodes.NO_MOBILE_PHONE)
    public void loadByNoMobilePhoneTest() {
        this.service.loadByMobilePhone("12312345678");
        fail();
    }

    @Test
    @Caption("测试：修改客户禁用状态")
    public void updateDisabledTest() {
        Customer customer0 = getData(Customer.class, 0);
        boolean disabled = !customer0.isDisabled();
        Customer customer = this.service.updateDisabled(customer0.getId(), disabled);
        assertEquals(disabled, customer.isDisabled());
    }
}
