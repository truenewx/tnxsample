<template>
    <div>
        <el-button type="primary" class="mb-3" @click="toAdd" v-if="addable">添加角色</el-button>
        <el-table :data="records" current-row-key="role" border stripe>
            <el-table-column prop="name" label="名称"></el-table-column>
            <el-table-column label="权限" class-name="tnxel-table_tags">
                <template slot-scope="scope">
                    <el-tag v-for="permission in scope.row.permissions" :key="permission">
                        {{permission}}
                    </el-tag>
                </template>
            </el-table-column>
            <el-table-column label="管理员" class-name="tnxel-table_tags">
                <template slot-scope="scope">
                    <el-tag type="info" v-for="manager in scope.row.managers" :key="manager">
                        {{manager}}
                    </el-tag>
                    <span v-if="scope.row.managerNum > scope.row.managers.length">等</span>
                    <span>共{{scope.row.managerNum}}人</span>
                </template>
            </el-table-column>
            <el-table-column fixed="right" label="操作" class-name="tnxel-table_tags">
                <template slot-scope="scope">
                    <router-link :to="'/role/'+scope.row.id+'/update'" class="tnxel-table_tag"
                        v-if="updatable">修改</router-link>
                    <router-link :to="'/role/'+scope.row.id+'/delete'" class="tnxel-table_tag"
                        v-if="deletable">删除</router-link>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
import menu from '@/layout/menu.js';

export default {
    data () {
        return {
            addable: false,
            updatable: false,
            deletable: false,
            records: [{
                id: 1,
                name: '王小虎',
                permissions: ['CUSTOMER_LIST', 'CUSTOMER_DETAIL', 'CUSTOMER_DISABLE'],
                managers: ['张三', '李四', '王五'],
                managerNum: 6,
            }],
        };
    },
    created () {
        const vm = this;
        menu.loadGrantedItems(() => {
            vm.addable = menu.isGranted('/role/add');
            vm.updatable = menu.isGranted('/role/*/update');
            vm.deletable = menu.isGranted('/role/*/delete');
        });
    },
    methods: {
        toAdd () {
            this.$router.push('/role/add');
        },
        toUpdate (roleId) {

        },
        toDelete (roleId) {

        }
    }
}
</script>
