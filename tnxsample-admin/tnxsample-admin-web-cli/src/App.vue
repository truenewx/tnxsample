<template>
    <a-locale-provider :locale="locale">
        <div id="app">
            <img alt="Vue logo" src="./assets/logo.png">
            <p>
                <a-button type="primary">Hello World</a-button>
            </p>
        </div>
    </a-locale-provider>
</template>

<script>
    import zh_CN from 'ant-design-vue/lib/locale-provider/zh_CN';
    import moment from 'moment';
    import 'moment/locale/zh-cn';

    moment.locale('zh-cn');

    export default {
        name: 'App',
        components: {
        },
        data: function() {
            return {
                locale: zh_CN
            }
        }
    }
</script>

<style>
    #app {
        font-family: Avenir, Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        margin-top: 60px;
    }
</style>
