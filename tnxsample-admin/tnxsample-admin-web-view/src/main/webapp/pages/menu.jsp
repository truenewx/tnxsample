<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="accordion" id="accordionMenu" js="/menu.js" css="/menu.css">
    <div class="card">
        <div class="card-header" id="menu-item-0">
            <h3 class="mb-0">
                <button class="btn btn-link btn-block text-left" type="button"
                    data-toggle="collapse" data-target="#collapse-0" aria-expanded="true"
                    aria-controls="collapse-0">
                    Collapsible Group Item #1
                </button>
            </h3>
        </div>
        <div id="collapse-0" class="collapse show" aria-labelledby="menu-item-0"
            data-parent="#accordionMenu">
            <ul class="list-group">
                <li class="list-group-item">Cras justo odio</li>
                <li class="list-group-item">Dapibus ac facilisis in</li>
                <li class="list-group-item">Morbi leo risus</li>
                <li class="list-group-item">Porta ac consectetur ac</li>
                <li class="list-group-item">Vestibulum at eros</li>
            </ul>
        </div>
    </div>
</div>
