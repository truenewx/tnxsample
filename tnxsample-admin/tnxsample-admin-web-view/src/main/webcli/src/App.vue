<template>
    <div id="app" class="d-flex flex-column">
        <el-header height="auto" class="border-bottom fixed-top">
            <layout-header/>
        </el-header>
        <div class="flex-grow-1 d-flex page-container">
            <el-aside width="auto">
                <layout-menu/>
            </el-aside>
            <el-main class="flex-grow-1 border-left d-flex flex-column" :class="{'bg-muted':!home}">
                <layout-breadcrumb v-if="!home"/>
                <div class="flex-grow-1 border bg-white p-3" v-if="!home">
                    <router-view></router-view>
                </div>
                <page-index v-else/>
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
    import breadcrumb from "./layout/breadcrumb";
    import footer from './layout/footer.vue';
    import index from './pages/index.vue';

    export default {
        name: 'App',
        components: {
            'layout-header': header,
            'layout-menu': menu,
            'layout-breadcrumb': breadcrumb,
            'layout-footer': footer,
            'page-index': index,
        },
        data () {
            return {}
        },
        computed: {
            home () {
                return this.$route.path === "/";
            }
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

    .el-main {
        padding: 1rem;
    }
</style>