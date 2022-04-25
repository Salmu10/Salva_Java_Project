package Hotel_v3.Modules.Users.Utils_arrays.CRUD;


import Hotel_v3.Modules.Users.Utils.CRUD_Users;
import Hotel_v3.Modules.Users.Utils_arrays.Ask_UserName;
import Hotel_v3.Modules.Users.Utils_arrays.Find;
import Hotel_v3.Utils.Menus;

import javax.swing.JOptionPane;

import Hotel_v3.Modules.Users.Classes.Admin;
import Hotel_v3.Modules.Users.Classes.Client;
import Hotel_v3.Modules.Users.Classes.Prenium;
import Hotel_v3.Modules.Users.Classes.Singleton_users;

public class Profile_user_arrays {

	public static void profile_admin(Admin admin) {
		
		String [] opciones = {"Read", "Update", "Eixit"};
		int option = 0, location = -1;
		
		admin = Ask_UserName.ask_username_admin();
		location = Find.Find_admin_username(admin);
		
		if (location != -1) {
			admin = Singleton_users.a_admin.get(location);
			do {
				option = Menus.menu_buttons_edit(opciones, admin.getUser_name() + ": What option do you want to do?", "Admin profile");
				switch (option) {
					case 0:
						CRUD_Users.read_user(admin);
						break;
					case 1:
						CRUD_Users.profile_user(admin);
						break;
				}
			} while (option != 2);
		}  else {
			JOptionPane.showMessageDialog(null, "Wrong data", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void profile_client(Client client) {
		
		String [] opciones = {"Read", "Update", "Eixit"};
		int option = 0, location = -1;
		
		client = Ask_UserName.ask_username_client();
		location = Find.Find_client_username(client);
		
		if (location != -1) {
			client = Singleton_users.a_client.get(location);
			do {
				option = Menus.menu_buttons_edit(opciones, client.getUser_name() + ": What option do you want to do?", "Client profile");
				switch (option) {
					case 0:
						CRUD_Users.read_user(client);
						break;
					case 1:
						CRUD_Users.profile_user(client);
						break;
				}
			} while (option != 2);
		}  else {
			JOptionPane.showMessageDialog(null, "Wrong data", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void profile_prenium(Prenium prenium) {
		
		String [] opciones = {"Read", "Update", "Eixit"};
		int option = 0, location = -1;
		
		prenium = Ask_UserName.ask_username_prenium();
		location = Find.Find_prenium_username(prenium);
		
		if (location != -1) {
			prenium = Singleton_users.a_prenium.get(location);
			do {
				option = Menus.menu_buttons_edit(opciones, prenium.getUser_name() + ": What option do you want to do?", "Client profile");
				switch (option) {
					case 0:
						CRUD_Users.read_user(prenium);
						break;
					case 1:
						CRUD_Users.profile_user(prenium);
						break;
				}
			} while (option != 2);
		}  else {
			JOptionPane.showMessageDialog(null, "Wrong data", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
