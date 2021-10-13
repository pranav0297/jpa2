package com.example.jpa2.demo_jpa2.repo;

import com.example.jpa2.demo_jpa2.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    @Query("from Employee")
    List<Employee> findAllEmployee();

    @Query("from Employee where firstName=:firstName")
    List<Employee> findAllEmployeeByFirstName(@Param("firstName") String name);

    @Modifying
    @Query("delete from Employee where firstName= :firstName")
    void deleteAllEmployeeByFirstName(@Param("firstName") String firstName);



    //====================================JPQL=======================================


    @Query("select firstName,lastName from Employee where salary>(select ls from (select avg(salary) as ls from Employee)as dr)")
    List<Employee> findEmployeeFirstAndLastNameBySorting(Sort by);


    @Modifying
    @Query("update Employee e set salary =: n where salary<(select ls from (select avg(salary)  as ls from Employee )as dr)")
    void updateAllEmployeeByAvgSalary(@Param("n") int n );




    @Modifying
    @Query("delete from Employee where salary=(select lowestSalary from (select min(salary) as lowestSalary from Employee) as deleteRecord)")
    void deleteAllEmployeeByAvgSalary();



  ///==================================Native======================================================


    @Query(value="Select emp_id ,emp_first_name,emp_age from employee  where emp_last_name='sharma'",nativeQuery = true)
    List<Object[]> findAllEmployeeByFirstAndLastNameNq();


    @Modifying
    @Query(value = "delete from employee where emp_age > :n" , nativeQuery = true)
    void deleteEmployeeByAgeGreaterByNative(@Param("n") int n);




}
