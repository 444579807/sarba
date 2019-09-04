package org.sarba.springboot.web.sarbaspringbootweb.entity;

import lombok.Data;

import java.util.Date;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-08-28 10:29
 * @description:
 **/
@Data
public class Message {

    private Long id;
    private String message;
    private Date   createDate;
    private String desc;

}
