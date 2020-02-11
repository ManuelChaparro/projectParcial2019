package views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

public class JPanelCake extends JPanel {
	public short x1AxisY, y1AxisY, x2AxisY, y2AxisY, x1AxisX, y1AxisX, x2AxisX, y2AxisX;

	public HashMap<String, Color> colorMap = new HashMap<String, Color>();
	public HashMap<String, String> map = new HashMap<String, String>();
	HashMap<String, Double> percentagesMap = new HashMap<String, Double>();
	public ArrayList<String> labelsText = new ArrayList<String>();
	public ArrayList<String> labelsNum = new ArrayList<String>();
	public ArrayList<String> wordsX = new ArrayList<String>();
	public ArrayList<String> wordsY = new ArrayList<String>();
	private static final long serialVersionUID = 1L;
	private String[][] graficMatrix;

	public JPanelCake(String[][] matrix) {
		this.setBackground(Color.WHITE);
		graficMatrix = matrix;
		autosetStrings();
	}

	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		setCordinatesAxis();
		calculatePercentages();
		drawStringsY(graphics2d);
		drawFunction(graphics2d);
	}

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

	// retorna un color aleatorio distinto de blanco
	public Color getRandomColor() {
		Color localColor = new Color((int) (Math.random() * 0x1000000));
		if (localColor == Color.WHITE)
			localColor = getRandomColor();
		return localColor;
	}

	// calcula los porcentajes de cada valor, estos los asigna a un hashMap
	private void calculatePercentages() {
		double total = 0;
		for (int i = 0; i < graficMatrix.length; i++) {
			total += Double.parseDouble(graficMatrix[i][1]);
		}
		for (int i = 0; i < graficMatrix.length; i++) {
			double actualNum = Double.parseDouble(graficMatrix[i][1]);
			double percentage = (actualNum / total) * 100;
			percentagesMap.put(graficMatrix[i][1], percentage);
		}
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

	// asigna un color para cada dato
	public void autosetStrings() {
		colorMap = new HashMap<String, Color>();
		ArrayList<String> localmatrixX = extractFromMatrix(graficMatrix, 0);
		for (String string : localmatrixX) {
			Color color = getRandomColor();
			colorMap.put(string, color);
		}
	}

	// pinta las llaves, el porcentaje de ocupacion y el color que les corresponde
	public void drawStringsY(Graphics2D graphics2d) {
		ArrayList<String> localmatrixX = extractFromMatrix(graficMatrix, 0);
		for (int i = 0; i < localmatrixX.size(); i++) {
			double longitudRect = y2AxisY - y1AxisY;
			double increment = (i + 1) * -(longitudRect / localmatrixX.size());
			Color color = colorMap.get(localmatrixX.get(i));
			graphics2d.setStroke(new BasicStroke(8f));
			graphics2d.setColor(color);
			graphics2d.drawLine((int) ((x2AxisY * 0.5) - 8f), (int) (y2AxisY + increment),
					(int) ((x2AxisY * 0.5) - 16f), (int) (y2AxisY + increment));
			double percentage = (percentagesMap.get(graficMatrix[i][1]));
			graphics2d.drawString(localmatrixX.get(i) + " : " + percentage + "%", (int) (x2AxisY * 0.5),
					(int) (y2AxisY + increment));
		}
	}

	// dibuja una linea en base a un angulo,radio y color
	private void drawLineByCenterAndAngle(double angle, int radius, Color color, Graphics2D graphics2d) {
		int x = (getWidth() / 2);
		int y = (getHeight() / 2);
		double x2 = x + (radius * Math.cos(Math.toRadians(angle))) + 1f;
		double y2 = y + (radius * -Math.sin(Math.toRadians(angle))) + 1f;
		graphics2d.setStroke(new BasicStroke(2f));
		graphics2d.setColor(color);
		graphics2d.drawLine(x, y, (int) x2, (int) y2);
	}

	// pinta un circulo siempre en el medio de la pantalla
	private void grapicCircleAtCenter(int radius, Graphics2D graphics2d) {
		graphics2d.setStroke(new BasicStroke(3f));
		graphics2d.setColor(Color.BLACK);
		graphics2d.drawOval((getWidth() / 2) - (radius / 2), (getHeight() / 2) - (radius / 2), radius, radius);
	}

	// dimensiona el radio del circulo para que siempre ocupe un 80% del frame
	// respecto a el alto o el ancho
	private double getAppropiateRadius(Graphics2D graphics2d) {
		double appropiateRadius = getWidth() * 0.8;
		if (appropiateRadius >= getHeight() * 0.8)
			appropiateRadius = getHeight() * 0.8;
		return appropiateRadius;
	}

	// pinta los porcentajes de ocupacion de cada componente de la matriz
	public void drawFunction(Graphics2D graphics2d) {
		// se inicializa una variable j que guarde el recorrido del grafico,
		// teniendo en cuenta que esta compuesto por multiples lineas de colores al
		// respresentad cada parte de la matriz
		double j = 0;
		// iniciamos un ciclo que recorre la matriz
		for (int i = 0; i < graficMatrix.length; i++) {
			// tomamos cada valor de la matriz
			String string = graficMatrix[i][1];
			// calculamos el maximo angulo al que recorrera cada valor
			// siempre se suma j para mantener el recorrido
			double localPercentage = j + (360 * (percentagesMap.get(string)) / 100);
			// tomamos el color previamente signado para pintar las lineas
			Color localColor = colorMap.get(graficMatrix[i][0]);
			// este ciclo pintara las lineas que dibujan cada porcentaje de ocupacion
			for (double k = j; k <= localPercentage; k += 0.01) {
				drawLineByCenterAndAngle(k, (int) getAppropiateRadius(graphics2d) / 2, localColor, graphics2d);
			}
			// pinta las lineas divisoras
			localColor = Color.BLACK;
			drawLineByCenterAndAngle(j, (int) getAppropiateRadius(graphics2d) / 2, localColor, graphics2d);
			// guarda el recorrido de j
			j = localPercentage;
		}
		drawLineByCenterAndAngle(0, (int) getAppropiateRadius(graphics2d) / 2, Color.BLACK, graphics2d);
		// dibuja el circulo
		grapicCircleAtCenter((int) getAppropiateRadius(graphics2d), graphics2d);
	}

}
