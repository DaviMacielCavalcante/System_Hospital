package model.dao;

import db.DB;
import model.dao.impl.FabricantesDaoJDBC;

public class DaoFactory {

	public static FabricantesDao createFabricantesDao() {
		return new FabricantesDaoJDBC(DB.getConnection());
	}
	
}
