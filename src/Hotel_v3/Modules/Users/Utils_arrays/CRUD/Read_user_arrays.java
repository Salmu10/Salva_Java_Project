package Hotel_v3.Modules.Users.Utils_arrays.CRUD;

import javax.swing.JOptionPane;

import Hotel_v3.Modules.Users.Classes.Admin;
import Hotel_v3.Modules.Users.Classes.Client;
import Hotel_v3.Modules.Users.Classes.Prenium;
import Hotel_v3.Modules.Users.Classes.Singleton_users;
import Hotel_v3.Modules.Users.Utils_arrays.Ask_UserName;
import Hotel_v3.Modules.Users.Utils_arrays.Find;
import Hotel_v3.Utils.Menus;

public class Read_user_arrays {

	public static void read_admin(Admin admin) {
		
		int menu = 0; 
		int	location = -1;
		String [] opciones = {"All", "One"};
		
		if (Singleton_users.a_admin.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No data, please create user", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			
			menu = Menus.menu_buttons_edit(opciones, "What will you do like?", "Read");
			
			switch (menu){
			
				case 0:
					for (int i = 0; i < Singleton_users.a_admin.size(); i++){
						String cad = "";
						cad = cad + (Singleton_users.a_admin.get(i).toString());
						JOptionPane.showMessageDialog(null, cad);
					}
					break;
					
				case 1:
					location = -1;
					admin = Ask_UserName.ask_username_admin();
					location = Find.Find_admin_username(admin);
					
					if (location != -1) {
						admin = Singleton_users.a_admin.get(location);
						JOptionPane.showMessageDialog(null, admin.toString());
					} else {
						JOptionPane.showMessageDialog(null, "The user doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
					}
					break;
			}
		}
	}
	
	public static void read_client(Client client) {
		
		int menu = 0; 
		int	location = -1;
		String [] opciones = {"All", "One"};
		
		if (Singleton_users.a_client.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No data, please create user", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			
			menu = Menus.menu_buttons_edit(opciones, "What will you do like?", "Read");
			
			switch (menu){
			
				case 0:
					for (int i = 0; i < Singleton_users.a_client.size(); i++){
						String cad = "";
						cad = cad + (Singleton_users.a_client.get(i).toString());
						JOptionPane.showMessageDialog(null, cad);
					}
					break;
					
				case 1:
					location = -1;
					client = Ask_UserName.ask_username_client();
					location = Find.Find_client_username(client);
					
					if (location != -1) {
						client = Singleton_users.a_client.get(location);
						JOptionPane.showMessageDialog(null, client.toString());
					} else {
						JOptionPane.showMessageDialog(null, "The user doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
					}
					break;
			}
		}
	}
	
	public static void read_prenium(Prenium prenium) {
		
		int menu = 0; 
		int	location = -1;
		String [] opciones = {"All", "One"};
		
		if (Singleton_users.a_prenium.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No data, please create user", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			
			menu = Menus.menu_buttons_edit(opciones, "What will you do like?", "Read");
			
			switch (menu){
			
				case 0:
					for (int i = 0; i < Singleton_users.a_prenium.size(); i++){
						String cad = "";
						cad = cad + (Singleton_users.a_prenium.get(i).toString());
						JOptionPane.showMessageDialog(null, cad);
					}
					break;
					
				case 1:
					location = -1;
					prenium = Ask_UserName.ask_username_prenium();
					location = Find.Find_prenium_username(prenium);
					
					if (location != -1) {
						prenium = Singleton_users.a_prenium.get(location);
						JOptionPane.showMessageDialog(null, prenium.toString());
					} else {
						JOptionPane.showMessageDialog(null, "The user doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
					}
					break;
			}
		}
	}
	
}
