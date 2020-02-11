package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelBanner extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelBanner(int width, int height) {
		setPreferredSize(new Dimension((int) (width*0.8), (int) (height*0.34)));
		setLayout(new BorderLayout());
		setBackground(Color.YELLOW);
		setVisible(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Image bannerImage = new ImageIcon(getClass().getResource(Constants.PATH_IMAGE_BANNER)).getImage();
		g2.drawImage(bannerImage, 0, 0, this);
	}

}
