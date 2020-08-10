<template>
    <el-form label-position="right" label-width="auto" :model="model" :rules="rules" status-icon>
        <el-form-item label="角色名称" prop="name">
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
                <el-tree ref="permissions"
                    :data="nodes"
                    :show-checkbox="true"
                    :default-expand-all="true"
                    :check-strictly="true"
                    :check-on-click-node="true"
                    :expand-on-click-node="false"
                    @check-change="onCheckChange"
                    node-key="id"
                    class="border px-1 py-2">
                    <div class="permission-node" slot-scope="{node,data}">
                        <span>{{data.label}}</span>
                        <span class="text-muted" :class="{'d-none': !data.remark}">
                            ({{data.remark}})
                        </span>
                    </div>
                </el-tree>
            </el-col>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="toSubmit">确定</el-button>
            <el-button @click="cancel">取消</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
import app from '../../app.js';
import menu from "../../layout/menu";

function addTreeNodesTo(parentId, menuItems, treeNodes) {
    for (let i = 0; i < menuItems.length; i++) {
        const item = menuItems[i];
        let node = {
            id: (parentId || 'node') + '-' + i,
            parentId: parentId,
            label: item.caption,
            remark: item.desc,
            permission: item.permission,
        };
        if (item.subs && item.subs.length) {
            node.children = node.children || [];
            addTreeNodesTo(node.id, item.subs, node.children);
        }
        if (item.operations && item.operations.length) {
            node.children = node.children || [];
            addTreeNodesTo(node.id, item.operations, node.children);
        }
        treeNodes.push(node);
    }
}

export default {
    data() {
        return {
            nodes: this.getTreeNodes(),
            model: {
                name: '',
                remark: '',
            },
            rules: {},
        };
    },
    created() {
        const vm = this;
        app.rpc.getMeta('/role/add', meta => {
            vm.rules = meta.rules;
        });
    },
    methods: {
        getTreeNodes() {
            let items = menu.getAssignableItems();
            const nodes = [];
            addTreeNodesTo(undefined, items, nodes);
            return nodes;
        },
        onCheckChange(node, checked) {
            if (checked) { // 节点被选中，则上级节点必须选中
                if (node.parentId) {
                    const tree = this.$refs.permissions;
                    tree.setChecked(node.parentId, true);
                }
            } else { // 节点未选中，则下级节点必须全部未选中
                const tree = this.$refs.permissions;
                if (node.children) {
                    node.children.forEach(child => {
                        tree.setChecked(child.id, false);
                    });
                }
            }
        },
        toSubmit() {
            const nodes = this.$refs.permissions.getCheckedNodes();
            if (nodes && nodes.length) {

            }
        },
        cancel() {
            this.$router.back();
        }
    }
}
</script>

<style>
form {
    max-width: 500px;
}

.permission-node {
    width: 100%;
}

.permission-node span:last-child {
    float: right;
    margin-right: 6px;
}
</style>
