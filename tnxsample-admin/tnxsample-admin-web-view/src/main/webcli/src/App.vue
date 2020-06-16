<template>
    <a-config-provider :locale="locale">
        <div id="app">
            <p>
                <img alt="Vue logo" src="./assets/logo.png">
            </p>
            <a-date-picker/>
        </div>
    </a-config-provider>
</template>

<script>
    import zh_CN from 'ant-design-vue/es/locale/zh_CN';
    import moment from 'moment';
    import 'moment/locale/zh-cn';

    moment.locale('zh-cn');

    export default {
        name: 'App',
        components: {},
        data: function() {
            return {locale: zh_CN};
        }
    }
</script>

<style>
    #app {
        text-align: center;
    }
</style>