package com.example.jpa.inheritence.demo_jpa2.inheritence;

import javax.persistence.Entity;

@Entity
public class card extends payment{

    private String cardno;

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }
}
