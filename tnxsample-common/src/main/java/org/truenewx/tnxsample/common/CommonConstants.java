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

    /**
     * 服务：门户视图
     */
    public static final String SERVICE_FACADE_VIEW = "facade-view";

    /**
     * 服务：后台视图
     */
    public static final String SERVICE_ADMIN_VIEW = "admin-view";

}
