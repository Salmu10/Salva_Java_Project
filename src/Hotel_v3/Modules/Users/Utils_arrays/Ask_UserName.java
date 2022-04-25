package Hotel_v3.Modules.Users.Utils_arrays;

import javax.swing.JOptionPane;

import Hotel_v3.Modules.Users.Classes.Singleton_users;
import Hotel_v3.Modules.Users.Classes.User;
import Hotel_v3.Modules.Users.Classes.Admin;
import Hotel_v3.Modules.Users.Classes.Client;
import Hotel_v3.Modules.Users.Classes.Prenium;
import Hotel_v3.Modules.Users.Utils.Data_CRUD;

public class Ask_UserName {
	
	public static Admin ask_username_admin() {
		
		Singleton_users.UserName = Data_CRUD.ask_username();
		Singleton_users.Password = Data_CRUD.ask_password();
		
		return new Admin(Singleton_users.UserName, Singleton_users.Password);
	}		
	
	public static Client ask_username_client() {
		
		Singleton_users.UserName = Data_CRUD.ask_username();
		Singleton_users.Password = Data_CRUD.ask_password();
		
		return new Client(Singleton_users.UserName, Singleton_users.Password);
	}	
	
	public static Prenium ask_username_prenium() {
		
		Singleton_users.UserName = Data_CRUD.ask_username();
		Singleton_users.Password = Data_CRUD.ask_password();
		
		return new Prenium(Singleton_users.UserName, Singleton_users.Password);
	}
	
	public static User ask_user() {
		
		Singleton_users.UserName = Data_CRUD.ask_username();
		Singleton_users.Password = Data_CRUD.ask_password();
		
		return new User(Singleton_users.UserName, Singleton_users.Password);
	}

	public static void set_username_admin(Admin admin) {
		
		int location = -1;
		admin = ask_username_admin();
		location = Find.Find_admin_username(admin);
		
		if (location != -1) {
			JOptionPane.showMessageDialog(null, "Couldn't register the user name because it already exists", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			admin.setUser_name(Singleton_users.UserName);
		}
	}
	
	public static void set_username_client(Client client) {
		
		int location = -1;
		client = ask_username_client();
		location = Find.Find_client_username(client);
		
		if (location != -1) {
			JOptionPane.showMessageDialog(null, "Couldn't register the user name because it already exists", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			client.setUser_name(Singleton_users.UserName);
		}
	}
	
	public static void set_username_prenium(Prenium prenium) {
		
		int location = -1;
		prenium = ask_username_prenium();
		location = Find.Find_prenium_username(prenium);
		
		if (location != -1) {
			JOptionPane.showMessageDialog(null, "Couldn't register the user name because it already exists", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			prenium.setUser_name(Singleton_users.UserName);
		}
	}
	
	public static void set_username(User user) {
		
		int location = -1;
		user = ask_user();
		location = Find.Find_user(user);
		
		if (location != -1) {
			JOptionPane.showMessageDialog(null, "Couldn't register the user name because it already exists", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			user.setUser_name(Singleton_users.UserName);
		}
	}

}
