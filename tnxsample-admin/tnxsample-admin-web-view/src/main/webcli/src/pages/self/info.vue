<template>
    <el-form label-position="right" label-width="auto" :model="model" :rules="rules" status-icon>
        <el-form-item label="用户名">{{model.username}}</el-form-item>
        <el-form-item label="是否超管">
            <div>
                <i class="fa"
                    :class="model.top ? 'fa-check text-primary' : 'fa-ban text-muted'"></i>
            </div>
        </el-form-item>
        <el-form-item label="头像">
            <tnxel-upload ref="headImageUpload" type="ManagerHeadImage"
                :files="model.headImageFile" v-if="model.username"/>
        </el-form-item>
        <el-form-item label="姓名" prop="fullName">
            <el-col :span="12">
                <el-input v-model.trim="model.fullName"/>
            </el-col>
        </el-form-item>
    </el-form>
</template>

<script>
    import {app, tnx, util} from '../../app.js';

    export default {
        props: ['opener'],
        data () {
            return {
                model: {
                    fullName: '',
                    headImageFile: null,
                },
                rules: {},
            };
        },
        created () {
            tnx.showLoading();
            const beginTime = new Date().getTime();
            const vm = this;
            app.rpc.get('/manager/self/info', model => {
                vm.model = model;
                // 先给模型赋值，再加载元数据，以确保字段校验不提前进行而导致失败
                app.rpc.getMeta('/manager/self/info', meta => {
                    vm.rules = meta.rules;
                    util.setMinTimeout(beginTime, function() {
                        tnx.closeLoading();
                    }, 500);
                });
            });
        },
        methods: {
            dialog () {
                return {
                    title: '修改个人信息',
                    width: '25%',
                    type: 'confirm',
                    click: this.toSubmit,
                }
            },
            toSubmit (yes, close) {
                if (yes) {
                    const model = this.model;
                    const opener = this.opener;
                    tnx.showLoading();
                    this.$refs.headImageUpload.getStorageUrls().then(function(storageUrls) {
                        model.headImageUrl = storageUrls[0];
                        const beginTime = new Date().getTime();
                        app.rpc.post('/manager/self/info', model, function() {
                            opener.managerCaption = model.fullName;
                            util.setMinTimeout(beginTime, function() {
                                tnx.toast('修改成功', () => {
                                    close();
                                });
                            }, 500);
                        });
                    }).catch(function(file) {
                        tnx.alert('文件"' + file.name + '"还未上传完毕，请稍候');
                    });
                    return false;
                }
            }
        }
    }
</script>
