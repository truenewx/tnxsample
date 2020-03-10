package org.truenewx.tnxsample.admin.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.truenewx.tnxjee.core.Strings;
import org.truenewx.tnxjee.model.query.Queried;
import org.truenewx.tnxjee.model.query.QuerySort;
import org.truenewx.tnxjee.repo.jpa.support.JpaUnityRepoSupport;
import org.truenewx.tnxsample.admin.model.entity.Manager;

/**
 * 管理员Repo实现
 *
 * @author jianglei
 */
@Repository
public class ManagerRepoImpl extends JpaUnityRepoSupport<Manager, Integer> implements ManagerRepox {

    @Override
    public long countByRoleId(int roleId) {
        String ql = "select count(*) from ManagerRoleRelation r where r.role.id = :roleId";
        return getAccessTemplate().count(ql, "roleId", roleId);
    }

    @Override
    public List<Integer> getIdsByUsernameOrFullName(String keyword) {
        String ql = "select id from Manager where username like :keyword or fullName like :keyword";
        return getAccessTemplate().list(ql, "keyword", Strings.PERCENT + keyword + Strings.PERCENT);
    }

    @Override
    public Queried<Manager> queryByKeywordAndTop(String keyword, Boolean top, int pageSize, int pageNo) {
        StringBuffer ql = new StringBuffer("from Manager where 1=1");
        Map<String, Object> params = new HashMap<>();
        if (StringUtils.isNotBlank(keyword)) {
            ql.append(" and (username like :keyword or fullName like :keyword)");
            params.put("keyword", Strings.PERCENT + keyword + Strings.PERCENT);
        }
        if (top != null) {
            ql.append(" and top=:top");
            params.put("top", top);
        }
        QuerySort sort = QuerySort.of("username", Boolean.FALSE);
        return query(ql, params, pageSize, pageNo, sort);
    }

    @Override
    public Queried<Manager> queryByRoleIdNotAndTop(int roleIdNot, Boolean top, int pageSize, int pageNo) {
        StringBuffer ql = new StringBuffer("from Manager m where m.id not in ")
                .append("(select r.manager.id from ManagerRoleRelation r where r.role.id=:roleIdNot)");
        Map<String, Object> params = new HashMap<>();
        params.put("roleIdNot", roleIdNot);
        if (top != null) {
            ql.append(" and top=:top");
            params.put("top", top);
        }
        QuerySort sort = QuerySort.of("m.username", Boolean.FALSE);
        return query(ql, params, pageSize, pageNo, sort);
    }

}
