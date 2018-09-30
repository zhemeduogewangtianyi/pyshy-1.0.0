<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新增Banner</title>
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
<div class="layer-pop add-category-layer fn-hide">

    <form>
        <input type="hidden" name="id" value="${(vo.id)!}" />
        <div class="row">
            <div class="form-group col-xs-6">
                <label class="col-xs-4 control-label">图片名称：</label>
                <div class="col-xs-8">
                    <input type="text" class="form-control" placeholder="请输入图片详情" name="name" value="${(vo.name)!}" />
                </div>
            </div>

            <div class="form-group col-xs-6">
                <label class="col-xs-4 control-label">排序：</label>
                <div class="col-xs-8">
                    <input type="text" class="form-control" placeholder="请输入图片排序" name="sort" value="${(vo.sort)!}" />
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-xs-6">
                <label class="col-xs-4 control-label">上传图片：</label>
                <div class="col-xs-8">
                    <input id="file" onchange="show_image()" type="file" name="file" />
                    <p class="help-block">上传图片不得大于10MB</p>
                </div>
            </div>
            <div class="form-group col-xs-6">
                <label class="col-xs-4 control-label">图片预览：</label>
                <div id="img_show" class="col-xs-8 hidden">
                    <img width="230px" height="150px" src="" class="layui-upload-img" id="img">
                </div>
            </div>
        </div>
    </form>
</div>
<script>

    $(function(){
        var id = $("input[name=id]").val();
        if(id){
            queryImage(id);
        }
    });

    function queryImage(id) {
        $.ajax({
            type : 'get',
            url : '/banner/queryImage',
            data : {"id":id},
            success : function (data) {
                $("#img").attr("src","data:image/jpeg;base64,"+data)
                $('#img_show').removeClass('hidden');
                $('#img_show').addClass("show");
            }
        })
    }

    function getFileUrl(sourceId) {
        var url;
        if (navigator.userAgent.indexOf("MSIE")>=1) { // IE
            url = document.getElementById(sourceId).value;
        } else if(navigator.userAgent.indexOf("Firefox")>0) { // Firefox
            url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
        } else if(navigator.userAgent.indexOf("Chrome")>0) { // Chrome
            url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
        }
        return url;
    }


    function show_image(){
        var f = document.getElementById('file');
        if(f.files.length>0){

            var src = getFileUrl("file");
            $('#img').attr('src',src);

            $('#img_show').removeClass('hidden');
            $('#img_show').addClass("show");
        }else{
            $('#img_show').removeClass('show');
            $('#img_show').addClass("hidden");
        }

    }

    function save(){
        var formDate = new FormData();

        var img_file = document.getElementById("file");
        var fileObj = img_file.files[0];

        if(img_file.files.length > 0){
            formDate.append("file",fileObj);
        }else{
            layer.msg("请添加图片！");
            return;
        }

        var param = {};


        var name = $('input[name=name]').val();
        var sort = $('input[name=sort]').val();

        if(!name){
            layer.msg("请输入图片名称！");
            return ;
        }

        if(!sort){
            layer.msg("请输入图片排序！");
            return;
        }

        param['name'] = name;
        param['sort'] = sort;

        formDate.append("param",JSON.stringify(param));

        $.ajax({
            type : 'post',
            url : "/banner/save",
            data : formDate,
            contentType : false,
            processData : false,
            async : false,
            success : function(data){
                if(data.code == 200){
                    layer.msg(data.message,{time:1000},function(e){
                        parent.window.location.reload();
                    });
                }else{
                    layer.msg(data.message);
                }
            }
        })
    }

    function update(){
        var formDate = new FormData();

        var img_file = document.getElementById("file");
        var fileObj = img_file.files[0];


        if(img_file.files.length > 0){
            formDate.append("file",fileObj);
        }
        console.log(fileObj)
        var param = {};

        var id = $('input[name=id]').val();
        var name = $('input[name=name]').val();
        var sort = $('input[name=sort]').val();

        if(!name){
            layer.msg("请输入图片名称！");
            return;
        }

        if(!sort){
            layer.msg("请输入图片排序！");
            return ;
        }

        param['id'] = id;
        param['name'] = name;
        param['sort'] = sort;

        formDate.append("param",JSON.stringify(param));

        $.ajax({
            type : 'post',
            url : "/banner/update",
            data : formDate,
            contentType : false,
            processData : false,
            async : false,
            success : function(data){
                if(data.code == 200){
                    layer.msg(data.message,{time:1000},function(e){
                        parent.window.location.reload();
                    });
                }else{
                    layer.msg(data.message);
                }
            }
        })
    }
</script>
</body>
</html>