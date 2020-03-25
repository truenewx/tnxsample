package org.truenewx.tnxsample.admin.service.fss.policy;

import org.springframework.stereotype.Service;
import org.truenewx.tnxjee.core.Strings;
import org.truenewx.tnxjeex.fss.service.model.FssUploadLimit;
import org.truenewx.tnxsample.admin.model.entity.Manager;
import org.truenewx.tnxsample.admin.service.model.FssAuthorizeType;

/**
 * 管理员头像的授权方针
 *
 * @author jianglei
 */
@Service
public class ManagerHeadImageAuthorizePolicy extends ManagerFssAuthorizePolicy {

    @Override
    public FssAuthorizeType getType() {
        return FssAuthorizeType.MANAGER_HEAD_IMAGE;
    }

    @Override
    public FssUploadLimit getUploadLimit(Manager user) {
        return new FssUploadLimit(1, 150 * 1024, "jpg", "png");
    }

    @Override
    public String getBucket() {
        return "headImage";
    }

    @Override
    public boolean isMd5AsFilename() {
        return true;
    }

    @Override
    public String getPath(String token, Manager manager, String filename) {
        return "manager/" + manager.getId() + Strings.SLASH + filename;
    }

    @Override
    public boolean isReadable(Manager manager, String path) {
        return manager != null && path.startsWith("manager/");
    }

    @Override
    public boolean isWritable(Manager manager, String path) {
        return isReadable(manager, path); // 读写权限判断一致
    }

}
