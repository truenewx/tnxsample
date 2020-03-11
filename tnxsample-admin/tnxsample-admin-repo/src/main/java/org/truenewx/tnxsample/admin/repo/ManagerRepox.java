package org.truenewx.tnxsample.admin.repo;

import org.truenewx.tnxjee.model.query.QueryResult;
import org.truenewx.tnxsample.admin.model.entity.Manager;

import java.util.List;

/**
 * 管理员扩展Repo
 *
 * @author jianglei
 */
public interface ManagerRepox {

    long countByRoleId(int roleId);

    List<Integer> getIdsByUsernameOrFullName(String keyword);

    QueryResult<Manager> queryByKeywordAndTop(String keyword, Boolean top, int pageSize, int pageNo);

    QueryResult<Manager> queryByRoleIdNotAndTop(int roleIdNot, Boolean top, int pageSize, int pageNo);

}
