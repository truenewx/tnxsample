<template>
    <el-form label-position="right" label-width="auto" :model="model" :rules="rules">
        <el-form-item label="用户名">{{model.username}}</el-form-item>
        <el-form-item label="是否超管">
            <div>
                <i class="fa"
                    :class="model.top ? 'fa-check text-primary' : 'fa-ban text-muted'"></i>
            </div>
        </el-form-item>
        <el-form-item label="头像">

        </el-form-item>
        <el-form-item label="姓名" prop="fullName">
            <el-col :span="12">
                <el-input v-model="model.fullName"></el-input>
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
                    fullName: null
                },
                rules: {},
                uploadUrl: app.rpc.context.fss + '/upload/ManagerHeadImage',
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
                    const beginTime = new Date().getTime();
                    app.rpc.post('/manager/self/info', model, function() {
                        opener.managerCaption = model.fullName;
                        util.setMinTimeout(beginTime, function() {
                            tnx.toast('修改成功', () => {
                                close();
                            });
                        }, 500);
                    });
                    return false;
                }
            }
        }
    }
</script>
