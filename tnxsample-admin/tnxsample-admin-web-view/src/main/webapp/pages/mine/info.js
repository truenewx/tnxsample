// mine/info.js
define(["app", "validator", "fssUpload"], function(app, Validator) {
    return function(container) {
        new Vue({
            el: container,
            data: {
                url: "/mine/info",
                model: {},
                v: new Validator(),
            },
            created: function() {
                tnx.showLoading();
                var _this = this;
                app.rpc.get(this.url, function(model) {
                    _this.model = model;
                    _this.v.setModel(model);
                    var storageUrls = model.headImageUrl ? [model.headImageUrl] : undefined;
                    $("#headImageContainer").fssUpload({
                        type: "ManagerHeadImage",
                        storageUrls: storageUrls,
                    });
                    tnx.hideLoading();
                });
                app.rpc.getMeta(this.url, function(meta) {
                    _this.v.setMeta(meta);
                });
            },
            methods: {
                submit: function() {
                    if (this.v.validate()) {
                        var _this = this;
                        $("#headImageContainer").fssUpload("getStorageUrls", function(storageUrls, uploadingFiles) {
                            if (uploadingFiles && uploadingFiles.length) {
                                var content = "还有文件正在上传中，请等待其上传完成，或者你也可以将其移除：";
                                content += uploadingFiles.join("、");
                                tnx.alert(content);
                            } else {
                                _this.model.headImageUrl = storageUrls[0];
                                app.rpc.post(_this.url, _this.model, function() {
                                    $("#managerDropdown").text(_this.model.fullName);
                                    tnx.toast("保存成功", 1000, function() {
                                        container.close();
                                    });
                                });
                            }
                        });
                    }
                },
                cancel: function() {
                    container.close();
                }
            }
        });
    }
});