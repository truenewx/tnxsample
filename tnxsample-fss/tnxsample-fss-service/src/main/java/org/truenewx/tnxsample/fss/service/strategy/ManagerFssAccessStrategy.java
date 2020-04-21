package org.truenewx.tnxsample.fss.service.strategy;

import org.truenewx.tnxjeex.fss.service.FssAccessStrategy;
import org.truenewx.tnxjeex.fss.service.model.FssProvider;
import org.truenewx.tnxsample.core.model.TypedUserIdentity;
import org.truenewx.tnxsample.fss.service.model.FssType;

/**
 * 管理员的文件存储访问策略
 *
 * @author jianglei
 */
public abstract class ManagerFssAccessStrategy
        implements FssAccessStrategy<FssType, TypedUserIdentity> {

    @Override
    public FssProvider getProvider() {
        return FssProvider.OWN;
    }

}
