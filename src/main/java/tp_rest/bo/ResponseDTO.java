package tp_rest.bo;

public class ResponseDTO<T> {

    public String code;
    public T data;

    public ResponseDTO(String code, T data) {
        this.code = code;
        this.data = data;
    }
}
