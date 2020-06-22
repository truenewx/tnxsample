<template>
    <div>
        <p>角色管理</p>
        <el-button type="primary" @click="toAdd">添加角色</el-button>
    </div>
</template>

<script>
    export default {
        title: '角色清单',
        data () {
            return {};
        },
        methods: {
            toAdd () {
                this.$router.push('/role/add');
            }
        }
    }
</script>
