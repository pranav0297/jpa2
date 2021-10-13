package com.example.jpa.inheritence.demo_jpa2.inheritence;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity

@DiscriminatorValue("cc")
public class CreditCard extends payment{

    private String cardno;

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }
}
