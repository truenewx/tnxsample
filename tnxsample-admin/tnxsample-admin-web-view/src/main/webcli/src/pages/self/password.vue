<template>
    <el-form label-position="right" label-width="auto" ref="form" :model="model" :rules="rules">
        <el-form-item label="原密码" prop="oldPassword">
            <el-col>
                <el-input type="password" v-model.trim="model.oldPassword"></el-input>
            </el-col>
        </el-form-item>
        <el-form-item label="新密码" prop="newPassword">
            <el-col>
                <el-input type="password" v-model.trim="model.newPassword"></el-input>
            </el-col>
        </el-form-item>
        <el-form-item label="确认密码" prop="newPassword2">
            <el-col>
                <el-input type="password" v-model.trim="model.newPassword2"></el-input>
            </el-col>
        </el-form-item>
    </el-form>
</template>

<script>
    import {app, tnx, util} from '../../app.js';

    export default {
        props: ['opener'],
        data () {
            const vm = this;
            return {
                model: {},
                rules: {
                    oldPassword: [{
                        required: true,
                        message: '请填写原密码'
                    }, {
                        validator: function(rule, fieldValue, callback) {
                            if (fieldValue && vm.oldPasswordError) {
                                return callback(new Error('原密码错误'));
                            }
                        }
                    }],
                    newPassword: [{
                        required: true,
                        message: '请填写新密码'
                    }, {
                        validator: function(rule, fieldValue, callback) {
                            if (vm.model.newPassword2) {
                                vm.$refs.form.validateField('newPassword2');
                            }
                        }
                    }],
                    newPassword2: [{
                        required: true,
                        message: '请填写确认密码'
                    }, {
                        validator: function(rule, fieldValue, callback) {
                            const model = vm.model;
                            if (model.newPassword && model.newPassword2
                                && model.newPassword !== model.newPassword2) {
                                return callback(new Error('新密码两次输入不一致'));
                            }
                        }
                    }]
                },
                oldPasswordError: false,
            };
        },
        methods: {
            dialog () {
                return {
                    title: '修改密码',
                    width: '20%',
                    type: 'confirm',
                    click: this.toSubmit,
                }
            },
            toSubmit (yes) {
                if (yes) {
                    this.oldPasswordError = false;
                    const vm = this;
                    this.$refs.form.validate(function(yes) {
                        if (yes) {
                            const model = Object.assign({}, vm.model);
                            delete model.newPassword2;
                            const beginTime = new Date().getTime();
                            tnx.showLoading();
                            app.rpc.post('/manager/self/password', model, function() {
                                util.setMinTimeout(beginTime, function() {
                                    tnx.alert('登录密码成功，请使用新密码重新登录', () => {
                                        app.rpc.post('/logout');
                                    });
                                }, 500);
                            }, {
                                params: this.model,
                                error: function() {
                                    vm.oldPasswordError = true;
                                    vm.$refs.form.validateField('oldPassword');
                                }
                            });
                        }
                    });
                    return false;
                }
            }
        }
    }
</script>
