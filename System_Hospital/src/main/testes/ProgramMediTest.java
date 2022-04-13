package main.testes;

import java.util.Scanner;

import entities.Fabricantes;
import entities.Medications;
import model.dao.DaoFactory;
import model.dao.MedicationsDao;

public class ProgramMediTest {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);	
		
		MedicationsDao medDao = DaoFactory.createMedicationsDao();
		
		System.out.println("=== TEST 1: medications insert ====");	
		
		System.out.print("Informe o nome: ");
		
		String name = sc.nextLine();
		
		System.out.print("Informe a dose: ");
		
		String dose = sc.nextLine();
		
		System.out.print("Informe código do fabricante: ");
		
		Integer num = sc.nextInt();
		sc.nextLine();
		
		Fabricantes fab = new Fabricantes(num, null);
		
		Medications med = new Medications(null, name, dose, fab);
		
		medDao.insert(med);
		
		System.out.println("Inserted! New id = " + med.getId() + ", Name: " + med.getMedName());

		
		sc.close();
	}

}
