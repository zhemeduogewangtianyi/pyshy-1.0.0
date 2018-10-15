<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户详情</title>

    <#include "../include/head.ftl">
    <style>
        .layer-pop{
            margin-top: 40px;
        }
        .row{
            margin: 15px;
            padding-left: 15px;
            padding-right: 15px;

        }
        .form-group{
            margin-bottom: 15px;
            margin-top: 15px;
        }
    </style>
</head>
<body>

<div class="layer-pop detail-picture-layer fn-hide">
    <div class="row">

        <div class="form-group col-xs-6">
            <label class="col-xs-4 control-label">用户ID：</label>
            <div class="col-xs-8">
                <label class="control-label">${(userInfo.uid)!}</label>
            </div>
        </div>

        <div class="form-group col-xs-6">
            <label class="col-xs-4 control-label">用户名称：</label>
            <div class="col-xs-8">
                <label class="control-label">${(userInfo.name)!}</label>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-xs-6">
            <label class="col-xs-4 control-label">用户账号：</label>
            <div class="col-xs-8">
                <label class="control-label">${(userInfo.username)!}</label>
            </div>
        </div>

        <div class="form-group col-xs-6">
            <label class="col-xs-4 control-label">用户状态：</label>
            <div class="col-xs-8">
                <label class="control-label">
                    <#if userInfo.state == 0>
                        启用中
                    <#elseif userInfo.state == 1>
                        已停用
                    </#if>
                </label>
            </div>
        </div>
    </div>

</div>

</body>
</html>