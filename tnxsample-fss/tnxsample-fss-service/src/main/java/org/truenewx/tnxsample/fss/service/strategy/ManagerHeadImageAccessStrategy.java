package org.truenewx.tnxsample.fss.service.strategy;

import org.springframework.stereotype.Service;
import org.truenewx.tnxjee.core.Strings;
import org.truenewx.tnxjee.model.spec.DimensionSize;
import org.truenewx.tnxjee.model.spec.user.IntegerUserIdentity;
import org.truenewx.tnxjeex.fss.service.model.FssUploadLimit;
import org.truenewx.tnxsample.common.CommonConstants;

/**
 * 管理员头像的访问策略
 *
 * @author jianglei
 */
@Service
public class ManagerHeadImageAccessStrategy extends ManagerFssAccessStrategy {

    @Override
    public String getType() {
        return "ManagerHeadImage";
    }

    @Override
    public FssUploadLimit getUploadLimit(IntegerUserIdentity userIdentity) {
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
    public String getPath(String token, IntegerUserIdentity userIdentity, String filename) {
        if (isValidUserIdentity(userIdentity)) {
            return "manager/" + userIdentity.getId() + Strings.SLASH + filename;
        }
        return null;
    }

    private boolean isValidUserIdentity(IntegerUserIdentity userIdentity) {
        return userIdentity != null && CommonConstants.USER_TYPE_MANAGER.equals(userIdentity.getType());
    }

    @Override
    public boolean isReadable(IntegerUserIdentity userIdentity, String path) {
        return isValidUserIdentity(userIdentity) && path.startsWith("manager/");
    }

    @Override
    public boolean isWritable(IntegerUserIdentity userIdentity, String path) {
        return isReadable(userIdentity, path); // 读写权限判断一致
    }

}
