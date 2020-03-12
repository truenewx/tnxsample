<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="navbar navbar-expand-md navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand" href="${context}/">tnxsample</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbar">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="managerDropdown" role="button"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">admin</a>
                    <div class="dropdown-menu" aria-labelledby="managerDropdown">
                        <a class="dropdown-item" href="#">修改密码</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">登出</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</header>