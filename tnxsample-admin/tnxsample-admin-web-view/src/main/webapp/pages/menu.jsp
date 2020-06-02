<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="side-navbar" :class="{'shrinked': shrinked}" js="/menu.js">
    <div class="sidebar-header text-center">
        <i class="fas cursor-pointer" :title="shrinked ? '展开菜单栏' : '收缩菜单栏'"
            :class="{'fa-angle-double-left': !shrinked, 'fa-angle-double-right': shrinked}"
            @click="shrink()"></i>
    </div>
    <ul class="list-unstyled">
        <li class="active">
            <a href="${context}/"><i class="fas fa-home"></i>首页</a>
        </li>
        <li>
            <a href="#menu-item-0" aria-expanded="false" data-toggle="collapse">
                <i class="fas fa-cogs"></i>系统管理
            </a>
            <ul id="menu-item-0" class="collapse list-unstyled">
                <li><a href="#">Page 1</a></li>
                <li><a href="#">Page 2</a></li>
                <li><a href="#">Page 3</a></li>
            </ul>
        </li>
        <li><a href="#"><i class="fas fa-user"></i>客户管理</a></li>
    </ul>
</nav>