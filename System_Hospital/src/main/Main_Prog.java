package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Patient;
import entities.Physician;

public class Main_Prog {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("--------------------------------------");
		System.out.println("       HOSPITAL SHINY STUFF           ");
		System.out.println("--------------------------------------");
		System.out.println();
		
		System.out.println("Enter doctor data: ");
		System.out.print("NAME: ");
		String name = sc.nextLine();
		System.out.println("CRM: ");
		String crm_cod = sc.nextLine();
		System.out.println("ESPECIALIZATION: ");
		String especi = sc.next();		
		Physician phy = new Physician(name, crm_cod, especi);		
		System.out.println();
		
		System.out.println("Enter patient data: ");
		System.out.print("NAME: ");
		String namePat = sc.nextLine();
		System.out.println("RG: ");
		Integer rg = Integer.valueOf(sc.nextLine());
		System.out.println("CPF: ");
		Integer cpf = Integer.valueOf(sc.nextLine());
		System.out.print("STREET: ");
		String street = sc.nextLine();
		System.out.println("HOUSE: ");
		int house = sc.nextInt();
		System.out.println("DISTRICT: ");
		sc.nextLine();
		String distr = sc.nextLine();
		System.out.println("CITY: ");
		String city = sc.nextLine();
		System.out.println("STATE: ");
		String state = sc.nextLine();
		System.out.print("BIRTH DATE: ");
		Date birth_date = sdf.parse(sc.nextLine());
		System.out.println("PHONE NUMBER: ");
		String phNumb = sc.nextLine();			
		Patient pat = new Patient(namePat, rg, cpf, street, house, distr, city, state, birth_date);
		phy.addPatient(pat);
		System.out.println("Medication and dose: ");
		String medications = sc.next();	
		Double dose = sc.nextDouble();
		phy.addMedications(medications, dose);
		System.out.println("Dose: ");
		
		
		

		
		
		sc.close();
	}

}
