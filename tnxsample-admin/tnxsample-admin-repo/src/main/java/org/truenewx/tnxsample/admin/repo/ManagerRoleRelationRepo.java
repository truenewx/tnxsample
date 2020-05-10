package org.truenewx.tnxsample.admin.repo;

import org.truenewx.tnxjee.repo.jpa.repository.JpaRelationRepository;
import org.truenewx.tnxsample.admin.model.entity.ManagerRoleRelation;

/**
 * 管理员-角色关系Repo
 */
public interface ManagerRoleRelationRepo
        extends JpaRelationRepository<ManagerRoleRelation, Integer, Integer>,
        ManagerRoleRelationRepox {

}
