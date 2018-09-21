package com.pyshy.common.baseEnum;

public enum CommonEnum {

    INT_0(0),
    INT_1(1),
    INT_2(2),
    INT_6(6),
    INT_200(200),
    INT_500(500),


    STRING_SALT("8d78869f470951332959580424d4bf4f"),
    STRING_USERNAME("admin"),
    STRING_YES("YES"),
    STRING_NO("NO"),
    STRING_IMG_JPG(".jpg"),
    STRING_SERVER_PORT("C:\\Users\\Administrator\\Desktop\\model\\src\\main\\resources\\static\\media\\picture\\");

    ;

    private Integer code;

    private String row;

    CommonEnum(Integer code) {
        this.code = code;
    }

    CommonEnum(String row) {
        this.row = row;
    }

    CommonEnum(Integer code, String row) {
        this.code = code;
        this.row = row;
    }

    public Integer getCode() {
        return code;
    }

    public String getRow() {
        return row;
    }
}
