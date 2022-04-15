package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;
import entities.Physician;
import model.dao.PhysicianDao;

public class PhysicianDaoJDBC implements PhysicianDao {
	
	private Connection conn;
	
	public PhysicianDaoJDBC(Connection conn) {
		this.conn = conn;
	}	

	@Override
	public void insert(Physician phy) {

		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(
					"INSERT INTO physician "
					+ "(name, crm, specName) "
					+ "VALUES "
					+ "(?, ?, ?) ",
					Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, phy.getName());
			ps.setString(2, phy.getCrm());
			ps.setString(3, phy.getSpecName());
			
			int rowsAff = ps.executeUpdate();
			
			if (rowsAff > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
						int id = rs.getInt(1);
						phy.setId(id);
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
	public void update(Physician phy) {
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(
					"UPDATE physician "
					+ "SET name = ? "
					+ "WHERE id = ?");
			
			ps.setString(1, phy.getName());
			ps.setInt(2, phy.getId());
			
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
	public void deleteById(Integer id) {
		
		PreparedStatement ps = null;
		
		try {
			ps= conn.prepareStatement(
					"DELETE FROM physician WHERE id = ?");
			
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
		
		
}

	
	

