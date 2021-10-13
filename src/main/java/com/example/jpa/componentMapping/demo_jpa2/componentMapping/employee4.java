package com.example.jpa.componentMapping.demo_jpa2.componentMapping;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class employee4 {
    @Id
    private int id;
    private String name ;

    @Embedded
    private address address1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public address getAddress1() {
        return address1;
    }

    public void setAddress1(address address1) {
        this.address1 = address1;
    }
}
