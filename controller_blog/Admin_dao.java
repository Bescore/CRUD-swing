package controller_blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.Connections;
import modele_blog.Articles;
import modele_blog.User;

public class Admin_dao {
	Connection connect = new Connections().getConnection();
	public boolean delete(Articles article) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement sql = connect.prepareStatement(
					"DELETE FROM article WHERE idarticle=? ");

			sql.setInt(1, article.getId());
			sql.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		try {
			PreparedStatement sqll = connect.prepareStatement("DELETE FROM commentaires WHERE com_article=?");

			sqll.setInt(1, article.getId());

			sqll.executeUpdate();
			System.out.println("Suppression article et commentaire  par un administrateur");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return false;
	}
	
	
	public boolean update(Articles article) {
		
		try {
			PreparedStatement sql = connect.prepareStatement(
					"UPDATE article SET titre=?, contenu=? WHERE idarticle=? ");

			sql.setString(1, article.getTitre());
			sql.setString(2, article.getContenu());
			sql.setInt(3, article.getId());
			sql.executeUpdate();
			System.out.println("modification administrateur");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return false;
	}
	
	public ArrayList<User> Admin_user_Read(){
		
		ArrayList<User> tab = new ArrayList<User>();
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM users ");

			ResultSet rs = sql.executeQuery();

			while (rs.next()) {

				User user = new User(rs.getInt("idusers"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getString("password"),rs.getInt("isAdmin"));
				tab.add(user);
			}
			;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return tab;
	}
}
