package org.truenewx.tnxsample.facade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.truenewx.tnxjee.service.exception.BusinessException;
import org.truenewx.tnxjee.service.impl.unity.AbstractUnityService;
import org.truenewx.tnxsample.facade.model.entity.User;
import org.truenewx.tnxsample.facade.repo.UserRepo;

/**
 * 用户服务实现
 *
 * @author jianglei
 */
@Service
public class UserServiceImpl extends AbstractUnityService<User, Integer> implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User loadByMobilePhone(String mobilePhone) {
        User user = this.userRepo.findByMobilePhone(mobilePhone);
        if (user == null) {
            throw new BusinessException(UserExceptionCodes.NO_MOBILE_PHONE, mobilePhone);
        }
        return user;
    }

    @Override
    public User updateDisabled(int userId, boolean disabled) {
        User user = find(userId);
        if (user != null) {
            user.setDisabled(disabled);
            this.userRepo.save(user);
        }
        return user;
    }

}
