package Hotel_v3.Modules.Users.Utils;

import javax.swing.JOptionPane;

import Hotel_v3.Classes.Fecha;
import Hotel_v3.Utils.Validates;

public class Data_date {
	
	/// Fecha de inicio
	
	public static Fecha ask_fecha_nacimiento(String message, String title) {
		
		String fecha = "";
		boolean result = false;
		Fecha fecha_nacimiento = null;
		int edad = 0;

		do {
			fecha = Validates.validastring_edit(message, title); 
			result = Reg_ex.valida_fecha(fecha);   /// Validamos el formato de la fecha.
			if (result == false) {
				result = false;
				JOptionPane.showMessageDialog(null, "You entered a invalid date\nYou must the date in format: dd/mm/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				result = true;
				fecha_nacimiento = new Fecha(fecha);   /// Creamos el objeto.
				System.out.println("The date is: " + fecha_nacimiento.toString());
				result = fecha_nacimiento.valida_fecha();   /// validamos la fecha, utilizando el validador de la classe Fecha, para que no se introduzca una fecha que no existe.
				if (result == false) {
					result = false;
					JOptionPane.showMessageDialog(null, "Invalid date\nYou must enter a existing date", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					result = true;
					edad = fecha_nacimiento.restar_fecha_sistema_2();
					if (edad < 18 || edad > 130) {   /// Condicion, para una edad válida.
						result = false;
						JOptionPane.showMessageDialog(null, "Invalid age\nYou must be older than 18 years", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						result = true;
					}
				}
			}
		} while ((result == false));

		return fecha_nacimiento;
	}
	
	/// Fecha de contratación
	
	public static Fecha ask_fecha_contratacion(Fecha fecha_nacimiento) {
		
		String fecha = "";
		boolean result = false;
		int equal = 0, antiguedad = 0, edad = 0;
		Fecha fecha_contrtacion = null;
		
		do {
			fecha = Validates.validastring_edit("Can you insert the date of hiring?", "The hiring date");
			result = Reg_ex.valida_fecha(fecha);   /// Validamos el formato de la fecha.
			if (result == false) {
				result = false;
				JOptionPane.showMessageDialog(null, "You entered a invalid date\nYou must the date in format: dd/mm/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				result = true;
				fecha_contrtacion = new Fecha(fecha);   /// Creamos el objeto
				System.out.println("The data of hiring: " + fecha_contrtacion.toString());
				result = fecha_contrtacion.valida_fecha();  /// validamos la fecha, utilizando el validador de la classe Fecha, para que no se introduzca una fecha que no existe.
				if (result == false) {
					result = false;
					JOptionPane.showMessageDialog(null, "Invalid date\nYou must enter a existing date", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					result = true;
					equal = fecha_nacimiento.compara_fechas(fecha_contrtacion);   /// Comparador para que la fecha de fin sea posterior a la de inicio
					if (equal == 1) {
						edad = fecha_nacimiento.restar2Fechas_años(fecha_contrtacion);
						if (edad < 18) {
							result = false;
							JOptionPane.showMessageDialog(null, "Invalid age\nYou must be older than 18 years", "Error", JOptionPane.ERROR_MESSAGE);
						} else {
							result = true;
							antiguedad = fecha_contrtacion.restar_fecha_sistema();
							if (antiguedad > 0) {
								result = false;
								JOptionPane.showMessageDialog(null, "Invalid date\nYou must be hired before today", "Error", JOptionPane.ERROR_MESSAGE);
							} else
								result = true;
						}
					} else if (equal == 2) {
						JOptionPane.showMessageDialog(null, "You can't be hired before you born", "Error", JOptionPane.ERROR_MESSAGE);
					} else if (equal == 3) {
						JOptionPane.showMessageDialog(null, "You can't be hired as soon as you borned", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		} while ((result == false) || (edad < 18) || (equal != 1));

		return fecha_contrtacion;
	}
	
	/// Actualizar fecha de nacimiento
	
	public static Fecha update_fecha_nacimiento_contratacion(Fecha fecha_contrtacion) {
		
		boolean result = false;
		int equal = 0, edad = 0;
		Fecha fecha_nacimiento = null;
		
		do {
			fecha_nacimiento = Data_date.ask_fecha_nacimiento("Can you insert your date of birth?", "Date of birth");
			equal = fecha_nacimiento.compara_fechas(fecha_contrtacion); 
			if (equal == 1) {
				edad = fecha_nacimiento.restar2Fechas_años(fecha_contrtacion);
				if (edad < 18) {
					result = false;
					JOptionPane.showMessageDialog(null, "Invalid age\nYou must be older than 18 years", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					result = true;
				}
			} else if (equal == 2)  {
				JOptionPane.showMessageDialog(null, "You can't be hired before you born", "Error", JOptionPane.ERROR_MESSAGE);
			} else if (equal == 3) {
				JOptionPane.showMessageDialog(null, "You can't leave the hotel the same day as you come", "Error", JOptionPane.ERROR_MESSAGE);
			} 
		} while ((result == false) || (edad < 2) || (equal != 1));
		
		JOptionPane.showMessageDialog(null, "You can't be hired as soon as you borned", "Error", JOptionPane.ERROR_MESSAGE);
		
		return fecha_nacimiento;
	}
	
	/// Actualizar fecha de nacimiento dependiendo de la de alta
	
	public static Fecha update_fecha_nacimiento_alta(Fecha fecha_alta) {
		
		boolean result = false;
		int equal = 0, edad = 0;
		Fecha fecha_nacimiento = null;
		
		do {
			fecha_nacimiento = Data_date.ask_fecha_nacimiento("Can you insert your date of birth?", "Date of birth");
			equal = fecha_nacimiento.compara_fechas(fecha_alta);
			if (equal == 1) {
				edad = fecha_nacimiento.restar2Fechas_años(fecha_alta);  
				if (edad < 18) {
					result = false;
					JOptionPane.showMessageDialog(null, "Invalid age\nYou must be older than 18 years", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					result = true;
				}
			} else if (equal == 2)  {
				JOptionPane.showMessageDialog(null, "You can't be registred before you born", "Error", JOptionPane.ERROR_MESSAGE);
			} else if (equal == 3) {
				JOptionPane.showMessageDialog(null, "You can't leave the hotel the same day as you come", "Error", JOptionPane.ERROR_MESSAGE);
			} 
		} while ((result == false) || (edad < 2) || (equal != 1));
		
		JOptionPane.showMessageDialog(null, "You can't be registred as soon as you borned", "Error", JOptionPane.ERROR_MESSAGE);
		
		return fecha_nacimiento;
	}
	
	/// Fecha de alta
	
	public static Fecha ask_fecha_alta(Fecha fecha_nacimiento) {
		String fecha = "";
		boolean result = false;
		int equal = 0, antiguedad = 0, edad = 0;
		Fecha fecha_alta = null;

		do {
			fecha = Validates.validastring_edit("Can you insert the date of register?", "The register date"); 
			result = Reg_ex.valida_fecha(fecha);   /// Validamos el formato de la fecha.
			if (result == false) {
				result = false;
				JOptionPane.showMessageDialog(null, "You entered a invalid date\nYou must the date in format: dd/mm/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				result = true;
				fecha_alta = new Fecha(fecha);// creem el objecte
				System.out.println("The data of registration: " + fecha_alta.toString());
				result = fecha_alta.valida_fecha();  /// validamos la fecha, utilizando el validador de la classe Fecha, para que no se introduzca una fecha que no existe.
				if (result == false) {
					result = false;
					JOptionPane.showMessageDialog(null, "Invalid date\nYou must enter a existing date", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					result = true;
					equal = fecha_nacimiento.compara_fechas(fecha_alta);   /// Comparador para que la fecha de fin sea posterior a la de inicio
					if (equal == 1) {
						edad = fecha_nacimiento.restar2Fechas_años(fecha_alta);
						if (edad < 18) {
							result = false;
							JOptionPane.showMessageDialog(null, "Invalid age\nYou must be older than 18 years", "Error", JOptionPane.ERROR_MESSAGE);
						} else {
							result = true;
							antiguedad = fecha_alta.restar_fecha_sistema();
							System.out.println("The dif is: " + antiguedad);
							if (antiguedad > 0) {
								result = false;
								JOptionPane.showMessageDialog(null, "Invalid date\nYou must be registred before today", "Error", JOptionPane.ERROR_MESSAGE);
							} else
								result = true;
						}
					} else if (equal == 2) {
						JOptionPane.showMessageDialog(null, "You can't be registred before you born", "Error", JOptionPane.ERROR_MESSAGE);
					} else if (equal == 3) {
						JOptionPane.showMessageDialog(null, "You can't be registred as soon as you borned", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		} while ((result == false) || (edad < 18) || (equal != 1));

		return fecha_alta;
	}
	
}
