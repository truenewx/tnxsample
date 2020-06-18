<template>
    <a-config-provider :locale="locale">
        <div id="app">
            <a-layout>
                <a-layout-header class="border-bottom">
                    <page-header/>
                </a-layout-header>
                <a-layout>
                    <a-layout-sider>Sider</a-layout-sider>
                    <a-layout-content>
                        <a-calendar/>
                    </a-layout-content>
                </a-layout>
                <a-layout-footer>
                </a-layout-footer>
            </a-layout>
        </div>
    </a-config-provider>
</template>

<script>
    import zh_CN from 'ant-design-vue/es/locale/zh_CN';
    import moment from 'moment';
    import 'moment/locale/zh-cn';

    moment.locale('zh-cn');

    import Header from '@/pages/Header.vue';

    export default {
        name: 'App',
        components: {
            "page-header": Header
        },
        data () {
            return {
                locale: zh_CN
            }
        }
    }
</script>

<style>
    .ant-layout-header {
        height: unset;
        line-height: 55px;
        background-color: #fff;
    }
</style>