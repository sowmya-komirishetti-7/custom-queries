package custom.queries.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import custom.queries.entity.Employee;
import custom.queries.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getEmployeesWithHighSalary(double salary) {
		return employeeRepository.findEmloyeeWithSlaryGreaterThan(salary);
	}
	
	public List<Employee> getEmployeesByManager(Long namagerId) {
		
		return employeeRepository.findEmployeesByManager(namagerId);
	}

	public List<Employee> searchEmployeesByName(String name) {
		
		return employeeRepository.findEmployeesByNameContaining(name);
	}
	
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}
}
