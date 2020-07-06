<template>
    <el-form label-position="right" label-width="auto" :model="model" :rules="rules">
        <el-form-item label="用户名">{{model.username}}</el-form-item>
        <el-form-item label="是否超管">
            <div>
                <i class="fa"
                    :class="model.top ? 'fa-check text-primary' : 'fa-ban text-muted'"></i>
            </div>
        </el-form-item>
        <el-form-item label="头像">
        </el-form-item>
        <el-form-item label="姓名" prop="fullName">
            <el-col :span="12">
                <el-input v-model="model.fullName"></el-input>
            </el-col>
        </el-form-item>
    </el-form>
</template>

<script>
    import {app, tnx} from '../../app.js';

    export default {
        data () {
            return {
                model: {
                    fullName: null
                },
                rules: {},
            };
        },
        created () {
            const vm = this;
            app.rpc.get('/manager/self/info', model => {
                vm.model = model;
            });
            app.rpc.getMeta('/manager/self/info', meta => {
                vm.rules = meta.rules;
            });
        },
        methods: {
            dialog () {
                return {
                    title: '修改个人信息',
                    width: '25%',
                    type: 'confirm',
                    click: this.toSubmit,
                }
            },
            toSubmit (yes, close, source) {
                if (yes) {
                    const model = this.model;
                    app.rpc.post('/manager/self/info', model, function() {
                        source.managerCaption = model.fullName;
                        tnx.alert('修改成功', () => {
                            close();
                        });
                    });
                    return false;
                }
            }
        }
    }
</script>
