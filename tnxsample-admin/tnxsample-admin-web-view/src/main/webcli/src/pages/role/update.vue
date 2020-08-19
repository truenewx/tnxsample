<template>
    <el-form label-position="right" label-width="auto" ref="form" :model="model"
        :rules="rules" :validate-on-rule-change="false" status-icon>
        <el-form-item label="名称" prop="name">
            <el-col :span="9">
                <el-input v-model.trim="model.name"/>
            </el-col>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
            <el-col :span="18">
                <el-input v-model.trim="model.remark"/>
            </el-col>
        </el-form-item>
        <el-form-item label="操作权限">
            <el-col :span="18">
                <tnxel-permission-tree class="border" ref="permissionTree" :menu="menu"
                    :permissions="model.permissions"/>
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
import menu from '../../layout/menu';

export default {
    components: {
        'tnxel-permission-tree': tnx.components.PermissionTree,
    },
    data() {
        return {
            menu: menu,
            model: {
                name: '',
                remark: '',
            },
            rules: {},
        };
    },
    created() {
        const roleId = this.$route.params.id;
        const vm = this;
        app.rpc.get('/role/' + roleId, model => {
            vm.model = model;
            app.rpc.getMeta('/role/*/update', meta => {
                vm.rules = meta.rules;
            });
        });
    },
    methods: {
        toSubmit() {
            const vm = this;
            this.$refs.form.validate(success => {
                if (success) {
                    const roleId = vm.$route.params.id;
                    const model = Object.assign({}, vm.model, {
                        permissions: this.$refs.permissionTree.getPermissions()
                    });
                    app.rpc.post('/role/' + roleId + '/update', model, function() {
                        vm.$refs.form.disabled = true;
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
