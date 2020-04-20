package org.truenewx.tnxsample.admin.service.fss;

import org.truenewx.tnxjeex.fss.service.FssServiceTemplate;
import org.truenewx.tnxsample.admin.service.model.FssAuthorizeType;
import org.truenewx.tnxsample.core.model.TypedUserIdentity;

/**
 * 文件存储服务
 *
 * @author jianglei
 */
public interface FssService extends FssServiceTemplate<FssAuthorizeType, TypedUserIdentity> {

}
