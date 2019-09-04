package org.sarba.spring.bean.pattern.anno;

import org.springframework.stereotype.Component;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-12 14:51
 * @description: 基于注解的bean定义
 **/
@Component("annoBean")
public class AnnoBean {

    public void getMessage(){
        System.out.println("I is anno bean message!");
    }

}
