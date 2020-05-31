package pl.teo.petshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserNotFoundExceptionAdvice {
    @ResponseBody
    @ExceptionHandler({UserNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFoundHandler (UserNotFoundException e){
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler({ProductNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String productNotFoundHandler (ProductNotFoundException e){
        return e.getMessage();
    }

    @ResponseBody
    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String resourceNotFoundException (ResourceNotFoundException e){
        return e.getMessage();
    }
}
