<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
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
        .add_btn{
            margin-left: 90%;
        }
    </style>
</head>
<body>

<div class="layer-pop add-category-layer fn-hide">

    <button type="button" class="btn btn-primary add_btn" onclick="addLine()">新增</button>
    <form id="add_form">
        <div class="row">

            <input type="hidden" name="id" value="${(categoryVO.id)!}">

            <div class="form-group col-xs-6">
                <label class="col-xs-4 control-label">分类：</label>
                <div class="col-xs-8">
                    <!--<label class="control-label">${(userInfo.uid)!}</label>-->
                    <input type="text" class="form-control" placeholder="请输入分类" name="category" id="category" value="${(categoryVO.category)!}" />
                </div>
            </div>


        </div>

        <#if children??>
            <#list children as vo>
                <div class="row add ${vo.id}">
                    <input type="hidden" name="children_id" value="${(vo.id)!}">
                    <div class="form-group col-xs-6">
                        <label class="col-xs-4 control-label" onclick="deleteLine(${vo.id})">选项
                            <#if vo_index == 0> A
                            <#elseif vo_index == 1> B
                            <#elseif vo_index == 2> C
                            <#elseif vo_index == 3> D
                            </#if>：
                        </label>
                        <div class="col-xs-8">
                            <!--<label class="control-label">${(userInfo.name)!}</label>-->
                            <input type="text" class="form-control" placeholder="请输入选项" name="addSelect" value="${(vo.addSelect)!}" />
                        </div>
                    </div>

                    <div class="form-group col-xs-6">
                        <label class="col-xs-4 control-label">错误信息：</label>
                        <div class="col-xs-8">
                            <!--<label class="control-label">${(userInfo.name)!}</label>-->
                            <input type="text" class="form-control" placeholder="错误信息,正确键入 0 " name="errorInfo" value="${(vo.errorInfo)!}" />
                        </div>
                    </div>
                </div>
            </#list>
        <#else>
            <div class="row add">
                <div class="form-group col-xs-6">
                    <label class="col-xs-4 control-label">选项：</label>
                    <div class="col-xs-8">
                        <!--<label class="control-label">${(userInfo.name)!}</label>-->
                        <input type="text" class="form-control" placeholder="请输入选项" name="addSelect" value="" />
                    </div>
                </div>

                <div class="form-group col-xs-6">
                    <label class="col-xs-4 control-label">错误信息：</label>
                    <div class="col-xs-8">
                        <!--<label class="control-label">${(userInfo.name)!}</label>-->
                        <input type="text" class="form-control" placeholder="错误信息,正确键入 0 " name="errorInfo" value="" />
                    </div>
                </div>
            </div>
        </#if>
    </form>

</div>
<script>
    function addLine(){
        var cls = S4();
        var count = document.getElementsByClassName("add");
        var name = "addSelect"+count.length;
        var errorInfo = "errorInfo"+count.length;
        if(count.length < 4){
            $(".add-category-layer").append("<div class="+cls+">\n" +
                "        <div class=\"row add\">\n" +
                "            <div class=\"form-group col-xs-6\">\n" +
                "                <label class=\"col-xs-4 control-label\" onclick='deleteLine("+cls+")'>选项：</label>\n" +
                "                <div class=\"col-xs-8\">\n" +
                "                    <!--<label class=\"control-label\">${(userInfo.name)!}</label>-->\n" +
                "                    <input type=\"text\" class=\"form-control\" placeholder=\"请输入选项\" name=\"addSelect\" value=\"\" />\n" +
                "                </div>\n" +
                "            </div>\n" +
                "\n" +
                "            <div class=\"form-group col-xs-6\">\n" +
                "                <label class=\"col-xs-4 control-label\">错误信息：</label>\n" +
                "                <div class=\"col-xs-8\">\n" +
                "                    <input type=\"text\" class=\"form-control\" placeholder=\"错误信息,正确键入 0 \" name=\"errorInfo\" />\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>");
        }else{
            layer.msg("最多只能添加4个选项！");
        }

    }
    function deleteLine(obj){
        var id = "."+obj;
        $(id).remove();

    }
    function S4() {
        var myData = new Date();
        var times = myData.getTime();//当前时间的毫秒数
        return times;
    }

    function save(){
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

        $.ajax({
            type : 'post',
            url : "/test/save",
            data : JSON.stringify(param),
            dataType : 'json',
            contentType : "application/json",
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