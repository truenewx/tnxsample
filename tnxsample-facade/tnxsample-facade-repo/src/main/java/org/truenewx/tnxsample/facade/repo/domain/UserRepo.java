package org.truenewx.tnxsample.facade.repo.domain;

import org.truenewx.tnxjee.repo.UnityRepo;
import org.truenewx.tnxsample.facade.model.domain.User;

/**
 * 用户Repo
 *
 * @author jianglei
 */
public interface UserRepo extends UnityRepo<User, Integer> {

    User findByMobilePhone(String mobilePhone);

}
