package com.pyshy.common.baseEnum;

public enum BizEnum {
    NOT_LOGIN("500","请先登录！"),
    SUCCESS("200","操作成功"),
    USER_NOT_ID("500","用户ID不正确"),
    USER_PASSWORD_NOT_NULL("500","原密码不能为空"),
    USER_NEW_PASSWORD_NOT_NULL("500","新密码不能为空"),
    REPEAT_PASSWOR_NOT_NULL("500","确认密码不能为空"),
    REPEAT_PASSWORD_DIFFERENCE("500","两次密码不一致"),
    OLD_PASSWORD_ERROR("500","原密码错误"),
    ADMIN_NOT_UPDATE("500","管理员密码不可被更改"),
    PASSWORD_LENGT_THAN_6("500","密码长度不可小于6位"),
    NEW_OLD_PASSWORD_NOT_EQUALS("500","新旧密码不可重复"),
    UPLOAD_ERROR("500","上传失败"),
    UPLOAD_NOT_NULL("500","上传文件不能为空"),
    UPLOAD_SUCCESS("200","上传成功"),
    UPLOAD_FORMAT_IS_ERROR("500","文件格式必须是 .jpg 结尾的图片文件"),
    CATEGORY_NOT_NULL("500","分类不能为空！"),
    ;

    private String code;
    private String message;

    BizEnum(String code,String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
