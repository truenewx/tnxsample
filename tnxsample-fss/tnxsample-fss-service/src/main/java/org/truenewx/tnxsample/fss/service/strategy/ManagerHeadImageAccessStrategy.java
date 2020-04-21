package org.truenewx.tnxsample.fss.service.strategy;

import org.springframework.stereotype.Service;
import org.truenewx.tnxjee.core.Strings;
import org.truenewx.tnxjeex.fss.service.model.FssUploadLimit;
import org.truenewx.tnxsample.core.model.TypedUserIdentity;
import org.truenewx.tnxsample.fss.service.model.FssType;

/**
 * 管理员头像的访问策略
 *
 * @author jianglei
 */
@Service
public class ManagerHeadImageAccessStrategy extends ManagerFssAccessStrategy {

    @Override
    public FssType getType() {
        return FssType.MANAGER_HEAD_IMAGE;
    }

    @Override
    public FssUploadLimit getUploadLimit(TypedUserIdentity userIdentity) {
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
    public String getPath(String token, TypedUserIdentity userIdentity, String filename) {
        return "manager/" + userIdentity.getId() + Strings.SLASH + filename;
    }

    @Override
    public boolean isReadable(TypedUserIdentity userIdentity, String path) {
        return userIdentity != null && path.startsWith("manager/");
    }

    @Override
    public boolean isWritable(TypedUserIdentity userIdentity, String path) {
        return isReadable(userIdentity, path); // 读写权限判断一致
    }

}
