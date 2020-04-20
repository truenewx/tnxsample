package org.truenewx.tnxsample.admin.service.fss.strategy;

import org.truenewx.tnxjeex.fss.service.FssAccessStrategy;
import org.truenewx.tnxjeex.fss.service.model.FssProvider;
import org.truenewx.tnxsample.admin.service.model.FssAuthorizeType;
import org.truenewx.tnxsample.core.model.TypedUserIdentity;

/**
 * 管理员的文件存储访问策略
 *
 * @author jianglei
 */
public abstract class ManagerFssAccessStrategy
        implements FssAccessStrategy<FssAuthorizeType, TypedUserIdentity> {

    @Override
    public FssProvider getProvider() {
        return FssProvider.OWN;
    }

}
