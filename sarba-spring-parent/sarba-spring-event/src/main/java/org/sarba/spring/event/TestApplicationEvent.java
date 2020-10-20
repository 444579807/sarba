package org.sarba.spring.event;

import org.springframework.context.ApplicationEvent;

public class TestApplicationEvent extends ApplicationEvent {

    private String  msg ;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public TestApplicationEvent(Object source,String msg) {
        super(source);
        this.msg = msg;
    }
}
