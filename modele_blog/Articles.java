package modele_blog;



public class Articles {
	private int id;
	private String titre;
	private String contenu;
	private String date;
	private String prenom_auteur;
	private int auteur;
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitre() {
		return titre;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}



	public String getContenu() {
		return contenu;
	}



	public void setContenu(String contenu) {
		this.contenu = contenu;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public int getAuteur() {
		return auteur;
	}



	public void setAuteur(int auteur) {
		this.auteur = auteur;
	}



	public Articles(int id, String titre, String contenu, String date, int auteur) {
		super();
		this.id = id;
		this.titre = titre;
		this.contenu = contenu;
		this.date = date;
		this.auteur = auteur;
	}



	public Articles(String titre, String contenu, String date, int auteur) {
		super();
		this.titre = titre;
		this.contenu = contenu;
		this.date = date;
		this.auteur = auteur;
	}

	


	public Articles(String titre, String contenu, int auteur) {
		super();
		this.titre = titre;
		this.contenu = contenu;
		this.auteur = auteur;
	}



	



	public Articles(String titre, String contenu, String date, String prenom_auteur) {
		super();
		this.titre = titre;
		this.contenu = contenu;
		this.date = date;
		this.prenom_auteur = prenom_auteur;
	}



	



	public Articles(int id, String titre, String contenu, String date, String prenom_auteur) {
		super();
		this.id = id;
		this.titre = titre;
		this.contenu = contenu;
		this.date = date;
		this.prenom_auteur = prenom_auteur;
	}



	@Override
	public String toString() {
		return "Articles [id=" + id + ", titre=" + titre + ", contenu=" + contenu + ", date=" + date + ", auteur="
				+ auteur + "]";
	}



	public String getPrenom_auteur() {
		return prenom_auteur;
	}



	public void setPrenom_auteur(String prenom_auteur) {
		this.prenom_auteur = prenom_auteur;
	}
	
	
	
}
