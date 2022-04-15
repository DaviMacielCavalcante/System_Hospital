package main.testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Patient;
import model.dao.DaoFactory;
import model.dao.PatientDao;

public class ProgramPatTeste {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/YYYY");
		
		Scanner sc= new Scanner(System.in);
		
		PatientDao patDao = DaoFactory.createPatientDao();
		
		System.out.println("=== TEST 1: patient insert ====");	
		
		System.out.print("Informe o nome: ");
		
		String name = sc.nextLine();
		
		System.out.print("Informe o cpf: ");
		
		String cpf = sc.nextLine();
		
		System.out.print("Informe a data de nascimento: ");
		
		Date birthDate = sdf.parse(sc.nextLine());
		
		System.out.print("Informe o telefone para contato: ");
		
		String phoneN = sc.nextLine();
		
		Patient pat = new Patient(null, name, cpf, birthDate, phoneN);
		
		patDao.insert(pat);
		
		System.out.println("Inserted! New id = " + pat.getId() + ", Name: " + pat.getName());
		
		sc.close();
	}

}
