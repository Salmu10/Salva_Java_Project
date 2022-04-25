package Hotel_v3;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Hotel_v3.Modules.Room.Classes.Double_room;
import Hotel_v3.Modules.Room.Classes.Single_room;
import Hotel_v3.Modules.Room.Classes.Singleton;
import Hotel_v3.Modules.Room.Classes.Suite_room;
import Hotel_v3.Modules.Room.Utils.Dummies_rooms;
import Hotel_v3.Modules.Users.Classes.Admin;
import Hotel_v3.Modules.Users.Classes.Client;
import Hotel_v3.Modules.Users.Classes.Prenium;
import Hotel_v3.Modules.Users.Classes.Singleton_users;
import Hotel_v3.Modules.Users.Classes.User;
import Hotel_v3.Modules.Users.Utils.Dummies_users;
import Hotel_v3.Modules.Users.Utils.Operations_user;
import Hotel_v3.Modules.Users.Utils_arrays.CRUD.Register_user_arrays;
import Hotel_v3.Utils.Menus;

public class Principal_v2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] opciones_menu_1 = {"Register Admin", "Register Client", "Register Prenium", "Log in", "Eixit"};
		int option = 0;
		
		User user = null;
		Admin admin = null;
		Client client = null;
		Prenium prenium = null;

		Singleton_users.a_admin = new ArrayList <Admin> ();
		Singleton_users.a_client = new ArrayList <Client> ();
		Singleton_users.a_prenium = new ArrayList <Prenium> ();
		
		Dummies_users.cargar_datos();
		
		Singleton.a_single = new ArrayList <Single_room> ();
		Singleton.a_double = new ArrayList <Double_room> ();
		Singleton.a_suite = new ArrayList <Suite_room> ();
		
		Dummies_rooms.cargar_datos();
		
		do {
			option = Menus.menu_buttons_edit(opciones_menu_1, "What do you want to do?", "Hotel Salvador");
			switch (option) {
				case 0:   /// Register Admin
					Register_user_arrays.register_admin(admin, user);
					break;
				
				case 1:   /// Register Client					
					Register_user_arrays.register_client(client, user);
					break;
					
				case 2:   /// Register Prenium
					Register_user_arrays.register_prenium(prenium, user);
					break;
					
				case 3:   /// Log in
					Operations_user.login(user);
					break;
			}
		} while(option != 4);
		
		JOptionPane.showMessageDialog(null, "Thanks for visiting Hotel Salvador");
	}

}
