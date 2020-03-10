package org.truenewx.tnxsample.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.truenewx.tnxjee.core.Strings;
import org.truenewx.tnxjee.core.crypto.Md5xEncryptor;
import org.truenewx.tnxjee.model.SubmitModel;
import org.truenewx.tnxjee.model.query.Queried;
import org.truenewx.tnxjee.repo.transaction.annotation.WriteTransactional;
import org.truenewx.tnxjee.service.api.exception.BusinessException;
import org.truenewx.tnxjee.service.impl.unity.AbstractUnityService;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.model.entity.Role;
import org.truenewx.tnxsample.admin.model.submit.SubmitManager;
import org.truenewx.tnxsample.admin.repo.ManagerRepo;
import org.truenewx.tnxsample.admin.repo.RoleRepo;

import java.time.Instant;
import java.util.Collection;

/**
 * 管理员服务实现
 *
 * @author jianglei
 */
@Service
public class ManagerServiceImpl extends AbstractUnityService<Manager, Integer> implements ManagerService {

    @Autowired
    private ManagerRepo repo;
    @Autowired
    private RoleRepo roleRepo;
    private Md5xEncryptor encryptor = new Md5xEncryptor(29);

    @Override
    public Manager loadByUsername(String username) {
        Manager manager = this.repo.findFirstByUsername(username);
        if (manager == null) { // 根据用户名找不到管理员
            throw new BusinessException(ManagerExceptionCodes.USERNAME_OR_PASSWORD_ERROR);
        }
        return manager;
    }

    @Override
    public Manager validateLogin(String username, String md5Password) {
        Manager manager = loadByUsername(username);
        if (!this.encryptor.validateByMd5Source(manager.getPassword(), md5Password, manager.getId())) { // 密码错误
            throw new BusinessException(ManagerExceptionCodes.USERNAME_OR_PASSWORD_ERROR);
        }
        if (manager.isDisabled()) { // 管理员被禁用
            throw new BusinessException(ManagerExceptionCodes.DISABLED_MANAGER);
        }
        manager.getAuthorities();
        return manager;
    }

    @Override
    public Queried<Manager> queryGeneral(String keyword, int pageSize, int pageNo) {
        return this.repo.queryByKeywordAndTop(keyword, false, pageSize, pageNo);
    }

    @Override
    public Manager updateHeadImageUrl(int id, String headImageUrl) {
        Manager manager = find(id);
        if (manager != null) {
            manager.setHeadImageUrl(headImageUrl);
            this.repo.save(manager);
        }
        return manager;
    }

    @Override
    public Manager updateFullName(int id, String fullName) {
        Manager manager = find(id);
        if (manager != null) {
            manager.setFullName(fullName);
            this.repo.save(manager);
        }
        return manager;
    }

    @Override
    public Manager updatePassword(int id, String oldMd5Password, String newMd5Password) {
        Manager manager = find(id);
        if (manager != null) {
            if (!this.encryptor.validateByMd5Source(manager.getPassword(), oldMd5Password, manager.getId())) { // 密码错误
                throw new BusinessException(ManagerExceptionCodes.USERNAME_OR_PASSWORD_ERROR);
            }
            manager.setPassword(this.encryptor.encryptByMd5Source(newMd5Password, manager.getId()));
            this.repo.save(manager);
        }
        return manager;
    }

    @Override
    @WriteTransactional
    public Manager resetPassword(int id, String newMd5Password) {
        Manager manager = find(id);
        if (manager != null) {
            manager.setPassword(this.encryptor.encryptByMd5Source(newMd5Password, manager.getId()));
            this.repo.save(manager);
        }
        return manager;
    }

    @Override
    public Manager add(SubmitModel<Manager> submitModel) {
        if (submitModel instanceof SubmitManager) {
            SubmitManager model = (SubmitManager) submitModel;
            String username = model.getUsername();
            if (this.repo.countByUsername(username) > 0) {
                throw new BusinessException(ManagerExceptionCodes.REPEAT_USERNAME, username).bind("username");
            }
            Manager manager = new Manager();
            manager.setUsername(username);
            manager.setPassword(Strings.ASTERISK); // 密码暂时置为星号
            manager.setFullName(model.getFullName());
            manager.setCreateTime(Instant.now());
            applyRoles(manager, model.getRoleIds());
            this.repo.save(manager);
            // 有了id之后再用id做密钥进行密码加密
            String encryptedPassword = this.encryptor.encryptByMd5Source(model.getPassword(), manager.getId());
            manager.setPassword(encryptedPassword);
            this.repo.save(manager);
            return manager;
        }
        return null;
    }

    private void applyRoles(Manager manager, int[] roleIds) {
        Collection<Role> roles = manager.getRoles();
        roles.clear();
        if (roleIds != null) {
            for (int roleId : roleIds) {
                this.roleRepo.findById(roleId).ifPresent(role -> {
                    roles.add(role);
                    role.getManagers().add(manager);
                });
            }
        }
    }

    @Override
    public Manager update(Integer id, SubmitModel<Manager> submitModel) {
        if (submitModel instanceof SubmitManager) {
            SubmitManager model = (SubmitManager) submitModel;
            Manager manager = load(id);
            manager.setFullName(model.getFullName());
            applyRoles(manager, model.getRoleIds());
            this.repo.save(manager);
            return manager;
        }
        return null;
    }

    @Override
    @WriteTransactional
    public Manager reverseDisabled(int id, boolean disabled) {
        Manager manager = find(id);
        if (manager != null && !manager.isTop()) { // 顶级管理员不能修改禁用项
            manager.setDisabled(!disabled);
            this.repo.save(manager);
        }
        return manager;
    }

    @Override
    public long countOfRole(int roleId) {
        return this.repo.countByRoleId(roleId);
    }

    @Override
    public Queried<Manager> queryGeneralOutOfRole(int exceptedRoleId, int pageSize, int pageNo) {
        return this.repo.queryByRoleIdNotAndTop(exceptedRoleId, false, pageSize, pageNo);
    }
}
