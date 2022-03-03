package entitites.abstracts;

public abstract class AllPhy {
	
	protected String name;
	protected String crm;		
	protected String specName;
	protected String inf;		
	
	public AllPhy() {
		super();
	}

	public AllPhy(String name, String crm, String specName) {		
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

	public String getInf() {
		return inf;
	}

	public void setInf(String inf) {
		this.inf = inf;
	}	
	
}
