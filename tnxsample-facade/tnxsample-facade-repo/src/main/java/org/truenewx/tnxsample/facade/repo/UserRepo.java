package org.truenewx.tnxsample.facade.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.truenewx.tnxsample.facade.model.entity.User;

/**
 * 用户Repo
 *
 * @author jianglei
 */
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByMobilePhone(String mobilePhone);

}
