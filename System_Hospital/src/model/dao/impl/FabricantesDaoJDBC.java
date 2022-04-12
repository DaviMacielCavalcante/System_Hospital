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
			ps.setInt(2, fab.getId());
			
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
	public void deleteByName(String name) {

		PreparedStatement ps = null;
		
		try {
			ps= conn.prepareStatement(
					"DELETE FROM fabricantes WHERE name = ?");
			
			ps.setString(1, name);
			
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
	public Fabricantes findByName(String name) {

		PreparedStatement ps = null;
		ResultSet rs= null;
		
		try {
			ps = conn.prepareStatement(
					"SELECT * FROM fabricantes WHERE name = ?");
			
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
					Fabricantes fab = instantiateFabricantes(rs);
					return fab;
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
	
	private Fabricantes instantiateFabricantes(ResultSet rs) throws SQLException {
		Fabricantes fab = new Fabricantes();
		fab.setId(rs.getInt("id"));
		fab.setName(rs.getString("name"));
		return fab;
	}

	@Override
	public List<Fabricantes> findAll() {
		
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		try {
			ps = conn.prepareStatement(
					"SELECT * FROM fabricantes");		
			
			rs = ps.executeQuery();
			
			List<Fabricantes> list = new ArrayList<>();
			
			Map<Integer, Fabricantes> map = new HashMap<>();
			
			while (rs.next()) {
					Fabricantes fab = map.get(rs.getInt("id"));

					if (fab == null) {
						fab = instantiateFabricantes(rs);
						map.put(rs.getInt("id"), fab);
					}
					list.add(fab);
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
