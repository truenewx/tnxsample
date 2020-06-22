<template>
    <div id="app" class="d-flex flex-column">
        <el-header height="auto" class="border-bottom fixed-top">
            <layout-header/>
        </el-header>
        <layout-router/>
        <el-footer height="auto" class="border-top py-2">
            <layout-footer/>
        </el-footer>
    </div>
</template>

<script>
    import header from './layout/header.vue';
    import router from './layout/router.vue';
    import footer from './layout/footer.vue';

    export default {
        name: 'App',
        components: {
            "layout-header": header,
            "layout-router": router,
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
</style>