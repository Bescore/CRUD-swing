package controller_blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.Connections;
import dao.Idao;
import modele_blog.commentaires;

public class commentaireDao implements Idao<commentaires> {
	Connection connect= new Connections().getConnection();
	
	

	@Override
	public ArrayList<commentaires> read() {
		return null;
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean create(commentaires object) {
		// TODO Auto-generated method stub
		
		if (object.getContenu_com().equalsIgnoreCase("")||object.getAuteur_com()<=0) {
			return false;
		}else {
		
			try {
				PreparedStatement sql=connect.prepareStatement("INSERT INTO commentaires(commentaire_contenu,auteur_du_commentaire,com_article) VALUES(?,?,?)");
				
				sql.setString(1, object.getContenu_com());
				sql.setInt(2, object.getAuteur_com());
				sql.setInt(3, object.getId());
				
				sql.executeUpdate();
				System.out.println("l'article a été commenté !");
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	
		return true;
	}
	
	
	@Override
	public ArrayList<commentaires> findby(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public ArrayList<commentaires> readee(commentaires object) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<commentaires> findycom(int com) {
		// TODO Auto-generated method stub
		ArrayList<commentaires> tab_coms=new ArrayList<commentaires>();
		try {
			PreparedStatement sql=connect.prepareStatement("SELECT * FROM commentaires INNER JOIN article ON article.idarticle=commentaires.com_article AND article.idarticle=? ");
			
			sql.setInt(1, com);
			ResultSet rs = sql.executeQuery();
			
			
			while ( rs.next()) {
				
				commentaires comments= new commentaires(rs.getString("commentaire_contenu"),rs.getInt("auteur_du_commentaire"));
				tab_coms.add(comments);
			} ;
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return tab_coms;
		
	}
	


}
