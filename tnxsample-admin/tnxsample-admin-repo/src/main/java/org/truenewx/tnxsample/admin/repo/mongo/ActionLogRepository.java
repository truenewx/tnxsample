package org.truenewx.tnxsample.admin.repo.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.truenewx.tnxsample.admin.model.ActionLog;

/**
 * 操作日志Repository
 *
 * @author jianglei
 */
public interface ActionLogRepository extends MongoRepository<ActionLog, String> {

}
