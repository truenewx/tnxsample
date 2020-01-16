package org.truenewx.tnxsample.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.truenewx.tnxsample.admin.model.entity.Manager;

/**
 * 管理员Repository
 *
 * @author jianglei
 */
public interface ManagerRepository extends JpaRepository<Manager, Integer> {

    long countByUsername(String username);

    Manager findFirstByUsername(String username);

}
