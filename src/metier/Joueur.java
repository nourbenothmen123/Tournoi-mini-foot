package metier;

import java.sql.Date;

public class Joueur {
	private int id;
	private String nomj;
	private String prenomj;
	private int salaire;
	private String datenaissance;
	private String pays;
	private int nbrmatchjoué;
	private String etat;
	private String nomequipe;
	private int idEquipe;
	public String getNomj() {
		return nomj;
	}
	public void setNomj(String nomj) {
		this.nomj = nomj;
	}
	public String getPrenomj() {
		return prenomj;
	}
	public void setPrenomj(String prenomj) {
		this.prenomj = prenomj;
	}
	public String getDatenaissance() {
		return datenaissance;
	}
	public void setDatenaissance(String datenaissance) {
		this.datenaissance = datenaissance;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public int getNbrmatchjoué() {
		return nbrmatchjoué;
	}
	public void setNbrmatchjoué(int nbrmatchjoué) {
		this.nbrmatchjoué = nbrmatchjoué;
	}

	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Joueur(int id,String nomj, String prenomj,String datenaiss, String pays,int salaire, String etat,int nbrmatchjoué,String nomequipe) {
		super();
		this.id=id;
		this.nomj = nomj;
		this.prenomj = prenomj;
		this.datenaissance = datenaiss;
		this.pays = pays;
		this.nbrmatchjoué = nbrmatchjoué;
		this.etat = etat;
		this.salaire=salaire;
		this.nomequipe=nomequipe;
	
	}
	public Joueur(int id,String nomj, String prenomj,String datenaiss, String pays,int salaire, String etat,int nbrmatchjoué,int idEquipe) {
		super();
		this.id=id;
		this.nomj = nomj;
		this.prenomj = prenomj;
		this.datenaissance = datenaiss;
		this.pays = pays;
		this.nbrmatchjoué = nbrmatchjoué;
		this.etat = etat;
		this.salaire=salaire;
		this.setIdEquipe(idEquipe);
	
	}
	public Joueur() {
		// TODO Auto-generated constructor stub
	}
	public int getSalaire() {
		return salaire;
	}
	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomequipe() {
		return nomequipe;
	}
	public void setNomequipe(String nomequipe) {
		this.nomequipe = nomequipe;
	}
	public int getIdEquipe() {
		return idEquipe;
	}
	public void setIdEquipe(int idEquipe) {
		this.idEquipe = idEquipe;
	}

}
