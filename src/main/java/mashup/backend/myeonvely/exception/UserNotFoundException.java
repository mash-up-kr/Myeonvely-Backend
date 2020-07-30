package mashup.backend.myeonvely.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserNotFoundException extends BaseException {

    public UserNotFoundException(){
        this("User does not exist.");
    }

    public UserNotFoundException(String message){
        super(ErrorCode.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message("[ UserNotFoundException]\n" + message)
                .build());
    }
}
