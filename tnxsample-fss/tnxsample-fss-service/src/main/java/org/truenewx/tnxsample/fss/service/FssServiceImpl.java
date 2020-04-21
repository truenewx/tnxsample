package org.truenewx.tnxsample.fss.service;

import org.springframework.stereotype.Service;
import org.truenewx.tnxjeex.fss.service.FssServiceTemplateImpl;
import org.truenewx.tnxsample.core.model.TypedUserIdentity;
import org.truenewx.tnxsample.fss.service.model.FssType;

/**
 * 文件存储服务实现
 *
 * @author jianglei
 */
@Service
public class FssServiceImpl extends FssServiceTemplateImpl<FssType, TypedUserIdentity>
        implements FssService {

}
