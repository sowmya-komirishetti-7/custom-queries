package custom.queries.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import custom.queries.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT e FROM Employee e WHERE e.salary > :salary")
	List<Employee> findEmloyeeWithSlaryGreaterThan(@Param("salary") double salary);
	
	@Query(value = "SELECT * FROM employee WHERE manager_id = :managerId", nativeQuery = true)
	List<Employee> findEmployeesByManager(@Param("managerId") Long managerId);
	
	@Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
	List<Employee> findEmployeesByNameContaining(@Param("name") String name);
	
}
