<template>
    <el-row class="container-fluid" type="flex" align="middle" justify="space-between">
        <h3>
            <el-link type="primary" :href="contextPath">{{title}}</el-link>
        </h3>
        <el-row type="flex" align="middle">
            <el-avatar class="mr-2" :size="32">
                <i class="el-icon-user-solid"></i>
            </el-avatar>
            <el-dropdown trigger="click">
            <span class="el-dropdown-link">{{manager.fullName}}
                <i class="el-icon-arrow-down el-icon--right"></i>
            </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item>个人资料</el-dropdown-item>
                    <el-dropdown-item>修改密码</el-dropdown-item>
                    <el-dropdown-item divided>登出系统</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
        </el-row>
    </el-row>
</template>

<script>
    export default {
        data() {
            return {
                title: process.env.VUE_APP_TITLE,
                contextPath: process.env.BASE_URL,
                manager: {
                    fullName: "admin"
                }
            };
        }
    }
</script>

<style scoped>
</style>