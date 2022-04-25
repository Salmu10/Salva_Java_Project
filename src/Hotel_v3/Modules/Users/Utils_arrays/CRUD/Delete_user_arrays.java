package Hotel_v3.Modules.Users.Utils_arrays.CRUD;

import javax.swing.JOptionPane;

import Hotel_v3.Modules.Users.Classes.Admin;
import Hotel_v3.Modules.Users.Classes.Client;
import Hotel_v3.Modules.Users.Classes.Prenium;
import Hotel_v3.Modules.Users.Classes.Singleton_users;
import Hotel_v3.Modules.Users.Utils_arrays.Ask_UserName;
import Hotel_v3.Modules.Users.Utils_arrays.Find;

public class Delete_user_arrays {
	
	public static void delete_admin(Admin admin) {
		int location = -1;
		
		if(Singleton_users.a_admin.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No data, please create user", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			location = -1;
			admin = Ask_UserName.ask_username_admin();
			location = Find.Find_admin_username(admin);
			if (location != -1) {
				Singleton_users.a_admin.remove(location);
				JOptionPane.showMessageDialog(null, "Deleted");
			} else {
				JOptionPane.showMessageDialog(null, "The user doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static void delete_client(Client client) {
		int location = -1;
		
		if(Singleton_users.a_client.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No data, please create user", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			location = -1;
			client = Ask_UserName.ask_username_client();
			location = Find.Find_client_username(client);
			if (location != -1) {
				Singleton_users.a_client.remove(location);
				JOptionPane.showMessageDialog(null, "Deleted");
			} else {
				JOptionPane.showMessageDialog(null, "The user doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public static void delete_prenium(Prenium prenium) {
		int location = -1;
		
		if(Singleton_users.a_prenium.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No data, please create user", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			location = -1;
			prenium = Ask_UserName.ask_username_prenium();
			location = Find.Find_prenium_username(prenium);
			if (location != -1) {
				Singleton_users.a_prenium.remove(location);
				JOptionPane.showMessageDialog(null, "Deleted");
			} else {
				JOptionPane.showMessageDialog(null, "The user doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
