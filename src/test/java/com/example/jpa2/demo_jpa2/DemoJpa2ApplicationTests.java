package com.example.jpa2.demo_jpa2;

import com.example.jpa2.demo_jpa2.repo.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class DemoJpa2ApplicationTests {

	@Autowired
	EmployeeRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	void testEmployeeCreate() {
		Employee employee = new Employee();
		employee.setFirstName("Amit");
		employee.setLastName("Verma");
		employee.setSalary(10000);
		employee.setAge(50);

		Employee employee2 = new Employee();
		employee2.setFirstName("chetan");
		employee2.setLastName("sharma");
		employee2.setSalary(100000);
		employee2.setAge(46);

		repository.save(employee);
		repository.save(employee2);
	}

	@Test
	void testFindAllEmployee() {
		System.out.println("-----------------" + repository.findAllEmployee());
	}

	@Test
	void testFindAllEmployeeByFirstName() {
		System.out.println("-----------------" + repository.findAllEmployeeByFirstName("Chetan"));
	}

	@Test
	@Transactional
	@Rollback(false)
	void testDeleteAllEmployeeByFirstName() {
		repository.deleteAllEmployeeByFirstName("Chetan");
	}




//========================================JPQL=====================================================
	@Test
	@Transactional
	@Rollback(false)
	void testFindEmployeeFirstAndLastNameBySorting(){
		repository.findEmployeeFirstAndLastNameBySorting(Sort.by(new Sort.Order(null,"age"),new Sort.Order(Sort.Direction.DESC,"salary")));
 }


	@Test
	@Transactional
	@Rollback(false)
	void testUpdateAllEmployeeByAvgSalary(){
		repository.updateAllEmployeeByAvgSalary(1);
	}


	@Test
	@Transactional
	@Rollback(false)
	void testDeleteAllEmployeeByMinSalary(){
		repository.deleteAllEmployeeByAvgSalary();
	}




	//=========================================Native ======================================
	@Test
	void testFindAllEmployeeByFirstAndLastNameNq() {
		List<Object[]> pd =repository.findAllEmployeeByFirstAndLastNameNq();
		for (Object[] object: pd) {
			System.out.println(object[0]);
			System.out.println(object[1]);
			System.out.println(object[2]);
		}
	}

	@Test
	@Transactional
	@Rollback(false)
	void testDeleteEmployeeByAgeGreaterByNative() {
		repository.deleteEmployeeByAgeGreaterByNative(45);
	}



}
