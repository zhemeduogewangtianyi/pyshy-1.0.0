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
    <!-- bootstrap-table.min.js -->
    <!--<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>-->
    <!-- 引入中文语言包 -->
    <!--<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>-->


</head>
<body>
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
                        <span title="pictureName">${(vo.pictureName)!}</span>
                    </div>
                </div>

            </div>

            <div class="row">

                <div class="form-group col-xs-6">
                    <label class="col-xs-4 control-label">图片预览：</label>
                    <div id="img_show" class="col-xs-8">
                        <img width="230px" height="150px" src="${(vo.imgUrlAll)!}" class="layui-upload-img" id="img">
                    </div>
                </div>

                <div class="form-group col-xs-6">
                    <label class="col-xs-4 control-label">作者：</label>
                    <div class="col-xs-8">
                        <span title="${(vo.author)!}">${(vo.author)!}</span>
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

            <div class="row">

                <div class="form-group col-xs-6">
                    <label class="col-xs-4 control-label">图片描述：</label>
                    <div class="col-xs-8">
                        <span title="${(vo.remark)!}">${(vo.remark)!}</span>
                    </div>
                </div>

                <div class="form-group col-xs-6">
                    <label class="col-xs-4 control-label">图片详情：</label>
                    <div class="col-xs-8">
                        <span title="${(vo.content)!}">${(vo.content)!}</span>
                    </div>
                </div>
            </div>

        </div>
    </div>
<script>

</script>
</body>
</html>