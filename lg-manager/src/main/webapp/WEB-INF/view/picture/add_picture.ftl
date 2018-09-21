<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>新增</title>

    <link rel="shortcut icon" href="media/images/9.png">
    <link href="/media/css/bootstrap.css" rel="stylesheet">
    <link href="/media/layer/theme/default/layer.css" rel="stylesheet">
    <link href="/media/layer/mobile/need/layer.css" rel="stylesheet">
    <!-- 引入bootstrap-table样式 -->
    <link href="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.css" rel="stylesheet">
    <script src="/media/js/jquery-1.11.1.js" type="text/javascript"></script>
    <script src="/media/js/bootstrap.js"></script>
    <script src="/media/layui/layui.js"></script>
    <script src="/media/layer/layer.js" merge="true"></script>
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

        <div class="row">
            <div class="form-group col-xs-6">
                <label class="col-xs-4 control-label">图片名称：</label>
                <div class="col-xs-8">
                    <input type="text" class="form-control" placeholder="请输入图片名称" name="pictureName" value="" />
                </div>
            </div>

            <div class="form-group col-xs-6">
                <label class="col-xs-4 control-label">作者：</label>
                <div class="col-xs-8">
                    <input type="text" class="form-control" placeholder="请输入作者" name="author" value="" />
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-xs-6">
                <label class="col-xs-4 control-label">图片详情：</label>
                <div class="col-xs-8">
                    <input type="text" class="form-control" placeholder="请输入图片详情" name="content" value="" />
                </div>
            </div>

            <div class="form-group col-xs-6">
                <label class="col-xs-4 control-label">图片描述：</label>
                <div class="col-xs-8">
                    <input type="text" class="form-control" placeholder="请输入图片描述" name="remark" value="" />
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
                    <img width="230px" height="150px" class="layui-upload-img" id="img">
                </div>
            </div>
        </div>


    </form>

</div>
<script>

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

        var pictureName = $('input[name=pictureName]').val();
        var pictureRemark = $('input[name=remark]').val();
        var pictureContent = $('input[name=content]').val();
        var author = $('input[name=author]').val();

        param['pictureName'] = pictureName;
        param['remark'] = pictureRemark;
        param['content'] = pictureContent;
        param['author'] = author;

        formDate.append("param",JSON.stringify(param));

        $.ajax({
            type : 'post',
            url : "/picture/upload",
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
        var param = {};
        var category = $("#category").val();
        var select = "";
        $("input[name=addSelect]").each(function(){
            select += $(this).val()+",";
        });
        var errorInfo = "";
        $("input[name=errorInfo]").each(function(){
            errorInfo += $(this).val()+",";
        });
        param['category'] = category;
        param['addSelect'] = select;
        param['errorInfo'] = errorInfo;

        param['id'] = $("input[name=id]").val();

        var childrenId = "";
        $("input[name=children_id]").each(function(){
            childrenId += $(this).val()+",";
        });

        param['childrenId'] =childrenId;
        $.ajax({
            type : 'post',
            url : "/test/update",
            data : JSON.stringify(param),
            dataType : 'json',
            contentType : "application/json",
            success : function(data){

                if(data.code == 200){
                    parent.layer.closeAll();
                    parent.layer.msg(data.message);
                    parent.location.reload();
                }else{
                    parent.layer.msg(data.message);
                }
            }
        })
    }
</script>
</body>
</html>