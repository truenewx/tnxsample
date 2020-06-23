<template>
    <el-menu class="border-right-0" :default-active="activePath" router unique-opened>
        <template v-for="(item, itemIndex) in items">
            <el-submenu v-if="item.subs" :key="itemIndex" :index="'' + itemIndex">
                <template slot="title">
                    <i class="fas" :class="item.icon"></i>
                    <span>{{item.caption}}</span>
                </template>
                <el-menu-item v-for="(sub, subIndex) in item.subs" :key="itemIndex + '-' + subIndex"
                    :index="sub.path">
                    <template slot="title">
                        <i class="fas" :class="sub.icon"></i>
                        <span>{{sub.caption}}</span>
                    </template>
                </el-menu-item>
            </el-submenu>
            <el-menu-item v-else :key="itemIndex" :index="item.path">
                <template slot="title">
                    <i class="fas" :class="item.icon"></i>
                    <span>{{item.caption}}</span>
                </template>
            </el-menu-item>
        </template>
    </el-menu>
</template>

<script>
    import menu from './menu.js';

    export default {
        data () {
            return {
                items: menu.items,
            };
        },
        computed: {
            activePath () {
                if (this.$route.path === "/") {
                    return undefined;
                }
                let item = menu.getItem(this.$route.path);
                return item ? item.path : undefined;
            }
        }
    }
</script>

<style>
    .el-menu .fa, .el-menu .fas {
        margin-right: 5px;
        width: 24px;
        text-align: center;
        vertical-align: middle;
    }
</style>
