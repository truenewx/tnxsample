package org.truenewx.tnxsample.admin.service.fss.policy;

import org.truenewx.tnxjeex.fss.service.FssAuthorizePolicy;
import org.truenewx.tnxjeex.fss.service.model.FssProvider;
import org.truenewx.tnxsample.admin.model.command.FssAuthorizeType;
import org.truenewx.tnxsample.admin.model.entity.Manager;

/**
 * 管理员的非结构化授权方针
 *
 * @author jianglei
 */
public abstract class ManagerFssAuthorizePolicy implements FssAuthorizePolicy<FssAuthorizeType, Manager> {

    @Override
    public FssProvider getProvider() {
        return FssProvider.OWN;
    }

}
