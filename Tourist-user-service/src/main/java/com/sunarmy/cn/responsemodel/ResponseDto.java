package com.sunarmy.cn.responsemodel;

import com.sunarmy.cn.datatype.ResponseType;

/**
 * Created by wb-wsj429645 on 2018/8/27.
 */
public class ResponseDto {
    Integer response_Code;
    String response_Msg;
    Object data;

    public ResponseDto() {
    }

    public ResponseDto(ResponseType responseType){
        this.response_Code= responseType.getCode();
        this.response_Msg= responseType.getMsg();
    }

    public ResponseDto(ResponseType responseType, String msg){
        this.response_Code= responseType.getCode();
        this.response_Msg=msg;
    }

    public ResponseDto(Integer code,String msg){
        this.response_Code=code;
        this.response_Msg=msg;
    }

    public Integer getResponse_Code() {
        return response_Code;
    }

    public void setResponse_Code(Integer response_Code) {
        this.response_Code = response_Code;
    }

    public String getResponse_Msg() {
        return response_Msg;
    }

    public void setResponse_Msg(String response_Msg) {
        this.response_Msg = response_Msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
