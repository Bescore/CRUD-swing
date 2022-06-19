package vue_blog;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller_blog.ArticleDao;
import controller_blog.UserDao;
import controller_blog.commentaireDao;
import modele_blog.Articles;
import modele_blog.User;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;

public class Formulaire_blog extends JFrame {

	private JPanel contentPane;
	private JTextField inp_nom;
	private JTextField inp_prenom;
	private JTextField inp_email;
	private JPasswordField inp_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulaire_blog frame = new Formulaire_blog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JLayeredPane layeredPane = new JLayeredPane();
	JPanel panel = new JPanel();
	JPanel panel_1 = new JPanel();
	JPanel panel_3 = new JPanel();
	JPanel panel_4 = new JPanel();
	JPanel panel_5 = new JPanel();
	JLabel date_post = new JLabel("Date");
	JLabel id_user = new JLabel("id_user_non_visible");
	JLabel id_post_hidden = new JLabel("id_post_hidden");

	JTextArea text_Area_com = new JTextArea();
	JTextArea commentaires = new JTextArea();
	JTextArea affiche_post = new JTextArea();
	JTextArea cont_article = new JTextArea();

	JTextArea affiche_titre_post = new JTextArea();
	private JTextField email_connexion;
	private JPasswordField pass_connexion;
	// private JTable table;
	private JTable table_1;
	private JTextField cont_title;

	/**
	 * Create the frame.
	 */

	public Formulaire_blog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 556, 375);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		layeredPane.setOpaque(true);
		layeredPane.setBounds(0, 0, 556, 364);
		panel_2.add(layeredPane);

		panel.setBounds(0, 0, 556, 370);
		panel.setBackground(new Color(143, 188, 143));
		panel.setLayout(null);
		layeredPane.add(panel);

		JLabel lblNewLabel = new JLabel("--Inscription--");
		lblNewLabel.setBounds(138, 11, 288, 30);
		lblNewLabel.setFont(new Font("Ravie", Font.BOLD, 26));
		panel.add(lblNewLabel);

		JLabel lblNom = new JLabel("Nom ");
		lblNom.setBounds(296, 69, 40, 25);
		panel.add(lblNom);

		JLabel lblPrnom = new JLabel("Pr\u00E9nom ");
		lblPrnom.setBounds(279, 128, 57, 14);
		panel.add(lblPrnom);

		JLabel lblEmail = new JLabel("Email ");
		lblEmail.setBounds(290, 177, 40, 14);
		panel.add(lblEmail);

		JLabel lblPassword = new JLabel("Mot de passe");
		lblPassword.setBounds(249, 228, 76, 14);
		panel.add(lblPassword);

		inp_nom = new JTextField();
		inp_nom.setBounds(335, 71, 118, 20);
		panel.add(inp_nom);
		inp_nom.setColumns(10);

		inp_prenom = new JTextField();
		inp_prenom.setBounds(335, 125, 118, 20);
		panel.add(inp_prenom);
		inp_prenom.setColumns(10);

		inp_email = new JTextField();
		inp_email.setBounds(335, 174, 118, 20);
		panel.add(inp_email);
		inp_email.setColumns(10);

		inp_password = new JPasswordField();
		inp_password.setBounds(335, 225, 118, 20);
		panel.add(inp_password);

		JLabel lblNewLabel_5 = new JLabel("CRUD MANIA");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setBounds(20, 128, 230, 106);
		lblNewLabel_5.setFont(new Font("Ravie", Font.BOLD, 26));
		panel.add(lblNewLabel_5);
		panel.revalidate();

		JButton envoyer = new JButton("s'inscrire");
		envoyer.setRolloverEnabled(false);
		envoyer.setBounds(226, 307, 110, 23);
		panel.add(envoyer);

		JButton btnNewButton = new JButton("J'ai un compte");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_remove(panel_1);
			}
		});
		btnNewButton.setBounds(346, 307, 118, 23);
		panel.add(btnNewButton);

		envoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = inp_nom.getText();
				String prenom = inp_prenom.getText();
				String email = inp_email.getText();
				String password = String.valueOf(inp_password.getPassword());
				UserDao userDao = new UserDao();
				User user = new User(nom, prenom, email, password);

				if (userDao.create(user)) {
					JOptionPane.showMessageDialog(contentPane, "bravo compte crée");

				} else {
					JOptionPane.showMessageDialog(contentPane, "changez de mail ou remplissez bien les champs !");
				}
				;

				add_remove(panel_1);
			}

		});

		panel_1.setLayout(null);
		panel_1.setBackground(new Color(143, 188, 143));
		panel_1.setBounds(0, 0, 556, 370);
		layeredPane.add(panel_1);

		JLabel Title_connexion = new JLabel("--Connexion--");
		Title_connexion.setForeground(new Color(0, 0, 0));
		Title_connexion.setFont(new Font("Ravie", Font.BOLD, 26));
		Title_connexion.setBounds(136, 16, 270, 64);
		panel_1.add(Title_connexion);

		JLabel lblEmail_1 = new JLabel("Email ");
		lblEmail_1.setBounds(291, 177, 35, 14);
		panel_1.add(lblEmail_1);

		JLabel lblPassword_1 = new JLabel("Mot de passe");
		lblPassword_1.setBounds(241, 228, 85, 14);
		panel_1.add(lblPassword_1);

		email_connexion = new JTextField();
		email_connexion.setColumns(10);
		email_connexion.setBounds(335, 174, 118, 20);
		panel_1.add(email_connexion);

		pass_connexion = new JPasswordField();
		pass_connexion.setBounds(335, 225, 118, 20);
		panel_1.add(pass_connexion);

		JButton connexion = new JButton("connexion");
		connexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = email_connexion.getText();
				String password = String.valueOf(pass_connexion.getPassword());

				UserDao userDao = new UserDao();
				System.out.println(userDao.findby(email, password));

				if (userDao.findby(email, password).size() != 0) {
					// ajouter l'id de l'utilisateur à la page à la page//
					id_user.setText(String.valueOf(userDao.findby(email, password).get(0).getId()));
					JOptionPane.showMessageDialog(contentPane, "vous êtes connecté !");
					add_remove(panel_3);
					JLabel lblNewLabel_1 = new JLabel("Bonjour " + userDao.findby(email, password).get(0).getPrenom());
					lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
					lblNewLabel_1.setBounds(25, 34, 400, 14);
					panel_3.add(lblNewLabel_1);

					JLabel lblNewLabel_2 = new JLabel(
							"adresse de connexion : " + userDao.findby(email, password).get(0).getEmail() + "");
					lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 9));
					lblNewLabel_2.setBounds(10, 345, 395, 14);
					panel_3.add(lblNewLabel_2);
					// metre string data ici

					// trouver les articles
					ArticleDao read_article = new ArticleDao();
					add_row(read_article.read());

					JButton add_article = new JButton("ajouter un article");
					add_article.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							add_remove(panel_4);

						}
					});
					add_article.setFocusable(false);
					add_article.setBounds(400, 11, 146, 23);
					panel_3.add(add_article);

					JButton envoyer_article = new JButton("Envoyer l'article");
					envoyer_article.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String email = email_connexion.getText();
							String password = String.valueOf(pass_connexion.getPassword());
							UserDao userDao = new UserDao();
							String titre = cont_title.getText();
							String contenu = cont_article.getText();
							System.out.println(userDao.findby(email, password).get(0).getId());

							Articles article = new Articles(titre, contenu,
									userDao.findby(email, password).get(0).getId());
							ArticleDao crud = new ArticleDao();
							if (crud.create(article)) {
								JOptionPane.showMessageDialog(contentPane, "votre article a été ajouté !");
								titre = null;
								contenu = null;
							}
							;
						}
					});
					envoyer_article.setBounds(70, 299, 158, 23);
					panel_4.add(envoyer_article);

					JButton retour = new JButton("retour");
					retour.setRolloverEnabled(false);
					retour.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							panel_3.removeAll();
							String email = email_connexion.getText();
							String password = String.valueOf(pass_connexion.getPassword());
							add_remove(panel_3);
							JLabel lblNewLabel_1 = new JLabel(
									"Bonjour " + userDao.findby(email, password).get(0).getPrenom());
							lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
							lblNewLabel_1.setBounds(25, 34, 400, 14);
							panel_3.add(lblNewLabel_1);

							JLabel lblNewLabel_2 = new JLabel(
									"adresse de connexion : " + userDao.findby(email, password).get(0).getEmail() + "");
							lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 9));
							lblNewLabel_2.setBounds(10, 345, 395, 14);
							panel_3.add(lblNewLabel_2);

							JButton add_article = new JButton("ajouter un article");
							add_article.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									add_remove(panel_4);

								}
							});

							add_article.setFocusable(false);
							add_article.setBounds(400, 11, 146, 23);
							panel_3.add(add_article);

							JButton deconnecter = new JButton("Se d\u00E9connecter");
							deconnecter.setBounds(421, 336, 125, 23);
							deconnecter.setFocusable(false);
							deconnecter.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									add_remove(panel_1);
									panel_3.removeAll();
									panel_3.add(deconnecter);
								}
							});
							panel_3.setLayout(null);
							panel_3.add(deconnecter);

							// retrouver les articles
							ArticleDao read_articl = new ArticleDao();
							add_row(read_articl.read());
							System.out.println(read_articl.read());
							panel_3.repaint();
							panel_3.revalidate();

						}
					});

					retour.setBounds(382, 299, 89, 23);
					panel_4.add(retour);
				} else {
					JOptionPane.showMessageDialog(contentPane, "compte inexistant ou mauvais mot de passe");
				}
			}
		});
		connexion.setBounds(226, 307, 110, 23);
		panel_1.add(connexion);

		JLabel lblNewLabel_5_1 = new JLabel("CRUD MANIA");
		lblNewLabel_5_1.setBackground(new Color(240, 248, 255));
		lblNewLabel_5_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_5_1.setFont(new Font("Ravie", Font.BOLD, 26));
		lblNewLabel_5_1.setBounds(31, 125, 270, 158);
		panel_1.add(lblNewLabel_5_1);

		JButton btnNewButton_1 = new JButton("inscription");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_remove(panel);
			}
		});
		btnNewButton_1.setBounds(346, 307, 118, 23);
		panel_1.add(btnNewButton_1);
		id_user.setVisible(false);

		id_user.setBounds(436, 26, 110, 14);
		panel_1.add(id_user);
		panel_5.setBackground(new Color(143, 188, 143));

		panel_5.setBounds(0, 0, 556, 370);
		layeredPane.add(panel_5);
		panel_5.setLayout(null);
		commentaires.setForeground(SystemColor.textHighlight);
		commentaires.setSelectedTextColor(Color.BLUE);
		commentaires.setAutoscrolls(false);
		commentaires.setColumns(2);
		commentaires.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

		commentaires.setEditable(false);
		commentaires.setBackground(Color.LIGHT_GRAY);
		commentaires.setBounds(290, 79, 240, 113);
		panel_5.add(commentaires);

		affiche_post.setBounds(10, 146, 243, 188);
		affiche_post.setBackground(Color.LIGHT_GRAY);
		panel_5.add(affiche_post);
		affiche_titre_post.setBounds(10, 79, 243, 28);
		affiche_titre_post.setBackground(Color.LIGHT_GRAY);

		affiche_titre_post.setLineWrap(true);
		panel_5.add(affiche_titre_post);

		JLabel lblNewLabel_6 = new JLabel("Le fameux show !");
		lblNewLabel_6.setBounds(155, 11, 235, 33);
		lblNewLabel_6.setFont(new Font("Source Code Pro Black", Font.BOLD, 23));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("commentaires :");
		lblNewLabel_7.setBounds(290, 55, 134, 14);
		lblNewLabel_7.setForeground(SystemColor.window);
		panel_5.add(lblNewLabel_7);
		date_post.setBounds(10, 345, 243, 14);
		date_post.setForeground(SystemColor.window);
		panel_5.add(date_post);

		JLabel lblNewLabel_8 = new JLabel("Titre :");
		lblNewLabel_8.setBounds(10, 60, 84, 14);
		lblNewLabel_8.setForeground(SystemColor.textHighlightText);
		panel_5.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Contenu :");
		lblNewLabel_9.setBounds(10, 121, 108, 14);
		lblNewLabel_9.setForeground(SystemColor.textHighlightText);
		panel_5.add(lblNewLabel_9);
		/// RETOUR DE LA PAGE SHOW ARTICLE
		JButton btnNewButton_3 = new JButton("retour");
		btnNewButton_3.setRolloverEnabled(false);
		btnNewButton_3.setBounds(441, 312, 89, 23);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commentaires.setText(null);
				panel_3.removeAll();
				UserDao userDao = new UserDao();

				String email = email_connexion.getText();
				String password = String.valueOf(pass_connexion.getPassword());
				add_remove(panel_3);
				JLabel lblNewLabel_1 = new JLabel("Bonjour " + userDao.findby(email, password).get(0).getPrenom());
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblNewLabel_1.setBounds(25, 34, 400, 14);
				panel_3.add(lblNewLabel_1);

				JLabel lblNewLabel_2 = new JLabel(
						"adresse de connexion : " + userDao.findby(email, password).get(0).getEmail() + "");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 9));
				lblNewLabel_2.setBounds(10, 345, 395, 14);
				panel_3.add(lblNewLabel_2);

				JButton add_article = new JButton("ajouter un article");
				add_article.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						add_remove(panel_4);
					}
				});

				add_article.setFocusable(false);
				add_article.setBounds(400, 11, 146, 23);
				panel_3.add(add_article);

				JButton deconnecter = new JButton("Se d\u00E9connecter");
				deconnecter.setBounds(421, 336, 125, 23);
				deconnecter.setFocusable(false);
				deconnecter.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						add_remove(panel_1);
						panel_3.removeAll();
						panel_3.add(deconnecter);
					}
				});
				panel_3.setLayout(null);
				panel_3.add(deconnecter);

				ArticleDao read_articl = new ArticleDao();
				add_row(read_articl.read());
				System.out.println(read_articl.read());
				panel_3.repaint();
				panel_3.revalidate();
			}
		});
		panel_5.add(btnNewButton_3);

		text_Area_com.setBounds(290, 217, 240, 55);

		text_Area_com.setBackground(SystemColor.menu);
		panel_5.add(text_Area_com);
		id_post_hidden.setForeground(new Color(255, 255, 255));
		id_post_hidden.setBackground(new Color(0, 255, 0));
		id_post_hidden.setBounds(355, 345, 60, 14);
		panel_5.add(id_post_hidden);

		JButton update_article = new JButton("modifier art.");
		update_article.setRolloverEnabled(false);
		update_article.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titre = affiche_titre_post.getText();
				String contenu = affiche_post.getText();
				int id = Integer.valueOf(id_post_hidden.getText());
				int auteur = Integer.valueOf(id_user.getText());
				// instancie un nouvelle object article
				Articles article_mod = new Articles(id, titre, contenu, auteur);

				// instancie article dao
				ArticleDao artDao = new ArticleDao();
				if (!artDao.update_article(article_mod)) {
					JOptionPane.showMessageDialog(contentPane,
							"Vous ne pouvez pas modifier un article que vous n'avez pas créé !");
				} else {
					JOptionPane.showMessageDialog(contentPane, "Vous modifiez l'article avec succès !");
				}
			}
		});
		update_article.setBounds(290, 283, 118, 23);
		panel_5.add(update_article);

		JLabel lblNewLabel_3 = new JLabel("ID Article :");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(290, 345, 60, 14);
		panel_5.add(lblNewLabel_3);

		JButton delete = new JButton("Supprimer");
		delete.setRolloverEnabled(false);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int auteur_d_action = Integer.valueOf(id_user.getText());
				int id_article = Integer.valueOf(id_post_hidden.getText());
				// on instancie un article
				Articles article = new Articles(id_article, auteur_d_action);

				// on instancie articleDao pour declencher le delete
				ArticleDao art_dao = new ArticleDao();

				// on declenche le delete

				if (JOptionPane.showConfirmDialog(contentPane, "Voulez vous vraiment supprimer cette article ?", "hop",
						JOptionPane.YES_NO_OPTION) == 0) {
					if (!art_dao.delete(article)) {
						JOptionPane.showMessageDialog(contentPane,
								"vous ne pouvez pas supprimer cette article car vous ne l'avez pas créé");
					}
					;
				}
				;

			}
		});
		delete.setBounds(418, 283, 112, 23);
		panel_5.add(delete);
		layeredPane.setLayer(panel_3, 0);
		panel_3.setAutoscrolls(true);
		panel_3.setBackground(new Color(143, 188, 143));
		panel_3.setBounds(0, 0, 556, 370);
		layeredPane.add(panel_3);

		JButton deconnecter_1 = new JButton("Se d\u00E9connecter");
		deconnecter_1.setRolloverEnabled(false);
		deconnecter_1.setBounds(421, 336, 125, 23);
		deconnecter_1.setFocusable(false);
		deconnecter_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_remove(panel_1);
				panel_3.removeAll();
				panel_3.add(deconnecter_1);
			}
		});
		panel_3.setLayout(null);
		// table.setFillsViewportHeight(true);

		// panel_3.add(table_1);

		panel_3.add(deconnecter_1);
		panel_4.setRequestFocusEnabled(false);
		panel_4.setDoubleBuffered(false);
		panel_4.setEnabled(false);
		panel_4.setBackground(new Color(143, 188, 143));

		panel_4.setBounds(0, 0, 556, 370);
		layeredPane.add(panel_4);
		panel_4.setLayout(null);

		JLabel titre_article = new JLabel("Titre de l'article");
		titre_article.setBounds(28, 31, 89, 14);
		panel_4.add(titre_article);

		cont_title = new JTextField();
		cont_title.setBounds(28, 56, 250, 20);
		panel_4.add(cont_title);
		cont_title.setColumns(10);

		JLabel contenu_article = new JLabel("Contenu de l'article");
		contenu_article.setBounds(28, 107, 152, 14);
		panel_4.add(contenu_article);

		cont_article.setLineWrap(true);
		cont_article.setBounds(28, 132, 250, 127);
		panel_4.add(cont_article);

		/*
		 * JLabel lblNewLabel_2 = new JLabel("adresse de connexion : ");
		 * lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		 * lblNewLabel_2.setBounds(10, 345, 395, 14); panel_3.add(lblNewLabel_2);
		 * 
		 */

		// SHOW l'article

	}

	// fonction de changement de panels
	public void add_remove(JPanel pane) {
		layeredPane.removeAll();
		// pane.setVisible(false);
		// JLabel lblNewLabel_8 = new JLabel("ayayaya");
		// pane.add(lblNewLabel_8);
		layeredPane.add(pane);
		pane.repaint();
		pane.revalidate();
	}

	// fonction read des articles dans le tableau
	public void add_row(ArrayList<Articles> Article) {
		// on créer le tableau
		table_1 = new JTable();
		table_1.setBackground(Color.GREEN);

		table_1.setModel(
				new DefaultTableModel(new String[] { "ID", "Titre", "contenu", "Date de cr\u00E9ation", "Auteur" }, 0));

		table_1.getColumnModel().getColumn(4).setPreferredWidth(92);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(101);
		table_1.setBounds(10, 45, 100, 200);

		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(10, 64, 526, 243);
		panel_3.add(scrollPane);

		// table_1.setEnabled(false); RENDRE LE TABLEEAU incliquable
		// on récupère le modèle du tableau 1
		DefaultTableModel model_table_1 = (DefaultTableModel) table_1.getModel();
		for (Articles articles : Article) {
			// on ajoute dynamiquement chaque ligne avec un foreach
			model_table_1.addRow(new Object[] { articles.getId(), articles.getTitre(), articles.getContenu(),
					articles.getDate(), articles.getPrenom_auteur() });

		}

		table_1.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table_1.getSelectedRow();
				int col = table_1.getSelectedColumn();

				commentaireDao com = new commentaireDao();

				// System.out.println(com.findycom((int)
				// model_table_1.getDataVector().get(row).get(0)).get(0).getContenu_com());
				// System.out.println(com.findycom((int)
				// model_table_1.getDataVector().get(row).get(0)));
				// System.out.println( model_table_1.getDataVector().get(row).get(0));

				// ajouter l'id du post à la page(caché pour l'utilisateur)//
				id_post_hidden.setText(String.valueOf(model_table_1.getDataVector().get(row).get(0)));

				//// A REVOIR////
				for (int i = 0; i < com.findycom((int) model_table_1.getDataVector().get(row).get(0)).size(); i++) {
					commentaires.append("- "
							+ com.findycom((int) model_table_1.getDataVector().get(row).get(0)).get(i).getContenu_com()
							+ "- " + "\n");
				}
				affiche_titre_post.setText((String) model_table_1.getDataVector().get(row).get(1));
				affiche_post.setText((String) (model_table_1.getDataVector().get(row).get(2)));
				date_post.setText((String) ("Post écrit le : " + model_table_1.getDataVector().get(row).get(3)));
				add_remove(panel_5);

				///////////////////////////////////////////////////////////////////////////////////////////////////

				JButton btnNewButton_4 = new JButton("Commenter");
				btnNewButton_4.setRolloverEnabled(false);
				btnNewButton_4.setBounds(290, 311, 147, 23);
				btnNewButton_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int id_articles = Integer.valueOf(id_post_hidden.getText());
						int id_userss = Integer.valueOf(id_user.getText());
						String contenu_com = text_Area_com.getText();
						// création de nouveau commentaire
						modele_blog.commentaires com = new modele_blog.commentaires(id_articles, contenu_com,
								id_userss);

						// instanciation de commentaireDao
						commentaireDao com_dao = new commentaireDao();

						com_dao.create(com);
						text_Area_com.setText("");
						int val = Integer.valueOf(id_post_hidden.getText());
						commentaireDao comm = new commentaireDao();
						commentaires.append("- "
								+ comm.findycom(val).get(comm.findycom(val).size() - 1).getContenu_com() + " -" + "\n");
						// System.out.println(comm.findycom(val));
						// System.out.println(comm.findycom(val).get(comm.findycom(val).size()-1).getContenu_com());
					}
				});
				panel_5.add(btnNewButton_4);

			}
		});

	}
}
