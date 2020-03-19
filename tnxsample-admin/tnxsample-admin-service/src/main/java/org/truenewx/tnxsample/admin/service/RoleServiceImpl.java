package org.truenewx.tnxsample.admin.service;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.truenewx.tnxjee.core.util.CollectionUtil;
import org.truenewx.tnxjee.model.CommandModel;
import org.truenewx.tnxjee.model.entity.unity.UnityUtil;
import org.truenewx.tnxjee.repo.transaction.annotation.WriteTransactional;
import org.truenewx.tnxjee.service.exception.BusinessException;
import org.truenewx.tnxjee.service.impl.unity.AbstractUnityService;
import org.truenewx.tnxsample.admin.model.command.RoleCommandModel;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.model.entity.Role;
import org.truenewx.tnxsample.admin.repo.ManagerRepo;
import org.truenewx.tnxsample.admin.repo.RoleRepo;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 角色服务
 *
 * @author jianglei
 */
@Service
public class RoleServiceImpl extends AbstractUnityService<Role, Integer> implements RoleService {

    @Autowired
    private RoleRepo repo;
    @Autowired
    private ManagerRepo managerRepo;

    @Override
    public Iterable<Role> findAll() {
        return this.repo.findAll();
    }

    @Override
    public List<Role> findByName(String name) {
        return this.repo.findByNameContainingOrderByOrdinal(name);
    }

    @Override
    @WriteTransactional
    public Role move(int id, boolean down) {
        Role role = find(id);
        if (role != null) {
            long ordinal = role.getOrdinal();
            Role other;
            if (down) { // 下移
                other = this.repo.findFirstByOrdinalGreaterThanOrderByOrdinal(ordinal);
            } else { // 上移
                other = this.repo.findFirstByOrdinalLessThanOrderByOrdinalDesc(ordinal);
            }
            // 互换序号
            if (other != null) {
                role.setOrdinal(other.getOrdinal());
                this.repo.save(role);
                other.setOrdinal(ordinal);
                this.repo.save(other);
            }
        }
        return role;
    }

    @Override
    public void validateBusiness(Integer id, CommandModel<Role> commandModel) {
        if (commandModel instanceof RoleCommandModel) {
            RoleCommandModel model = (RoleCommandModel) commandModel;
            String name = model.getName();
            if (StringUtils.isNotBlank(name)) {
                if ((id == null && this.repo.countByName(name) > 0)
                        || (id != null && this.repo.countByNameAndIdNot(name, id) > 0)) {
                    throw new BusinessException(ManagerExceptionCodes.ROLE_REPEAT_NAME, name);
                }
            }
        }
    }

    @Override
    protected Role beforeSave(Integer id, CommandModel<Role> commandModel) {
        if (commandModel instanceof RoleCommandModel) {
            RoleCommandModel model = (RoleCommandModel) commandModel;
            validateBusiness(id, model);

            Role role;
            if (id == null) {
                role = new Role();
                role.setOrdinal(System.currentTimeMillis());
            } else {
                role = load(id);
            }
            role.setName(model.getName());
            role.setRemark(model.getRemark());
            Set<String> permissions = new HashSet<>();
            CollectionUtil.addAll(permissions, model.getPermissions());
            role.setPermissions(permissions);
            Collection<Manager> managers = role.getManagers();
            int[] newManagerIds = model.getManagerIds();
            // 原管理员在新管理员中没有的，说明被移除了
            managers.removeIf(manager -> {
                boolean removing = !ArrayUtils.contains(newManagerIds, manager.getId());
                if (removing) {
                    manager.getRoles().remove(role);
                }
                return removing;
            });
            // 此时管理员清单中现存的均为已包含在新管理员中的，需要添加新加的管理员
            if (newManagerIds != null) {
                for (int managerId : newManagerIds) {
                    if (!UnityUtil.containsId(managers, managerId)) {
                        this.managerRepo.findById(managerId).ifPresent(manager -> {
                            managers.add(manager);
                            manager.getRoles().add(role);
                        });
                    }
                }
            }
            this.repo.save(role);
            return role;
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Role role = find(id);
        if (role != null) {
            // 移除包含的管理员关系
            Collection<Manager> managers = role.getManagers();
            managers.forEach(manager -> {
                manager.getRoles().remove(role);
            });
            this.repo.delete(role);
            return true;
        }
        return false;
    }

}
