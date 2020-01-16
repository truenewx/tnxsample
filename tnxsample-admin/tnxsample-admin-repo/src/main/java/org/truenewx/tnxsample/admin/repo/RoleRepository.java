package org.truenewx.tnxsample.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.truenewx.tnxsample.admin.model.entity.Role;

/**
 * 角色Repository
 *
 * @author jianglei
 */
public interface RoleRepository extends RoleRepo, JpaRepository<Role, Integer> {

}
