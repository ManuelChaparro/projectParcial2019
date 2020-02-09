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

	public void showErrorUrlFileNotFound() {
		JOptionPane.showMessageDialog(null, Constants.ERROR_STRING, "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	
	public void showMessage(String message) {
		System.out.println(message);
	}

	public String setToForNumbersSisben(Object object, Object object2) {
		if ((int)object==0 && (int) object2 == 0) {
			System.out.println(2);
			return Constants.WITHOUT_SCORE;
		}else {
			int sisbenTwo =  ((int) object2)-1;
			return String.valueOf(object) + ",00 A " + String.valueOf(sisbenTwo)+",99";
		}

	}

	public String setToForNumbersAge(Object object, Object object2) {	
		return String.valueOf(object) + " A " + String.valueOf(object2);
	}


}
