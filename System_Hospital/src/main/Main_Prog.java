package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Medications;
import entities.Patient;
import entities.Physician;

public class Main_Prog {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("--------------------------------------");
		System.out.println("       HOSPITAL SHINY STUFF           ");
		System.out.println("--------------------------------------");
		System.out.println();		
		
		boolean error = true;
		do {			
			try {
				error = false;				
				System.out.println("Enter patient data: ");
				System.out.print("NAME: ");
				String namePat = sc.nextLine();
				System.out.print("RG: ");
				Integer rg = Integer.valueOf(sc.nextLine());
				System.out.print("CPF: ");
				Integer cpf = Integer.valueOf(sc.nextLine());
				System.out.print("STREET: ");
				String street = sc.nextLine();
				System.out.print("HOUSE: ");
				int house = sc.nextInt();
				System.out.print("DISTRICT: ");
				sc.nextLine();
				String distr = sc.nextLine();
				System.out.print("CITY: ");
				String city = sc.nextLine();
				System.out.print("STATE: ");
				String state = sc.nextLine();
				System.out.print("BIRTH DATE: ");
				Date birth_date = sdf.parse(sc.nextLine());
				System.out.print("PHONE NUMBER: ");
				String phNumb = sc.nextLine();			
				Patient pat = new Patient(namePat, rg, cpf, street, house, distr, city, state, birth_date, phNumb);
			
				System.out.println("Enter doctor data: ");
				System.out.print("NAME: ");
				String name = sc.nextLine();
				System.out.print("CRM: ");
				String crm_cod = sc.nextLine();
				System.out.print("ESPECIALIZATION: ");
				String especi = sc.next();		
				Physician phy = new Physician(name, crm_cod, especi);
			
			
				System.out.print("How many medications? ");
				int n = sc.nextInt();
				for (int i = 1; i <= n; i++) {
					sc.nextLine();
					System.out.print("Medication: ");
					String medications = sc.nextLine();					
					System.out.print("Dose: ");
					String dose = sc.nextLine();		
					Medications medication = new Medications(medications, dose);
					phy.addMedications(medication);
				}			
					
				phy.addPatient(pat);
				
				System.out.println();
				
				System.out.println("Any additional information? [y/n]");
				char resp = sc.next().charAt(0);
				if ( resp == 'y') {
					phy.information();
				}				
				
				System.out.println("PRESCRIPTION: ");
				System.out.println(sdf2.format(new Date()));
				System.out.println(phy);
				if (resp == 'y') {
					System.out.println("Additional Information: ");
					System.out.print(phy.getInf()); 				
				}
			}
			catch (Exception e) {				
				System.out.println("Invalid input data");
				error = true;
				sc.nextLine();
			}				
					
		} while (error == true);
		sc.close();	
	}
}
	