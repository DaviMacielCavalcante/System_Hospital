package main.testes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Fabricantes;
import entities.Medications;
import model.dao.DaoFactory;
import model.dao.MedicationsDao;

public class ProgramMediTest {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);	
		
		MedicationsDao medDao = DaoFactory.createMedicationsDao();
		
		/*System.out.println("=== TEST 1: medications insert ====");	
		
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
		
		System.out.println("Inserted! New id = " + med.getId() + ", Name: " + med.getMedName());*/
		
		/*System.out.println("=== TEST 2: medications update ====");
		
		System.out.print("Informe o código do produto: ");
		
		Integer id = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Informe o nome: ");
		
		String name = sc.nextLine();
		
		System.out.print("Informe a dose: ");
		
		String dose = sc.nextLine();
		
		System.out.print("Informe código do fabricante: ");
		
		Integer num = sc.nextInt();
		sc.nextLine();
		
		Fabricantes fab = new Fabricantes(num, null);
		
		Medications med = new Medications(id, name, dose, fab);
		
		medDao.update(med);
		
		System.out.println("Update Completed!");
		System.out.println(med);
		
		System.out.println("=== TEST 3: medications findByName ====");		
		
		System.out.print("Informe o nome: ");
		
		String name = sc.nextLine();
		
		List<Medications> list = new ArrayList<>();
		
		list = medDao.findByName(name);
		
		for (Medications med : list) {
			System.out.println(med);
		}
		
		System.out.println("=== TEST 4: medications findAll ====");				
		
		List<Medications> list = new ArrayList<>();
		
		list = medDao.findAll();
		
		for (Medications med : list) {
			System.out.println(med);
		}
				
		
		System.out.println("=== TEST 5: medications findByFabricantes ====");				
		
		List<Medications> list = new ArrayList<>();
		
		System.out.print("Informe o código do fabricante: ");
		Integer id = sc.nextInt();		
		
		list = medDao.findByFabricantes(id);
		
		for (Medications med : list) {
			System.out.println(med);
		}
		
		
		
		System.out.println("=== TEST 6: medications deleteById ====");				
		
		System.out.print("Informe o código do produto: ");
		Integer id = sc.nextInt();
		
		medDao.deleteById(id);
		
		*/
		
		sc.close();
	}

}
