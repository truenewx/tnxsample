<template>
    <div id="app" class="d-flex flex-column">
        <el-header height="auto" class="border-bottom fixed-top">
            <layout-header/>
        </el-header>
        <div class="flex-grow-1 d-flex page-container">
            <el-aside width="auto">
                <layout-menu/>
            </el-aside>
            <el-main class="flex-grow-1 border-left">
                <router-view></router-view>
            </el-main>
        </div>
        <el-footer height="auto" class="border-top py-2">
            <layout-footer/>
        </el-footer>
    </div>
</template>

<script>
    import header from './layout/header.vue';
    import menu from './layout/menu.vue';
    import footer from './layout/footer.vue';

    export default {
        name: 'App',
        components: {
            "layout-header": header,
            "layout-menu": menu,
            "layout-footer": footer,
        },
        data() {
            return {}
        }
    }
</script>

<style>
    html, body {
        height: 100%;
    }

    #app {
        height: auto;
        min-height: 100%;
    }

    header {
        line-height: 55px;
        background-color: #fff;
    }

    .page-container {
        padding-top: 56px;
    }

    aside {
        min-width: 222px;
    }
</style>