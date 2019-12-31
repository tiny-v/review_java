package com.my.basic.enums;

/**
 * @author YMa69
 * @date 2019/12/31.
 */
public enum LocalEnum {

    HTTP_SUCCESS_200(200, "success"),
    HTTP_ERROR_400(400, "unreachable");

    private int code;
    private String msg;
    LocalEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }


    @Override
    public String toString() {
        return "LocalEnum{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public static void main(String[] args){
        System.out.println(LocalEnum.HTTP_ERROR_400.toString());
    }
}
