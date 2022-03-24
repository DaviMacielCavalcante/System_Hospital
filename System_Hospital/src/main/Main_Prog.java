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
		System.out.println("       HOSPITAL PÉ DE DEFUNTO           ");
		System.out.println("--------------------------------------");
		System.out.println();		
		
		boolean error = true;
		do {			
			try {
				error = false;
				
				Patient pat = new Patient("Maria", "00539855296", sdf.parse("25/05/1995"), "55555555");
				System.out.println("O paciente já está registrado? [s/n]");
				char exists = sc.next().charAt(0);
				if (exists == 's') {
					System.out.println(pat.toString()); 
				}
				else {					
					sc.nextLine();
					System.out.println("Informe os dados do paciente: ");
					System.out.print("Nome: ");
					String namePat = sc.nextLine();				
					System.out.print("CPF: ");
					String cpf = sc.nextLine();				
					System.out.print("Data de Nascimento: ");
					Date birth_date = sdf.parse(sc.nextLine());
					System.out.print("Telefone: ");
					String phNumb = sc.nextLine();			
					pat = new Patient(namePat, cpf, birth_date, phNumb);					
				}			
				sc.nextLine();
				System.out.println();
				System.out.println("Informe dos dados do médico: ");
				System.out.print("Nome: ");
				String name = sc.nextLine();
				System.out.print("CRM: ");
				String crm_cod = sc.nextLine();
				System.out.print("Especialização: ");
				String especi = sc.next();		
				Physician phy = new Physician(name, crm_cod, especi);
			
				System.out.println();
				System.out.print("Quantos medicamentos? ");
				int n = sc.nextInt();
				sc.nextLine();
				
				for (int i = 1; i <= n; i++) {
					System.out.println();
					System.out.print("Medicamento: ");
					String medications = sc.nextLine();					
					System.out.print("Dose: ");
					String dose = sc.nextLine();		
					Medications medication = new Medications(medications, dose);
					phy.addMedications(medication);
				}			
					
				phy.addPatients(pat);
				
				System.out.println();
				
				System.out.println("Alguma informação adicional? [s/n]");
				char resp = sc.next().charAt(0);
				
				if ( resp == 's') {
					phy.information();
				}				
				System.out.println();
				System.out.println("Prescrição: ");
				System.out.println();
				System.out.println(sdf2.format(new Date()));				
				System.out.println(phy);				
				if (resp == 's') {
					System.out.println("Informação Adicional: ");
					System.out.print(phy.getInf()); 				
				}
			}
			catch (Exception e) {
				System.out.println();
				System.out.println("Entrada de dados inválida!");
				System.out.println();
				System.out.println("Aperte enter para recomeçar.");
				error = true;
				sc.nextLine();
			}				
					
		} while (error == true);
		sc.close();	
	}
}
	