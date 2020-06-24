<template>
    <div class="text-center m-3">首页: {{name}}</div>
</template>

<script>
    import app from '../assets/app.js';

    export default {
        data () {
            return {
                name: app.name,
            };
        }
    }
</script>
