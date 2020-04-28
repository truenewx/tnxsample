package org.truenewx.tnxsample.fss.service.strategy;

import org.springframework.stereotype.Service;
import org.truenewx.tnxjee.core.Strings;
import org.truenewx.tnxjee.model.spec.DimensionSize;
import org.truenewx.tnxjeex.fss.service.model.FssUploadLimit;
import org.truenewx.tnxsample.core.model.TypedUserIdentity;
import org.truenewx.tnxsample.core.model.UserType;
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
        FssUploadLimit limit = new FssUploadLimit(1, 1024 * 1024, "jpg", "png", "gif");
        limit.enableImage(true, new DimensionSize(128, 128));
        return limit;
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
        if (isValidUserIdentity(userIdentity)) {
            return "manager/" + userIdentity.getId() + Strings.SLASH + filename;
        }
        return null;
    }

    private boolean isValidUserIdentity(TypedUserIdentity userIdentity) {
        return userIdentity != null && userIdentity.getType() == UserType.MANAGER;
    }

    @Override
    public boolean isReadable(TypedUserIdentity userIdentity, String path) {
        return isValidUserIdentity(userIdentity) && path.startsWith("manager/");
    }

    @Override
    public boolean isWritable(TypedUserIdentity userIdentity, String path) {
        return isReadable(userIdentity, path); // 读写权限判断一致
    }

}
