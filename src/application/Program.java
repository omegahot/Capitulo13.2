package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter department's name: ");
		String demartmentName = sc.nextLine();
		
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		
		System.out.print("Level: ");
		String level = sc.nextLine();
		
		System.out.print("Base Salary:");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, 
								   WorkerLevel.valueOf(level), 
								   baseSalary, 
								   new Department(demartmentName));
		
		System.out.println("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for (int i = 0 ; i < n ; i++) {
			
			System.out.println("Enter contract #"+ i +" data:");
			System.out.print("Data (dd/mm/yyyy):" );
			Date contractDate = sdf.parse(sc.next());
			
			System.out.println("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration: ");
			int hours = sc.nextInt();
			
			HourContract contract = new HourContract(contractDate, 
					                                 valuePerHour, 
					                                 hours);
			
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.println("Enter month and year to calculate income (mm/yyyy): ");
		String yearAndMonth = sc.next();
		int month = Integer.parseInt(yearAndMonth.substring(0,2)); 
		int year = Integer.parseInt(yearAndMonth.substring(3,4)); 
		
		System.out.println("Name: " + worker.getNome());
		System.out.println("Department: " + worker.getDepartment().getNome());
		System.out.println("Income for: " 
		                       + yearAndMonth
				               + ": " + String.format("%.2f", worker.income(year, month)));
		
		
		sc.close();
		
	}

}
