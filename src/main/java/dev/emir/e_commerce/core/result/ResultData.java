package dev.emir.e_commerce.core.result;

public class ResultData<T> extends Result {

    private T data;

    public ResultData(boolean status, String message, String code, T data) {
        super(status, message, code);
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
