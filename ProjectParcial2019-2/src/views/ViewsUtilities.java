package views;

import javax.swing.JOptionPane;

public class ViewsUtilities {
	
	public void showErrorFileNotFound() {
		JOptionPane.showMessageDialog(null, Constants.FILE_NOT_FOUND, "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	public void showErrorToInt() {
		JOptionPane.showMessageDialog(null, Constants.ERROR_TO_INT, "ERROR", JOptionPane.ERROR_MESSAGE);
		
	}

	public void showErrorByZero() {
		JOptionPane.showMessageDialog(null, Constants.ERROR_BY_ZERO, "ERROR", JOptionPane.ERROR_MESSAGE);
		
	}

	public void showErrorArea() {
		JOptionPane.showMessageDialog(null, Constants.ERROR_AREA, "ERROR", JOptionPane.ERROR_MESSAGE);
		
	}

	public void showErrorString() {
		JOptionPane.showMessageDialog(null, Constants.ERROR_STRING, "ERROR", JOptionPane.ERROR_MESSAGE);
		
	}

}
