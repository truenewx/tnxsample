<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="zh-cn">
<meta charset="UTF-8">
<head>
    <title>修改个人资料</title>
</head>

<body js="true">
<form @submit.prevent="submit" novalidate>
    <div class="form-group row">
        <label class="col-3 col-form-label">用户名</label>
        <div class="col-9">
            <p class="form-control-plaintext" v-text="model.username"></p>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-3 col-form-label">是否超管</label>
        <div class="col-9">
            <p class="form-control-plaintext">
                <i class="fa" :class="model.top ? 'fa-check text-primary' : 'fa-ban text-muted'"></i>
            </p>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-3 col-form-label">头像</label>
        <div class="col-9">

        </div>
    </div>
    <div class="form-group row">
        <label for="fullName" class="col-3 col-form-label">姓名</label>
        <div class="col-4">
            <input type="text" class="form-control" id="fullName" name="fullName"
                v-model.trim="model.fullName" @blur="$v.validate($event)">
        </div>
        <div class="col-5" :class="{'is-invalid': errors.fullName}">
            <div class="invalid-feedback" v-if="errors.fullName">{{errors.fullName.join(";")}}</div>
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
