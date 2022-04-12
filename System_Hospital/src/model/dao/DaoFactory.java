package model.dao;

import db.DB;
import model.dao.impl.FabricantesDaoJDBC;
import model.dao.impl.MedicationsDaoJDBC;

public class DaoFactory {

	public static FabricantesDao createFabricantesDao() {
		return new FabricantesDaoJDBC(DB.getConnection());
	}
	
	public static MedicationsDao createMedicationsDao() {
		return new MedicationsDaoJDBC(DB.getConnection());
	}
	
}
