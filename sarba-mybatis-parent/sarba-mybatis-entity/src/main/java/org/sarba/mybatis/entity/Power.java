package org.sarba.mybatis.entity;


import java.io.Serializable;

public class Power  implements Serializable{

    private Integer id;
    private String powerName;

    public Power() {
    }

    public Power(String powerName) {
        this.powerName = powerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }
}
