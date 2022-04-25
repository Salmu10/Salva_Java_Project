package Hotel_v3.Utils;

import javax.swing.JOptionPane;

public class Menus {
	
	// Menú botones
	
	public static int menu_buttons (String[] opciones) {
		
		int option = 0;
		
		option = JOptionPane.showOptionDialog(null, "Select an option", "Menu", 0, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);	
		//System.out.println("User choose: " + option);
		
		if (option == -1) {
			JOptionPane.showMessageDialog(null, "Closing the application", "Closing", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0); // Al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecución
		}
		
		return option;
	}
	
	// Menú botones edit
	
	public static int menu_buttons_edit (String[] opciones, String message, String title) {
		
		int option = 0;
		
		option = JOptionPane.showOptionDialog(null, message, title, 0, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);	
		//System.out.println("User choose: " + option);
		
		if (option == -1) {
			JOptionPane.showMessageDialog(null, "Closing the application", "Closing", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0); // Al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecución
		}
		
		return option;
	}
	
	// Menú combobox
	
	public static String menu_combobox (String[] opciones) {
		
		Object option = null;
		
		option = JOptionPane.showInputDialog(null, "Select an option", "Menu", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		System.out.println("User choose: " + option);
		
		if (option == null) {
			JOptionPane.showMessageDialog(null, "Closing the application", "Closing", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0); // Al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecución
		}
		
		return option.toString();
	}
	
	// Menú combobox edit
	
	public static String menu_combobox_edit (String[] opciones, String message, String title) {
		
		Object option = null;
		
		option = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		System.out.println("User choose: " + option);
		
		if (option == null) {
			JOptionPane.showMessageDialog(null, "Closing the application", "Closing", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0); // Al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecución
		}
		
		return option.toString();
	}
	
	
	public static boolean YES_NO (String boolean1, String boolean2, String message, String title) {
		
		boolean valor = false;
		int option = 0;
		String [] opciones = {boolean1, boolean2};
		
		option = Menus.menu_buttons_edit(opciones, message, title);
		
		if (option == 0) {
			valor = true;
		}else {
			valor = false;
		}
		
		return valor;
	}
	
}
