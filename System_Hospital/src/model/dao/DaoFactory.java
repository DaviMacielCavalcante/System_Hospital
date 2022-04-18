package model.dao;

import db.DB;
import model.dao.impl.FabricantesDaoJDBC;
import model.dao.impl.MedicationsDaoJDBC;
import model.dao.impl.PatientDaoJDBC;
import model.dao.impl.PhysicianDaoJDBC;
import model.dao.impl.ReceitaDaoJDBC;

public class DaoFactory {

	public static FabricantesDao createFabricantesDao() {
		return new FabricantesDaoJDBC(DB.getConnection());
	}
	
	public static MedicationsDao createMedicationsDao() {
		return new MedicationsDaoJDBC(DB.getConnection());
	}
	
	public static PhysicianDao createPhysicianDao() {
		return new PhysicianDaoJDBC(DB.getConnection());
	}
	
	public static PatientDao createPatientDao() {
		return new PatientDaoJDBC(DB.getConnection());
	}

	public static ReceitaDao createReceitaDao() {
		return new ReceitaDaoJDBC(DB.getConnection());
	}
}
