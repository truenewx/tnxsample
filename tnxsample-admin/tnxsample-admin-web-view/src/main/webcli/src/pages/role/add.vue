<template>
    <el-form label-position="right" label-width="auto" ref="form" :model="model" :rules="rules"
        status-icon>
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
                <tnxel-permission-tree ref="permissionTree" :menu="menu" class="border"/>
            </el-col>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="toSubmit">确定</el-button>
            <el-button @click="cancel">取消</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
import {app, tnx} from '@/app';
import menu from '@/layout/menu';

export default {
    data () {
        return {
            menu: menu,
            model: {
                name: '',
                remark: '',
            },
            rules: {},
        };
    },
    created () {
        const vm = this;
        app.rpc.getMeta('/role/add', meta => {
            vm.rules = meta.rules;
        });
    },
    methods: {
        toSubmit () {
            const vm = this;
            this.$refs.form.validate(success => {
                if (success) {
                    const model = Object.assign({}, this.model, {
                        permissions: this.$refs.permissionTree.getPermissions()
                    });
                    app.rpc.post('/role/add', model, function() {
                        tnx.toast('添加成功', function() {
                            vm.cancel();
                        });
                    });
                }
            });
        },
        cancel () {
            this.$router.back();
        }
    }
}
</script>

<style scoped>
form {
    max-width: 500px;
}
</style>
