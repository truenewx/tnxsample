<template>
    <el-form label-position="right" label-width="auto" ref="form" :model="model"
        :rules="rules" :validate-on-rule-change="false" :disabled="disabled" status-icon>
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
            disabled: false,
        };
    },
    created() {
        const managerId = this.$route.params.id;
        const vm = this;
        app.rpc.get('/manager/' + managerId, model => {
            vm.model = model;
            app.rpc.getMeta('/manager/*/update', meta => {
                delete meta.rules.password;
                vm.rules = meta.rules;
            });
        });
    },
    methods: {
        toSubmit() {
            const vm = this;
            this.$refs.form.validate(success => {
                if (success) {
                    const managerId = vm.$route.params.id;
                    const model = Object.assign({}, vm.model, {});
                    app.rpc.post('/manager/' + managerId + '/update', model, function() {
                        vm.disabled = true;
                        tnx.toast('修改成功', function() {
                            vm.cancel();
                        });
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
