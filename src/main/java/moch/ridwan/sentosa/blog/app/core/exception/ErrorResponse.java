package moch.ridwan.sentosa.blog.app.core.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;



@Getter
@Setter
public class ErrorResponse {
    private String message;
    private Throwable ex;
    private HttpStatus httpStatus;
}
