package main.testes;

import java.text.ParseException;

public class ProgramPatTeste {

	public static void main(String[] args) throws ParseException {
		
		/*SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
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
		
		
		System.out.println("=== TEST 2: patient update ====");	
		
		System.out.print("Informe o número de cadastro: ");
		Integer id = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Informe o nome: ");
		
		String name = sc.nextLine();
		
		System.out.print("Informe o cpf: ");
		
		String cpf = sc.nextLine();
		
		System.out.print("Informe a data de nascimento: ");
		
		Date birthDate = sdf.parse(sc.nextLine());
		
		System.out.print("Informe o telefone para contato: ");
		
		String phoneN = sc.nextLine();
		
		Patient pat = new Patient(id, name, cpf, birthDate, phoneN);
		
		patDao.update(pat);	
		
		
		System.out.println("=== TEST 3: patient deleteById ====");	
		
		System.out.print("Informe o número de cadastro: ");
		Integer id = sc.nextInt();
		sc.nextLine();
		
		patDao.deleteById(id);
		
		
		System.out.println("=== TEST 4: patient findAll ====");		
		
		List<Patient> list = new ArrayList<>();
		
		list = patDao.findAll();
		
		for (Patient pat : list) {
			System.out.println(pat);
		}
		sc.close();
		*/
	}

}
