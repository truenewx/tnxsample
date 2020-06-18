<template>
    <div class="d-flex justify-content-between align-items-center">
        <h1 class="text-primary mb-0">
            <a :href="contextPath">{{title}}</a>
        </h1>
        <a-dropdown :trigger="['click']">
            <a class="ant-dropdown-link" @click="e => e.preventDefault()">
                <a-avatar icon="user" size="small" style="margin-right: 4px;"/>
                {{manager.fullName}} <a-icon type="down" />
            </a>
            <a-menu slot="overlay">
                <a-menu-item key="0">
                    <a href="http://www.alipay.com/">1st menu item</a>
                </a-menu-item>
                <a-menu-item key="1">
                    <a href="http://www.taobao.com/">2nd menu item</a>
                </a-menu-item>
            </a-menu>
        </a-dropdown>
    </div>
</template>

<script>
    export default {
        data () {
            return {
                title: process.env.VUE_APP_TITLE || 'tnxsample-admin',
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