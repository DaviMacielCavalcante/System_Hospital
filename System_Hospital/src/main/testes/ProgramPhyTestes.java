package main.testes;

import java.util.Scanner;

import entities.Physician;
import model.dao.DaoFactory;
import model.dao.PhysicianDao;

public class ProgramPhyTestes {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		
		PhysicianDao phyDao = DaoFactory.createPhysicianDao();
		
		/*System.out.println("=== TEST 1: medications insert ====");	
		
		System.out.print("Informe o nome: ");
		
		String name = sc.nextLine();
		
		System.out.print("Informe o CRM: ");
		
		String crm = sc.nextLine();
		
		System.out.print("Informe a especialização : ");
		
		String specName = sc.nextLine();		
		
		Physician phy = new Physician(null, name, crm, specName);
		
		phyDao.insert(phy);
		
		System.out.println("Inserted! New id = " + phy.getId() + ", Name: " + phy.getName() + ", Especialização: " + phy.getSpecName());
		
		
		
		System.out.println("=== TEST 2: medications update ====");	
		
		System.out.print("Informe o código do funcionário: ");
		
		Integer cod = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Informe o nome: ");
		
		String name = sc.nextLine();
		
		System.out.print("Informe o CRM: ");
		
		String crm = sc.nextLine();
		
		System.out.print("Informe a especialização : ");
		
		String specName = sc.nextLine();		
		
		Physician phy = new Physician(cod, name, crm, specName);
		
		phyDao.update(phy);		
		
		System.out.println("=== TEST 3: physician deleteById ====");				
		
		System.out.print("Informe o código do produto: ");
		Integer id = sc.nextInt();
		
		phyDao.deleteById(id);
		
		*/
		
		sc.close();
	}
	
}
