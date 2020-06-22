<template>
    <div>
        <el-breadcrumb class="px-3 pb-3 border-bottom">
            <el-breadcrumb-item :to="{ path: '/' }">
                <i class="fas fa-home"></i> 首页
            </el-breadcrumb-item>
            <el-breadcrumb-item v-for="(item, index) in items" :key="''+index" :to="item.path">
                {{item.caption}}
            </el-breadcrumb-item>
        </el-breadcrumb>
        <el-page-header class="my-3" :content="items[items.length-1].caption"
            @back="back"></el-page-header>
    </div>
</template>

<script>
    import menu from './menu.js';

    export default {
        data () {
            return {};
        },
        computed: {
            items () {
                return menu.getBreadcrumbItems(this.$route.path);
            }
        },
        methods: {
            back () {
                this.$router.back();
            }
        }
    }
</script>

<style>
    .el-breadcrumb__inner.is-link {
        font-weight: normal;
        color: #409EFF;
    }
</style>