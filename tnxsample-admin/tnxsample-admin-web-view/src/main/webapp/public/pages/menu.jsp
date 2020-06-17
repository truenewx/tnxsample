<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="side-navbar" :class="{'shrinked': shrinked}" js="menu.js">
    <div class="sidebar-header text-center">
        <i class="fas" role="button" :title="shrinked ? '展开菜单栏' : '收缩菜单栏'"
            :class="{'fa-angle-double-left': !shrinked, 'fa-angle-double-right': shrinked}"
            @click="shrink()"></i>
    </div>
    <ul class="list-unstyled">
        <li id="menu-item-default" :class="{'active': currentPath == '${context}/index'}">
            <a href="#${context}/index">
                <i class="fas fa-home"></i>首页
            </a>
        </li>
        <c:forEach var="level1Item" items="${menu.items}" varStatus="level1Status">
            <c:if test="${level1Item.type == 'MenuLink'}">
                <li id="menu-item-${level1Status.index}"
                    :class="{'active': currentPath == '${context}${level1Item.path}'}">
                    <a href="#${context}${level1Item.path}">
                        <i class="fas ${level1Item.icon}"></i>${level1Item.caption}
                    </a>
                </li>
            </c:if>
            <c:if test="${level1Item.type == 'MenuNode'}">
                <li>
                    <a href="#menu-item-${level1Status.index}"
                        :aria-expanded="expandedIndex == ${level1Status.index}"
                        data-toggle="collapse">
                        <i class="fas ${level1Item.icon}"></i>${level1Item.caption}
                    </a>
                    <ul id="menu-item-${level1Status.index}" class="collapse list-unstyled"
                        :class="{'show': expandedIndex == ${level1Status.index}}">
                        <c:forEach var="level2Item" items="${level1Item.subs}"
                            varStatus="level2Status">
                            <c:if test="${level2Item.type == 'MenuLink'}">
                                <li id="menu-item-${level1Status.index}-${level2Status.index}"
                                    :class="{'active': currentPath == '${context}${level2Item.path}'}">
                                    <a href="#${context}${level2Item.path}">
                                        <i class="fas ${level2Item.icon}"></i>${level2Item.caption}
                                    </a>
                                </li>
                            </c:if>
                        </c:forEach>
                    </ul>
                </li>
            </c:if>
        </c:forEach>
    </ul>
</nav>
