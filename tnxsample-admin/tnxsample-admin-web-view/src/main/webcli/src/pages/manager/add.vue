<template>
    <el-form label-position="right" label-width="auto" ref="form" :model="model"
        :rules="rules" :validate-on-rule-change="false" status-icon>
        <el-form-item label="工号" prop="jobNo">
            <el-col :span="12">
                <el-input v-model.trim="model.jobNo"/>
            </el-col>
        </el-form-item>
        <el-form-item label="姓名" prop="fullName">
            <el-col :span="12">
                <el-input v-model.trim="model.fullName"/>
            </el-col>
        </el-form-item>
        <el-form-item label="用户名" prop="username">
            <el-col :span="12">
                <el-input v-model.trim="model.username"/>
            </el-col>
        </el-form-item>
        <el-form-item label="登录密码" prop="password">
            <el-col :span="12">
                <el-input type="password" v-model.trim="model.password"></el-input>
            </el-col>
        </el-form-item>
        <el-form-item label="确认密码" prop="password2">
            <el-col :span="12">
                <el-input type="password" v-model.trim="model.password2"></el-input>
            </el-col>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="toSubmit">确定</el-button>
            <el-button @click="cancel">取消</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
import {app, tnx} from '../../app';

export default {
    data() {
        return {
            model: {},
            rules: {},
        };
    },
    created() {
        const vm = this;
        app.rpc.getMeta('/manager/add', meta => {
            const passwordRules = meta.rules.password;
            const password2Rules = [].concat(passwordRules);
            if (password2Rules[0].required) {
                password2Rules[0].message = '确认密码不能为空';
            }
            password2Rules.push({
                validator: function(rule, fieldValue, callback) {
                    const model = vm.model;
                    if (model.password && model.password2
                        && model.password !== model.password2) {
                        return callback(new Error('登录密码两次输入不一致'));
                    }
                    return callback();
                }
            });
            passwordRules.push({
                validator: function(rule, fieldValue, callback) {
                    if (vm.model.password2) {
                        vm.$refs.form.validateField('password2');
                    }
                    return callback();
                }
            });
            meta.rules.password2 = password2Rules;
            vm.rules = meta.rules;
        });
    },
    methods: {
        toSubmit() {
            const vm = this;
            this.$refs.form.validate(success => {
                if (success) {
                    tnx.confirm('管理员账号添加后无法删除，只能禁用，请谨慎操作。确定要添加吗？', yes => {
                        if (yes) {
                            const model = Object.assign({}, vm.model, {});
                            app.rpc.post('/manager/add', model, function() {
                                vm.$refs.form.disabled = true;
                                tnx.toast('添加成功', function() {
                                    vm.cancel();
                                });
                            });
                        }
                    });
                }
            });
        },
        cancel() {
            this.$router.back();
        }
    }
}
</script>
