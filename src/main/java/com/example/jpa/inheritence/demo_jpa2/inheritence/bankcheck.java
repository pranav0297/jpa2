package com.example.jpa.inheritence.demo_jpa2.inheritence;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class bankcheck extends payment2{

    private String checknumber;


    public String getChecknumber() {
        return checknumber;
    }

    public void setChecknumber(String checknumber) {
        this.checknumber = checknumber;
    }
}
