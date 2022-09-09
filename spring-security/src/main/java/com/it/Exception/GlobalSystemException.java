package com.it.Exception;

import com.it.util.SystemJsonResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 定义全局异常类
 */
@Data
@NoArgsConstructor
public class GlobalSystemException extends  RuntimeException{
     SystemJsonResponse systemJsonResponse;

     public GlobalSystemException(SystemJsonResponse systemJsonResponse) {
          System.out.println("构造器");
          this.systemJsonResponse = systemJsonResponse;
     }
}
