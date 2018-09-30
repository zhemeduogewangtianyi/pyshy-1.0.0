<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <style>
        .carousel-inner img {
            width:100%;
        }
        .picture_detail{
            margin-left: 20px;
            margin-right: 20px;
        }
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
        .detail-picture-layer{
            margin-left: 5%;
        }
    </style>
    <meta charset="UTF-8">
    <title>首页</title>
    <#include "../include/head.ftl" />
</head>
<body>
    <input type="hidden" name="id" value="${(vo.id)!}" />
    <div class="picture_detail">
        <div class="layer-pop detail-picture-layer fn-hide">

            <div class="row">
                <div class="form-group col-xs-6">
                    <label class="col-xs-4 control-label">图片序号：</label>
                    <div id="img_show" class="col-xs-8">
                        <span title="${(vo.id)!}">${(vo.id)!}</span>
                    </div>
                </div>

                <div class="form-group col-xs-6">
                    <label class="col-xs-4 control-label">图片名称：</label>
                    <div class="col-xs-8">
                        <span title="${(vo.name)!}">${(vo.name)!}</span>
                    </div>
                </div>

            </div>
        ${(vo.picture)!}
            <div class="row">

                <div class="form-group col-xs-6">
                    <label class="col-xs-4 control-label">图片预览：</label>
                    <div id="img_show" class="col-xs-8">
                        <img width='230px' height="150px" src='' class="layui-upload-img" id="img" />
                    </div>
                </div>

                <div class="form-group col-xs-6">
                    <label class="col-xs-4 control-label">排序：</label>
                    <div class="col-xs-8">
                        <span title="${(vo.sort)!}">${(vo.sort)!}</span>
                    </div>
                </div>

            </div>

            <div class="row">

                <div class="form-group col-xs-6">
                    <label class="col-xs-4 control-label">上传人：</label>
                    <div class="col-xs-8">
                        <span title="${(vo.createName)!}">${(vo.createName)!}</span>
                    </div>
                </div>

                <div class="form-group col-xs-6">
                    <label class="col-xs-4 control-label">上传时间：</label>
                    <div class="col-xs-8">
                        <span title="${(vo.createTimeStr)!}">${(vo.createTimeStr)!}</span>
                    </div>
                </div>

            </div>

            <div class="row">

                <div class="form-group col-xs-6">
                    <label class="col-xs-4 control-label">最后修改人：</label>
                    <div class="col-xs-8">
                        <span title="${(vo.updateName)!}">${(vo.updateName)!}</span>
                    </div>
                </div>

                <div class="form-group col-xs-6">
                    <label class="col-xs-4 control-label">修改时间：</label>
                    <div class="col-xs-8">
                        <span title="${(vo.updateTimeStr)!}">${(vo.updateTimeStr)!}</span>
                    </div>
                </div>

            </div>

        </div>
    </div>
<script>
    $(function(){
        queryImage($("input[name=id]").val());
    });

    function queryImage(id) {
        $.ajax({
            type : 'get',
            url : '/banner/queryImage',
            data : {"id":id},
            success : function (data) {
                $("#img").attr("src","data:image/jpeg;base64,"+data)
            }
        })
    }
</script>
</body>
</html>