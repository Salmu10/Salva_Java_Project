package Hotel_v3.Modules.Users.Utils_arrays.CRUD;

import javax.swing.JOptionPane;

import Hotel_v3.Modules.Users.Classes.Admin;
import Hotel_v3.Modules.Users.Classes.Client;
import Hotel_v3.Modules.Users.Classes.Prenium;
import Hotel_v3.Modules.Users.Classes.Singleton_users;
import Hotel_v3.Modules.Users.Classes.User;
import Hotel_v3.Modules.Users.Utils.CRUD_Users;
import Hotel_v3.Modules.Users.Utils_arrays.Ask_UserName;
import Hotel_v3.Modules.Users.Utils_arrays.Find;

public class Register_user_arrays {

	public static void register_admin(Admin admin, User user) {
		
		int location = -1;
		user = Ask_UserName.ask_user();
		location = Find.Find_user(user);
		
		if (location != -1) {
			JOptionPane.showMessageDialog(null, "Couldn't create the admin because it already exists", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			admin = (Admin)CRUD_Users.register_user(0);
			Singleton_users.a_admin.add(admin);
		}
	}
	
	public static void register_client(Client client, User user) {
		
		int location = -1;
		user = Ask_UserName.ask_user();
		location = Find.Find_user(user);

		
		if (location != -1) {
			JOptionPane.showMessageDialog(null, "Couldn't create the client because it already exists", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			client = (Client)CRUD_Users.register_user(1);
			Singleton_users.a_client.add(client);
		}
	}
	
	public static void register_prenium(Prenium prenium, User user) {
		
		int location = -1;
		user = Ask_UserName.ask_user();
		location = Find.Find_user(user);
		
		if (location != -1) {
			JOptionPane.showMessageDialog(null, "Couldn't create the prenium client because it already exists", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			prenium = (Prenium)CRUD_Users.register_user(2);
			Singleton_users.a_prenium.add(prenium);
		}
	}
}
