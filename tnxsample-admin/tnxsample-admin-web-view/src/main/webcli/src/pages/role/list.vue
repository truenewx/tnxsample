<template>
    <div>
        <el-button type="primary" class="mb-3" @click="toAdd" v-if="addable">添加角色</el-button>
        <el-table :data="records" :empty-text="emptyRecordText" border stripe>
            <el-table-column prop="name" label="名称" min-width="160px" width="160px"/>
            <el-table-column label="操作权限" class-name="tnxel-table_tags nowrap" min-width="40%">
                <template slot-scope="scope">
                    <el-tag v-for="permission in scope.row.permissions" :key="permission">
                        {{permission}}
                    </el-tag>
                </template>
            </el-table-column>
            <el-table-column label="管理员" class-name="tnxel-table_tags nowrap" min-width="40%">
                <template slot-scope="scope">
                    <template v-if="scope.row.managerNum > 0">
                        <span>共{{scope.row.managerNum}}人：</span>
                        <el-tag type="info" v-for="manager in scope.row.managers" :key="manager">
                            {{manager}}
                        </el-tag>
                    </template>
                    <span class="text-muted" v-else>&lt;无&gt;</span>
                </template>
            </el-table-column>
            <el-table-column label="操作" class-name="tnxel-table_tags" min-width="100px"
                width="100px" header-align="center" align="center">
                <template slot-scope="scope">
                    <router-link :to="'/role/' + scope.row.id + '/update'" class="tnxel-table_tag"
                        v-if="updatable">修改</router-link>
                    <router-link :to="'/role/' + scope.row.id + '/delete'" class="tnxel-table_tag"
                        v-if="deletable">删除</router-link>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
import app from "../../app";
import menu from '../../layout/menu.js';

export default {
    data () {
        return {
            addable: false,
            updatable: false,
            deletable: false,
            records: null,
        };
    },
    computed: {
        emptyRecordText () {
            return this.records === null ? '加载中...' : '暂无数据';
        }
    },
    created () {
        const vm = this;
        menu.loadGrantedItems(() => {
            vm.addable = menu.isGranted('/role/add');
            vm.updatable = menu.isGranted('/role/*/update');
            vm.deletable = menu.isGranted('/role/*/delete');
        });
        app.rpc.get('/role/list', {}, function(records) {
            for (let record of records) {
                if (record.permissions) {
                    for (let i = 0; i < record.permissions.length; i++) {
                        const item = menu.getItemByPermission(record.permissions[i]);
                        if (item) {
                            record.permissions[i] = item.caption;
                        }
                    }
                }
            }
            vm.records = records;
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

<style>
</style>
