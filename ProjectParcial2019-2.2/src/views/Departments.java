package views;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;

import controller.Commands;
import controller.Controller;

public class Departments extends JComboBox<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Departments(Controller controller) {
		createItems();
		setFont(Constants.DEFAULT_FONT_MIN);
		setBackground(Constants.AQUA_COLOR);
		addActionListener(controller);
		setActionCommand(Commands.GET_ID_DEPARTMENT.name());
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setForeground(Color.WHITE);
	}

	private void createItems() {
		addItem(Constants.AMAZONAS);
		addItem(Constants.ANTIOQUIA);
		addItem(Constants.ARAUCA);
		addItem(Constants.ATLANTICO);
		addItem(Constants.BOGOTA_DC);
		addItem(Constants.BOLIVAR);
		addItem(Constants.BOYACA);
		addItem(Constants.CALDAS);
		addItem(Constants.CAQUETA);
		addItem(Constants.CASANARE);
		addItem(Constants.CAUCA);
		addItem(Constants.CESAR);
		addItem(Constants.CHOCO);
		addItem(Constants.CORDOBA);
		addItem(Constants.CUNDINAMARCA);
		addItem(Constants.GUAINIA);
		addItem(Constants.GUAVIARE);
		addItem(Constants.HUILA);
		addItem(Constants.LA_GUAJIRA);
		addItem(Constants.MAGDALENA);
		addItem(Constants.META);
		addItem(Constants.NARINO);
		addItem(Constants.NORTE_DE_SANTANDER);
		addItem(Constants.PUTUMAYO);
		addItem(Constants.QUNIDIO);
		addItem(Constants.RISARALDA);
		addItem(Constants.SAN_ANDRES);
		addItem(Constants.SANTANDER);
		addItem(Constants.SUCRE);
		addItem(Constants.TOLIMA);
		addItem(Constants.VALLE_DEL_CAUCA);
		addItem(Constants.VAUPES);
		addItem(Constants.VICHADA);
	}
	
}
