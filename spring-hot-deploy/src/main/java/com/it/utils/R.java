package com.it.utils;


import lombok.Data;

//方便联调
@Data
public class R {
    private  boolean flag;
    private  Object data;

    private  String message;

    public R(boolean flag){
        this.flag=flag;
    }

    public R() {
    }
    public R(boolean flag ,Object data ){
        this.data=data;
        this.flag=flag;
    }

    public R(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }
}
