package vue_blog;

import javax.swing.JPanel;
import java.awt.Color;

public class test extends JPanel {

	/**
	 * Create the panel.
	 */
	public test() {
		setBounds(10, 5, 440, 295);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 5, 440, 295);
		panel.setBackground(Color.RED);
		add(panel);

	}
/*ajouter un panel à part, penser au setbounds du debut sinon ça ne fonctionne pas !*/
}
