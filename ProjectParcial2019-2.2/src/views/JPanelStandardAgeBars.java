package views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.JPanel;

public class JPanelStandardAgeBars extends JPanel {
	private int zeros = 0;
	public HashMap<String, Color> colorMap = new HashMap<String, Color>();
	public short x1AxisY, y1AxisY, x2AxisY, y2AxisY, x1AxisX, y1AxisX, x2AxisX, y2AxisX;
	public String[][] graficMatrix;
	public HashMap<String, String> map = new HashMap<String, String>();
	HashMap<String, String> CoordinatesX;
	HashMap<String, String> CoordinatesY;
	public ArrayList<String> labelsText = new ArrayList<String>();
	public ArrayList<String> labelsNum = new ArrayList<String>();
	public ArrayList<String> wordsX = new ArrayList<String>();
	public ArrayList<String> wordsY = new ArrayList<String>();
	private static final long serialVersionUID = 1L;

	public JPanelStandardAgeBars(String[][] matrix) {
		this.graficMatrix = matrix;
		autosetStrings();
	}

	public void filterValues() {
		String[][] localMatrix = graficMatrix;

		for (int i = 0; i < localMatrix.length; i++) {
			String axeX = localMatrix[i][0];
			String axeY = localMatrix[i][1];
			if (verifyStay(wordsX, axeX)) {
				wordsX.add(axeX);
			}
			if (verifyStay(wordsY, axeX)) {
				wordsY.add(axeY);
			}
		}
	}

	public void calculateAditions() {
		for (int i = 0; i < graficMatrix.length; i++) {
			String value = graficMatrix[i][1];
			while (value.length() > 2) {

			}
		}
	}

//	private double getMaxNumberOfMatrix() {
//		double max = 0;
//		String maxS = "";
//		for (int i = 0; i < graficMatrix.length; i++) {
//			if (Double.parseDouble(graficMatrix[i][1]) >= max) {
//				max = Double.parseDouble(graficMatrix[i][1]);
//				maxS = graficMatrix[i][1];
//			}
//		}
//		zeros = maxS.length();
//		return max;
//	}

	public boolean verifyStay(ArrayList<String> stringList, String line) {
		boolean isInList = false;
		for (String string : stringList) {
			if (string.equalsIgnoreCase(line))
				isInList = true;
		}
		return isInList;
	}

	public ArrayList<String> extractFromMatrix(String[][] matrix, int idex) {
		ArrayList<String> extract = new ArrayList<String>();
		for (int i = 0; i < matrix.length; i++) {
			if (!(verifyStay(extract, matrix[i][idex]))) {
				extract.add(matrix[i][idex]);
			}
		}
		return extract;
	}

	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D graphics2d = (Graphics2D) graphics;
		setCordinatesAxis();
		drawAxis(graphics2d);
		drawDivisionsAxisY(graphics2d);
		drawDivisionsAxisX(graphics2d);
		drawStringsY(graphics2d);
		drawStringsX(graphics2d);
		drawGridLinesY(graphics2d);
		drawGridLinesX(graphics2d);
		drawFunction(graphics2d);
	}

	private ArrayList<String> ordinateTable(ArrayList<String> values) {
		ArrayList<String> filterValues = new ArrayList<String>();
		for (String string : values) {
			if( isUniqueInList(filterValues,string))
				filterValues.add(string);
		}
		
		Collections.sort(filterValues);
		return filterValues;
	}
	
	private boolean isUniqueInList(ArrayList<String> departamentsList, String departament) {
		boolean isInList = true;
		for (String string : departamentsList) {
			if (string.equals(departament)) {
				isInList = false;
			}
		}
		return isInList;
	}

	public void setCordinatesAxis() {
		x1AxisY = (short) (getWidth() * 0.1);
		y1AxisY = (short) (getHeight() * 0.1);

		x2AxisY = x1AxisY;
		y2AxisY = (short) (getHeight() - y1AxisY);

		x1AxisX = x2AxisY;
		y1AxisX = y2AxisY;

		x2AxisX = (short) ((getWidth() * 1.0) - x1AxisX);
		y2AxisX = y1AxisX;

	}

	public void drawAxis(Graphics2D graphics2d) {
		graphics2d.setStroke(new BasicStroke(2.5f));
		graphics2d.drawLine(x1AxisY, y1AxisY, x2AxisY, y2AxisY);
		graphics2d.setStroke(new BasicStroke(0.1f));
		graphics2d.drawLine(x1AxisX, y1AxisX, x2AxisX, y2AxisX);
	}

	public void drawDivisionsAxisY(Graphics2D graphics2d) {
		ArrayList<String> localmatrixY = ordinateTable(extractFromMatrix(graficMatrix, 1));
		for (int i = 0; i < localmatrixY.size(); i++) {
			double longitudRect = y2AxisY - y1AxisY;
			double increment = (i + 1) * -(longitudRect / localmatrixY.size());
			if ((i % (Math.pow(10, zeros - 2))) == 0) {
				graphics2d.drawLine((short) (x2AxisY * 0.95), (short) (y2AxisY + increment), (short) (x2AxisY * 1.05),
						(short) (y2AxisY + increment));
			}
		}

	}

	public void drawDivisionsAxisX(Graphics2D graphics2d) {
		ArrayList<String> localmatrixX = extractFromMatrix(graficMatrix, 0);
		for (int i = 0; i < localmatrixX.size(); i++) {
			double longitudRectX = x1AxisX - x2AxisX;
			double increment = (i + 1) * -(longitudRectX / localmatrixX.size());
			graphics2d.drawLine((short) (x1AxisX + increment), (short) (y1AxisX * 0.99), (short) (x1AxisX + increment),
					(short) (y1AxisX * 1.010));
		}
	}

	public void drawStringsY(Graphics2D graphics2d) {
		CoordinatesY = new HashMap<String, String>();
		ArrayList<String> localmatrixY = ordinateTable(extractFromMatrix(graficMatrix, 1));
		for (int i = 0; i < localmatrixY.size(); i++) {
			double longitudRect = y2AxisY - y1AxisY;
			double increment = (i+1) * -(longitudRect / localmatrixY.size());
//			if (i % (Math.pow(10, zeros - 2)) == 0)
			graphics2d.drawString(localmatrixY.get(i), (int) (x2AxisY * 0.5), (int) (y2AxisY + increment));
			CoordinatesY.put(localmatrixY.get(i), "" + increment);
		}
	}

	public void drawStringsX(Graphics2D graphics2d) {
		ArrayList<String> localmatrixX = extractFromMatrix(graficMatrix, 0);
		CoordinatesX = new HashMap<String, String>();
		for (int i = 0; i < localmatrixX.size(); i++) {
			double longitudRect = x1AxisY - x2AxisX;
			double increment = (i + 1) * -(longitudRect / localmatrixX.size());
			graphics2d.setColor(colorMap.get(localmatrixX.get(i)));
			graphics2d.drawString(localmatrixX.get(i), (int) ((x1AxisX + increment) * 0.990), (int) (y1AxisX * 1.04));
			CoordinatesX.put(localmatrixX.get(i), "" + increment);
		}
	}

	public void drawGridLinesY(Graphics2D graphics2d) {
//		ArrayList<String> localmatrixY = ordinateTable(extractFromMatrix(graficMatrix, 1));
		for (int i = 0; i < graficMatrix.length; i++) {
			double longitudRect = y2AxisY - y1AxisY;
			double increment = (i + 1) * -(longitudRect / graficMatrix.length);
			graphics2d.setStroke(new BasicStroke(1.5f));
			graphics2d.setColor(Color.LIGHT_GRAY);
			graphics2d.drawLine((Short) (x1AxisY), (short) (y2AxisY + increment), (Short) (x2AxisX),
					(short) (y2AxisY + increment));
		}
	}

	public void autosetStrings() {
		colorMap = new HashMap<String, Color>();
		ArrayList<String> localmatrixX = extractFromMatrix(graficMatrix, 0);
		for (String string : localmatrixX) {
			Color color = getRandomColor();
			colorMap.put(string, color);
		}
	}

	public void drawGridLinesX(Graphics2D graphics2d) {
		ArrayList<String> localmatrixX = extractFromMatrix(graficMatrix, 0);
		for (int i = 0; i < localmatrixX.size(); i++) {
			double longitudRect = x1AxisX - x2AxisX;
			double increment = (i + 1) * -(longitudRect / localmatrixX.size());
			graphics2d.setStroke(new BasicStroke(1.5f));
			graphics2d.setColor(Color.LIGHT_GRAY);
			graphics2d.drawLine((short) (x1AxisX + increment), (short) (y1AxisX), (short) (x1AxisX + increment),
					(short) (y1AxisY));
		}
	}

	public Color getRandomColor() {
		Color localColor = new Color((int) (Math.random() * 0x1000000));
		if (localColor == Color.WHITE)
			localColor = getRandomColor();
		return localColor;
	}

	public void drawFunction(Graphics2D graphics2d) {
//variables locales iniciales
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		double actualCoordinateX = x2AxisY;
//		double actualCoordinateY = y2AxisY;
//recorre la matriz que va a graficar
		for (int j = 0; j < graficMatrix.length; j++) {
			double incrementY = Double.parseDouble(CoordinatesY.get(graficMatrix[j][1]));
			double incrementX = Double.parseDouble(CoordinatesX.get(graficMatrix[j][0]));
//dibuja puntos
			graphics2d.setStroke(new BasicStroke(8.0f));
			graphics2d.setColor(Color.RED);
			graphics2d.drawLine((short) (x1AxisX + incrementX), (short) (y2AxisY + incrementY),
					(short) (x1AxisX + incrementX), (short) (y2AxisY + incrementY));
//dibuja lineas, requiere las variables locales iniciales			
//			graphics2d.setStroke(new BasicStroke(4.5f));
//			graphics2d.setColor(Color.GRAY);
//			graphics2d.drawLine((short) (actualCoordinateX), (short) (actualCoordinateY),
//					(short) (x1AxisX + incrementX), (short) (y2AxisY + incrementY));
//			actualCoordinateX = x1AxisX + incrementX;
//			actualCoordinateY = y2AxisY + incrementY;
//			actualCoordinateX = x1AxisX + incrementX;
//			actualCoordinateY = y2AxisY + incrementY;
//
			graphics2d.setColor(Color.BLACK);
			graphics2d.drawString(graficMatrix[j][1], (int) ((x1AxisX + incrementX) * 0.991),
					(int) ((y2AxisY + incrementY) * 0.991));

//dibuja las barras
//			if (Math.pow(10, zeros - 2) <= Double.parseDouble(graficMatrix[j][1])) {
			graphics2d.setStroke(new BasicStroke(25f));
			graphics2d.setColor(colorMap.get(graficMatrix[j][0]));
			graphics2d.drawLine((short) (x1AxisX + incrementX), (short) (y1AxisX - 12.5f),
					(short) (x1AxisX + incrementX), (short) (y2AxisY + incrementY + 12.5));
//			}
		}
	}

}
