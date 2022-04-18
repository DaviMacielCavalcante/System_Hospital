package main.testes;

import java.util.Date;
import java.util.Scanner;

import entities.Medications;
import entities.Patient;
import entities.Physician;
import entities.Receita;
import model.dao.DaoFactory;
import model.dao.ReceitaDao;

public class ProgramRecTeste {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		ReceitaDao recDao = DaoFactory.createReceitaDao();

		System.out.println("=== TEST 1: receita insert ====");
		
		System.out.println("Informe o código do Médico: ");
		
		Integer id1 = sc.nextInt();
		
		System.out.println("Informe o código do Paciente: ");
		
		Integer id2 = sc.nextInt();
		
		System.out.println("Informe o código do Medicamento: ");
		
		Integer id3 = sc.nextInt();
		
		Physician phy = new Physician(id1, null, null, null);
		Patient pat = new Patient(id2, null, null, null, null);
		Medications med = new Medications(id3, null, null, null);
		Receita rec = new Receita(null, phy, pat, med, new Date());
		
		recDao.insert(rec);
		
		/*System.out.println("Inserted! New id = " + rec.getId());
		
		System.out.println("=== TEST 2: receitas deleteById ====");				
		
		System.out.print("Informe o código da receita: ");
		Integer id = sc.nextInt();
		
		recDao.deleteById(id);*/
		
		sc.close();
	}

}
