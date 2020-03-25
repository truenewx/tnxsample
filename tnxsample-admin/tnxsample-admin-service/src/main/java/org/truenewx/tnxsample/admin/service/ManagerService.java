package org.truenewx.tnxsample.admin.service;

import org.truenewx.tnxjee.model.query.QueryResult;
import org.truenewx.tnxjee.service.unity.ModelUnityService;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.service.model.CommandManagerSelf;

/**
 * 管理员服务
 *
 * @author jianglei
 */
public interface ManagerService extends ModelUnityService<Manager, Integer> {

    Manager loadByUsername(String username);

    Manager validateLogin(String username, String md5Password);

    QueryResult<Manager> queryGeneral(String keyword, int pageSize, int pageNo);

    Manager updateSelf(int id, CommandManagerSelf command);

    Manager updatePassword(int id, String oldMd5Password, String newMd5Password);

    Manager resetPassword(int id, String newMd5Password);

    Manager reverseDisabled(int id, boolean disabled);

    long countOfRole(int roleId);

    QueryResult<Manager> queryGeneralOutOfRole(int exceptedRoleId, int pageSize, int pageNo);

}
