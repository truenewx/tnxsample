package org.truenewx.tnxsample.admin.service.unstructured.policy;

import org.truenewx.tnxjeex.unstructured.service.UnstructuredAuthorizePolicy;
import org.truenewx.tnxjeex.unstructured.service.model.UnstructuredProvider;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.model.submit.UnstructuredAuthorizeType;

/**
 * 管理员的非结构化授权方针
 *
 * @author jianglei
 */
public abstract class ManagerUnstructuredAuthorizePolicy
        implements UnstructuredAuthorizePolicy<UnstructuredAuthorizeType, Manager> {

    @Override
    public UnstructuredProvider getProvider() {
        return UnstructuredProvider.OWN;
    }

}
