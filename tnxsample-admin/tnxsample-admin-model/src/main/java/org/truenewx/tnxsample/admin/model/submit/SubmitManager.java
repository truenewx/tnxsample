package org.truenewx.tnxsample.admin.model.submit;

import org.truenewx.tnxjee.model.SubmitModel;
import org.truenewx.tnxsample.admin.model.entity.Manager;

import lombok.Getter;
import lombok.Setter;

/**
 * 管理员提交模型
 *
 * @author jianglei
 */
@Getter
@Setter
public class SubmitManager implements SubmitModel<Manager> {

    private String username;
    private String password;
    private String fullName;
    private int[] roleIds;

}
