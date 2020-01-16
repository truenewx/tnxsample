package org.truenewx.tnxsample.admin.service.unstructured;

import org.springframework.stereotype.Service;
import org.truenewx.tnxjeex.unstructured.service.UnstructuredServiceTemplateImpl;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.model.submit.UnstructuredAuthorizeType;

/**
 * 非结构化存储服务实现
 *
 * @author jianglei
 */
@Service
public class UnstructuredServiceImpl extends UnstructuredServiceTemplateImpl<UnstructuredAuthorizeType, Manager>
        implements UnstructuredService {

}
