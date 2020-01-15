package org.truenewx.tnxsample.facade.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.truenewx.tnxsample.facade.model.User;

/**
 * 用户Repository
 *
 * @author jianglei
 */
public interface UserRepository extends UserRepo, JpaRepository<User, Integer> {

}
