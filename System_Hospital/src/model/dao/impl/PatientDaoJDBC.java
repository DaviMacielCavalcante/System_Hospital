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
import entities.Patient;
import model.dao.PatientDao;

public class PatientDaoJDBC implements PatientDao {

private Connection conn;
	
	public PatientDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Patient pat) {
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(
					"INSERT INTO patient "
					+ "(name, cpf, birthDate, phoneN) "
					+ "VALUES "
					+ "(?, ?, ?, ?) ",
					Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, pat.getName());
			ps.setString(2, pat.getCpf());
			ps.setDate(3, new java.sql.Date(pat.getBirthDate().getTime()));
			ps.setString(4, pat.getPhoneN());
			
			int rowsAff = ps.executeUpdate();
			
			if (rowsAff > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
						int id = rs.getInt(1);
						pat.setId(id);
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
	public void update(Patient pat) {
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(
					"UPDATE patient "
					+ "SET name = ?, cpf = ?, birthDate = ?, phoneN = ?) "					
					+ "WHERE name = ? ");
			
			ps.setString(1, pat.getName());
			ps.setString(2, pat.getCpf());
			ps.setDate(3, new java.sql.Date(pat.getBirthDate().getTime()));
			ps.setString(4, pat.getPhoneN());			
			
			int rowsAff = ps.executeUpdate();
			
			if (rowsAff > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
						int id = rs.getInt(1);
						pat.setId(id);
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
	public void deleteById(Integer id) {
		
		PreparedStatement ps = null;
		
		try {
			ps= conn.prepareStatement(
					"DELETE FROM patient WHERE id = ?");
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException("Unexpected error! No rows affected");
		}
		finally {
			DB.closeStatement(ps);
		}
		
	}
	
	private Patient instantiatePatient(ResultSet rs) throws SQLException {
		Patient pat = new Patient();
		pat.setId(rs.getInt("id"));
		pat.setName(rs.getString("name"));
		return pat;
	}

	@Override
	public List<Patient> findAll() {
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		try {
			ps = conn.prepareStatement(
					"SELECT * FROM patients");		
			
			rs = ps.executeQuery();
			
			List<Patient> list = new ArrayList<>();
			
			Map<Integer, Patient> map = new HashMap<>();
			
			while (rs.next()) {
					Patient pat = map.get(rs.getInt("id"));

					if (pat == null) {
						pat = instantiatePatient(rs);
						map.put(rs.getInt("id"), pat);
					}
					list.add(pat);
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
	
}
