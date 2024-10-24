package custom.queries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import custom.queries.entity.Employee;
import custom.queries.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/salary/{salary}")
	public List<Employee> getEmployeesWithHighSalary(@PathVariable double salary) {
		
		return employeeService.getEmployeesWithHighSalary(salary);
	}
	
	@GetMapping("/manager/{managerId}")
	public List<Employee> getEmployeesByManager(@PathVariable Long managerId) {
		
		return employeeService.getEmployeesByManager(managerId);
	}
	
	@GetMapping("/search/{name}")
	public List<Employee> searchEmployeesByName(@PathVariable String name) {
		
		return employeeService.searchEmployeesByName(name);
	}
	
	@PostMapping("/save")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		return employeeService.saveEmployee(employee);
	}

}
