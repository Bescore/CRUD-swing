package vue_blog;

import javax.swing.JPanel;

import modele_blog.User;

import java.awt.Color;

public class test extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8332859496406149880L;

	/**
	 * Create the panel.
	 */
	public test(User user) {
		
		setBounds(10, 5, 440, 295);
		setLayout(null);
		user.getNom();
		JPanel panel = new JPanel();
		panel.setBounds(10, 5, 440, 295);
		panel.setBackground(Color.RED);
		add(panel);

	}
/*ajouter un panel à part, penser au setbounds du debut sinon ça ne fonctionne pas !*/
}
