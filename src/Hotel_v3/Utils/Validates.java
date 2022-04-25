package Hotel_v3.Utils;

import javax.swing.JOptionPane;

public class Validates {
	
	//// Valida Int ///

	public static int validaint() {

		int num = 0;
		String cad;
		boolean condition = true;

		do {
			try {
				cad = JOptionPane.showInputDialog(null, "Insert an integer number", "Interger Number", JOptionPane.QUESTION_MESSAGE);
				if (cad == null) {
					JOptionPane.showMessageDialog(null, "Closing the application", "Closing", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0); // Al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecución
				} else {
					num = Integer.parseInt(cad);
					condition = true;
					System.out.println("The number is: " + num);
				}
			} catch (Exception e) { // Detecta cuando salta el error.
				JOptionPane.showMessageDialog(null, "This isn't an integer number", "Error", JOptionPane.ERROR_MESSAGE);
				condition = false;
				System.out.println("Error");
			}
		} while (condition == false);

		return num;
	}

	//// Valida Int modificado ///

	public static int validaint_edit(String mensaje, String titulo) {

		int num = 0;
		String cad;
		boolean condition = true;

		do {
			try {
				cad = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
				if (cad == null) {
					JOptionPane.showMessageDialog(null, "Closing the application", "Closing", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0); // Al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecución
				} else {
					num = Integer.parseInt(cad);
					condition = true;
					System.out.println("The number is: " + num);
				}
			} catch (Exception e) { // Detecta cuando salta el error.
				JOptionPane.showMessageDialog(null, "This isn't an integer number", "Error", JOptionPane.ERROR_MESSAGE);
				condition = false;
				System.out.println("Error");
			}
		} while (condition == false);

		return num;
	}

	/// Valida Char///

	public static char validachar() {

		char letra = 0;
		String cad;
		boolean condition = true;

		do {
			try {
				cad = JOptionPane.showInputDialog(null, "Enter a letter", "Letter", JOptionPane.QUESTION_MESSAGE);
				if (cad == null) {
					JOptionPane.showMessageDialog(null, "Closing the application", "Closing", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0); // Al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecución
				} else {
					letra = cad.charAt(0);
					condition = true;
					System.out.println("The letter is: " + letra);
				}
			} catch (Exception e) { // Detecta cuando salta el error.
				JOptionPane.showMessageDialog(null, "This isn't a letter", "Error", JOptionPane.ERROR_MESSAGE);
				condition = false;
				System.out.println("Error");
			}
		} while (condition == false);

		return letra;
	}

	/// Valida Float ///

	public static float validafloat() {

		float num = 0.0f;
		String cad;
		boolean condition = true;

		do {
			try {
				cad = JOptionPane.showInputDialog(null, "Insert a float number", "Float Number", JOptionPane.QUESTION_MESSAGE);
				if (cad == null) {
					JOptionPane.showMessageDialog(null, "Closing the application", "Closing", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0); // Al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecución
				} else {
					num = Float.parseFloat(cad);
					condition = true;
					System.out.println("The number is: " + num);
				}
			} catch (Exception e) { // Detecta cuando salta el error.
				JOptionPane.showMessageDialog(null, "This isn't a float number", "Error", JOptionPane.ERROR_MESSAGE);
				condition = false;
				System.out.println("Error");
			}
		} while (condition == false);

		return num;
	}
	
	/// Valida Float Edit ///

	public static float validafloat_edit(String mensaje, String titulo) {

		float num = 0.0f;
		String cad;
		boolean condition = true;

		do {
			try {
				cad = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
				if (cad == null) {
					JOptionPane.showMessageDialog(null, "Closing the application", "Closing", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0); // Al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecución
				} else {
					num = Float.parseFloat(cad);
					condition = true;
					System.out.println("The number is: " + num);
				}
			} catch (Exception e) { // Detecta cuando salta el error.
				JOptionPane.showMessageDialog(null, "This isn't a float number", "Error", JOptionPane.ERROR_MESSAGE);
				condition = false;
				System.out.println("Error");
			}
		} while (condition == false);

		return num;
	}

	/// Valida String ///

	public static String validastring() {

		String cad = "";
		boolean condition = true;

		do {
			try {
				cad = JOptionPane.showInputDialog(null, "Enter a string", "String", JOptionPane.QUESTION_MESSAGE);
				condition = true;
				if (cad == null) {
					JOptionPane.showMessageDialog(null, "Closing the application", "Closing", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0); // al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecución
				}
				if (cad.equals("")) {
					JOptionPane.showMessageDialog(null, "Error de introducción de datos", "Error", JOptionPane.ERROR_MESSAGE);
					condition = false;
				}
			} catch (Exception e) { // Detecta cuando salta el error.
				JOptionPane.showMessageDialog(null, "No has introducido una cadena", "Error", JOptionPane.ERROR_MESSAGE);
				condition = false;
			}
		} while (condition == false);

		return cad;
	}
	
	/// Valida String Edit ///

	public static String validastring_edit(String mensaje, String titulo) {

		String cad = "";
		boolean condition = true;

		do {
			try {
				cad = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
				condition = true;
				if (cad == null) {
					JOptionPane.showMessageDialog(null, "Closing the application", "Closing", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0); // al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecución
				}
				if (cad.equals("")) {
					JOptionPane.showMessageDialog(null, "Error de introducción de datos", "Error", JOptionPane.ERROR_MESSAGE);
					condition = false;
				}
			} catch (Exception e) { // Detecta cuando salta el error.
				JOptionPane.showMessageDialog(null, "No has introducido una cadena", "Error", JOptionPane.ERROR_MESSAGE);
				condition = false;
			}
		} while (condition == false);

		return cad;
	}

	/// Valida Y/N ///
	
	public static char valida_y_n() {

		char seguir = 'Y';
		String cad;
		boolean condition = true;

		do {
			do {
				try {
					cad = JOptionPane.showInputDialog(null, "Do you want to continue reading? (Y/N)", "Continue?", JOptionPane.QUESTION_MESSAGE);
					if (cad == null) {
						JOptionPane.showMessageDialog(null, "Closing the application", "Closing", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0); // Al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecución
					} else {
						seguir = cad.charAt(0);
						seguir = Character.toUpperCase(seguir);
						condition = true;
					}
				} catch (Exception e) { // Detecta cuando salta el error.
					JOptionPane.showMessageDialog(null, "Data entry error", "Error", JOptionPane.ERROR_MESSAGE);
					condition = false;
					System.out.println("Error");
				}
			} while (condition == false);
			if ((seguir != 'Y') && (seguir != 'N')) {
				JOptionPane.showMessageDialog(null, "You didn't enter Y or N", "Error", JOptionPane.ERROR_MESSAGE);
			}
			if (seguir == 'N') {
				JOptionPane.showMessageDialog(null, "Reading the atributs...", "Reading", JOptionPane.INFORMATION_MESSAGE);
			}
		} while ((seguir != 'Y') && (seguir != 'N'));

		return seguir;
	}

	/// Valida int distinto de 0 ///
	
	public static int validaint_nozero(){
		
		int num = 0;
		boolean interruptor  = false;
		
		do {
			num = validaint_edit("Enter a nonzero number for the divisor", "Int no 0");
			if (num != 0) {
				interruptor = true;
			} else {
				JOptionPane.showMessageDialog(null, "Error, Can't divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} while (interruptor == false);
		
		return num;
	}
	

}
