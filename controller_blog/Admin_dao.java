package controller_blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.Connections;
import modele_blog.Articles;
import modele_blog.User;

public class Admin_dao {
	

	public boolean delete(Articles article) {
		// TODO Auto-generated method stub
		Connection connect = new Connections().getConnection();
		try {
			PreparedStatement sql = connect.prepareStatement("DELETE FROM article WHERE idarticle=? ");

			sql.setInt(1, article.getId());
			sql.executeUpdate();
			sql.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		try {
			PreparedStatement sqll = connect.prepareStatement("DELETE FROM commentaires WHERE com_article=?");

			sqll.setInt(1, article.getId());

			sqll.executeUpdate();
			connect.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return false;
	}

	public boolean update(Articles article) {
		Connection connect = new Connections().getConnection();
		try {
			PreparedStatement sql = connect
					.prepareStatement("UPDATE article SET titre=?, contenu=? WHERE idarticle=? ");

			sql.setString(1, article.getTitre());
			sql.setString(2, article.getContenu());
			sql.setInt(3, article.getId());
			sql.executeUpdate();
			connect.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return false;
	}

	public ArrayList<User> Admin_user_Read() {
		Connection connect = new Connections().getConnection();
		ArrayList<User> tab_user = new ArrayList<User>();
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM users ");

			ResultSet rs = sql.executeQuery();

			while (rs.next()) {

				User user = new User(rs.getInt("idusers"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getString("password"), rs.getInt("isAdmin"));
				tab_user.add(user);
			}

			System.out.println("liste des users retourné");
			connect.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return tab_user;
	}

	public boolean delete_user(int iduser) {
		Connection connect = new Connections().getConnection();
		try {
			PreparedStatement sqll = connect.prepareStatement("DELETE FROM users WHERE idusers=?");

			sqll.setInt(1, iduser);

			sqll.executeUpdate();
			connect.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		/*
		 * try { PreparedStatement sqll =
		 * connect.prepareStatement("DELETE FROM article WHERE auteur=?");
		 * 
		 * sqll.setInt(1, iduser);
		 * 
		 * sqll.executeUpdate(); System.out.println("user supprimé"); return true; }
		 * catch (Exception e) { // TODO: handle exception
		 * System.out.println(e.getMessage()); }
		 */
		return false;

	}

	public boolean update_user(String nom, String prenom, int isAdmin, int iduser) {
		Connection connect = new Connections().getConnection();
		try {
			PreparedStatement sqll = connect
					.prepareStatement("UPDATE users SET nom=?,prenom=?,isAdmin=? WHERE idusers=?");

			sqll.setString(1, nom);
			sqll.setString(2, prenom);
			sqll.setInt(3, isAdmin);
			sqll.setInt(4, iduser);

			sqll.executeUpdate();
			connect.close();
			System.out.println("executé");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}
}
