package com.z5n.springboot.blog.util;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintViolationException;
import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;

/**
 * 异常处理工具类
 */
public class ConstraintViolationExceptionHandler {
    /**
     * 批量获取异常信息
     * @param e 异常类
     * @return 异常信息
     */
    public static String getMessage(ConstraintViolationException e) {
        List<String> msgList = new ArrayList<>();
        for(ConstraintViolation<?> constraintViolation : e.getConstraintViolations()){
            msgList.add(constraintViolation.getMessage());
        }
        String messages = StringUtils.join(msgList.toArray(), ";");
        return messages;
    }
}
