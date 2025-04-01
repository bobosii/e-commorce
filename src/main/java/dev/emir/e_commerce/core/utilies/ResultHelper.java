package dev.emir.e_commerce.core.utilies;

import dev.emir.e_commerce.core.result.ResultData;

public class ResultHelper {

    public static <T> ResultData<T> created(T data){
        return new ResultData<>(true,Messages.CREATED,"200",data);
    }
}
