package org.truenewx.tnxsample.facade.repo;

import org.truenewx.tnxjee.repo.jpa.repository.JpaUnityRepository;
import org.truenewx.tnxsample.facade.model.entity.User;

/**
 * 用户Repo
 *
 * @author jianglei
 */
public interface UserRepo extends JpaUnityRepository<User, Integer> {

    User findByMobilePhone(String mobilePhone);

}
