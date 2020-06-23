<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<meta charset="UTF-8">
<head>
    <title>修改登录密码</title>
</head>

<body js="true">
<form @submit.prevent="submit" novalidate>
    <div class="form-group row">
        <label for="oldPassword" class="col-3 col-form-label required">原密码</label>
        <div class="col-5">
            <input type="password" class="form-control" id="oldPassword"
                :class="{'is-invalid': error.oldPassword}" v-model.trim="model.oldPassword">
        </div>
        <div class="col-4 is-invalid" v-if="error.oldPassword">
            <div class="invalid-feedback">原密码错误</div>
        </div>
    </div>
    <div class="form-group row">
        <label for="newPassword" class="col-3 col-form-label required">新密码</label>
        <div class="col-5">
            <input type="password" class="form-control" id="newPassword"
                :class="{'is-invalid': error.newPassword}" v-model.trim="model.newPassword">
        </div>
        <div class="col-4 is-invalid" v-if="error.newPassword">
            <div class="invalid-feedback">两次输入的密码不一致</div>
        </div>
    </div>
    <div class="form-group row">
        <label for="newPassword2" class="col-3 col-form-label required">确认密码</label>
        <div class="col-5">
            <input type="password" class="form-control" id="newPassword2"
                :class="{'is-invalid': error.newPassword}" v-model.trim="newPassword2">
        </div>
        <div class="col-4 is-invalid" v-if="error.newPassword">
            <div class="invalid-feedback">两次输入的密码不一致</div>
        </div>
    </div>
    <div class="form-group row mb-0">
        <div class="offset-3 col-9">
            <button type="submit" class="btn btn-primary">确定</button>
            <button type="button" class="btn btn-secondary" @click="cancel">取消</button>
        </div>
    </div>
</form>
</body>
</html>
