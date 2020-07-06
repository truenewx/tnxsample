<%@ page language="java" contentType="text/html; charset=utf-8" %>
<div id="header-container" js="header.js">
    <el-header height="auto" class="border-bottom fixed-top" theme="primary">
        <el-row class="container" type="flex" align="middle" justify="space-between">
            <h3>
                <el-link href="${context}/" :underline="false">{{title}}</el-link>
            </h3>
        </el-row>
    </el-header>
</div>
