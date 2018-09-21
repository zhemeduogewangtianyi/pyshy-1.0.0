package com.pyshy.common.utils;

public class HttpSplicingUtils {

    private static final String SERVER_PORT = "http://localhost:8080/media/picture/";

    private static final String PICTURE_PATH = "C:\\Users\\Administrator\\Desktop\\model\\src\\main\\resources\\static\\media\\picture\\";

    public static String serverSplicing(String pictureName){
        String server_port = SERVER_PORT + pictureName;
        return server_port;
    }

    public static String pathSplicing(String pictureName){
        String picture_path = PICTURE_PATH + pictureName;
        return picture_path;
    }

}
