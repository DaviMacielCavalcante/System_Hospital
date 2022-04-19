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
import entities.Patient;
import entities.Physician;
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
	public List<Receita> findByPatName(String name) {
		
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		try {
			ps = conn.prepareStatement(
					"SELECT r.*, p.*, pat.*, med.*, f.* FROM receita AS r "
					+ "INNER JOIN physician AS p ON r.id_phy = p.id "
					+ "INNER JOIN patient AS pat ON r.id_pat = pat.id "
					+ "INNER JOIN medications AS med ON r.id_medications = med.id "
					+ "INNER JOIN fabricantes AS f ON med.id_fabricantes = f.id "
					+ "WHERE pat.name = ?");
			
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			
			List<Receita> list = new ArrayList<>();
			
			Map<Integer, Fabricantes> map = new HashMap<>();
			Map<Integer, Medications> mapMed = new HashMap<>();
			Map<Integer, Patient> mapPat = new HashMap<>();
			Map<Integer, Physician> mapPhy = new HashMap<>();
			
			while (rs.next()) {
				
					Fabricantes fab = map.get(rs.getInt("f.id"));

					if (fab == null) {
						fab = instantiateFabricantes(rs);
						map.put(rs.getInt("f.id"), fab);
					}
					
					Medications medications = mapMed.get(rs.getInt("med.id"));					
					
					if (medications == null) {
						medications = instantiateMedications(rs, fab);
						mapMed.put(rs.getInt("med.id"), medications);
					}
					
					Patient patient = mapPat.get(rs.getInt("pat.id"));
					
					if (patient == null){
						patient = instantiatePatient(rs);
						mapPat.put(rs.getInt("pat.id"), patient);
					}
					
					Physician physician = mapPhy.get(rs.getInt("p.id"));
					
					if (physician == null) {
						physician = instantiatePhysician(rs);
						mapPhy.put(rs.getInt("p.id"), physician);
					}
					
					Receita receita = instantiateReceita(rs, physician, patient, medications);
					list.add(receita);
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
	public List<Receita> findAll() {
		
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		try {
			ps = conn.prepareStatement(
					"SELECT r.*, p.*, pat.*, med.*, f.* FROM receita AS r "
					+ "INNER JOIN physician AS p ON r.id_phy = p.id "
					+ "INNER JOIN patient AS pat ON r.id_pat = pat.id "
					+ "INNER JOIN medications AS med ON r.id_medications = med.id "
					+ "INNER JOIN fabricantes AS f ON med.id_fabricantes = f.id;");		
			
			rs = ps.executeQuery();
			
			List<Receita> list = new ArrayList<>();
			
			Map<Integer, Fabricantes> map = new HashMap<>();
			Map<Integer, Medications> mapMed = new HashMap<>();
			Map<Integer, Patient> mapPat = new HashMap<>();
			Map<Integer, Physician> mapPhy = new HashMap<>();
			
			while (rs.next()) {
				
					Fabricantes fab = map.get(rs.getInt("f.id"));

					if (fab == null) {
						fab = instantiateFabricantes(rs);
						map.put(rs.getInt("f.id"), fab);
					}
					
					Medications medications = mapMed.get(rs.getInt("med.id"));					
					
					if (medications == null) {
						medications = instantiateMedications(rs, fab);
						mapMed.put(rs.getInt("med.id"), medications);
					}
					
					Patient patient = mapPat.get(rs.getInt("pat.id"));
					
					if (patient == null){
						patient = instantiatePatient(rs);
						mapPat.put(rs.getInt("pat.id"), patient);
					}
					
					Physician physician = mapPhy.get(rs.getInt("p.id"));
					
					if (physician == null) {
						physician = instantiatePhysician(rs);
						mapPhy.put(rs.getInt("p.id"), physician);
					}
					
					Receita receita = instantiateReceita(rs, physician, patient, medications);
					list.add(receita);
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
	
	private Fabricantes instantiateFabricantes(ResultSet rs) throws SQLException {
		Fabricantes fab = new Fabricantes();
		fab.setId(rs.getInt("f.id"));
		fab.setName(rs.getString("f.name"));
		return fab;
	}
	
	private Medications instantiateMedications(ResultSet rs, Fabricantes fab) throws SQLException {
		Medications med = new Medications();
		med.setId(rs.getInt("med.id"));
		med.setMedName(rs.getString("med.name"));
		med.setDose(rs.getString("med.dose"));
		med.setFabricante(fab);
		return med;
	}
	
	private Patient instantiatePatient(ResultSet rs) throws SQLException{
		Patient pat = new Patient();
		pat.setId(rs.getInt("pat.id"));
		pat.setName(rs.getString("pat.name"));
		pat.setCpf(rs.getString("pat.cpf"));
		pat.setBirthDate(rs.getDate("pat.birthDate"));
		pat.setPhoneN(rs.getString("pat.phoneN"));
		return pat;
	}
	
	private Physician instantiatePhysician(ResultSet rs) throws SQLException{
		Physician phy = new Physician();
		phy.setId(rs.getInt("p.id"));
		phy.setName(rs.getString("p.name"));
		phy.setCrm(rs.getString("p.crm"));
		phy.setSpecName(rs.getString("p.specName"));
		return phy;
	}
	
	private Receita instantiateReceita(ResultSet rs, Physician physician, Patient patient, Medications medications) throws SQLException{
		Receita rec = new Receita();
		rec.setId(rs.getInt("r.id"));
		rec.setPhysician(physician);
		rec.setPatient(patient);
		rec.setMedications(medications);
		rec.setDateTime(rs.getDate("r.data"));
		return rec;
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
