package Hotel_v3.Modules.Users.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg_ex {
	
	private static final String reg_ex_nombre = "^[a-zA-Z\\s]*$";   /// Solo letras de la A a la Z
	private static final String reg_ex_nombreconnumeros = "^[A-Za-z0-9]*$";   /// Nombre y digitos
	private static final String reg_ex_tlf = "^[0-9]{2,3}-? ?[0-9]{6,7}$";
	private static final String reg_ex_dni = "^[0-9]{8}+[A-Z]$";   /// 8 dígitos y 1 letra 
	private static final String reg_ex_direccion = "^[a-zA-Z]+_[a-zA-Z]+_[n]+[0-9]*$";
	private static final String reg_ex_email = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String reg_ex_fecha = "[0-9]{2}[/][0-9]{2}[/][0-9]{4}";
	private static final String reg_ex_password = "^(?=\\w*\\d)(?=\\w*[a-z])\\S{8,16}$";
	
	
	/// validar nombre de usuario
	
	public static boolean valida_user_name(String user_name) {
		
		Pattern pattern = Pattern.compile(reg_ex_nombreconnumeros);
	    Matcher matcher = pattern.matcher(user_name);
	    
	    if(matcher.matches()) {
	    	return true;
		}else {
		    return false; 
		}
	}
		
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
	
	/// Validar un DNI
	
	public static boolean valida_DNI(String dni) {
		
        Pattern pattern = Pattern.compile(reg_ex_dni);
        Matcher matcher = pattern.matcher(dni);
        
		if(matcher.matches()) {
			boolean val = true;
			String dni2 = "", caracteres = "TRWAGMYFPDXBNJZSQVHLCKET";
			int dni1 = 0, modulo = 0;
			
			for(int i = 0; i < 8; i++) {
				dni2 = dni2 + dni.charAt(i);
			}
			char letra = dni.charAt(8);			
			dni1 = Integer.parseInt(dni2);
			modulo = dni1 % 23;
			char let = caracteres.charAt(modulo);
			if(let == letra) {
				val = true;
			} else {
				val = false;
			}
				
			return val;
		 }
		
	    return false;
	  }
	
	/// Validar una direeción
	
	public static boolean valida_direccion(String direccion){
		
        Pattern pattern = Pattern.compile(reg_ex_direccion);
        Matcher matcher = pattern.matcher(direccion);
        
		if(matcher.matches()) {
			return true;
		} else {
			return false; 
		}
	  }
		
	/// Validamos un numero de telefono español que empiece por 9, 6 o 7
	
	public static boolean valida_telefono(String telefono){
			
		Pattern pattern=Pattern.compile(reg_ex_tlf);
		Matcher matcher=pattern.matcher(telefono);
		
		if(matcher.matches()) {
			return true;
		} else {
			return false; 
		}
	}

	/// Validar un correo electrónico
	
	public static boolean valida_email(String email) {
		
		Pattern pattern = Pattern.compile(reg_ex_email);
		Matcher matcher = pattern.matcher(email);
		
		if(matcher.matches()) {
			return true;
		} else {
			return false; 
		}
	}
	
	/// validar una contraseña
	
	public static boolean valida_password(String contraseña) {
		
	    Pattern pattern = Pattern.compile(reg_ex_password);
	    Matcher matcher = pattern.matcher(contraseña);
	    
		if(matcher.matches()) {
			return true;
		} else {
			return false; 
		}
	}
}
