package Hotel_v3.Modules.Room.Utils;

import javax.swing.JOptionPane;

import Hotel_v3.Utils.Menus;
import Hotel_v3.Utils.Validates;

public class Data_CRUD {
	
	/// Ask Boolean
	
	public static boolean ask_yes_no(String boolean1, String boolean2, String message, String title) {
		
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

	/// Ask nombre 
	
	public static String ask_name(String message, String titol) {
		
		boolean resultado = false;
		String nombre = "";
		
		do {
			nombre = Validates.validastring_edit(message, titol);
			resultado = Reg_ex.valida_nombre(nombre);
			if (resultado == false) {
				JOptionPane.showMessageDialog(null, "You entered a invalde name\nYou must enter only letters", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				resultado = true;
			}
		} while (resultado == false);
		
		return nombre;
	}
	
	/// Ask fecha 
	
	public static String ask_date(String message, String titol) {
		
		boolean resultado = false;
		String fecha = "";
		
		do {
			fecha = Validates.validastring_edit(message, titol);
			resultado = Reg_ex.valida_fecha(fecha);
			if (resultado == false) {
				JOptionPane.showMessageDialog(null, "You entered a invalde date\nYou must the date in format: dd/mm/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				resultado = true;
			}
		} while (resultado == false);
		
		return fecha;
	}

	/// Ask número en tanto por cien

	public static String ask_descuento() {
		
		boolean resultado = false;
		String Descuentos = "";
		
		do {
			Descuentos = Validates.validastring_edit("Can you enter the discount?", "Discount");
			resultado = Reg_ex.valida_porcentaje(Descuentos);
			if (resultado == false) {
				JOptionPane.showMessageDialog(null, "You entered a invalid discount\nYou must enter a number as a percentage", "Error",JOptionPane.ERROR_MESSAGE);
			} else {
				resultado = true;
			}
		} while (resultado == false);
		
		return Descuentos;
	}
	
	/// Ask una ID 
	
	public static String ask_ID() {
		
		boolean resultado = false;
		String id = "";
		
		do {
			id = Validates.validastring_edit("Can you enter the room ID?", "Room ID");
			resultado = Reg_ex.valida_id(id);
			if (resultado == false) {
				JOptionPane.showMessageDialog(null, "You entered a invalid ID\nYou must enter 3 digits + 1 Capital letter (between A and D)", "Error",JOptionPane.ERROR_MESSAGE);
			} else {
				resultado = true;
			}
		} while (resultado == false);
		
		return id;
	}
	
	/// Ask un número de 3 cifras 
	
	public static String ask_m2() {
		
		boolean resultado = false;
		String m2 = "";
		
		do {
			m2 = Validates.validastring_edit("Can you enter the m2 of the room?", "Room M2");
			resultado = Reg_ex.valida_m2(m2);
			if (resultado == false) {
				JOptionPane.showMessageDialog(null, "You entered a invalid number\nYou must enter max 3 digits", "Error",JOptionPane.ERROR_MESSAGE);
			} else {
				resultado = true;
			}
		} while (resultado == false);
		
		return m2;
	}
	
	/// Ask un número de 3 cifras 
	
	public static String ask_capacity() {
		
		boolean resultado = false;
		String capacity = "";
		
		do {
			capacity = Validates.validastring_edit("Can you enter the capacity of the room?", "Room capacity");
			resultado = Reg_ex.valida_capacity(capacity);
			if (resultado == false) {
				JOptionPane.showMessageDialog(null, "You entered a invalid number\nYou must enter a number between 0 and 6", "Error",JOptionPane.ERROR_MESSAGE);
			} else {
				resultado = true;
			}
		} while (resultado == false);
		
		return capacity;
	}
	
	/// Ask un número de 1 a 5 cifras con de 1 a 3 decimales
	
	public static String ask_price() {
		
		boolean resultado = false;
		String price = "";
		
		do {
			price = Validates.validastring_edit("Can you enter the price of the room?", "Room capacity");
			resultado = Reg_ex.valida_price(price);
			if (resultado == false) {
				JOptionPane.showMessageDialog(null, "You entered a invalid number\nYou must enter a number with 1 to 5 digits with 1 to 3 decimals", "Error",JOptionPane.ERROR_MESSAGE);
			} else {
				resultado = true;
			}
		} while (resultado == false);
		
		return price;
	}

}
