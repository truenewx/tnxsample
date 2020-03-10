package org.truenewx.tnxsample.admin.repo;

import java.util.List;

import org.truenewx.tnxjee.repo.jpa.repository.JpaUnityRepository;
import org.truenewx.tnxsample.admin.model.entity.Role;

/**
 * 角色Repo
 *
 * @author jianglei
 */
public interface RoleRepo extends JpaUnityRepository<Role, Integer> {

    List<Role> findByNameContainingOrderByOrdinal(String name);

    int countByName(String name);

    int countByNameAndIdNot(String name, int idNot);

    Role findFirstByOrdinalLessThanOrderByOrdinalDesc(long ordinalLessThan);

    Role findFirstByOrdinalGreaterThanOrderByOrdinal(long ordinalGreaterThan);

}
