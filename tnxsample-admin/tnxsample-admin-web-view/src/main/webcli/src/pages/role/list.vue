<template>
    <div>
        <el-button type="primary" class="mb-3" @click="toAdd" v-if="addable">添加角色</el-button>
        <el-table :data="records" current-row-key="role" border stripe>
            <el-table-column prop="name" label="角色名称"></el-table-column>
            <el-table-column label="管理员数量">
                <template slot-scope="scope">
                    <el-button type="text">{{scope.row.managerNum}}</el-button>
                </template>
            </el-table-column>
            <el-table-column fixed="right" label="操作">
                <template slot-scope="scope">
                    <el-button type="text">查看</el-button>
                    <el-button type="text">编辑</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
import menu from '../../layout/menu.js';

export default {
    data () {
        return {
            addable: menu.isGranted('/role/add'),
            records: [{
                name: '王小虎',
                managerNum: 0,
            }, {
                name: '王小虎',
                managerNum: 1,
            }, {
                name: '王小虎',
                managerNum: 2,
            }, {
                name: '王小虎',
                managerNum: 3,
            }],
        };
    },
    methods: {
        toAdd () {
            this.$router.push('/role/add');
        }
    }
}
</script>
