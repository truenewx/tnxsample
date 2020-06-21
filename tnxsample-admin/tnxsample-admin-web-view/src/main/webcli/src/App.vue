<template>
    <div id="app" class="d-flex flex-column">
        <el-header height="auto" class="border-bottom fixed-top">
            <page-header/>
        </el-header>
        <div class="flex-grow-1 d-flex page-container">
            <el-aside width="auto">
                <page-menu/>
            </el-aside>
            <el-main class="flex-grow-1 border-left">Main</el-main>
        </div>
        <el-footer height="auto" class="border-top py-2">
            <page-footer/>
        </el-footer>
    </div>
</template>

<script>
    import Header from './pages/Header.vue';
    import Menu from './pages/Menu.vue';
    import Footer from './pages/Footer.vue';

    export default {
        name: 'App',
        components: {
            "page-header": Header,
            "page-menu": Menu,
            "page-footer": Footer,
        },
        data () {
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

    aside {
        min-width: 222px;
        height: 100%;
    }

    .page-container {
        padding-top: 56px;
    }
</style>