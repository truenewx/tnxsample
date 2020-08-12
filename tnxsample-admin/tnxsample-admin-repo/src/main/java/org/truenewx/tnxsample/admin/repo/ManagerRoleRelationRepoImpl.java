package org.truenewx.tnxsample.admin.repo;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import org.truenewx.tnxjee.core.util.tuple.Binary;
import org.truenewx.tnxjee.core.util.tuple.Binate;
import org.truenewx.tnxjee.model.query.QueryResult;
import org.truenewx.tnxjee.repo.jpa.support.JpaRelationRepoSupport;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.model.entity.ManagerRoleRelation;
import org.truenewx.tnxsample.admin.model.entity.Role;

/**
 * 管理员-角色关系Repo扩展实现
 */
@Repository
public class ManagerRoleRelationRepoImpl
        extends JpaRelationRepoSupport<ManagerRoleRelation, Integer, Integer>
        implements ManagerRoleRelationRepox {

    @Override
    protected Binate<String, String> getIdProperty() {
        return new Binary<>("id.managerId", "id.roleId");
    }

    @Override
    public List<Role> getRolesByManagerId(int managerId) {
        String oql = "select r.role from ManagerRoleRelation r where r.id.managerId=:managerId";
        return getAccessTemplate().list(oql, "managerId", managerId);
    }

    @Override
    public QueryResult<Manager> queryManagersByRoleId(int roleId, int pageSize, int pageNo) {
        String oql = "from ManagerRoleRelation r where r.id.roleId=:roleId";
        Map<String, Object> params = Map.of("roleId", roleId);
        QueryResult<ManagerRoleRelation> qr = query(oql, params, pageSize, pageNo, null);
        return qr.map(relation -> {
            return relation.getManager();
        });
    }

}
