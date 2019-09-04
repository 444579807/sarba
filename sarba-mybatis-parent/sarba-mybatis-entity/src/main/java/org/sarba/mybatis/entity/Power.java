package org.sarba.mybatis.entity;


import java.io.Serializable;

public class Power  implements Serializable{

    private Long id;
    private String powerName;

    public Power(Long id,String powerName){
        this.id = id;
        this.powerName = powerName;
    }

    public Power(String powerName) {
        this.powerName = powerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }
}
