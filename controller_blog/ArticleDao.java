package controller_blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.Connections;
import dao.Idao;
import modele_blog.Articles;

public class ArticleDao implements Idao<Articles> {
	Connection connect = new Connections().getConnection();

	@Override
	public boolean create(Articles object) {
		// TODO Auto-generated method stub
		try {
			Connection connect = new Connections().getConnection();
			PreparedStatement sql = connect
					.prepareStatement("INSERT INTO article(titre,contenu,auteur,date) VALUES(?,?,?,now())");

			sql.setString(1, object.getTitre());
			sql.setString(2, object.getContenu());
			sql.setInt(3, object.getAuteur());

			sql.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public ArrayList<Articles> read() {
		// TODO Auto-generated method stub
		ArrayList<Articles> tab_article = new ArrayList<Articles>();
		try {
			PreparedStatement sql = connect.prepareStatement(
					"SELECT * FROM Article LEFT JOIN users ON users.idusers=article.auteur ORDER BY date DESC");

			ResultSet rs = sql.executeQuery();

			while (rs.next()) {

				Articles article = new Articles(rs.getInt("idarticle"), rs.getString("titre"), rs.getString("contenu"),
						rs.getString("date"), rs.getString("prenom"));
				if (article.getPrenom_auteur() == null) {

					article.setPrenom_auteur("Ancien Membre");
				}
				tab_article.add(article);
			}
			;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return tab_article;
	}

	public boolean update_article(Articles article) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement sql = connect.prepareStatement(
					"SELECT * FROM article inner join users where article.auteur=users.idusers AND article.auteur=? AND idarticle=? ");

			sql.setInt(1, article.getAuteur());
			sql.setInt(2, article.getId());
			ResultSet rs = sql.executeQuery();

			if (rs.next()) {
				System.out.println("user trouvé");
				try {
					PreparedStatement sqll = connect
							.prepareStatement("UPDATE article SET titre=?, contenu=? WHERE idarticle=?");

					sqll.setString(1, article.getTitre());
					sqll.setString(2, article.getContenu());
					sqll.setInt(3, article.getId());

					sqll.executeUpdate();
					return true;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}

			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return false;

	}

	public boolean delete(Articles article) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement sql = connect.prepareStatement(
					"SELECT * FROM article inner join users where article.auteur=users.idusers AND article.auteur=? AND idarticle=? ");

			sql.setInt(1, article.getAuteur());
			sql.setInt(2, article.getId());
			ResultSet rs = sql.executeQuery();

			if (rs.next()) {
				System.out.println("user trouvé");
				try {
					PreparedStatement sqll = connect.prepareStatement("DELETE FROM article WHERE idarticle=?");

					sqll.setInt(1, article.getId());

					sqll.executeUpdate();
					// utilisation de la méthode de suppression de commentaire
					delete_associate_coms(article.getId());
					return true;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}

			}
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return false;
	}

	public boolean delete_associate_coms(int id_coms) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement sql = connect.prepareStatement("DELETE FROM commentaires  WHERE com_article=?");

			sql.setInt(1, id_coms);

			sql.executeUpdate();
			System.out.println("les commentaires associées sont supprimé");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;

	}

	@Override
	public ArrayList<Articles> readee(Articles object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Articles> findby(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Articles> findycom(int com) {
		// TODO Auto-generated method stub
		return null;
	}

}
