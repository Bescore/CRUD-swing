package vue_blog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller_blog.UserDao;
import modele_blog.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

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
	
	private JTextField email_connexion;
	private JPasswordField pass_connexion;
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
												String email= email_connexion.getText();
												String password=String.valueOf(pass_connexion.getPassword());
												
												UserDao userDao=new	UserDao();
												System.out.println(userDao.findby(email,password));
												if (userDao.findby(email,password).size()!= 0) {
													JOptionPane.showMessageDialog(contentPane,"vous êtes connecté !");
													add_remove(panel_3);
													JLabel lblNewLabel_1 = new JLabel("Bonjour "+userDao.findby(email,password).get(0).getPrenom());
													lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
													lblNewLabel_1.setBounds(25, 34, 124, 14);
													panel_3.add(lblNewLabel_1);
													
													JLabel lblNewLabel_2 = new JLabel("adresse de connexion : "+userDao.findby(email,password).get(0).getEmail()+"");
													lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 9));
													lblNewLabel_2.setBounds(10, 345, 395, 14);
													panel_3.add(lblNewLabel_2);
													
												}else {
													JOptionPane.showMessageDialog(contentPane,"compte inexistant ou mauvais mot de passe");
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
										layeredPane.setLayer(panel_3, 0);
										panel_3.setBackground(new Color(176, 196, 222));
										
										
										panel_3.setBounds(0, 0, 556, 370);
										layeredPane.add(panel_3);
										panel_3.setLayout(null);
										
										JButton deconnecter = new JButton("Se d\u00E9connecter");
										deconnecter.setFocusable(false);
										deconnecter.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												add_remove(panel_1);
											}
										});
										deconnecter.setBounds(421, 336, 125, 23);
										panel_3.add(deconnecter);
							
						envoyer.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String nom=inp_nom.getText();
								String prenom=inp_prenom.getText();
								String email=inp_email.getText();
								String password=String.valueOf(inp_password.getPassword());
							UserDao userDao=new	UserDao();
							User user=new User(nom,prenom,email,password);
							
							if (userDao.create(user)) {
								JOptionPane.showMessageDialog(contentPane,"bravo compte crée");
								add_remove(panel_1);
							}else {
								JOptionPane.showMessageDialog(contentPane,"changez de mail ou remplissez bien les champs !");
							};
							}
							
						});
						

						/*JLabel lblNewLabel_2 = new JLabel("adresse de connexion : ");
						lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
						lblNewLabel_2.setBounds(10, 345, 395, 14);
						panel_3.add(lblNewLabel_2);*/
	}
	public void add_remove( JPanel pane) {
		layeredPane.removeAll();
		//pane.setVisible(false);
		//JLabel lblNewLabel_8 = new JLabel("ayayaya");
		//pane.add(lblNewLabel_8);
		layeredPane.add(pane);
		pane.repaint();
		pane.revalidate();
	}
}
