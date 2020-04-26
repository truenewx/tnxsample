// index.js
define(["app", "fssUpload"], function(app) {
    return function(container) {
        new Vue({
            el: container,
            data: {},
            created: function() {
            },
            mounted: function() {
                $("#headImageContainer").fssUpload({
                    type: "MANAGER_HEAD_IMAGE"
                });
            },
            methods: {
                submit: function() {
                    $("#headImageContainer").fssUpload("getStorageUrls", function(storageUrls, uploadingFiles) {
                        if (uploadingFiles && uploadingFiles.length) {
                            var content = "还有文件正在上传中，请等待其上传完成，或者你也可以将其移除：";
                            content += uploadingFiles.join("、");
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
