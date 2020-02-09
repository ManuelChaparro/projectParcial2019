package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelHome extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel containerImage;
	private Image home;

	public PanelHome(String pathImageHome) {
		setPreferredSize(new Dimension(1000, 1000));
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initComponents(pathImageHome);		
	}

	private void initComponents(String pathImageHome) {
		home = new ImageIcon(getClass().getResource(pathImageHome)).getImage();
		Icon rescaledHome = new ImageIcon(home.getScaledInstance((int) (Constants.WIDTH*0.8),
				(int) (Constants.HEIGTH*0.8), Image.SCALE_SMOOTH));
		containerImage = new JLabel(rescaledHome);
		add(containerImage);
	}


}
