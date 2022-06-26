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
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller_blog.Admin_dao;
import controller_blog.ArticleDao;
import controller_blog.UserDao;
import controller_blog.commentaireDao;
import modele_blog.Articles;
import modele_blog.User;
import javax.swing.JList;
import java.awt.Toolkit;
import javax.swing.JToggleButton;
import javax.swing.UIManager;

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
	JPanel panel_6 = new JPanel();
	JPanel panel_7 = new JPanel();
	JLabel image_blog = new JLabel("");
	JLabel date_post = new JLabel("Date");
	JLabel id_user = new JLabel("id_user_non_visible");
	JLabel isAdmin = new JLabel("isAdmin_non_visible");
	JLabel id_post_hidden = new JLabel("id_post_hidden");
	JLabel id_admin_user = new JLabel("id_admin_user");
	JTextArea input_becoming_admin = new JTextArea();
	JTextArea affiche_titre_post = new JTextArea();
	JTextArea text_Area_com = new JTextArea();
	JTextArea commentaires = new JTextArea();
	JTextArea affiche_post = new JTextArea();
	JTextArea cont_article = new JTextArea();
	JTextArea changer_nom_user = new JTextArea();
	JTextArea changer_prenom_user = new JTextArea();

	private JTextField email_connexion;
	private JPasswordField pass_connexion;
	// private JTable table;
	private JTable table_1;
	private JTextArea cont_title;
	private JTable table_users;

	/**
	 * Create the frame.
	 */

	public Formulaire_blog() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Formulaire_blog.class.getResource("/images/administrateur (1) (1).png")));
		setResizable(false);
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

		panel_1.setLayout(null);
		panel_1.setBackground(new Color(143, 188, 143));
		panel_1.setBounds(0, 0, 556, 370);
		layeredPane.add(panel_1);

		JLabel Title_connexion = new JLabel("Connexion");
		Title_connexion.setForeground(new Color(0, 0, 0));
		Title_connexion.setFont(new Font("Stencil", Font.BOLD, 26));
		Title_connexion.setBounds(31, 97, 270, 64);
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
		connexion.setBorder(UIManager.getBorder("CheckBox.border"));
		connexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// System.out.println(Pattern.matches("/^[a-zA-Z0-9._%-]+[@]+[a-zA-Z0-9.-]+[.]+[a-zA-Z]{2,4}$/","hello"));
				String email = email_connexion.getText();
				String password = String.valueOf(pass_connexion.getPassword());
				UserDao userDao = new UserDao();

				if (userDao.findby(email, password).size() != 0) {
					// ajouter l'id de l'utilisateur à la page//
					id_user.setText(String.valueOf(userDao.findby(email, password).get(0).getId()));
					isAdmin.setText(String.valueOf(userDao.findby(email, password).get(0).getIsAdmin()));
					JOptionPane.showMessageDialog(contentPane, "vous êtes connecté !");
					add_remove(panel_3);
					JLabel lblNewLabel_1 = new JLabel("Bonjour " + userDao.findby(email, password).get(0).getPrenom());
					lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
					lblNewLabel_1.setBounds(25, 34, 400, 14);
					panel_3.add(lblNewLabel_1);

					JLabel lblNewLabel_2 = new JLabel(
							"adresse de connexion : " + userDao.findby(email, password).get(0).getEmail() + "");
					lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 9));
					lblNewLabel_2.setBounds(290, 34, 400, 14);
					panel_3.add(lblNewLabel_2);
					// metre string data ici

					// trouver les articles
					ArticleDao read_article = new ArticleDao();
					add_row(read_article.read());

					// gerer user
					if (isAdmin.getText().equalsIgnoreCase("1")) {
						JButton gerer_user = new JButton("G\u00E9rer les utilisateurs");
						gerer_user.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Admin_dao admin_dao = new Admin_dao();
								DefaultTableModel dtm = (DefaultTableModel) table_users.getModel();
								dtm.setRowCount(0);

								// generer le tableau des users
								// on ajoute dynamiquement chaque ligne avec un foreach
								(admin_dao.Admin_user_Read()).forEach(element ->

								dtm.addRow(new Object[] { element.getId(), element.getNom(), element.getPrenom(),
										element.getEmail(), element.getPassword(), element.getIsAdmin() }));
								add_remove(panel_6);
							}
						});
						gerer_user.setBounds(10, 336, 193, 23);
						panel_3.add(gerer_user);

					}

					JButton add_article = new JButton("ajouter un article");
					add_article.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							affiche_titre_post.setVisible(true);
							image_blog.setVisible(true);
							cont_title.setVisible(true);
							add_remove(panel_4);
						}
					});
					add_article.setFocusable(false);
					add_article.setBounds(270, 336, 146, 23);
					panel_3.add(add_article);

					JButton envoyer_article = new JButton("Envoyer l'article");
					envoyer_article.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String email = email_connexion.getText();
							String password = String.valueOf(pass_connexion.getPassword());
							UserDao userDao = new UserDao();
							String titre = cont_title.getText();
							String contenu = cont_article.getText();

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
							lblNewLabel_2.setBounds(290, 34, 400, 14);
							panel_3.add(lblNewLabel_2);

							JButton add_article = new JButton("ajouter un article");
							add_article.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									affiche_titre_post.setVisible(true);
									image_blog.setVisible(true);
									cont_title.setVisible(true);
									add_remove(panel_4);

								}
							});

							add_article.setFocusable(false);
							add_article.setBounds(270, 336, 146, 23);
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

							panel_3.repaint();
							panel_3.revalidate();

							// kiki gerer user
							if (isAdmin.getText().equalsIgnoreCase("1")) {
								JButton gerer_user = new JButton("G\u00E9rer les utilisateurs");
								gerer_user.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {

										Admin_dao admin_dao = new Admin_dao();

										// generer le tableau des users de nouveau
										DefaultTableModel dtm = (DefaultTableModel) table_users.getModel();
										dtm.setRowCount(0);
										// System.out.println(admin_dao.Admin_user_Read());
										// on ajoute dynamiquement chaque ligne avec un foreach
										(admin_dao.Admin_user_Read()).forEach(element ->

										dtm.addRow(new Object[] { element.getId(), element.getNom(),
												element.getPrenom(), element.getEmail(), element.getPassword(),
												element.getIsAdmin() }));
										// revenir au panel_6
										add_remove(panel_6);

									}

								});
								gerer_user.setBounds(10, 336, 193, 23);
								panel_3.add(gerer_user);
							}

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
		lblNewLabel_5_1.setFont(new Font("Stencil", Font.BOLD, 26));
		lblNewLabel_5_1.setBounds(31, 151, 270, 83);
		panel_1.add(lblNewLabel_5_1);

		JButton btnNewButton_1 = new JButton("inscription");
		btnNewButton_1.setBorder(UIManager.getBorder("CheckBox.border"));
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
		isAdmin.setVisible(false);

		isAdmin.setBounds(10, 26, 103, 14);
		panel_1.add(isAdmin);
		
				panel.setBounds(0, 0, 556, 370);
				panel.setBackground(new Color(143, 188, 143));
				panel.setLayout(null);
				layeredPane.add(panel);
				
						JLabel lblNewLabel_5 = new JLabel("CRUD MANIA");
						lblNewLabel_5.setForeground(new Color(0, 0, 0));
						lblNewLabel_5.setBounds(39, 94, 230, 56);
						lblNewLabel_5.setFont(new Font("Stencil", Font.BOLD, 26));
						panel.add(lblNewLabel_5);
						
								JLabel lblNewLabel = new JLabel("Inscription");
								lblNewLabel.setBounds(39, 167, 230, 30);
								lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 26));
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
																								panel.revalidate();
																								
																										JButton envoyer = new JButton("s'inscrire");
																										envoyer.setBorder(UIManager.getBorder("CheckBox.border"));
																										envoyer.setRolloverEnabled(false);
																										envoyer.setBounds(226, 307, 110, 23);
																										panel.add(envoyer);
																										
																												JButton btnNewButton = new JButton("J'ai un compte");
																												btnNewButton.setBorder(UIManager.getBorder("CheckBox.border"));
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
																												
																																// Pattern.matches("^[a-zA-Z0-9._%-]+[@]+[a-zA-Z0-9.-]+[.]+[a-zA-Z]{2,4}$",email)
																																if (Pattern.matches("^[a-zA-Z0-9._%-]+[@]+[a-zA-Z0-9.-]+[.]+[a-zA-Z]{2,4}$", email)) {
																																	userDao.create(user);
																																	JOptionPane.showMessageDialog(contentPane, "bravo compte crée");
																												
																																} else {
																																	JOptionPane.showMessageDialog(contentPane, "champ manquant,email déja utilisé ou invalide !");
																																}
																																;
																												
																															}
																												
																														});
		panel_5.setBackground(new Color(143, 188, 143));

		panel_5.setBounds(0, 0, 556, 370);
		layeredPane.add(panel_5);
		panel_5.setLayout(null);
		affiche_post.setLineWrap(true);
		// scrollPanel.add(commentaires);
		// panel_5.add(commentaires);

		affiche_post.setBounds(10, -14, 41, 124);
		affiche_post.setBackground(Color.LIGHT_GRAY);
		panel_5.add(affiche_post);
		// panel_5.add(affiche_titre_post);

		JLabel lblNewLabel_6 = new JLabel("Le fameux show !");
		lblNewLabel_6.setBounds(155, 11, 235, 33);
		lblNewLabel_6.setFont(new Font("Stencil", Font.BOLD, 23));
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
		btnNewButton_3.setBorder(UIManager.getBorder("CheckBox.border"));
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
				lblNewLabel_2.setBounds(290, 34, 400, 14);
				panel_3.add(lblNewLabel_2);

				JButton add_article = new JButton("ajouter un article");
				add_article.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						image_blog.setVisible(true);
						cont_title.setVisible(true);
						affiche_titre_post.setVisible(true);
						add_remove(panel_4);
					}
				});

				add_article.setFocusable(false);
				add_article.setBounds(270, 336, 146, 23);
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
				panel_3.repaint();
				panel_3.revalidate();

				// gerer user
				if (isAdmin.getText().equalsIgnoreCase("1")) {
					JButton gerer_user = new JButton("G\u00E9rer les utilisateurs");
					gerer_user.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {

							Admin_dao admin_dao = new Admin_dao();

							// generer le tableau des users de nouveau
							DefaultTableModel dtm = (DefaultTableModel) table_users.getModel();
							dtm.setRowCount(0);
							// System.out.println(admin_dao.Admin_user_Read());
							// on ajoute dynamiquement chaque ligne avec un foreach
							(admin_dao.Admin_user_Read()).forEach(element ->

							dtm.addRow(new Object[] { element.getId(), element.getNom(), element.getPrenom(),
									element.getEmail(), element.getPassword(), element.getIsAdmin() }));
							// revenir au panel_6
							add_remove(panel_6);

						}
					});
					gerer_user.setBounds(10, 336, 193, 23);
					panel_3.add(gerer_user);
				}
			}
		});
		panel_5.add(btnNewButton_3);
		// panel_5.add(text_Area_com);
		id_post_hidden.setForeground(new Color(255, 255, 255));
		id_post_hidden.setBackground(new Color(0, 255, 0));
		id_post_hidden.setBounds(355, 345, 60, 14);
		panel_5.add(id_post_hidden);

		JButton update_article = new JButton("modifier art.");
		update_article.setBorder(UIManager.getBorder("CheckBox.border"));
		update_article.setRolloverEnabled(false);
		update_article.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titre = affiche_titre_post.getText();
				String contenu = affiche_post.getText();
				int id = Integer.valueOf(id_post_hidden.getText());
				int auteur = Integer.valueOf(id_user.getText());

				// si on est admin
				if (isAdmin.getText().equalsIgnoreCase("1")) {
					Articles article = new Articles(id, titre, contenu, auteur);
					Admin_dao admin = new Admin_dao();
					admin.update(article);
					JOptionPane.showMessageDialog(contentPane, "Vous êtes admin et vous modifiez cette article");
					// sinon
				} else {

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
			}
		});
		update_article.setBounds(290, 283, 118, 23);
		panel_5.add(update_article);

		JLabel lblNewLabel_3 = new JLabel("ID Article :");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(290, 345, 60, 14);
		panel_5.add(lblNewLabel_3);

		JButton delete = new JButton("Supprimer");
		delete.setBorder(UIManager.getBorder("CheckBox.border"));
		delete.setRolloverEnabled(false);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int auteur_d_action = Integer.valueOf(id_user.getText());
				int id_article = Integer.valueOf(id_post_hidden.getText());

				// si on est admin on utilise le le crud admin dédié avec tous les droits
				if (isAdmin.getText().equalsIgnoreCase("1")) {
					Articles article = new Articles(id_article);
					Admin_dao admin = new Admin_dao();
					admin.delete(article);
					JOptionPane.showMessageDialog(contentPane, "Vous êtes admin et vous supprimez cette article");
					// sinon on tulise le crud classique des users
				} else {

					// on instancie un article
					Articles article = new Articles(id_article, auteur_d_action);

					// on instancie articleDao pour declencher le delete
					ArticleDao art_dao = new ArticleDao();

					// on declenche le delete

					if (JOptionPane.showConfirmDialog(contentPane, "Voulez vous vraiment supprimer cette article ?",
							"hop", JOptionPane.YES_NO_OPTION) == 0) {
						if (!art_dao.delete(article)) {
							JOptionPane.showMessageDialog(contentPane,
									"vous ne pouvez pas supprimer cette article car vous ne l'avez pas créé");
						} else {
							JOptionPane.showMessageDialog(contentPane, "vous supprimez l'article cliquez sur retour");
						}
					}
					;
				}
			}
		});
		delete.setBounds(418, 283, 112, 23);
		panel_5.add(delete);
		commentaires.setLineWrap(true);
		commentaires.setBackground(Color.LIGHT_GRAY);
		commentaires.setEditable(false);
		commentaires.setForeground(SystemColor.textHighlight);
		commentaires.setSelectedTextColor(Color.BLUE);
		commentaires.setColumns(2);
		commentaires.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		commentaires.setBounds(0, 0, 240, 127);
		// commentaires.setBounds(290, 79, 240, 113);

		JScrollPane scrollPanel = new JScrollPane(commentaires);
		scrollPanel.setBounds(290, 79, 240, 127);
		panel_5.add(scrollPanel);
		affiche_titre_post.setLineWrap(true);
		affiche_titre_post.setBounds(10, 77, 243, 33);
		affiche_titre_post.setBackground(Color.LIGHT_GRAY);
		text_Area_com.setLineWrap(true);

		text_Area_com.setBounds(0, 0, 240, 55);

		text_Area_com.setBackground(SystemColor.menu);

		JScrollPane scrollPane_ecrire_commentaire = new JScrollPane(text_Area_com);
		scrollPane_ecrire_commentaire.setAutoscrolls(true);
		scrollPane_ecrire_commentaire.setBounds(290, 217, 240, 55);
		panel_5.add(scrollPane_ecrire_commentaire);

		JScrollPane scrollPanel_contenu = new JScrollPane(affiche_post);
		scrollPanel_contenu.setBounds(10, 146, 243, 126);
		panel_5.add(scrollPanel_contenu);

		JScrollPane scrollPane_titre_post = new JScrollPane(affiche_titre_post);
		scrollPane_titre_post.setBounds(10, 77, 243, 33);
		panel_5.add(scrollPane_titre_post);
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

		JLabel contenu_article = new JLabel("Contenu de l'article");
		contenu_article.setBounds(28, 107, 152, 14);
		panel_4.add(contenu_article);

		cont_article.setLineWrap(true);
		cont_article.setBounds(28, 132, 250, 127);

		cont_title = new JTextArea();
		cont_title.setVisible(false);
		cont_title.setLineWrap(true);
		cont_title.setBorder(null);
		cont_title.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		cont_title.setBounds(28, 56, 250, 20);
		cont_title.setColumns(10);

		JScrollPane scrollPane_titre_panel_4 = new JScrollPane(cont_title);
		scrollPane_titre_panel_4.setBounds(28, 56, 250, 29);
		panel_4.add(scrollPane_titre_panel_4);

		JScrollPane scrollPane_contenu_panel_4 = new JScrollPane(cont_article);
		scrollPane_contenu_panel_4.setBounds(28, 132, 250, 159);
		panel_4.add(scrollPane_contenu_panel_4);

		image_blog.setVisible(false);
		image_blog.setIcon(new ImageIcon(Formulaire_blog.class.getResource("/images/blog.gif")));
		image_blog.setBounds(353, 31, 208, 213);

		JScrollPane scrollPane_image_panel_4 = new JScrollPane(image_blog);
		scrollPane_image_panel_4.setBounds(309, 64, 203, 203);
		panel_4.add(scrollPane_image_panel_4);

		panel_6.setBackground(new Color(143, 188, 143));
		panel_6.setBounds(0, 0, 556, 370);
		layeredPane.add(panel_6);
		panel_6.setLayout(null);

		table_users = new JTable();
		table_users.setBackground(Color.GREEN);
		table_users.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nom", "Prenom", "Email", "Password", "Admin ?" }) {
			/*cellules non editables*/	
			 @Override
		    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
		});
		table_users.getColumnModel().getColumn(0).setPreferredWidth(78);
		table_users.getColumnModel().getColumn(1).setPreferredWidth(98);
		table_users.getColumnModel().getColumn(2).setPreferredWidth(121);
		table_users.getColumnModel().getColumn(3).setPreferredWidth(134);
		table_users.getColumnModel().getColumn(4).setPreferredWidth(92);
		table_users.getColumnModel().getColumn(5).setPreferredWidth(101);
		table_users.setBounds(433, 241, -347, -182);
		////////// ----------------------------------/////////////////
		DefaultTableModel model_table_user = (DefaultTableModel) table_users.getModel();
		table_users.setRowHeight(30);

		// mouse click event sur les ligne du tableau des users
		table_users.addMouseListener((MouseListener) new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int row = table_users.getSelectedRow();

				id_admin_user.setText(String.valueOf(model_table_user.getDataVector().get(row).get(0)));
				changer_nom_user.setText((String) model_table_user.getDataVector().get(row).get(1));
				changer_prenom_user.setText((String) model_table_user.getDataVector().get(row).get(2));
				input_becoming_admin.setText(String.valueOf(model_table_user.getDataVector().get(row).get(5)));

				add_remove(panel_7);

				// System.out.println(model_table_user.getDataVector().get(row));
			}
		});

		// centrer les infos du tableau users

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		for (int x = 0; x < table_users.getColumnCount(); x++) {
			table_users.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
		}
		JScrollPane scrollPane_users = new JScrollPane(table_users);
		scrollPane_users.setBounds(21, 58, 512, 231);
		panel_6.add(scrollPane_users);

		JButton retour_to_art_list = new JButton("retour");
		retour_to_art_list.setRolloverEnabled(false);
		retour_to_art_list.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model_table_1 = (DefaultTableModel) table_1.getModel();
				model_table_1.setRowCount(0);
				ArticleDao read_articl = new ArticleDao();

				(read_articl.read()).forEach(element -> model_table_1.addRow(new Object[] { element.getId(),
						element.getTitre(), element.getContenu(), element.getDate(), element.getPrenom_auteur() }));

				add_remove(panel_3);

			}
		});
		retour_to_art_list.setBounds(419, 319, 89, 23);
		panel_6.add(retour_to_art_list);

		JLabel lblNewLabel_11 = new JLabel("Liste des utilisateurs");
		lblNewLabel_11.setFont(new Font("Stencil", Font.PLAIN, 26));
		lblNewLabel_11.setBounds(21, 24, 453, 23);
		panel_6.add(lblNewLabel_11);

		panel_7.setBackground(new Color(143, 188, 143));
		panel_7.setBounds(0, 0, 556, 370);
		layeredPane.add(panel_7);
		panel_7.setLayout(null);
		id_admin_user.setVisible(false);

		id_admin_user.setBounds(30, 11, 77, 23);
		panel_7.add(id_admin_user);

		changer_nom_user.setBounds(30, 177, 192, 22);
		panel_7.add(changer_nom_user);

		changer_prenom_user.setBounds(246, 177, 182, 22);
		panel_7.add(changer_prenom_user);

		JButton valider_changement_user = new JButton("Valider les changements");
		valider_changement_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user_nom = changer_nom_user.getText();
				String user_prenom = changer_prenom_user.getText();
				int user_id = Integer.valueOf(id_admin_user.getText());
				int user_admin_field = Integer.valueOf(input_becoming_admin.getText());

				Admin_dao admin_dao = new Admin_dao();
				// realiser l'update
				admin_dao.update_user(user_nom, user_prenom, user_admin_field, user_id);

				// generer le tableau des users de nouveau
				DefaultTableModel dtm = (DefaultTableModel) table_users.getModel();
				dtm.setRowCount(0);
				// System.out.println(admin_dao.Admin_user_Read());
				// on ajoute dynamiquement chaque ligne avec un foreach
				(admin_dao.Admin_user_Read()).forEach(element ->

				dtm.addRow(new Object[] { element.getId(), element.getNom(), element.getPrenom(), element.getEmail(),
						element.getPassword(), element.getIsAdmin() }));
				// revenir au panel_6
				add_remove(panel_6);

			}
		});
		valider_changement_user.setBorder(UIManager.getBorder("CheckBox.border"));
		valider_changement_user.setBackground(new JButton().getBackground());
		valider_changement_user.setRolloverEnabled(false);
		valider_changement_user.setBounds(30, 238, 192, 23);
		panel_7.add(valider_changement_user);

		JButton supprimer_user = new JButton("Supprimer l'utilisateur");
		supprimer_user.setBorder(UIManager.getBorder("CheckBox.border"));
		supprimer_user.setRolloverEnabled(false);
		supprimer_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (id_admin_user.getText().equalsIgnoreCase(id_user.getText())) {

					JOptionPane.showMessageDialog(contentPane,
							"Vous ne pouvez pas vous supprimer vous même, il faut pas déconner..");
				} else {
					int id_user_a_supprimer = Integer.valueOf(id_admin_user.getText());
					Admin_dao admin_dao = new Admin_dao();
					admin_dao.delete_user(id_user_a_supprimer);

					DefaultTableModel dtm = (DefaultTableModel) table_users.getModel();
					dtm.setRowCount(0);
					// generer le tableau des users

					// on ajoute dynamiquement chaque ligne avec un foreach
					(admin_dao.Admin_user_Read()).forEach(element ->

					dtm.addRow(new Object[] { element.getId(), element.getNom(), element.getPrenom(),
							element.getEmail(), element.getPassword(), element.getIsAdmin() }));

					add_remove(panel_6);
				}
			}
		});
		supprimer_user.setBounds(246, 238, 182, 23);
		panel_7.add(supprimer_user);

		JLabel lblNewLabel_12 = new JLabel("Changer nom :");
		lblNewLabel_12.setBounds(30, 156, 90, 14);
		panel_7.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("Changer pr\u00E9nom :");
		lblNewLabel_13.setBounds(246, 156, 119, 14);
		panel_7.add(lblNewLabel_13);

		JButton btnNewButton_7 = new JButton("retour");
		btnNewButton_7.setBorder(UIManager.getBorder("CheckBox.border"));
		btnNewButton_7.setRolloverEnabled(false);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_dao admin_dao = new Admin_dao();
				DefaultTableModel dtm = (DefaultTableModel) table_users.getModel();
				dtm.setRowCount(0);
				// generer le tableau des users

				// System.out.println(admin_dao.Admin_user_Read());

				// on ajoute dynamiquement chaque ligne avec un foreach
				(admin_dao.Admin_user_Read()).forEach(element ->

				dtm.addRow(new Object[] { element.getId(), element.getNom(), element.getPrenom(), element.getEmail(),
						element.getPassword(), element.getIsAdmin() }));
				add_remove(panel_6);
			}
		});
		btnNewButton_7.setBounds(436, 309, 89, 23);
		panel_7.add(btnNewButton_7);

		input_becoming_admin.setBounds(456, 177, 48, 22);
		panel_7.add(input_becoming_admin);

		JLabel becoming_admin = new JLabel("Admin ? (0/1)");
		becoming_admin.setBounds(456, 156, 90, 14);
		panel_7.add(becoming_admin);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Formulaire_blog.class.getResource("/images/administrateur (1) (1).png")));
		lblNewLabel_4.setBounds(122, 41, 100, 100);
		panel_7.add(lblNewLabel_4);

		JLabel lblNewLabel_10 = new JLabel("0 = non  1 = oui");
		lblNewLabel_10.setBounds(456, 210, 90, 14);
		panel_7.add(lblNewLabel_10);

	}

	public void add_remove(JPanel pane) {
		layeredPane.removeAll();
		layeredPane.add(pane);
		pane.repaint();
		pane.validate();
	}
	// add_remove prenant un objet user en paramètre , c'est du best practice, bien
	// reverifier cette façon de fair

	// fonction read des articles dans le tableau
	public void add_row(ArrayList<Articles> Article) {
		// on créer le tableau
		table_1 = new JTable();
		table_1.setBackground(Color.GREEN);

		table_1.setModel(
				new DefaultTableModel(new String[] { "ID", "Titre", "contenu", "Date de cr\u00E9ation", "Auteur" }, 0) {
					 @Override
					    public boolean isCellEditable(int row, int column) {
					       //all cells false
					       return false;
					    }
				});

		table_1.getColumnModel().getColumn(4).setPreferredWidth(92);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(101);
		table_1.setBounds(10, 45, 100, 200);

		// centrer les infos du tableau article

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		for (int x = 0; x < table_1.getColumnCount(); x++) {
			table_1.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);

		}

		/////////////////////
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
			table_1.setRowHeight(30);

		}

		table_1.addMouseListener((MouseListener) new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				int row = table_1.getSelectedRow();
				commentaireDao com = new commentaireDao();

				// ajouter l'id du post à la page(caché pour l'utilisateur)//
				id_post_hidden.setText(String.valueOf(model_table_1.getDataVector().get(row).get(0)));

				//// A REVOIR////
				for (int i = 0; i < com.findycom((int) model_table_1.getDataVector().get(row).get(0)).size(); i++) {
					commentaires.append(""
							+ com.findycom((int) model_table_1.getDataVector().get(row).get(0)).get(i).getNom_auteur()
							+ " dit : "
							+ com.findycom((int) model_table_1.getDataVector().get(row).get(0)).get(i).getContenu_com()
							+ "\n");
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
						// vider le champ commentaire
						text_Area_com.setText("");
						int val = Integer.valueOf(id_post_hidden.getText());
						commentaireDao comm = new commentaireDao();
						commentaires.append("" + comm.findycom(val).get(comm.findycom(val).size() - 1).getNom_auteur()
								+ " dit : " + comm.findycom(val).get(comm.findycom(val).size() - 1).getContenu_com()
								+ " " + "\n");
						// System.out.println(comm.findycom(val));
						// System.out.println(comm.findycom(val).get(comm.findycom(val).size()-1).getContenu_com());
					}
				});
				panel_5.add(btnNewButton_4);

			}
		});

	}
}
