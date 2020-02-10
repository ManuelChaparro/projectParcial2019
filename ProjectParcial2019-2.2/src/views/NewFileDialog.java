package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import controller.Controller;
import handler.HandlerLanguage;

public class NewFileDialog extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NewFileContainer container;
	private LabelObject description, notice;
	private PanelObject containerNotice;
	
	public NewFileDialog(Controller controller) {
		setPreferredSize(new Dimension(1000, 500));
		setBackground(Color.WHITE);
		initComponents(controller);
	}

	private void initComponents(Controller controller) {
		JPanel northLabel = new JPanel();
		northLabel.setPreferredSize(new Dimension(1000, 40));
		northLabel.setBackground(Constants.AQUA_COLOR);
		northLabel.setLayout(new FlowLayout());
		
		description = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.TITLE_ADD_NEW_CHAIN),
				Constants.AQUA_COLOR, Color.WHITE, Constants.DEFAULT_FONT_MAX);
		description.setFont(Constants.DEFAULT_FONT_MAX);
		description.setForeground(Color.WHITE);
		


		northLabel.add(description);
		add(northLabel, BorderLayout.NORTH);
		
		container = new NewFileContainer(controller);
		add(container, BorderLayout.CENTER);
		
		containerNotice = new PanelObject(new FlowLayout(), Constants.RED_COLOR);
		notice = new LabelObject(HandlerLanguage.languageProperties.getProperty(Constants.ERROR_STRING), Constants.RED_COLOR,
				Color.WHITE, Constants.DEFAULT_FONT);
		containerNotice.add(notice);
		containerNotice.setVisible(false);
		add(containerNotice, BorderLayout.SOUTH);
	}

	public void changeLanguage() {
		description.setText(HandlerLanguage.languageProperties.getProperty(Constants.TITLE_ADD_NEW_CHAIN));
		container.changeLanguage();
	}

	public Object[] getDataFruit() {
		return container.getDataFruit();
	}

	public void clearData() {
		container.clearData();
		
	}

	public void setVisibleNotice(boolean b) {
		containerNotice.setVisible(b);
		
	}

}
