package Hotel_v3.Modules.Room.Utils;

import Hotel_v3.Classes.Fecha;
import Hotel_v3.Modules.Room.Classes.Double_room;
import Hotel_v3.Modules.Room.Classes.Room;
import Hotel_v3.Modules.Room.Classes.Single_room;
import Hotel_v3.Modules.Room.Classes.Singleton;
import Hotel_v3.Modules.Room.Classes.Suite_room;
import Hotel_v3.Modules.Users.Utils.Data_CRUD;

public class Dummies_rooms {
	
	/// Atributos Single
	
	private static String[] id_single = {"10A", "10B", "10C", "10D", "20A"};  
	private static String[] m2_single = {"200", "400", "300", "200", "250"};  
	private static String[] capicity_single = {"1", "1", "1", "1", "1"};  
	private static boolean[] available_single = {true, false, true, true, false};   
	private static boolean[] wifi_single = {true, true, true, true, false};   
	private static Fecha[] fecha_inicio_single = {new Fecha("20/06/2021"), new Fecha("02/12/2021"), new Fecha("17/11/2021"), new Fecha("25/01/2021"), new Fecha("05/03/2021")};
	private static Fecha[] fecha_fin_single = {new Fecha("30/06/2021"), new Fecha("10/12/2021"), new Fecha("20/11/2021"), new Fecha("30/01/2021"), new Fecha("09/03/2021")};
	private static boolean[] tv_single = {true, true, false, true, true};  
	private static String[] excursion_single = {"Climb", "Mountain", "Guided route", "Mountain", "Guided route"};

	/// Atributos Double
	
	private static String[] id_double = {"10A", "10B", "10C", "10D", "20A"};  
	private static String[] m2_double = {"250", "300", "200", "400", "300"};  
	private static String[] capicity_double = {"1", "1", "1", "1", "1"};  
	private static boolean[] available_double = {true, false, true, true, false};   
	private static boolean[] wifi_double = {true, true, true, true, false};   
	private static Fecha[] fecha_inicio_double = {new Fecha("20/08/2021"), new Fecha("02/07/2021"), new Fecha("17/10/2021"), new Fecha("15/03/2021"), new Fecha("08/04/2021")};
	private static Fecha[] fecha_fin_double = {new Fecha("25/08/2021"), new Fecha("08/07/2021"), new Fecha("23/10/2021"), new Fecha("20/03/2021"), new Fecha("12/04/2021")};
	private static boolean[] tv_double = {true, false, true, true, true};  
	private static boolean[] bed_type_double = {true, false, false, true, false};  
	private static boolean[] spa_double = {true, false, true, true, true};
	private static Fecha[] start_date_spa_double = {new Fecha("21/08/2021"), null, new Fecha("17/10/2021"), new Fecha("15/03/2021"), new Fecha("12/04/2021")};
	private static Fecha[] end_date_spa_double = {new Fecha("22/08/2021"), null, new Fecha("18/10/2021"), new Fecha("15/03/2021"), new Fecha("12/04/2021")};

	/// Atributos Suite
	
	
	private static String[] id_suite = {"200A", "200B", "200C", "200D", "210A"};   /// 1
	private static String[] m2_suite = {"450", "400", "500", "500", "400"};  
	private static String[] capicity_suite = {"1", "1", "1", "1", "1"};  
	private static boolean[] available_suite = {true, true, true, false, false};   
	private static boolean[] wifi_suite = {false, true, true, true, false};   
	private static Fecha[] fecha_inicio_suite = {new Fecha("21/11/2021"), new Fecha("11/05/2021"), new Fecha("18/09/2021"), new Fecha("09/08/2021"), new Fecha("12/12/2021")};
	private static Fecha[] fecha_fin_suite = {new Fecha("26/08/2021"), new Fecha("16/05/2021"), new Fecha("22/09/2021"), new Fecha("13/08/2021"), new Fecha("22/12/2021")};
	private static boolean[] champagne_suite = {true, true, false, false, true};  
	private static boolean[] bed_type_suite = {true, false, false, true, false};
	private static boolean[] jacuzzi_suite = {true, true, true, false, true};
	private static boolean[] spa_suite = {true, true, true, false, false};
	private static Fecha[] start_date_spa_suite = {new Fecha("22/11/2021"), new Fecha("11/05/2021"), new Fecha("20/09/2021"), null, null};
	private static Fecha[] end_date_spa_suite = {new Fecha("22/11/2021"), new Fecha("13/05/2021"), new Fecha("21/09/2021"), null, null};


	public static void cargar_datos() {
		
		int longitud = 5;
		boolean condicion = false;

		condicion = Data_CRUD.ask_yes_no("Yes", "No", "Do you want to charge 5 testing rooms?", "Dummies");
		if (condicion == true)
			cargar_dummies(longitud);
	}

	
	public static void cargar_dummies(int longitud) {
		Room single = null, double_room = null, suite = null;
		
		for (int i = 0; i < longitud; i++) {    /// Single
			single = new Single_room(id_single[i], m2_single[i], capicity_single[i], available_single[i], wifi_single[i], fecha_inicio_single[i], fecha_fin_single[i], tv_single[i], excursion_single[i]);
			Singleton.a_single.add((Single_room) single);
		}
		
		for (int i = 0; i < longitud; i++) {   /// Double

			double_room = new Double_room(id_double[i], m2_double[i], capicity_double[i], available_double[i], wifi_double[i], fecha_inicio_double[i], fecha_fin_double[i], tv_double[i], bed_type_double[i], spa_double[i], start_date_spa_double[i], end_date_spa_double[i]);
			Singleton.a_double.add((Double_room) double_room);
		}
		
		for (int i = 0; i < longitud; i++) {   /// Suite
			
			suite = new Suite_room(id_suite[i], m2_suite[i], capicity_suite[i], available_suite[i], wifi_suite[i], fecha_inicio_suite[i], fecha_fin_suite[i], champagne_suite[i], bed_type_suite[i], jacuzzi_suite[i], spa_suite[i], start_date_spa_suite[i], end_date_spa_suite[i]);
			Singleton.a_suite.add((Suite_room) suite);
		}
	}

}
