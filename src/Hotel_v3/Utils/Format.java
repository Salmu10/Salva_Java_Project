package Hotel_v3.Utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Format {
	
	public static String format_1d(double number) {
		
		DecimalFormat format1 = new DecimalFormat(".#");
		
		return format1.format(number);
	}
	
	public static String format_2d(double number) {
		
		DecimalFormat format1 = new DecimalFormat(".##");
		
		return format1.format(number);
	}
	
	public static String format_3d(double number) {
		
		DecimalFormat format1 = new DecimalFormat(".###");
		
		return format1.format(number);
	}

	public static String Format_Dollar(double moneda) {
		
		NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.US);   /// Dolar
		
		return coin.format(moneda);
	}
	
	public static String Format_Libra(double moneda) {
		
		NumberFormat coin=NumberFormat.getCurrencyInstance(Locale.UK);   /// Libras
		
		return coin.format(moneda);
	}
	
	public static String Format_Euro(double moneda) {
		
		NumberFormat coin=NumberFormat.getCurrencyInstance( Locale.FRANCE);   /// Euro
		
		return coin.format(moneda);
	}

}
