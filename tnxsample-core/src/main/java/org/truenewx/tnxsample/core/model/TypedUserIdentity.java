package org.truenewx.tnxsample.core.model;

import org.truenewx.tnxjee.core.Strings;
import org.truenewx.tnxjee.model.spec.user.UserIdentity;

/**
 * 用类型区分的用户标识
 *
 * @author jianglei
 */
public class TypedUserIdentity implements UserIdentity {

    private static final long serialVersionUID = 757290666256132022L;

    private UserType type;
    private int id;

    public TypedUserIdentity(UserType type, int id) {
        this.type = type;
        this.id = id;
    }

    public UserType getType() {
        return this.type;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.type + Strings.COLON + this.id;
    }
}
