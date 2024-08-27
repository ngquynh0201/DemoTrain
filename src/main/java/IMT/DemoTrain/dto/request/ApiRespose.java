package IMT.DemoTrain.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;

import IMT.DemoTrain.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiRespose<T> {
    private int code = 1000;
    private String message;
    private T result;

    // public int getCode() {
    //     return code;
    // }

    // public void setCode(int code) {
    //     this.code = code;
    // }

    // public String getMessage() {
    //     return message;
    // }

    // public void setMessage(String message) {
    //     this.message = message;
    // }

    // public T getResult() {
    //     return result;
    // }

    // public void setResult(T result) {
    //     this.result = result;
    // }

    public void setResult(User createUser) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
