// index.js
define(["app", "fssUpload"], function(app) {
    return function(container) {
        new Vue({
            el: container,
            data: {},
            created: function() {
            },
            mounted: function() {
                this.uploader = $("#headImageContainer").fssUpload({
                    type: "MANAGER_HEAD_IMAGE"
                });
            },
            methods: {
                submit: function() {
                    this.uploader.fssUpload("getStorageUrls", function(storageUrls, uploadingFiles) {
                        if (uploadingFiles && uploadingFiles.length) {
                            var content = "以下文件正在上传中，请等待其上传完成，或者你也可以将其移除。\n";
                            content += uploadingFiles.join(", ");
                            tnx.alert(content);
                        } else {
                            tnx.alert(storageUrls.join("\n"));
                        }
                    });
                }
            }
        });
    }
});
