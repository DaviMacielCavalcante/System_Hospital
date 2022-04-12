package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import entities.Fabricantes;
import entities.Medications;
import model.dao.MedicationsDao;

public class MedicationsDaoJDBC implements MedicationsDao {
	
	private Connection conn;
	
	public MedicationsDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Medications med) {

		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(
					"INSERT INTO medications "
					+ "(name, dose, id_fabricantes) "
					+ "VALUES "
					+ "(?, ?, ?) ",
					Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, med.getMedName());
			ps.setString(2, med.getDose());
			ps.setInt(3, med.getFabricante().getId());
			
			int rowsAff = ps.executeUpdate();
			
			if (rowsAff > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
						int id = rs.getInt(1);
						med.setId(id);
				}
				DB.closeResultSet(rs);
			}
		}
		catch (SQLException e) {
			throw new DbException("Unexpected error! No rows affected");
		}
		finally {
			DB.closeStatement(ps);
		}		
	}

	@Override
	public void update(Medications med) {
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(
					"INSERT INTO medications "
					+ "(name, dose, id_fabricantes) "
					+ "VALUES "
					+ "(?, ?, ?) "
					+ "WHERE id = ?");
			
			ps.setString(1, med.getMedName());
			ps.setString(2, med.getDose());
			ps.setInt(3, med.getFabricante().getId());
			ps.setInt(4, med.getId());
			
			ps.executeUpdate();			
		}
		catch (SQLException e) {
			throw new DbException("Unexpected error! No rows affected");
		}
		finally {
			DB.closeStatement(ps);
		}	
		
		
	}	

	@Override
	public Medications findByName(String name) {
		
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		try {
			ps = conn.prepareStatement(
					"SELECT * FROM medications WHERE name = ?");
			
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
					Fabricantes fab = instantiateFabricantes(rs);					
					Medications med = instantiateMedications(rs, fab);
					return med;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException("Unexpected error! No rows affected");
		}
		finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
	}
	
	@Override
	public Medications findByFabricantes(Fabricantes fab) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Fabricantes instantiateFabricantes(ResultSet rs) throws SQLException {
		Fabricantes fab = new Fabricantes();
		fab.setId(rs.getInt("id"));
		fab.setName(rs.getString("name"));
		return fab;
	}
	
	private Medications instantiateMedications(ResultSet rs, Fabricantes fab) throws SQLException {
		Medications med = new Medications();
		med.setId(rs.getInt("id"));
		med.setMedName(rs.getString("name"));
		med.setDose(rs.getString("dose"));
		med.setFabricante(fab);
		return med;
	}
	

	@Override
	public List<Medications> findAll() {
		
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		try {
			ps = conn.prepareStatement(
					"SELECT * FROM medications");		
			
			rs = ps.executeQuery();
			
			List<Medications> list = new ArrayList<>();
			
			Map<Integer, Fabricantes> map = new HashMap<>();
			
			while (rs.next()) {
					Fabricantes fab = map.get(rs.getInt("id"));

					if (fab == null) {
						fab = instantiateFabricantes(rs);
						map.put(rs.getInt("id"), fab);
					}
					
					Medications med = instantiateMedications(rs, fab);
					list.add(med);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException("Unexpected error! No rows affected");
		}
		finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	

}
