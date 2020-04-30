package org.truenewx.tnxsample.fss.service;

import org.truenewx.tnxjee.model.spec.user.IntegerUserIdentity;
import org.truenewx.tnxjeex.fss.service.FssServiceTemplate;
import org.truenewx.tnxsample.fss.service.model.FssType;

/**
 * 文件存储服务
 *
 * @author jianglei
 */
public interface FssService extends FssServiceTemplate<FssType, IntegerUserIdentity> {

}
