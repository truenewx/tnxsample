<template>
    <tnxel-form ref="form" :model="model" rule="/manager/*/update" :on-rules-loaded="onRulesLoaded"
        :submit="submit">
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
    </tnxel-form>
</template>

<script>
import {app, tnx} from '../../app';

export default {
    components: {
        'tnxel-form': tnx.components.Form,
    },
    data() {
        return {
            model: {},
        };
    },
    created() {
        const managerId = this.$route.params.id;
        const vm = this;
        app.rpc.get('/manager/' + managerId, model => {
            vm.model = model;
        });
    },
    methods: {
        onRulesLoaded(rules) {
            delete rules.password;
        },
        submit() {
            const vm = this;
            const managerId = vm.$route.params.id;
            const model = Object.assign({}, vm.model, {});
            app.rpc.post('/manager/' + managerId + '/update', model, function() {
                vm.$refs.form.disable();
                tnx.toast('修改成功', function() {
                    vm.$router.back();
                });
            });
        }
    }
}
</script>
