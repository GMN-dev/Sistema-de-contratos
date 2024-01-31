package entities;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.enums.WorkerLevel;
import java.time.format.DateTimeFormatter;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	private Department department;
	private List<HourContract> listContracts = new ArrayList<>();
	
	//Constructor
	public Worker(String name, WorkerLevel workerLevelInput ,Double salaryInput, Department department) {
		this.name = name;
		this.department = department;
		this.baseSalary = salaryInput;
		this.level = workerLevelInput;
	}
	
	// Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public WorkerLevel getLevel() {
		return level;
	}
	public void setLevel(WorkerLevel level) {
		this.level = level;
	}
	public Double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getDepartment() {
		return this.department.getName();
	}	 
	public List<HourContract> getListContracts() {
		return listContracts;
	}
	
	
	// functions
	public void addContract(HourContract hourContract) {
		this.getListContracts().add(hourContract);
	}
	
	public void removeContract(HourContract hourContract) {
		this.getListContracts().remove(hourContract);
	}
	
	public Double income(String dateInput) {
		DateTimeFormatter dateFormatted = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateToSearchAndCalculate = LocalDate.parse("01/"+dateInput, dateFormatted);
		Double sumDatesTotalValue = this.getListContracts().stream()
				.filter(x->(x.getDate().getYear()==dateToSearchAndCalculate.getYear())&&(x.getDate().getMonth()==dateToSearchAndCalculate.getMonth()))
				.mapToDouble(x->x.totalValue())
				.sum();
		return sumDatesTotalValue + this.getBaseSalary();
	}
		
}
	
