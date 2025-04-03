package dev.emir.e_commerce.core.utilies;

import dev.emir.e_commerce.core.result.Result;
import dev.emir.e_commerce.core.result.ResultData;
import dev.emir.e_commerce.dto.response.CursorResponse;
import dev.emir.e_commerce.dto.response.category.CategoryResponse;
import lombok.ToString;
import org.springframework.data.domain.Page;

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

    public static <T> ResultData<CursorResponse<T>> cursor(Page<T> pageData){

        CursorResponse<T> cursor = new CursorResponse<>();
        cursor.setItems(pageData.getContent());
        cursor.setPageNumber(pageData.getNumber());
        cursor.setPageSize(pageData.getSize());
        cursor.setTotalElement(pageData.getTotalElements());

        return ResultHelper.success(cursor);
    }
}
