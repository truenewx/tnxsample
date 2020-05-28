package org.truenewx.tnxsample.common;

/**
 * 通用常量类
 *
 * @author jianglei
 */
public class CommonConstants {

    private CommonConstants() {
    }

    /**
     * 存放session信息的集合名称
     */
    public static final String SESSION_COLLECTION_NAME = "session";

    /**
     * session过期时间，单位：秒
     */
    public static final int SESSION_TIMEOUT = 900;

    /**
     * 用户类型：客户
     */
    public static final String USER_TYPE_CUSTOMER = "customer";

    /**
     * 用户类型：管理员
     */
    public static final String USER_TYPE_MANAGER = "manager";

    /**
     * 管理员级别：普通
     */
    public static final String MANAGER_RANK_NORMAL = "normal";

    /**
     * 管理员级别：顶级
     */
    public static final String MANAGER_RANK_TOP = "top";

}
