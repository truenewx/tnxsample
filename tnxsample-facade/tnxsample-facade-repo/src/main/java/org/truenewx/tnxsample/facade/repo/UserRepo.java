package org.truenewx.tnxsample.facade.repo;

import org.truenewx.tnxjee.repo.UnityRepo;
import org.truenewx.tnxsample.facade.model.entity.User;

/**
 * 用户Repo
 *
 * @author jianglei
 */
public interface UserRepo extends UnityRepo<User, Integer> {

    User findByMobilePhone(String mobilePhone);

}
