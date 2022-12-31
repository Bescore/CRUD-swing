package controller_blog;

import java.sql.*;
import java.util.ArrayList;

import dao.Connections;
import dao.Idao;
import modele_blog.User;

public class UserDao implements Idao<User> {

	

	@Override
	public boolean create(User object) {
		// TODO Auto-generated method stub
		Connection connect = new Connections().getConnection();
		if (object.getNom().equalsIgnoreCase("") || object.getPrenom().equalsIgnoreCase("")
				|| object.getEmail().equalsIgnoreCase("") || object.getPassword().equalsIgnoreCase("")) {
			return false;
		}

		if (readee(object).size() != 0) {
			return false;
		} else {
			try {
				PreparedStatement sql = connect
						.prepareStatement("INSERT INTO users(nom,prenom,email,password) VALUES(?,?,?,CONCAT('*', UPPER(SHA1(UNHEX(SHA1(?))))))");

				sql.setString(1, object.getNom());
				sql.setString(2, object.getPrenom());
				sql.setString(3, object.getEmail());
				sql.setString(4, object.getPassword());
				
				sql.executeUpdate();
				connect.close();
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}

		return true;
		//////////////////////////////////////////////////////

	}

	@Override
	public ArrayList<User> read() {
		// TODO Auto-generated method stub
		Connection connect = new Connections().getConnection();
		ArrayList<User> tab = new ArrayList<User>();
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM users ");

			ResultSet rs = sql.executeQuery();

			while (rs.next()) {

				User user = new User(rs.getInt("idusers"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getString("password"));
				tab.add(user);
			}
			connect.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return tab;
	}

	public ArrayList<User> readee(User object) {
		// TODO Auto-generated method stub
		Connection connect = new Connections().getConnection();
		ArrayList<User> tab = new ArrayList<User>();
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM users where email=? ");

			sql.setString(1, object.getEmail());

			ResultSet rs = sql.executeQuery();

			while (rs.next()) {

				User user = new User(rs.getInt("idusers"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getString("password"));
				tab.add(user);
			}
			connect.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return tab;
	}

	@Override
	public ArrayList<User> findby(String email, String password) {
		// TODO Auto-generated method stub
		Connection connect = new Connections().getConnection();
		ArrayList<User> tab_user = new ArrayList<User>();

		try {
			PreparedStatement sql = connect
					.prepareStatement("SELECT * FROM users where email= ? AND password=CONCAT('*', UPPER(SHA1(UNHEX(SHA1(?))))) ");

			sql.setString(1, email);
			sql.setString(2, password);

			ResultSet rs = sql.executeQuery();

			if (rs.next()) {
				User user = new User(rs.getInt("idusers"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"), rs.getString("password"), rs.getInt("isAdmin"));
				tab_user.add(user);
				// return tab_user;

			}
			connect.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return tab_user;
	}

	@Override
	public ArrayList<User> findycom(int com) {
		// TODO Auto-generated method stub
		return null;
	}

}
