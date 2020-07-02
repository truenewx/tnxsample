<template>
    <div>

    </div>
</template>

<script>
    export default {
        data () {
            return {};
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
