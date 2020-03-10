package org.truenewx.tnxsample.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.truenewx.tnxsample.admin.model.entity.Role;

import java.util.List;

/**
 * 角色Repo
 *
 * @author jianglei
 */
public interface RoleRepo extends JpaRepository<Role, Integer> {

    List<Role> findByNameContainingOrderByOrdinal(String name);

    int countByName(String name);

    int countByNameAndIdNot(String name, int idNot);

    Role findFirstByOrdinalLessThanOrderByOrdinalDesc(long ordinalLessThan);

    Role findFirstByOrdinalGreaterThanOrderByOrdinal(long ordinalGreaterThan);

}
