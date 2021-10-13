package com.example.jpa.componentMapping.demo_jpa2.componentMapping;

import com.example.jpa.componentMapping.demo_jpa2.componentMapping.repo.employee4Repository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class ApplicationTests {
	@Autowired
	employee4Repository repository;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreate(){
		employee4 employee = new employee4();
		employee.setId(123);
		employee.setName("abhay");

		address address1 = new address();

		address1.setStreetaddress("shyam park");
		address1.setCity("gzb");
		address1.setState("up");
		address1.setCountry("india");
		address1.setZipcode("201001");

		employee.setAddress1(address1);
		repository.save(employee);
	}


}
