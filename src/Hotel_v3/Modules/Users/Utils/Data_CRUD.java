package Hotel_v3.Modules.Users.Utils;

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
	
	/// Ask una ID 
	
	public static String ask_username() {
		
		boolean resultado = false;
		String username = "";
		
		do {
			username = Validates.validastring_edit("Can you enter the user name?", "User name");
			resultado = Reg_ex.valida_user_name(username);
			if (resultado == false) {
				JOptionPane.showMessageDialog(null, "You entered a invalid username\nYou must enter only letters and numbers", "Error",JOptionPane.ERROR_MESSAGE);
			} else {
				resultado = true;
			}
		} while (resultado == false);
		
		return username;
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

	/// Ask dirección
	
	public static String ask_address() {
		
		boolean resultado = false;
		String direccion = "";
		
		do {
			direccion = Validates.validastring_edit("Can you enter your address?", "The address");
			resultado = Reg_ex.valida_direccion(direccion);
			if (resultado == false) {
				JOptionPane.showMessageDialog(null, "You entered a invalid address\nYou must entered street name + number\nIf your house don't have number, please write 0", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				resultado = true;
			}
		} while (resultado == false);
		
		return direccion;
	}
	
	/// Ask DNI

	public static String ask_dni() {
		
		boolean resultado = false;
		String dni = "";
		
		do {
			dni = Validates.validastring_edit("Can you enter your dni?", "DNI");
			resultado = Reg_ex.valida_DNI(dni);
			if (resultado == false) {
				JOptionPane.showMessageDialog(null, "You entered a invalid dni\nYou must enter 8 numbers + capital letter", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				resultado = true;
			}
		} while (resultado == false);
		
		return dni;
	}
	
	/// Ask correo electrónico

	public static String ask_email() {
		
		boolean resultado = false;
		String email = "";
		
		do {
			email = Validates.validastring_edit("Can you enter your email?", "The email");
			resultado = Reg_ex.valida_email(email);
			if (resultado == false) {
				JOptionPane.showMessageDialog(null, "You entered a invalid email\nYou must enter, for example: example123@localhost.com/es/net..", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				resultado = true;
			}
		} while (resultado == false);
		
		return email;
	}
	
	/// Ask una contraseña 
	
	public static String ask_password() {
		
		boolean resultado = false;
		String password = "";
		
		do {
			password = Validates.validastring_edit("Can you enter your password?", "Password");
			resultado = Reg_ex.valida_password(password);
			if (resultado == false) {
				JOptionPane.showMessageDialog(null, "You entered a invalid password\nYou must enter low letter + one number + min 8*\nThe symbols are allowed", "Error",JOptionPane.ERROR_MESSAGE);
			} else {
				resultado = true;
			}
		} while (resultado == false);
		
		return password;
	}
	
	/// Ask número de teléfono +34 xxx xx xx xx

	public static String ask_telephone() {
		
		boolean resultado = false;
		String telefono = "";
		
		do {
			telefono = Validates.validastring_edit("Can you enter your phone number?", "The Phone Number");
			resultado = Reg_ex.valida_telefono(telefono);
			if (resultado == false) {
				JOptionPane.showMessageDialog(null, "You entered a invalid phone number\nYou must entered +34XXXXXXXXX (x)numbers", "Error",JOptionPane.ERROR_MESSAGE);
			} else {
				resultado = true;
			}
		} while (resultado == false);
		
		return telefono;
	}

}
