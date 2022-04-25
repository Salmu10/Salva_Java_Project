package Hotel_v3.Modules.Room.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg_ex {
	
	private static final String reg_ex_nombre = "^[a-zA-Z\\s]*$";   /// Solo letras de la A a la Z
	private static final String reg_ex_id = "^([0-9]{1,3})([A-D]{1})$";   /// 3 dígitos y 1 letra 
	private static final String reg_ex_fecha = "[0-9]{2}[/][0-9]{2}[/][0-9]{4}";
	private static final String reg_ex_porcentaje = "^[0-9]+(\\.[0-9]{2})?%$";
	private static final String reg_ex_m2 = "^[0-9]{1,3}$";
	private static final String reg_ex_capacity = "^[0-6]$";
	private static final String reg_ex_price = "^\\d{1,5}(\\.\\d{1,3})?$";   /// Numero de 1 a 5 cifras con de un a 3 decimales
	
		
	/// validar nombre
	
	public static boolean valida_nombre(String nombre) {
		
		Pattern pattern = Pattern.compile(reg_ex_nombre);
	    Matcher matcher = pattern.matcher(nombre);
	    
	    if(matcher.matches()) {
	    	return true;
		}else {
		    return false; 
		}
	}
	
	/// validar ID
	
	public static boolean valida_id(String id) {
			
	    Pattern pattern = Pattern.compile(reg_ex_id);
	    Matcher matcher = pattern.matcher(id);
		if(matcher.matches()) {
			return true;
		}else {
			return false; 
		}
	}
	
	/// Validar una fecha
		
	public static boolean valida_fecha(String fecha) {
		
		Pattern pattern = Pattern.compile(reg_ex_fecha);
		Matcher matcher = pattern.matcher(fecha);
		
		if(matcher.matches()) {
			return true;
		} else {
			return false; 	  
		}
	}
	
	/// validar un número en tanto por cien
	
	public static boolean valida_porcentaje(String numero) {
		
	    Pattern pattern = Pattern.compile(reg_ex_porcentaje);
	    Matcher matcher = pattern.matcher(numero);
	    
		if(matcher.matches()) {
			return true;
		}else {
			return false; 
		}
	}
	
	/// validar un número de 3 cifras
	
	public static boolean valida_m2(String m2) {
		
	    Pattern pattern = Pattern.compile(reg_ex_m2);
	    Matcher matcher = pattern.matcher(m2);
	    
		if(matcher.matches()) {
			return true;
		}else {
			return false; 
		}
	}
	
	/// validar un número de 0 a 6
	
	public static boolean valida_capacity(String capacity) {
		
	    Pattern pattern = Pattern.compile(reg_ex_capacity);
	    Matcher matcher = pattern.matcher(capacity);
	    
		if(matcher.matches()) {
			return true;
		}else {
			return false; 
		}
	}
	
	/// validar un número de 1 a 5 cifras con de un a 3 decimales
	
	public static boolean valida_price(String price) {
		
	    Pattern pattern = Pattern.compile(reg_ex_price);
	    Matcher matcher = pattern.matcher(price);
	    
		if(matcher.matches()) {
			return true;
		}else {
			return false; 
		}
	}

}
