package Hotel_v3.Modules.Users.Utils;

import Hotel_v3.Classes.Fecha;
import Hotel_v3.Modules.Users.Classes.Admin;
import Hotel_v3.Modules.Users.Classes.Client;
import Hotel_v3.Modules.Users.Classes.Prenium;
import Hotel_v3.Modules.Users.Classes.Singleton_users;
import Hotel_v3.Modules.Users.Classes.User;

public class Dummies_users {

	/// Atributos Admin
	
	private static String[] username_admin = {"Admin1", "Admin2", "Admin3", "Admin4", "Admin5"};
	private static String[] password_admin = {"12345678a", "12345678a", "12345678a", "12345678a", "12345678a"};
	private static String[] nombre_admin = {"Salva", "Andrea", "Amparo", "David", "Sergi"};
	private static String[] apellido_admin = {"Muñoz", "Huertas", "Úbeda", "Garcia", "Perez"};
	private static String[] email_admin = {"ubedasalva@gmail.com", "andreahuertas@gmail.com", "mausa1768@gmail.com", "pepeitomanolito01@gmail.com", "holaqtal@gmail.com"};
	private static Fecha[] fecha_nacimineto_admin = {new Fecha("20/06/1997"), new Fecha("02/12/2000"), new Fecha("17/11/1968"), new Fecha("25/01/1994"), new Fecha("05/03/1975")};
	private static String[] DNI_admin = {"48604947J", "48604947J", "48604947J", "48604947J", "48604947J"};
	private static String[] telefono_admin = {"633691086", "644691071", "626691489", "684691041", "788692486"};
	private static Fecha[] fecha_contratacion_admin = {new Fecha("17/04/2020"), new Fecha("02/11/2020"), new Fecha("04/04/2020"), new Fecha("25/01/2021"), new Fecha("05/07/2021")};

	/// Atributos Client
	
	private static String[] username_client = {"Client1", "Client2", "Client3", "Client4", "Client5"};
	private static String[] password_client = {"12345678a", "12345678a", "12345678a", "12345678a", "12345678a"};
	private static String[] nombre_client = {"Rafa", "Anna", "Dolores", "Raul", "Ramón"};
	private static String[] apellido_client = {"Muñoz", "Huertas", "Úbeda", "Garcia", "Perez"};
	private static String[] email_client = {"ramoncin@gmail.com", "roberto19@gmail.com", "miguelito03@gmail.com", "yomogan@gmail.com", "casamunyozubeda@gmail.com"};
	private static Fecha[] fecha_nacimineto_client = {new Fecha("20/06/1997"), new Fecha("02/12/2000"), new Fecha("17/11/1968"), new Fecha("25/01/1994"), new Fecha("05/03/1975")};
	private static String[] DNI_client = {"48604947J", "48604947J", "48604947J", "48604947J", "48604947J"};
	private static boolean[] sex_client = {true, false, false, true, false}; 
	private static String[] telefono_client = {"672694586", "699346157", "634615794", "784316759", "7823649712"};
	private static boolean[] shopping_client = {false, true, true, false, true}; 
	private static Fecha[] fecha_alta_client = {new Fecha("25/04/2019"), new Fecha("02/10/2020"), new Fecha("24/09/2020"), new Fecha("25/04/2021"), new Fecha("15/08/2021")};

	/// Atributos Prenium
	
	private static String[] username_prenium = {"Prenium1", "Prenium1", "Prenium1", "Prenium1", "Prenium1"};
	private static String[] password_prenium = {"12345678a", "12345678a", "12345678a", "12345678a", "12345678a"};
	private static String[] nombre_prenium = {"Maria", "Vicent", "Manuel", "Marta", "Edu"};
	private static String[] apellido_prenium = {"Muñoz", "Huertas", "Úbeda", "Garcia", "Perez"};
	private static String[] email_prenium = {"salvamu@gmail.com", "huertas@gmail.com", "maunu78@gmail.com", "manolito01@gmail.com", "tafwl@gmail.com"};
	private static Fecha[] fecha_nacimineto_prenium = {new Fecha("20/07/1975"), new Fecha("02/12/1997"), new Fecha("17/10/1998"), new Fecha("25/02/1993"), new Fecha("08/01/1991")};
	private static String[] DNI_prenium = {"48604947J", "48604947J", "48604947J", "48604947J", "48604947J"};
	private static boolean[] sex_prenium = {true, true, true, false, false}; 
	private static String[] telefono_prenium = {"679316497", "745613495", "711349862", "611649532", "638613754"};
	private static String[] direccion_prenium = {"Salvador Tormo 37", "Pio XII 12", "Daniel Gil 09", "MArtinez Valls 45", "Jose Iranzo 10"};
	private static boolean[] shopping_prenium = {true, false, true, false, true};
	private static Fecha[] fecha_alta_prenium = {new Fecha("30/06/2021"), new Fecha("02/10/2019"), new Fecha("24/09/2020"), new Fecha("22/07/2021"), new Fecha("10/03/2021")};


	public static void cargar_datos() {
		
		int longitud = 5;
		boolean condicion = false;

		condicion = Data_CRUD.ask_yes_no("Yes", "No", "Do you want to charge 5 testing users?", "Dummies");
		if (condicion == true)
			cargar_dummies(longitud);
	}

	
	public static void cargar_dummies(int longitud) {
		User admin = null, client = null, prenium = null;
		
		for (int i = 0; i < longitud; i++) {    /// Admin
			admin = new Admin(username_admin[i], password_admin[i], nombre_admin[i], apellido_admin[i], email_admin[i], fecha_nacimineto_admin[i], DNI_admin[i], fecha_contratacion_admin[i], telefono_admin[i]);
			Singleton_users.a_admin.add((Admin) admin);
		}
		
		for (int i = 0; i < longitud; i++) {   /// Client

			client = new Client(username_client[i], password_client[i], nombre_client[i], apellido_client[i], email_client[i], fecha_nacimineto_client[i], DNI_client[i], sex_client[i], telefono_client[i], shopping_client[i], fecha_alta_client[i]);
			Singleton_users.a_client.add((Client) client);
		}
		
		for (int i = 0; i < longitud; i++) {   /// Prenium
			
			prenium = new Prenium(username_prenium[i], password_prenium[i], nombre_prenium[i], apellido_prenium[i], email_prenium[i], fecha_nacimineto_prenium[i], DNI_prenium[i], sex_prenium[i], telefono_prenium[i], direccion_prenium[i], shopping_prenium[i], fecha_alta_prenium[i]);
			Singleton_users.a_prenium.add((Prenium) prenium);
		}
	}

}
