<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户详情</title>
    <#include "../include/head.ftl" />
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
        .detail-test-layer{
            margin-left: 5%;
        }
    </style>
</head>
<body>

<div class="layer-pop detail-test-layer ">
    <div class="row">

        <div class="form-group col-xs-6">
            <label class="col-xs-4 control-label">分类名称：</label>
            <div class="col-xs-8">
                <label class="control-label">${(category.category)!}</label>
            </div>
        </div>

        <div class="form-group col-xs-6">
            <label class="col-xs-4 control-label">分类状态：</label>
            <div class="col-xs-8">
                <label class="control-label">
                    <#if category.state == 0>
                        启用中
                    <#elseif category.state == 1>
                        已停用
                    </#if>
                </label>
            </div>
        </div>

    </div>

    <div class="row">

        <div class="form-group col-xs-6">
            <label class="col-xs-4 control-label">最后修改人：</label>
            <div class="col-xs-8">
                <label class="control-label">${(category.updateName)!}</label>
            </div>
        </div>

        <div class="form-group col-xs-6">
            <label class="col-xs-4 control-label">修改时间：</label>
            <div class="col-xs-8">
                <label class="control-label">${(category.updateStr)!}</label>
            </div>
        </div>

    </div>

    <#list select as s>
        <div class="row">

            <div class="form-group col-xs-6">
                <label class="col-xs-4 control-label">选项
                            <#if s_index == 0> A
                            <#elseif s_index == 1> B
                            <#elseif s_index == 2> C
                            <#elseif s_index == 3> D
                            </#if>：
                </label>
                <div class="col-xs-8">
                    <label class="control-label">${(s.addSelect)!}</label>
                </div>
            </div>

            <div class="form-group col-xs-6">
                <label class="col-xs-4 control-label">错误反馈：</label>
                <div class="col-xs-8">
                    <label class="control-label">${(s.errorInfo)!}</label>
                </div>
            </div>

        </div>
    </#list>

</div>

</body>
</html>