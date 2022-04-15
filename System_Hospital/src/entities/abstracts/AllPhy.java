package entities.abstracts;

public abstract class AllPhy {
	
	protected Integer id;
	protected String name;
	protected String crm;		
	protected String specName;			
	
	public AllPhy() {
		super();
	}

	public AllPhy(Integer id, String name, String crm, String specName) {	
		this.id = id;
		this.name = name;
		this.crm = crm;
		this.specName = specName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	
}
