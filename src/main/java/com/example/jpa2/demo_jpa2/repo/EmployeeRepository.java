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


//     @Query("select firstName,lastName from Employee where salary>(select ls from (select avg(salary) as ls from Employee)as dr)")
//     List<Employee> findEmployeeFirstAndLastNameBySorting(Sort by);


   @Modifying
    @Query("select avg(salary) from Employee")
    List<Object> findAvg();

    @Modifying
    @Query("update Employee set salary = 0 where salary = :n2")
    void updateByAvg( @Param("n2") Object n2);


    @Modifying
    @Query("select min(salary) from Employee")
    List<Object> findMin();

    @Modifying
    @Query("delete from Employee where salary =:n")
    void deleteByMin(@Param("n") Object n);



  ///==================================Native======================================================


    @Query(value="Select emp_id ,emp_first_name,emp_age from employee  where emp_last_name='sharma'",nativeQuery = true)
    List<Object[]> findAllEmployeeByFirstAndLastNameNq();


    @Modifying
    @Query(value = "delete from employee where emp_age > :n" , nativeQuery = true)
    void deleteEmployeeByAgeGreaterByNative(@Param("n") int n);




}
