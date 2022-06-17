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
		return false;
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
				
				commentaires comments= new commentaires(rs.getString("commentaire_contenu"),rs.getString("auteur_du_commentaire"));
				tab_coms.add(comments);
			} ;
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return tab_coms;
		
	}
	


}
