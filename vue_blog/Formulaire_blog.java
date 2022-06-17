package vue_blog;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller_blog.ArticleDao;
import controller_blog.UserDao;
import controller_blog.commentaireDao;
import modele_blog.Articles;
import modele_blog.User;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;

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
		
				panel_1.setLayout(null);
				panel_1.setBackground(new Color(176, 196, 222));
				panel_1.setBounds(0, 0, 556, 370);
				layeredPane.add(panel_1);
				
						JLabel Title_connexion = new JLabel("--Connexion--");
						Title_connexion.setForeground(new Color(0, 0, 0));
						Title_connexion.setFont(new Font("Source Sans Pro Black", Font.BOLD, 23));
						Title_connexion.setBounds(188, 11, 175, 30);
						panel_1.add(Title_connexion);
						
								JLabel lblEmail_1 = new JLabel("email ");
								lblEmail_1.setBounds(291, 177, 35, 14);
								panel_1.add(lblEmail_1);
								
										JLabel lblPassword_1 = new JLabel("mot de passe");
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
																			JOptionPane.showMessageDialog(contentPane, "vous êtes connecté !");
																			add_remove(panel_3);
																			JLabel lblNewLabel_1 = new JLabel("Bonjour " + userDao.findby(email, password).get(0).getPrenom());
																			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
																			lblNewLabel_1.setBounds(25, 34, 124, 14);
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
																			retour.addActionListener(new ActionListener() {
																				public void actionPerformed(ActionEvent e) {
																					panel_3.removeAll();
																					String email = email_connexion.getText();
																					String password = String.valueOf(pass_connexion.getPassword());
																					add_remove(panel_3);
																					System.out.println(userDao.findby(email, password).get(0).getPrenom());
																					JLabel lblNewLabel_1 = new JLabel(
																							"Bonjour " + userDao.findby(email, password).get(0).getPrenom());
																					lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
																					lblNewLabel_1.setBounds(25, 34, 124, 14);
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
																			
																			retour.setBounds(382, 299, 89, 23);
																			panel_4.add(retour);
																		} else {
																			JOptionPane.showMessageDialog(contentPane, "compte inexistant ou mauvais mot de passe");
																		}
																	}
																});
																connexion.setBounds(226, 307, 110, 23);
																panel_1.add(connexion);
																
																		JLabel lblNewLabel_5_1 = new JLabel("Blog");
																		lblNewLabel_5_1.setBackground(new Color(240, 248, 255));
																		lblNewLabel_5_1.setForeground(new Color(0, 0, 0));
																		lblNewLabel_5_1.setFont(new Font("Source Sans Pro Black", Font.BOLD, 30));
																		lblNewLabel_5_1.setBounds(27, 47, 99, 55);
																		panel_1.add(lblNewLabel_5_1);
																		
																				JButton btnNewButton_1 = new JButton("inscription");
																				btnNewButton_1.addActionListener(new ActionListener() {
																					public void actionPerformed(ActionEvent e) {
																						add_remove(panel);
																					}
																				});
																				btnNewButton_1.setBounds(346, 307, 118, 23);
																				panel_1.add(btnNewButton_1);
																				
																						JLabel lblNewLabel_4 = new JLabel("New label");
																						lblNewLabel_4.setIcon(new ImageIcon(Formulaire_blog.class.getResource("/images/img3.gif")));
																						lblNewLabel_4.setBounds(27, 146, 134, 121);
																						panel_1.add(lblNewLabel_4);

		panel.setBounds(0, 0, 556, 370);
		panel.setBackground(new Color(176, 196, 222));
		panel.setLayout(null);
		layeredPane.add(panel);

		JLabel lblNewLabel = new JLabel("--Inscription--");
		lblNewLabel.setBounds(188, 11, 175, 30);
		lblNewLabel.setFont(new Font("Source Sans Pro Black", Font.BOLD, 23));
		panel.add(lblNewLabel);

		JLabel lblNom = new JLabel("nom ");
		lblNom.setBounds(296, 69, 40, 25);
		panel.add(lblNom);

		JLabel lblPrnom = new JLabel("pr\u00E9nom ");
		lblPrnom.setBounds(279, 128, 57, 14);
		panel.add(lblPrnom);

		JLabel lblEmail = new JLabel("email ");
		lblEmail.setBounds(290, 177, 40, 14);
		panel.add(lblEmail);

		JLabel lblPassword = new JLabel("password ");
		lblPassword.setBounds(273, 228, 63, 14);
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

		JLabel lblNewLabel_5 = new JLabel("Blog");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setBounds(27, 47, 99, 55);
		lblNewLabel_5.setFont(new Font("Source Sans Pro Black", Font.BOLD, 30));
		panel.add(lblNewLabel_5);
		panel.revalidate();

		JButton envoyer = new JButton("s'inscrire");
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

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Formulaire_blog.class.getResource("/images/img2.gif")));
		lblNewLabel_3.setBounds(27, 146, 134, 121);
		panel.add(lblNewLabel_3);
		
		

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
		layeredPane.setLayer(panel_3, 0);
		panel_3.setAutoscrolls(true);
		panel_3.setBackground(new Color(176, 196, 222));

		panel_3.setBounds(0, 0, 556, 370);
		layeredPane.add(panel_3);

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
		// table.setFillsViewportHeight(true);

		// panel_3.add(table_1);

		panel_3.add(deconnecter);
		panel_4.setBackground(SystemColor.activeCaption);

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
		panel_5.setBackground(SystemColor.activeCaption);
		
		
		panel_5.setBounds(0, 0, 556, 370);
		layeredPane.add(panel_5);
		panel_5.setLayout(null);
		affiche_post.setBackground(Color.LIGHT_GRAY);
		
	
		affiche_post.setBounds(10, 146, 243, 188);
		panel_5.add(affiche_post);
		affiche_titre_post.setBackground(Color.LIGHT_GRAY);
		
		
		affiche_titre_post.setLineWrap(true);
		affiche_titre_post.setBounds(10, 79, 243, 28);
		panel_5.add(affiche_titre_post);
		
		JLabel lblNewLabel_6 = new JLabel("Le fameux show !");
		lblNewLabel_6.setFont(new Font("Source Code Pro Black", Font.BOLD, 23));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(155, 11, 235, 33);
		panel_5.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("commentaires :");
		lblNewLabel_7.setForeground(SystemColor.window);
		lblNewLabel_7.setBounds(303, 60, 134, 14);
		panel_5.add(lblNewLabel_7);
		date_post.setForeground(SystemColor.window);
		
		
		date_post.setBounds(10, 345, 243, 14);
		panel_5.add(date_post);
		
		JLabel lblNewLabel_8 = new JLabel("Titre :");
		lblNewLabel_8.setForeground(SystemColor.textHighlightText);
		lblNewLabel_8.setBounds(10, 60, 84, 14);
		panel_5.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Contenu :");
		lblNewLabel_9.setForeground(SystemColor.textHighlightText);
		lblNewLabel_9.setBounds(10, 121, 108, 14);
		panel_5.add(lblNewLabel_9);
		
		
		commentaires.setBackground(Color.LIGHT_GRAY);
		commentaires.setBounds(303, 79, 227, 94);
		panel_5.add(commentaires);
		
		JButton btnNewButton_3 = new JButton("retour");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commentaires.setText(null);
				add_remove(panel_3);
			}
		});
		btnNewButton_3.setBounds(441, 312, 89, 23);
		panel_5.add(btnNewButton_3);

		/*
		 * JLabel lblNewLabel_2 = new JLabel("adresse de connexion : ");
		 * lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		 * lblNewLabel_2.setBounds(10, 345, 395, 14); panel_3.add(lblNewLabel_2);
		
		 */
		
		
		//SHOW l'article
		
		
		
		
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
		table_1.setBackground(Color.ORANGE);

		table_1.setModel(
				new DefaultTableModel(new String[] { "ID", "Titre", "contenu", "Date de cr\u00E9ation", "Auteur" }, 0));

		table_1.getColumnModel().getColumn(4).setPreferredWidth(92);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(101);
		table_1.setBounds(10, 45, 100, 200);

		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(10, 64, 526, 243);
		panel_3.add(scrollPane);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(27, 224, 89, 23);
		panel.add(btnNewButton_2);
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
			 
			commentaireDao com=new commentaireDao();
			
			//System.out.println(com.findycom((int) model_table_1.getDataVector().get(row).get(0)).get(0).getContenu_com());
			//System.out.println(com.findycom((int) model_table_1.getDataVector().get(row).get(0)));
			//System.out.println( model_table_1.getDataVector().get(row).get(0));
			
			
			
			//// A REVOIR////
				for (int i = 0; i < com.findycom((int) model_table_1.getDataVector().get(row).get(0)).size(); i++) {
					commentaires.append(com.findycom((int) model_table_1.getDataVector().get(row).get(0)).get(i).getContenu_com()+"\n");
				}
				affiche_titre_post.setText((String) model_table_1.getDataVector().get(row).get(1));
				affiche_post.setText((String) (model_table_1.getDataVector().get(row).get(2)));
				date_post.setText((String) ( "Post écrit le : "+ model_table_1.getDataVector().get(row).get(3)));
				add_remove(panel_5);
			
			}
			});
		
	}
}
