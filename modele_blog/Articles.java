package modele_blog;

public class Articles {
	private int id;
	private String titre;
	private String contenu;
	private String date;
	private String auteur;
	
	
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



	public String getAuteur() {
		return auteur;
	}



	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}



	public Articles(int id, String titre, String contenu, String date, String auteur) {
		super();
		this.id = id;
		this.titre = titre;
		this.contenu = contenu;
		this.date = date;
		this.auteur = auteur;
	}



	public Articles(String titre, String contenu, String date, String auteur) {
		super();
		this.titre = titre;
		this.contenu = contenu;
		this.date = date;
		this.auteur = auteur;
	}



	@Override
	public String toString() {
		return "Articles [id=" + id + ", titre=" + titre + ", contenu=" + contenu + ", date=" + date + ", auteur="
				+ auteur + "]";
	}
	
	
	
}
