<template>
    <div>
        <p>角色管理</p>
        <el-button type="primary" @click="toAdd" v-if="addable">添加角色</el-button>
    </div>
</template>

<script>
    import menu from '../../layout/menu.js';

    export default {
        title: '角色清单',
        data () {
            return {
                addable: menu.isGranted('/role/add'),
            };
        },
        methods: {
            toAdd () {
                this.$router.push('/role/add');
            }
        }
    }
</script>
