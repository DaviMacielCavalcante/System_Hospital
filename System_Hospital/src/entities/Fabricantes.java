package entities;

import java.io.Serializable;
import java.util.Objects;

public class Fabricantes implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	
	public Fabricantes() {
		
	}

	public Fabricantes(Integer id, String name) {		
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fabricantes other = (Fabricantes) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Fabricantes [id=" + id + ", name=" + name + "]";
	}
	
	

}
