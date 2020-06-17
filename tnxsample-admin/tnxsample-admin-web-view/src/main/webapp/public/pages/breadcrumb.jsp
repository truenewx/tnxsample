<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav aria-label="breadcrumb" js="breadcrumb.js" v-if="links && links.length">
    <ol class="breadcrumb border-bottom">
        <template v-for="(link, index) of links">
            <li class="breadcrumb-item" :class="{'active': index == (links.length - 1)}">
                <a :href="'#' + link.path" v-if="link.path && index != (links.length - 1)">{{link.caption}}</a>
                <span v-else>{{link.caption}}</span>
            </li>
        </template>
    </ol>
</nav>