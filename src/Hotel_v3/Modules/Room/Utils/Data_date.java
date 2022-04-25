package Hotel_v3.Modules.Room.Utils;

import javax.swing.JOptionPane;

import Hotel_v3.Classes.Fecha;
import Hotel_v3.Utils.Validates;

public class Data_date {
	
	/// Fecha de inicio
	
	public static Fecha ask_fecha_inicio(String message, String title) {
		
		String fecha = "";
		boolean result = false;
		Fecha fecha_inicio = null;
		int dias = 0;

		do {
			fecha = Validates.validastring_edit(message, title); 
			result = Reg_ex.valida_fecha(fecha);   /// Validamos el formato de la fecha.
			if (result == false) {
				result = false;
				JOptionPane.showMessageDialog(null, "You entered a invalid date\nYou must the date in format: dd/mm/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				result = true;
				fecha_inicio = new Fecha(fecha);   /// Creamos el objeto
				System.out.println("The date is: " + fecha_inicio.toString());   /// Lo mostramos por consola
				result = fecha_inicio.valida_fecha();  /// validamos la fecha, utilizando el validador de la classe Fecha, para que no se introduzca una fecha que no existe.
				if (result == false) {
					result = false;
					JOptionPane.showMessageDialog(null, "Invalid date\nYou must enter a existing date", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					result = true;
					dias = fecha_inicio.restar_fecha_sistema();
					if (dias < 0) {   /// Condición para una fecha de entrada válida
						result = false;
						JOptionPane.showMessageDialog(null, "Invalid start date\nYou must enter a day after today", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						result = true;
					} 
				}
			}
		} while ((result == false));

		return fecha_inicio;
	}
	
	/// Fecha de fin
	
	public static Fecha ask_fecha_fin(Fecha fecha_inicio) {
		
		String fecha = "";
		boolean result = false;
		int equal = 0, diferencia = 0;
		Fecha fecha_fin = null;

		do {
			fecha = Validates.validastring_edit("Can you insert the end date?", "End Date");
			result = Reg_ex.valida_fecha(fecha);   /// Validamos el formato de la fecha.
			if (result == false) {
				result = false;
				JOptionPane.showMessageDialog(null, "You entered a invalid date\nYou must the date in format: dd/mm/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				result = true;
				fecha_fin = new Fecha(fecha);   /// Creamos el objeto
				System.out.println("End date: " + fecha_fin.toString());
				result = fecha_fin.valida_fecha();   /// validamos la fecha, utilizando el validador de la classe Fecha, para que no se introduzca una fecha que no existe.
				if (result == false) {
					result = false;
					JOptionPane.showMessageDialog(null, "Invalid date\nYou must enter a existing date", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					result = true;
					equal = fecha_inicio.compara_fechas(fecha_fin);   /// Comparador para que la fecha de fin sea posterior a la de inicio
					if (equal == 1) {
						diferencia = fecha_inicio.restar2Fechas(fecha_fin);   /// La fecha de salida debe ser dos dias superior a la de inicio
						if (diferencia < 2) {
							result = false;
							JOptionPane.showMessageDialog(null, "Invalid date\nYou must enter 2 days after the start date", "Error", JOptionPane.ERROR_MESSAGE);
						} else {
							result = true;
						}
					} else if (equal == 2) {
						JOptionPane.showMessageDialog(null, "You can't leave the hotel before you come", "Error", JOptionPane.ERROR_MESSAGE);
					} else if (equal == 3) {
						JOptionPane.showMessageDialog(null, "You can't leave the hotel the same day as you come", "Error", JOptionPane.ERROR_MESSAGE);
					} 
				} 
			} 
		} while ((result == false) || (diferencia < 2) || (equal != 1));

		return fecha_fin;
	}
	
	/// Actualizar fecha de inicio
	
	public static Fecha update_fecha_inicio(Fecha fecha_fin) {
		
		boolean result = false;
		int equal = 0, diferencia = 0;
		Fecha fecha_inicio = null;
		
		do {
			fecha_inicio = Data_date.ask_fecha_inicio("Can you insert the start date?", "Start Date");  /// Pedimos la fecha de inicio
			equal = fecha_inicio.compara_fechas(fecha_fin);   /// Comparador para que la fecha de fin sea posterior a la de inicio
			if (equal == 1) {
				diferencia = fecha_inicio.restar2Fechas(fecha_fin);   /// La fecha de salida debe ser dos dias superior a la de inicio
				if (diferencia < 2) {
					result = false;
					JOptionPane.showMessageDialog(null, "Invalid date\nYou must enter 2 days after the start date", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					result = true;
				}
			} else if (equal == 2)  {
				JOptionPane.showMessageDialog(null, "You can't come to the hotel after you leave", "Error", JOptionPane.ERROR_MESSAGE);
			} else if (equal == 3) {
				JOptionPane.showMessageDialog(null, "You can't leave the hotel the same day as you come", "Error", JOptionPane.ERROR_MESSAGE);
			} 
		} while ((result == false) || (diferencia < 2) || (equal != 1));
		
		JOptionPane.showMessageDialog(null, "The start date has been updated", "Start date", JOptionPane.INFORMATION_MESSAGE);
		
		return fecha_inicio;
	}
	
	/// Actualizar fecha de inicio con dependencia de la fecha de iniciod e spa
	
	public static Fecha update_fecha_inicio_sub(Fecha fecha_sub_inicio, Fecha fecha_fin) {
		
		boolean result = false;
		int equal = 0, equal_2 = 0, diferencia = 0;
		Fecha fecha_inicio = null;
		
		do {
			fecha_inicio = Data_date.ask_fecha_inicio("Can you insert the start date?", "Start Date");  /// Pedimos la fecha de inicio
			equal = fecha_inicio.compara_fechas(fecha_fin);   /// Comparador para que la fecha de fin sea posterior a la de inicio
			equal_2 = fecha_inicio.compara_fechas(fecha_sub_inicio);   /// Comparador para que la fecha de inicio sub sea anterior a la de fin
			if (equal_2 == 1) {
				if (equal == 1) {
					diferencia = fecha_inicio.restar2Fechas(fecha_fin);   /// La fecha de salida debe ser dos dias superior a la de inicio
					if (diferencia < 2) {
						result = false;
						JOptionPane.showMessageDialog(null, "Invalid date\nYou must enter 2 days after the start date", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						result = true;
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "The start date have to be before the start date SPA and before the end date", "Error", JOptionPane.ERROR_MESSAGE);
			} 
		} while ((result == false) || (diferencia < 2) || (equal != 1) || (equal_2 != 1));
		
		JOptionPane.showMessageDialog(null, "The start date has been updated", "Start date", JOptionPane.INFORMATION_MESSAGE);
		
		return fecha_inicio;
	}
	
	/// Fecha de inicio dentro de una previa
	
	public static Fecha ask_fecha_sub_inicio(Fecha fecha_inicio, Fecha fecha_fin) {
		
		boolean result = false;
		int equal = 0, equal_2 = 0, diferencia = 0;
		Fecha fecha_sub_inicio = null;
		
		do {
			fecha_sub_inicio = Data_date.ask_fecha_inicio("Can you insert the start date of the SPA?", "SPA Start Date");  /// Pedimos la fecha de inicio
			equal = fecha_sub_inicio.compara_fechas(fecha_inicio);   /// Comparador para que la fecha de inicio sub sea posterior a la de inicio
			equal_2 = fecha_sub_inicio.compara_fechas(fecha_fin);   /// Comparador para que la fecha de inicio sub sea anterior a la de fin
			if ((equal != 1) && (equal_2 != 2)) {
				diferencia = fecha_sub_inicio.restar2Fechas(fecha_fin);   /// La fecha de salida debe ser dos dias superior a la de inicio
				if (diferencia < 0) {
					result = false;
					JOptionPane.showMessageDialog(null, "Invalid date\nYou must go to the Spa before you leave the hotel", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					result = true;
				}
			} else {
				JOptionPane.showMessageDialog(null, "You have to be at hotel", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} while ((result == false) || (diferencia < 0) || (equal == 1) || (equal_2 == 2));
		
		return fecha_sub_inicio;
	}
	
	/// Fecha de fin dentro de una previa
	
	public static Fecha ask_fecha_sub_fin(Fecha fecha_sub_inicio, Fecha fecha_fin) {
		
		boolean result = false;
		int equal = 0, equal_2 = 0, diferencia = 0;
		Fecha fecha_sub_fin = null;
		
		do {
			fecha_sub_fin = Data_date.ask_fecha_inicio("Can you insert the end date of the SPA?", "SPA End Date");  /// Pedimos la fecha de inicio
			equal = fecha_sub_fin.compara_fechas(fecha_sub_inicio);   /// Comparador para que la fecha de inicio sub sea posterior a la de inicio
			equal_2 = fecha_sub_fin.compara_fechas(fecha_fin);   /// Comparador para que la fecha de inicio sub sea anterior a la de fin
			if ((equal != 1) && (equal_2 != 2)) {
				diferencia = fecha_sub_fin.restar2Fechas(fecha_fin);   /// La fecha de salida debe ser dos dias superior a la de inicio
				if (diferencia < 0) {
					result = false;
					JOptionPane.showMessageDialog(null, "Invalid date\nYou must go to the Spa before you leave the hotel", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					result = true;
				}
			} else {
				JOptionPane.showMessageDialog(null, "You have to be at hotel and set the end date SPA after the start date of the SPA", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} while ((result == false) || (diferencia < 0) || (equal == 1) || (equal_2 == 2));
		
		return fecha_sub_fin;
	}
}
