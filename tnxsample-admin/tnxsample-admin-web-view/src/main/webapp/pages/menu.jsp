<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="side-navbar" :class="{'shrinked': shrinked}">
    <div class="sidebar-header text-center">
        <i class="fas" role="button" :title="shrinked ? '展开菜单栏' : '收缩菜单栏'"
            :class="{'fa-angle-double-left': !shrinked, 'fa-angle-double-right': shrinked}"
            @click="shrink()"></i>
    </div>
    <ul class="list-unstyled">
        <li class="active">
            <router-link to="/index"><i class="fas fa-home"></i>首页</router-link>
        </li>
    <c:forEach var="level1Item" items="${menu.items}" varStatus="level1Status">
        <li>
        <c:if test="${level1Item.type == 'MenuLink'}">
            <a href="#"><i class="fas ${level1Item.icon}"></i>${level1Item.caption}</a>
        </c:if><c:if test="${level1Item.type == 'MenuNode'}">
            <a href="#menu-item-${level1Status.index}" aria-expanded="false" data-toggle="collapse">
                <i class="fas ${level1Item.icon}"></i>${level1Item.caption}
            </a>
            <ul id="menu-item-${level1Status.index}" class="collapse list-unstyled">
            <c:forEach var="level2Item" items="${level1Item.subs}">
                <c:if test="${level2Item.type == 'MenuLink'}">
                <li><a href="#"><i class="fas ${level2Item.icon}"></i>${level2Item.caption}</a></li>
                </c:if>
            </c:forEach>
            </ul>
        </c:if>
        </li>
    </c:forEach>
    </ul>
</nav>