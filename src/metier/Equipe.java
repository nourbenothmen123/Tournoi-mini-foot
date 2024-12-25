package metier;

public class Equipe {
	private int idEq;
	private String nomequipe;
	private String datecreation;
	private String entraineur;
	public int getIdEq() {
		return idEq;
	}
	public void setIdEq(int idEq) {
		this.idEq = idEq;
	}
	public String getNomequipe() {
		return nomequipe;
	}
	public void setNomequipe(String nomequipe) {
		this.nomequipe = nomequipe;
	}
	public String getEntraineur() {
		return entraineur;
	}
	public void setEntraineur(String entraineur) {
		this.entraineur = entraineur;
	}
	public Equipe(int idEq, String nomequipe, String datecreation, String entraineur) {
		super();
		this.idEq = idEq;
		this.nomequipe = nomequipe;
		this.datecreation = datecreation;
		this.entraineur = entraineur;
	}
	public Equipe() {
		// TODO Auto-generated constructor stub
	}
	public String getDatecreation() {
		return datecreation;
	}
	public void setDatecreation(String datecreation) {
		this.datecreation = datecreation;
	}
	
	
	


}
