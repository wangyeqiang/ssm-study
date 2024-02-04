package org.example.error;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 全局异常发生会走此类下的Handler方法
@ControllerAdvice    // 可以返回逻辑视图，转发和重定向
@RestControllerAdvice  //  加了ResponseBody 直接返回json字符串的
public class GlobalExceptionHandler {

    /**
     * 发生异常 =》 @ControllerAdvice 注解的类型 =》 ExceptionHandler(指定的异常) =》 handler
     * 指定的异常可以精准查找 或者 查找父异常
     * @param e
     * @return
     */
    @ExceptionHandler(ArithmeticException.class)
    public Object ArithmeticExceptionHandler(ArithmeticException e){
        // 自定义处理异常
        String message = e.getMessage();
        System.out.println("message = " + message);
        return message;

    }

    @ExceptionHandler(Exception.class)  // 和下面形参的类型一致
    public Object ExceptionHandler(Exception e){
        // 自定义处理异常
        // 自定义处理异常
        String message = e.getMessage();
        System.out.println("message = " + message);
        return message;

    }
}
