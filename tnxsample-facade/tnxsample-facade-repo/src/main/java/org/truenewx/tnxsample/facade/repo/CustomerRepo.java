package org.truenewx.tnxsample.facade.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.truenewx.tnxsample.facade.model.entity.Customer;

/**
 * 客户Repo
 *
 * @author jianglei
 */
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    Customer findByMobilePhone(String mobilePhone);

}
