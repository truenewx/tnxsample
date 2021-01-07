package org.truenewx.tnxsample.admin.model.query;

import java.time.Instant;
import java.util.List;

import org.truenewx.tnxjee.model.query.Querying;

import lombok.Getter;
import lombok.Setter;

/**
 * 操作日志的分页查询条件
 *
 * @author jianglei
 */
@Getter
@Setter
public class ActionLogQuerying extends Querying {

    private static final long serialVersionUID = -1417419280956901061L;

    private List<Integer> managerIds;
    private Instant beginTime;
    private Instant endTime;

}
