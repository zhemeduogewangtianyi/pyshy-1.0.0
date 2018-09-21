<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

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
            margin-left: 40%;
        }
        .row{
            margin-right: 0px;
            margin-left: -20px;
        }
    </style>
</head>
<body>
    <div class="layer-pop update-password-later">
        <form id="update_user_password_form" class="form-horizontal">
            <input type="hidden" name="uid" id="uid" value="${uid}" />

            <div class="row">
                <div class="form-group col-xs-6">
                    <label class="control-label">原密码：</label>
                    <input type="password" name="password" id="password" value="" />
                </div>
            </div>

            <div class="row">
                <div class="form-group col-xs-6">
                    <label class="control-label">新密码：</label>
                    <input type="password" name="newPassword" id="newPassword" value="" />
                </div>
            </div>

            <div class="row">
                <div class="form-group col-xs-6">
                    <label class="control-label">确认密码：</label>
                    <input type="password" name="repeatPassword" id="repeatPassword" value="" />
                </div>
            </div>
        </form>
    </div>

<script>
    function update_password(){
        var data = $("#update_user_password_form").serialize();
        $.ajax({
            type : 'post',
            url : "/user/updatePassword",
            data : data,
            success : function(data){
                // parent.window.query();
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