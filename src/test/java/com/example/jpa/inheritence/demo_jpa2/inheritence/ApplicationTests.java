package com.example.jpa.inheritence.demo_jpa2.inheritence;

import com.example.jpa.inheritence.demo_jpa2.inheritence.repo.PaymentRepository;
import com.example.jpa.inheritence.demo_jpa2.inheritence.repo.payment2Repository;
import com.example.jpa.inheritence.demo_jpa2.inheritence.repo.payment3Repository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

class ApplicationTests {

	@Autowired
	PaymentRepository repository;

@Autowired
	payment2Repository repository2;

	@Autowired
	payment3Repository repository3;


	@Test
	void contextLoads() {

	}


	//===========================SINGLE TABLE==========================================
@Test
	void createPaymentCc(){
		CreditCard cc = new CreditCard();

		cc.setId(100);
		cc.setAmount(10000d);
		cc.setCardno("123456");
		repository.save(cc);
	}

	@Test
	void createPaymentCh(){
		check ch = new check();

		ch.setId(1001);
		ch.setAmount(1000d);
		ch.setChecknumber("1234567");
		repository.save(ch);
	}


	//====================================TABLE PER CLASS=========================================


	@Test
	void createPaymentCcc(){
		card cc = new card();

		cc.setId(100);
		cc.setAmount(10000d);
		cc.setCardno("123456");
		repository.save(cc);
	}

	@Test
	void createPaymentChh(){
		bankcheck ch = new bankcheck();

		ch.setId(1001);
		ch.setAmount(1000d);
		ch.setChecknumber("1234567");
		repository2.save(ch);
	}

	//======================================JOINED ========================================


	@Test
	void createPaymentCccc(){
		card2 cc = new card2();

		cc.setId(100);
		cc.setAmount(10000d);
		cc.setCardno("123456");
		repository3.save(cc);
	}

	@Test
	void createPaymentChhh(){
		bankcheck2 ch = new bankcheck2();

		ch.setId(1001);
		ch.setAmount(1000d);
		ch.setChecknumber("1234567");
		repository3.save(ch);
	}


}
