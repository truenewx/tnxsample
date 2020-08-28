package org.truenewx.tnxsample.admin.repo;

import org.truenewx.tnxjee.repo.jpa.repository.JpaUnityRepository;
import org.truenewx.tnxsample.admin.model.entity.Manager;

/**
 * 管理员Repository
 *
 * @author jianglei
 */
public interface ManagerRepo extends JpaUnityRepository<Manager, Integer>, ManagerRepox {

    Manager findFirstByUsername(String username);

}
