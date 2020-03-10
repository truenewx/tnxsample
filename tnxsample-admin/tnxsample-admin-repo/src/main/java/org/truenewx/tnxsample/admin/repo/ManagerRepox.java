package org.truenewx.tnxsample.admin.repo;

import java.util.List;

import org.truenewx.tnxjee.model.query.Queried;
import org.truenewx.tnxsample.admin.model.entity.Manager;

/**
 * 管理员扩展Repo
 *
 * @author jianglei
 */
public interface ManagerRepox {

    long countByRoleId(int roleId);

    List<Integer> getIdsByUsernameOrFullName(String keyword);

    Queried<Manager> queryByKeywordAndTop(String keyword, Boolean top, int pageSize, int pageNo);

    Queried<Manager> queryByRoleIdNotAndTop(int roleIdNot, Boolean top, int pageSize, int pageNo);

}
