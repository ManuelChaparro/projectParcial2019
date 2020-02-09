package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

public class PanelObject extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public PanelObject(LayoutManager layout, Color background) {
		setLayout(layout);
		setBackground(background);
	}
	
	public PanelObject(Color background, LabelObject label, TextFieldObject textField) {
		setLayout(new BorderLayout(0, 5));
		setBackground(background);
		setBorder(new EmptyBorder(10, 10, 0, 10));
		setPreferredSize(new Dimension(300, 50));
		
		add(label, BorderLayout.NORTH);
		add(textField, BorderLayout.CENTER);
	}
	
	public PanelObject(Color background, LabelObject label, Departments panel) {
		setLayout(new BorderLayout(0, 5));
		setBackground(background);
		setBorder(new EmptyBorder(10, 10, 0, 10));
		setPreferredSize(new Dimension(300, 50));
		
		add(label, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
	}
	
	public PanelObject(Color background, LabelObject label, PhysicalState panel) {
		setLayout(new BorderLayout(0, 5));
		setBackground(background);
		setBorder(new EmptyBorder(10, 10, 0, 10));
		setPreferredSize(new Dimension(300, 50));
		
		add(label, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
	}
	
	public PanelObject(Color background, PanelObject center, PanelObject west) {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(500, 20));
		setBorder(new EmptyBorder(5, 15, 5, 15));
		setBackground(background);
		
		add(west, BorderLayout.EAST);
		add(center, BorderLayout.CENTER);

	}
	
	public PanelObject(Color background, ButtonObject west, ButtonObject east) {
		setLayout(new BorderLayout());
//		setPreferredSize(new Dimension((int) (Constants.WIDTH*0.4), (int) (Constants.HEIGTH*0.06)));
		setBackground(background);
//		setBorder(new EmptyBorder(0, (int) (Constants.WIDTH*0.04), 0, (int) (Constants.WIDTH*0.04)));
		
		add(west, BorderLayout.WEST);
		add(east, BorderLayout.EAST);

	}

	public PanelObject(Color background, LabelObject north, JSpinner center) {
		setLayout(new BorderLayout(0, 5));
		setBorder(new EmptyBorder(5, 15, 5, 15));
		setBackground(background);
		
		add(north, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
	}
	
	

}
