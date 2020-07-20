package org.truenewx.tnxsample.admin.web.api.model;

import javax.validation.constraints.NotBlank;

import org.truenewx.tnxjeex.fss.model.FssFileMeta;
import org.truenewx.tnxsample.admin.model.entity.Manager;

public class BasicManager {

    private Manager unity;
    private FssFileMeta headImageFile;

    public BasicManager(Manager unity) {
        this.unity = unity;
    }

    @NotBlank
    public String getUsername() {
        return this.unity.getUsername();
    }

    public boolean isTop() {
        return this.unity.isTop();
    }

    @NotBlank
    public String getFullName() {
        return this.unity.getFullName();
    }

    public String getHeadImageUrl() {
        return this.unity.getHeadImageUrl();
    }

    public FssFileMeta getHeadImageFile() {
        return this.headImageFile;
    }

    public void setHeadImageFile(FssFileMeta headImageFile) {
        this.headImageFile = headImageFile;
    }

}
