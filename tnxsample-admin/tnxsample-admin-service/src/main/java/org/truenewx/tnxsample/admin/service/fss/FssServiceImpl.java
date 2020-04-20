package org.truenewx.tnxsample.admin.service.fss;

import org.springframework.stereotype.Service;
import org.truenewx.tnxjeex.fss.service.FssServiceTemplateImpl;
import org.truenewx.tnxsample.admin.service.model.FssAuthorizeType;
import org.truenewx.tnxsample.core.model.TypedUserIdentity;

/**
 * 文件存储服务实现
 *
 * @author jianglei
 */
@Service
public class FssServiceImpl extends FssServiceTemplateImpl<FssAuthorizeType, TypedUserIdentity>
        implements FssService {

}
