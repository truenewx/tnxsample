package org.truenewx.tnxsample.admin.repo;

import java.util.List;

import org.truenewx.tnxjee.repo.UnityRepo;
import org.truenewx.tnxsample.admin.model.Role;

/**
 * 角色Repo
 *
 * @author jianglei
 */
public interface RoleRepo extends UnityRepo<Role, Integer> {

    List<Role> findByNameContainingOrderByOrdinal(String name);

    int countByName(String name);

    int countByNameAndIdNot(String name, int idNot);

    Role findFirstByOrdinalLessThanOrderByOrdinalDesc(long ordinalLessThan);

    Role findFirstByOrdinalGreaterThanOrderByOrdinal(long ordinalGreaterThan);

}
