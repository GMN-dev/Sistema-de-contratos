import java.util.Locale;
import java.util.Scanner;
import entities.Department;
import entities.Worker;
import entities.enums.WorkerLevel;
import entities.HourContract;

public class Main {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
	
		System.out.print("Enter department´s name: ");
		String departmentsName = sc.nextLine();
		System.out.print("Name:");
		String name = sc.nextLine();
		System.out.print("Level: ");
		
		WorkerLevel workerLevel = WorkerLevel.converterWorkerLevel();
		
		System.out.println("Base salary: ");
		Double baseSalary = sc.nextDouble();
		System.out.println("How many contracts: ");
		Integer numContracts = sc.nextInt();
		
		
		Department dp = new Department(departmentsName);
		Worker worker = new Worker(name, workerLevel ,baseSalary, dp);
			
		for(int i = 1;i<=numContracts;i++) {
			System.out.printf("Enter contract #%d data:\n", i);
			System.out.print("Date: ");
			String dateInput = sc.next();
			System.out.println("Value per hour");
			Double valuePerHour = sc.nextDouble();
			System.out.println("Hours worked");
			Integer hours = sc.nextInt();
			HourContract newHourContract = new HourContract(dateInput, valuePerHour, hours);
			worker.addContract(newHourContract);
		}
	
		
		System.out.println("Enter month and year to this worker (MM/YYYY): ");
		String dateToGetIncome = sc.next();
		System.out.println(worker.getName());
		System.out.println(worker.getDepartment());
		System.out.printf("Income for %s: %.2f", dateToGetIncome, worker.income(dateToGetIncome));
		
	}
}