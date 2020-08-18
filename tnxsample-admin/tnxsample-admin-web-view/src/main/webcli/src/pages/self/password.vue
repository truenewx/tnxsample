<template>
    <el-form label-position="right" label-width="auto" ref="form" :model="model"
        :rules="rules" :validate-on-rule-change="false" status-icon>
        <el-form-item label="原密码" prop="oldPassword">
            <el-col>
                <el-input type="password" v-model.trim="model.oldPassword"
                    @input="oldPasswordInput"></el-input>
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
import {app, tnx, util} from '@/app';

export default {
    props: ['opener'],
    data() {
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
                        return callback();
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
                        return callback();
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
                        return callback();
                    }
                }]
            },
            oldPasswordError: false,
        };
    },
    computed: {
        oldMd5Password: function() {
            return this.model.oldPassword ? util.md5(this.model.oldPassword) : '';
        },
        newMd5Password: function() {
            return this.model.newPassword ? util.md5(this.model.newPassword) : '';
        },
    },
    methods: {
        dialog() {
            return {
                title: '修改密码',
                width: '20%',
                type: 'confirm',
                click: this.toSubmit,
            }
        },
        oldPasswordInput: function() {
            this.oldPasswordError = false;
        },
        toSubmit(yes) {
            if (yes) {
                this.oldPasswordError = false;
                const vm = this;
                this.$refs.form.validate(function(yes) {
                    if (yes) {
                        const beginTime = new Date().getTime();
                        tnx.showLoading();
                        app.rpc.post('/manager/self/password', function() {
                            util.setMinTimeout(beginTime, function() {
                                tnx.alert('登录密码修改成功，请使用新密码重新登录', () => {
                                    vm.opener.logout();
                                });
                            }, 500);
                        }, {
                            params: {
                                oldPassword: vm.oldMd5Password,
                                newPassword: vm.newMd5Password,
                            },
                            error: function() {
                                tnx.closeLoading();
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
