package org.sarba.springboot.web.sarbaspringbootweb.controller;

import org.sarba.springboot.web.sarbaspringbootweb.entity.Message;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @program: sarba
 * @author: zhanght
 * @create: 2019-08-28 10:26
 * @description:
 **/
@RestController
@RequestMapping("/web")
public class WebController {

    @ResponseBody
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public Message getMessage(){
        Message message = new Message();
        message.setId(1l);
        message.setCreateDate(new Date());
        message.setDesc("message desc !");
        message.setMessage("message");
        return message ;
    }

}
