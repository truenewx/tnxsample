package org.truenewx.tnxsample.admin.repo;

import java.util.List;

import org.truenewx.tnxjee.model.query.Queried;
import org.truenewx.tnxjee.repo.UnityRepo;
import org.truenewx.tnxsample.admin.model.Manager;

/**
 * 管理员Repo
 *
 * @author jianglei
 */
public interface ManagerRepo extends UnityRepo<Manager, Integer> {

    Manager findFirstByUsername(String username);

    long countByUsername(String username);

    long countByRoleId(int roleId);

    List<Integer> getIdsByUsernameOrFullName(String keyword);

    Queried<Manager> queryByKeywordAndTop(String keyword, Boolean top, int pageSize, int pageNo);

    Queried<Manager> queryByRoleIdNotAndTop(int roleIdNot, Boolean top, int pageSize, int pageNo);

}
