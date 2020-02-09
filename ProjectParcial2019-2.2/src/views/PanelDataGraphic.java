package views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

import controller.Controller;

public class PanelDataGraphic extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double x1AxisOne, y1AxisOne, x2AxisOne, y2AxisOne, x1AxisTwo, y1AxisTwo, x2AxisTwo, y2AxisTwo;
	private int[] firstTriangleX, firstTriangleY, secondTriangleX, secondTriangleY;
	private Controller controller;
	
	public PanelDataGraphic(Controller controller) {
		this.controller = controller;
		setSize(new Dimension(1000, 500));
		setBackground(Color.WHITE);
		initializeTriangles();
		generateXandYLines(controller);
	}

	private void generateXandYLines(Controller controller) {
		x1AxisOne = (short) (getWidth()*0.1);
		y1AxisOne =  (short)(getHeight()*0.1);
		x2AxisOne =  (short)x1AxisOne;
		y2AxisOne =  (short) (getHeight()*0.9);

		x1AxisTwo = x1AxisOne;
		y1AxisTwo = y2AxisOne;
		x2AxisTwo = (short) (getWidth()*0.9);
		y2AxisTwo = y2AxisOne;
	}
	
	private void initializeTriangles() {
		firstTriangleX = new int[3];
		firstTriangleY = new int[3];
		secondTriangleX = new int[3];
		secondTriangleY = new int[3];
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		generateXandYLines(controller);
		g2.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
		g2.setStroke(new BasicStroke(2.5f));
		g2.setColor(Color.GREEN.darker().darker().darker());
		
		//Draw lines x and y
		g2.draw(new Line2D.Double(x1AxisOne, y1AxisOne, x2AxisOne, y2AxisOne));
		g2.draw(new Line2D.Double(x1AxisTwo, y1AxisTwo, x2AxisTwo, y2AxisTwo));
		
		//Draw First Triangle
		firstTriangleX[0] = (int) (x1AxisOne-5);
		firstTriangleX[1] = (int) (int) x1AxisOne;
		firstTriangleX[2] = (int) (x1AxisOne+5);
		firstTriangleY[0] = (int) y1AxisOne;
		firstTriangleY[1] = (int) y1AxisOne-10;
		firstTriangleY[2] = (int) y1AxisOne;
		g2.drawPolygon(firstTriangleX, firstTriangleY, 3);
		
		//Draw Second Triangle
		secondTriangleX[0] = (int) (x2AxisTwo);
		secondTriangleX[1] = (int) (int) x2AxisTwo+10;
		secondTriangleX[2] = (int) (x2AxisTwo);
		secondTriangleY[0] = (int) y2AxisTwo-5;
		secondTriangleY[1] = (int) y1AxisTwo;
		secondTriangleY[2] = (int) y1AxisTwo+5;
		g2.drawPolygon(secondTriangleX, secondTriangleY, 3);
	}

}
