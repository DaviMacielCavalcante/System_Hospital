package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import entities.Patient;
import entities.Physician;

public class File_Checker {
	
	private String pathFolder;
	private String pathFile;
	
	public File_Checker() {
		
	}

	public File_Checker(String pathFolder) {		
		this.pathFolder = pathFolder;
	}

	public File_Checker(String pathFolder, String pathFile) {		
		this.pathFolder = pathFolder;
		this.pathFile = pathFile;
	}

	public String getPathFolder() {
		return pathFolder;
	}

	public String getPathFile() {
		return pathFile;
	}

	public boolean thereIsAFolder() {
		if (getPathFolder() == null) {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter a folder path: ");
			String strPath = sc.nextLine();			
			
			boolean success = new File(strPath + "\\Patient_Data").mkdir();
			System.out.println("Directory creation:" + success);
					
			sc.close();
			return true;
		}
		else if (getPathFolder() != null){			
			System.out.println("Directory creation: Unnecessary. The directory already exists.");
			
			return false;
		}
		else {			
			System.out.println("Directory creation: false");
			
			return false;
		}
	}
	
	public boolean patientFolder() {				
		
		String strPath = "C:\\Users\\Davi\\Documents\\MeusProjetos\\Eclipse_Projetos_Prototipos\\System_Hospital\\System_Hospital";	
				
		File patientFolder = new File(strPath + Patient.getName());		
		
		if (patientFolder.exists()) {			
			System.out.println("Directory creation: Unnecessary. The directory already exists.");
			
			return false;						
		}
		else {				
			boolean success = new File(strPath + Patient.getName()).mkdir();
			
			System.out.println("Directory creation:" + success);		
			
			return success;			
		}				
	}
	
	public boolean patientFile() {
		String strPath = "C:\\Users\\Davi\\Documents\\MeusProjetos\\Eclipse_Projetos_Prototipos\\System_Hospital\\System_Hospital";	
		
		File patientFolder = new File(strPath + Patient.getName());		
		
		File patientFile = new File(patientFolder + Patient.getName());
		
		if (patientFile.exists()) {			
			System.out.println("File creation: Unnecessary. The file already exists.");
			
			return false;						
		}
		else {				
			try (BufferedWriter br = new BufferedWriter(new FileWriter(patientFile, true))) {
				System.out.println("File creation: success");	
				
				br.write(Physician.toString());
				br.newLine();
				
				return true;	
			}
			catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
			
			return true;
		}
						
	}

}
