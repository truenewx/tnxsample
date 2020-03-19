package org.truenewx.tnxsample.facade.service;

import org.truenewx.tnxjee.service.unity.UnityService;
import org.truenewx.tnxsample.facade.model.entity.User;

/**
 * 用户服务
 * 
 * @author jianglei
 */
public interface UserService extends UnityService<User, Integer> {

    User loadByMobilePhone(String mobilePhone);

    User updateDisabled(int userId, boolean disabled);

}
