package org.truenewx.tnxsample.fss.service.strategy;

import org.springframework.stereotype.Service;
import org.truenewx.tnxjee.core.Strings;
import org.truenewx.tnxjee.model.spec.FlatSize;
import org.truenewx.tnxjee.model.spec.user.IntegerUserIdentity;
import org.truenewx.tnxjeex.fss.service.model.FssUploadLimit;
import org.truenewx.tnxsample.common.constant.UserTypes;

/**
 * 管理员头像的访问策略
 *
 * @author jianglei
 */
@Service
public class ManagerHeadImageAccessStrategy extends AbstractFssAccessStrategy {

    @Override
    public String getType() {
        return "ManagerHeadImage";
    }

    @Override
    public FssUploadLimit getUploadLimit(IntegerUserIdentity userIdentity) {
        FssUploadLimit limit = new FssUploadLimit(1, 1024 * 1024, "jpg", "png", "gif");
        limit.enableImage(true, new FlatSize(64, 64));
        return limit;
    }

    @Override
    public String getContextPath() {
        return "/headImage/manager";
    }

    @Override
    public String getRelativeDir(String scope, IntegerUserIdentity userIdentity) {
        if (isValidUserIdentity(userIdentity)) {
            return Strings.SLASH + userIdentity.getId();
        }
        return null;
    }

    private boolean isValidUserIdentity(IntegerUserIdentity userIdentity) {
        return userIdentity != null && UserTypes.MANAGER.equals(userIdentity.getType());
    }

    @Override
    public boolean isReadable(IntegerUserIdentity userIdentity, String relativeDir) {
        return isValidUserIdentity(userIdentity); // 管理员可以读其他管理员的头像
    }

}
