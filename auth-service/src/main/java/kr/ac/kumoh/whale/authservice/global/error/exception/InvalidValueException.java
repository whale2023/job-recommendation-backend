package kr.ac.kumoh.whale.authservice.global.error.exception;

import kr.ac.kumoh.whale.authservice.global.error.exception.BusinessException;
import kr.ac.kumoh.whale.authservice.global.error.exception.ErrorCode;

public class InvalidValueException extends BusinessException {
    public InvalidValueException(String value) {
        super(value, ErrorCode.INVALID_INPUT_VALUE);
    }

    public InvalidValueException(String value, ErrorCode errorCode){
        super(value, errorCode);
    }
}
