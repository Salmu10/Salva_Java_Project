package Hotel_v3.Modules.Users.Utils_arrays;


import javax.swing.JOptionPane;

import Hotel_v3.Modules.Users.Classes.Admin;
import Hotel_v3.Modules.Users.Classes.Client;
import Hotel_v3.Modules.Users.Classes.Prenium;
import Hotel_v3.Modules.Users.Classes.Singleton_users;
import Hotel_v3.Modules.Users.Classes.User;

public class Find {
	
	public static int Find_admin_username(Admin admin) { 
		
		int pos = -1;
		
		
		for (int i = 0; i <= (Singleton_users.a_admin.size() - 1); i++) {
			if((Singleton_users.a_admin.get(i).getUser_name()).equals(admin.getUser_name())) {
				if((Singleton_users.a_admin.get(i).getPassword()).equals(admin.getPassword())) {
					return i;
				} else {
					return i;
				}
			}
		}
		return pos;
	}
	
	public static int Find_client_username(Client client) { 
		
		int pos = -1;
		
		for (int i = 0; i <= (Singleton_users.a_client.size() - 1); i++) {
			if((Singleton_users.a_client.get(i).getUser_name()).equals(client.getUser_name())) {
				if((Singleton_users.a_client.get(i).getPassword()).equals(client.getPassword())) {
					return i;
				} else {
					return pos;
				}
			}
		}
		
		return pos;
	}

	public static int Find_prenium_username(Prenium prenium) { 
		
		int pos = -1;
		
		for (int i = 0; i <= (Singleton_users.a_prenium.size() - 1); i++) {
			if((Singleton_users.a_prenium.get(i).getUser_name()).equals(prenium.getUser_name())) {
				if((Singleton_users.a_prenium.get(i).getPassword()).equals(prenium.getPassword())) {
					return i;
				} else {
					return pos;
				}
			}
		}
		
		return pos;
	}
	
	public static int Find_user(User user) { 
		
		int pos = -1;
		int user_type = 0;
		
		for (int i = 0; i <= (Singleton_users.a_admin.size() - 1); i++) {
			if((Singleton_users.a_admin.get(i).getUser_name()).equals(user.getUser_name())) {
				if((Singleton_users.a_admin.get(i).getPassword()).equals(user.getPassword())) {
					user_type = 1;
					return user_type;
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect password", "Error", JOptionPane.ERROR_MESSAGE);
					return user_type;
				}
			}
		}
		
		for (int i = 0; i <= (Singleton_users.a_client.size() - 1); i++) {
			if((Singleton_users.a_client.get(i).getUser_name()).equals(user.getUser_name())) {
				if((Singleton_users.a_client.get(i).getPassword()).equals(user.getPassword())) {
					user_type = 2;
					return user_type;
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect password", "Error", JOptionPane.ERROR_MESSAGE);
					return user_type;
				}
			}
		}
		
		for (int i = 0; i <= (Singleton_users.a_prenium.size() - 1); i++) {
			if((Singleton_users.a_prenium.get(i).getUser_name()).equals(user.getUser_name())) {
				if((Singleton_users.a_prenium.get(i).getPassword()).equals(user.getPassword())) {
					user_type = 3;
					return user_type;
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect password", "Error", JOptionPane.ERROR_MESSAGE);
					return user_type;
				}
			}
		}
		
		return pos;
	}

}
