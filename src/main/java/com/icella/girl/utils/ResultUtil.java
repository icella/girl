package com.icella.girl.utils;

import com.icella.girl.domain.Result;

public class ResultUtil {
    public static Result success(Object data){
        Result result = new Result();
        result.setCode(0);
        result.setMessage("Success");
        result.setData(data);

        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code, String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);

        return result;
    }
}
