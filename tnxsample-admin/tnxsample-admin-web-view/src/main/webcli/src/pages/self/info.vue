<template>
    <el-form ref="model" :model="model" :rules="rules">
        <el-form-item label="姓名" prop="fullName">
            <el-input v-model="model.fullName"></el-input>
        </el-form-item>
    </el-form>
</template>

<script>
    export default {
        data () {
            return {
                model: {},
                rules: {},
            };
        },
        methods: {
            dialog () {
                return {
                    title: '修改个人信息',
                    type: 'confirm',
                    click: this.toSubmit
                }
            },
            toSubmit (yes) {
                console.info(yes);
            }
        }
    }
</script>
