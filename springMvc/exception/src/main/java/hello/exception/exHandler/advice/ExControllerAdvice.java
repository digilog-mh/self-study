package hello.exception.exHandler.advice;

import hello.exception.exHandler.ErrorResult;
import hello.exception.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackages = "hello.exception.api")
//@ControllerAdvice + @ResponseBody, 대상을 지정하지 않으면 모든 컨트롤러에 적용.(글로벌 적용)
public class ExControllerAdvice {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult illegalExHandler(IllegalArgumentException e){
        log.error("[exceptionHandler] ex",e);
        return new ErrorResult("BAD", e.getMessage());
        //정상처리.
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResult> userExHandler(UserException e){
        log.error("[exceptionHandler] ex ",e);
        ErrorResult errorResult = new ErrorResult("USER-EX", e.getMessage());
        return new ResponseEntity(errorResult, HttpStatus.BAD_REQUEST);
        //user-ex
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public ErrorResult exHandler(Exception e){
        log.error("[exceptionHandler] ex ",e);
        return new ErrorResult("EX", "내부오류");
        //ex
    }
}
