package com.wfy.java.cExceptionHandling;

/*
 * @Author wfy
 * @Date 2020/10/22 10:43
 * com.wfy.java.cExceptionHandling
 */

public class CustomException {
    public static void main(String[] args) {

    }
}

// 在一个大型项目中，可以自定义新的异常类型，但是，保持一个合理的异常继承体系是非常重要的。
// 一个常见的做法是自定义一个BaseException作为“根异常”，然后，派生出各种业务类型的异常。
// BaseException需要从一个适合的Exception派生，通常建议从RuntimeException派生：
// 自定义的BaseException应该提供多个构造方法：
class BaseException extends RuntimeException {
    public BaseException() {
        super();
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
}

class UserNotFoundException extends BaseException {

}

class LoginFailedException extends BaseException {

}