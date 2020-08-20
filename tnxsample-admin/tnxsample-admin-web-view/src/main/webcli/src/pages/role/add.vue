<template>
    <tnxel-form ref="form" :model="model" :rule="url" :submit="submit">
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
                <tnxel-permission-tree class="border" ref="permissionTree" :menu="menu"/>
            </el-col>
        </el-form-item>
    </tnxel-form>
</template>

<script>
import {app, tnx} from '../../app';
import menu from '../../layout/menu';

export default {
    components: {
        'tnxel-form': tnx.components.Form,
        'tnxel-permission-tree': tnx.components.PermissionTree,
    },
    data() {
        return {
            url: '/role/add',
            menu: menu,
            model: {
                name: '',
                remark: '',
            },
        };
    },
    methods: {
        submit() {
            const vm = this;
            const model = Object.assign({}, vm.model, {
                permissions: this.$refs.permissionTree.getPermissions()
            });
            app.rpc.post(vm.url, model, function() {
                vm.$refs.form.disable();
                tnx.toast('添加成功', function() {
                    vm.$router.back();
                });
            });
        }
    }
}
</script>
