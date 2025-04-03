package dev.emir.e_commerce.core.utilies;

import dev.emir.e_commerce.core.result.Result;
import dev.emir.e_commerce.core.result.ResultData;
import lombok.ToString;

@ToString
public class ResultHelper {

    public static <T> ResultData<T> created(T data){
        return new ResultData<>(true,Messages.CREATED,"200",data);
    }

    public static <T> ResultData<T> validateError(T data){
        return new ResultData<>(false,Messages.VALIDATE_ERROR,"400",data);
    }

    public static <T> ResultData<T> success(T data){
        return new ResultData<>(true,Messages.OK,"201",data);
    }
    public static Result notFoundError(String message){
        return new Result(false,message,"400");
    }
}
