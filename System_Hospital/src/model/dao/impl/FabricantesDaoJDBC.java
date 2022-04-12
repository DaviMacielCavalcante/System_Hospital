package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import entities.Fabricantes;
import model.dao.FabricantesDao;

public class FabricantesDaoJDBC implements FabricantesDao {

	private Connection conn;
	
	public FabricantesDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Fabricantes fab) {

		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(
					"INSERT INTO fabricantes "
					+ "(name) "
					+ "VALUES "
					+ "(?) ",
					Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, fab.getName());
			
			int rowsAff = ps.executeUpdate();
			
			if (rowsAff > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
						int id = rs.getInt(1);
						fab.setId(id);
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
	public void update(Fabricantes fab) {

		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(
					"UPDATE fabricantes "
					+ "SET name = ? "
					+ "WHERE id = ?");
			
			ps.setString(1, fab.getName());
		}
		catch (SQLException e) {
			throw new DbException("Unexpected error! No rows affected");
		}
		finally {
			DB.closeStatement(ps);
		}
		
		
	}

	@Override
	public void deleteByName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Fabricantes findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fabricantes> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
