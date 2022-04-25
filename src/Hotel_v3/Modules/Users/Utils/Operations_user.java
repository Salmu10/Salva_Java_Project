package Hotel_v3.Modules.Users.Utils;


import javax.swing.JOptionPane;

import Hotel_v3.Modules.Room.Classes.Double_room;
import Hotel_v3.Modules.Room.Classes.Single_room;
import Hotel_v3.Modules.Room.Classes.Suite_room;
import Hotel_v3.Modules.Room.Utils_arrays.CRUD.Create_arrays;
import Hotel_v3.Modules.Room.Utils_arrays.CRUD.Delete_arrays;
import Hotel_v3.Modules.Room.Utils_arrays.CRUD.Read_arrays;
import Hotel_v3.Modules.Room.Utils_arrays.CRUD.Update_arrays;
import Hotel_v3.Modules.Users.Classes.Admin;
import Hotel_v3.Modules.Users.Classes.Client;
import Hotel_v3.Modules.Users.Classes.Prenium;
import Hotel_v3.Modules.Users.Classes.Singleton_users;
import Hotel_v3.Modules.Users.Classes.User;
import Hotel_v3.Modules.Users.Utils_arrays.Ask_UserName;
import Hotel_v3.Modules.Users.Utils_arrays.Find;
import Hotel_v3.Modules.Users.Utils_arrays.CRUD.Profile_user_arrays;
import Hotel_v3.Utils.Menus;

public class Operations_user {
	
	public static void login(User user) {
	
		int user_type = -1;
		
		if ((Singleton_users.a_admin.isEmpty()) && (Singleton_users.a_client.isEmpty()) && (Singleton_users.a_prenium.isEmpty())) {
			JOptionPane.showMessageDialog(null, "No data, please create user", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			user_type = -1;
			user = Ask_UserName.ask_user();
			user_type = Find.Find_user(user);
			if (user_type != -1) { 
				if (user_type == 1) {
					menu_admin();
				}
				if (user_type == 2) {
					menu_client();
				}
				if (user_type == 3) {
					menu_prenium();
				}
			} else {
				JOptionPane.showMessageDialog(null, "The user doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
		
	/// Menu Admin
	
	public static void menu_admin() {
		
		String[] opciones_menu_1 = {"Single", "Double", "Suite", "Profile", "Log out"};
		String[] opciones_menu_2 = {"Create", "Read", "Update", "Delete", "Exit"};
		int option = 0, op_menu_2 = 0, op_menu_3 = 0, op_menu_4 = 0;
		
		Single_room single = null;
		Double_room double_room = null;
		Suite_room suite = null;
		Admin admin = null;
		
		do {
			option = Menus.menu_buttons_edit(opciones_menu_1, "What room do you want", "Hotel Salvador: Admin");
			switch (option) {
				case 0:  /// Single Room
					
					do {
						op_menu_2 = Menus.menu_buttons_edit(opciones_menu_2, "What do you want to do?", "Single Room Admin");
							switch (op_menu_2) {
								case 0:  /// Create single room
									Create_arrays.create_single(single);
									break;
									
								case 1:  /// Read single room
									Read_arrays.read_single(single);
									break;
									
								case 2:  /// Update single room
									Update_arrays.update_single(single);
									break;
									
								case 3: /// Delete single room
									Delete_arrays.delete_single(single);
									break;
							}
					} while(op_menu_2 != 4);
				break;
				
				case 1:  /// Double Room
					
					do {
						op_menu_3 = Menus.menu_buttons_edit(opciones_menu_2, "What do you want to do?", "Double Room Admin");
							switch (op_menu_3) {
								case 0:  /// Create double room
									Create_arrays.create_double(double_room);
									break;
									
								case 1:  /// Read double room
									Read_arrays.read_double(double_room);
									break;
									
								case 2:  /// Update double room
									Update_arrays.update_double(double_room);
									break;
									
								case 3: /// Delete double room
									Delete_arrays.delete_double(double_room);
									break;
							}
					} while(op_menu_3 != 4);
					break;
					
				case 2:   /// Suite Room
					
					do {
						op_menu_4 = Menus.menu_buttons_edit(opciones_menu_2, "What do you want to do?", "Suite Room Admin");
							switch (op_menu_4) {
								case 0:  /// Create suite room
									Create_arrays.create_suite(suite);
									break;
									
								case 1:  /// Read suite room
									Read_arrays.read_suite(suite);
									break;
									
								case 2:  /// Update suite room
									Update_arrays.update_suite(suite);
									break;
									
								case 3: /// Delete suite room
									Delete_arrays.delete_suite(suite);
									break;
							}
					} while(op_menu_4 != 4);
				break;
				
				case 3:   /// Profile Admin
					Profile_user_arrays.profile_admin(admin);
				break;
			}
		} while(option != 4);
	}
	
	/// Menu Client
	
	public static void menu_client() {
		
		String[] opciones_menu_1 = {"Single", "Double", "Suite", "Profile", "Log out"};
		String[] opciones_menu_2 = {"Read", "Exit"};
		int option = 0, op_menu_2 = 0, op_menu_3 = 0, op_menu_4 = 0;
		
		Single_room single = null;
		Double_room double_room = null;
		Suite_room suite = null;
		Client client = null;
		
		do {
			option = Menus.menu_buttons_edit(opciones_menu_1, "What room do you want", "Hotel Salvador: Client");
			switch (option) {
				case 0:  /// Single Room
					
					do {
						op_menu_2 = Menus.menu_buttons_edit(opciones_menu_2, "What do you want to do?", "Single Room Client");
							switch (op_menu_2) {
								case 0:  /// Read single room
									Read_arrays.read_single(single);
									break;
							}
					} while(op_menu_2 != 1);
				break;
				
				case 1:  /// Double Room
					
					do {
						op_menu_3 = Menus.menu_buttons_edit(opciones_menu_2, "What do you want to do?", "Double Room Client");
							switch (op_menu_3) {
								case 0:  /// Read double room
									Read_arrays.read_double(double_room);
									break;
							}
					} while(op_menu_3 != 1);
					break;
					
				case 2:   /// Suite Room
					
					do {
						op_menu_4 = Menus.menu_buttons_edit(opciones_menu_2, "What do you want to do?", "Suite Room Client");
							switch (op_menu_4) {
								case 0:  /// Read suite room
									Read_arrays.read_suite(suite);
									break;

							}
					} while(op_menu_4 != 1);
				break;
				
				case 3:   /// Profile Client					
					Profile_user_arrays.profile_client(client);
				break;
			}
		} while(option != 4);
	}
	
	/// Menu Register
	
	public static void menu_prenium() {
		
		String[] opciones_menu_1 = {"Single", "Double", "Suite", "Profile", "Log out"};
		String[] opciones_menu_2 = {"Read", "Update", "Exit"};
		int option = 0, op_menu_2 = 0, op_menu_3 = 0, op_menu_4 = 0;
		
		Single_room single = null;
		Double_room double_room = null;
		Suite_room suite = null;
		Prenium prenium = null;

		do {
			option = Menus.menu_buttons_edit(opciones_menu_1, "What room do you want", "Hotel Salvador: Prenium");
			switch (option) {
				case 0:  /// Single Room
					
					do {
						op_menu_2 = Menus.menu_buttons_edit(opciones_menu_2, "What do you want to do?", "Single Room Prenium");
							switch (op_menu_2) {									
								case 0:  /// Read single room
									Read_arrays.read_single(single);
									break;
									
								case 1:  /// Update single room
									Update_arrays.update_single(single);
									break;
							}
					} while(op_menu_2 != 2);
				break;
				
				case 1:  /// Double Room
					
					do {
						op_menu_3 = Menus.menu_buttons_edit(opciones_menu_2, "What do you want to do?", "Double Room Prenium");
							switch (op_menu_3) {
								case 0:  /// Read double room
									Read_arrays.read_double(double_room);
									break;
									
								case 1:  /// Update double room
									Update_arrays.update_double(double_room);
									break;
							}
					} while(op_menu_3 != 2);
					break;
					
				case 2:   /// Suite Room
					
					do {
						op_menu_4 = Menus.menu_buttons_edit(opciones_menu_2, "What do you want to do?", "Suite Room Prenium");
							switch (op_menu_4) {
								case 0:  /// Read suite room
									Read_arrays.read_suite(suite);
									break;
									
								case 1:  /// Update suite room
									Update_arrays.update_suite(suite);
									break;
							}
					} while(op_menu_4 != 2);
				break;
				
				case 3:   /// Profile Prenium					
					Profile_user_arrays.profile_prenium(prenium);
				break;
			}
		} while(option != 4);
	}
	

}
