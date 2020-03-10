package org.truenewx.tnxsample.admin.repo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import org.truenewx.tnxjee.model.query.Queried;
import org.truenewx.tnxjee.repo.mongo.support.MongoUnityRepoSupport;
import org.truenewx.tnxsample.admin.model.entity.ActionLog;
import org.truenewx.tnxsample.admin.model.query.ActionLogQuerying;

/**
 * 操作日志Repo实现
 *
 * @author jianglei
 */
@Repository
public class ActionLogRepoImpl extends MongoUnityRepoSupport<ActionLog, String> implements ActionLogRepox {

    @Override
    public Queried<ActionLog> query(ActionLogQuerying querying) {
        List<Criteria> criterias = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(querying.getManagerIds())) {
            criterias.add(Criteria.where("managerId").in(querying.getManagerIds()));
        }
        if (querying.getBeginTime() != null) {
            criterias.add(Criteria.where("createTime").gte(querying.getBeginTime()));
        }
        if (querying.getEndTime() != null) {
            criterias.add(Criteria.where("createTime").lt(querying.getEndTime()));
        }

        return query(criterias, querying);
    }

}
