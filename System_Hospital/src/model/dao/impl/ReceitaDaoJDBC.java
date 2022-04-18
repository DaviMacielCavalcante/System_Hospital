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
import entities.Receita;
import model.dao.ReceitaDao;

public class ReceitaDaoJDBC implements ReceitaDao {

	private Connection conn;

	public ReceitaDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Receita rec) {
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(
					"INSERT INTO receita "
					+ "(id_phy, id_pat, id_medications, data) "
					+ "VALUES "
					+ "(?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, rec.getPhysician().getId());
			ps.setInt(2, rec.getPatient().getId());
			ps.setInt(3, rec.getMedications().getId());
			ps.setDate(4, new java.sql.Date(rec.getDateTime().getTime()));
			
			int rowsAff = ps.executeUpdate();
			
			if (rowsAff > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
						int id = rs.getInt(1);
						rec.setId(id);
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
	public Receita findByPatName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Receita> findAll() {
		
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		try {
			ps = conn.prepareStatement(
					"SELECT r.id, p.name, p.specName, pat.name, med.name, med.dose, f.name FROM receita AS r "
					+ "INNER JOIN physician AS p ON r.id_phy = p.id "
					+ "INNER JOIN patient AS pat ON r.id_pat = pat.id "
					+ "INNER JOIN medications AS med ON r.id_medications = med.id "
					+ "INNER JOIN fabricantes AS f ON med.id_fabricantes = f.id;");		
			
			rs = ps.executeQuery();
			
			List<Medications> list = new ArrayList<>();
			
			Map<Integer, Fabricantes> map = new HashMap<>();
			
			while (rs.next()) {
					Fabricantes fab = map.get(rs.getInt("id_fabricantes"));

					if (fab == null) {
						fab = instantiateFabricantes(rs);
						map.put(rs.getInt("id_fabricantes"), fab);
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
		
		PreparedStatement ps = null;
		
		try {
			ps= conn.prepareStatement(
					"DELETE FROM receita WHERE id = ?");
			
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
