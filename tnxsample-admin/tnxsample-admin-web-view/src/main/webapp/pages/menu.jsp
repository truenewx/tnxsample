<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="side-navbar" :class="{'shrinked': shrinked}" js="/menu.js">
    <div class="sidebar-header text-center">
        <i class="fas" role="button" :title="shrinked ? '展开菜单栏' : '收缩菜单栏'"
            :class="{'fa-angle-double-left': !shrinked, 'fa-angle-double-right': shrinked}"
            @click="shrink()"></i>
    </div>
    <ul class="list-unstyled">
        <li class="active">
            <a href="${context}/"><i class="fas fa-home"></i>首页</a>
        </li>
    <c:forEach var="level1Link" items="${menu.links}" varStatus="level1Status">
        <li>
        <c:if test="${empty level1Link.subLinks}">
            <a href="#"><i class="fas ${level1Link.icon}"></i>${level1Link.caption}</a>
        </c:if><c:if test="${not empty level1Link.subLinks}">
            <a href="#menu-item-${level1Status.index}" aria-expanded="false" data-toggle="collapse">
                <i class="fas ${level1Link.icon}"></i>${level1Link.caption}
            </a>
            <ul id="menu-item-${level1Status.index}" class="collapse list-unstyled">
            <c:forEach var="level2Link" items="${level1Link.subLinks}">
                <li><a href="#"><i class="fas ${level2Link.icon}"></i>${level2Link.caption}</a></li>
            </c:forEach>
            </ul>
        </c:if>
        </li>
    </c:forEach>
    </ul>
</nav>