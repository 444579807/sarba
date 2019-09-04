package org.sarba.spring.bean.pattern.javaBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-07-12 14:52
 * @description:
 **/
@Configuration
public class BeanConfiguration {

    @Bean
    public JavaBean javaBean(){
        return new JavaBean();
    }
}
