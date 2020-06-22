<template>
    <el-menu class="border-right-0" :default-active="$route.path" router unique-opened>
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
    import menuConfig from './menu.config.js';

    export default {
        data() {
            return {
                items: menuConfig.items,
            };
        }
    }
</script>
