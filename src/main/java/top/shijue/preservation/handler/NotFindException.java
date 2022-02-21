package top.shijue.preservation.handler;/*
 * @Author: Dong
 * @DateTime: 2021/7/15 上午11:46
 * @Description: TODO 未找到资源自定义异常
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFindException extends RuntimeException{
    public NotFindException() {
    }

    public NotFindException(String message) {
        super(message);
    }

    public NotFindException(String message, Throwable cause) {
        super(message, cause);
    }
}
