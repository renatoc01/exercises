package com.renato;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComplexCollectionStreamProcessing {

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Alice", "Engineering", 60000));
		employees.add(new Employee("Bob", "Marketing", 45000));
		employees.add(new Employee("Charlie", "Engineering", 70000));
		employees.add(new Employee("Dave", "Engineering", 40000));
		employees.add(new Employee("Eve", "Engineering", 55000));
		employees.add(new Employee("Frank", "HR", 35000));
		employees.add(new Employee("Grace", "Engineering", 75000));

		System.out.println(processEmployeeData(employees));

	}

	// Complex Collection Stream Processing
	// To tackle this challenge you'll need a solid understanding of advanced Stream
	// API concepts, especially complex filtering and mapping.
	public static List<Employee> processEmployeeData(List<Employee> employees) {
		return employees.stream().filter(e -> e.getDepartment().equals("Engineering"))
				.sorted(Comparator.comparing(Employee::getSalary).reversed()).map(e -> {
					// Complex transformation logic
					e.setBonusEligibility(calculateBonusEligibility(e));
					return e;
				}).limit(10).collect(Collectors.toList());
	}

	private static boolean calculateBonusEligibility(Employee employee) {
		return employee.getSalary() > 60000; // Exemplo simples: salários maiores que 50.000 têm direito ao bônus
	}

}

class Employee {
	private String name;
	private String department;
	private double salary;
	private boolean bonusEligibility;

	// Construtor, getters e setters
	public Employee(String name, String department, double salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public double getSalary() {
		return salary;
	}

	public boolean isBonusEligibility() {
		return bonusEligibility;
	}

	public void setBonusEligibility(boolean bonusEligibility) {
		this.bonusEligibility = bonusEligibility;
	}

	@Override
	public String toString() {
		return name + " - " + department + " - " + salary + " - " + bonusEligibility;
	}
}