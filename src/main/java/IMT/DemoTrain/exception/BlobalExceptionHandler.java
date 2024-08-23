package IMT.DemoTrain.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import IMT.DemoTrain.dto.request.ApiRespose;

@ControllerAdvice
public class BlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiRespose> handlingRuntimeException(RuntimeException exception) {
        ApiRespose apiRespose = new ApiRespose();

        apiRespose.setCode(ErroCode.UNCATEGORIZED_EXCEPTION.getCode());
        apiRespose.setMessage(ErroCode.UNCATEGORIZED_EXCEPTION.getMessage());

        return ResponseEntity.badRequest().body(apiRespose);
    }

    ResponseEntity<ApiRespose> handlingAppException(AppException exception) {
        ErroCode erroCode = exception.getErroCode();
        ApiRespose apiRespose = new ApiRespose();

        apiRespose.setCode(erroCode.getCode());
        apiRespose.setMessage(erroCode.getMessage());

        return ResponseEntity.badRequest().body(apiRespose);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiRespose> handlingValidation(MethodArgumentNotValidException exception) {
        String enumKey = exception.getFieldError().getDefaultMessage();

        ErroCode erroCode = ErroCode.INVALID_KEY;
        try {
            erroCode = ErroCode.valueOf(enumKey);
        } catch (IllegalArgumentException e) {

        }
        ApiRespose apiRespose = new ApiRespose();

        apiRespose.setCode(erroCode.getCode());
        apiRespose.setMessage(erroCode.getMessage());

        return ResponseEntity.badRequest().body(apiRespose);
    }
}
