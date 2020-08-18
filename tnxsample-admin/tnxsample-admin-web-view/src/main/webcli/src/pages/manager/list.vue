<template>
    <div>
        <div class="d-flex justify-content-between mb-3">
            <el-button type="primary" @click="toAdd" v-if="addable">添加管理员</el-button>
        </div>
        <el-table :data="records" :empty-text="emptyRecordText" border stripe>
            <el-table-column prop="jobNo" label="工号" min-width="80px"/>
            <el-table-column prop="fullName" label="姓名" min-width="80px"/>
            <el-table-column prop="username" label="用户名" min-width="100px"/>
            <el-table-column label="所属角色" class-name="tnxel-table_tags nowrap" min-width="200px">
                <template slot-scope="scope">
                    <template v-if="scope.row.roles.length > 0">
                        <el-tag type="info" v-for="role in scope.row.roles" :key="role.id">
                            {{role.name}}
                        </el-tag>
                    </template>
                    <span class="text-muted" v-else>&lt;无&gt;</span>
                </template>
            </el-table-column>
            <el-table-column label="状态" min-width="60px" header-align="center" align="center">
                <template slot-scope="scope">
                    <i class="el-icon-remove-outline link" v-if="scope.row.disabled"></i>
                    <i class="el-icon-success link" v-else></i>
                </template>
            </el-table-column>
            <el-table-column label="操作" class-name="tnxel-table_tags" min-width="60px"
                header-align="center" align="center">
                <template slot-scope="scope">
                    <router-link :to="'/manager/' + scope.row.id + '/update'"
                        class="tnxel-table_tag" v-if="updatable"><span>修改</span></router-link>
                    <a href="javascript:void(0)" @click="toResetPassword">重置密码</a>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
import menu from "../../layout/menu";
import {app} from "../../app";

export default {
    data() {
        return {
            addable: false,
            updatable: false,
            records: null,
            paging: null,
        };
    },
    computed: {
        emptyRecordText() {
            return this.records === null ? '加载中...' : '暂无数据';
        }
    },
    created() {
        const vm = this;
        menu.loadGrantedItems(() => {
            vm.addable = menu.isGranted('/manager/add');
            vm.updatable = menu.isGranted('/manager/*/update');
            vm.deletable = menu.isGranted('/manager/*/delete');
        });
        app.rpc.get('/manager/list', {}, function(result) {
            vm.records = result.records;
            vm.paging = result.paging;
        });
    },
    methods: {
        toAdd() {
            this.$router.push('/manager/add');
        },
        toResetPassword() {
        }
    }
}
</script>
