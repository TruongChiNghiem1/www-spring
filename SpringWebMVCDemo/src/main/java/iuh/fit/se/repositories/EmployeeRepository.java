package iuh.fit.se.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import iuh.fit.se.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value = "SELECT * FROM employee e WHERE e.first_name LIKE  %:keyword%"
            + " OR e.last_name LIKE %:keyword%"
            + " OR e.email LIKE  %:keyword%"
            + " OR e.phone_number LIKE  %:keyword%", nativeQuery = true)
    List<Employee> search(@Param("keyword") String keyword);
}
