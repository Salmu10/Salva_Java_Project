package Hotel_v3;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Hotel_v3.Modules.Room.Classes.Double_room;
import Hotel_v3.Modules.Room.Classes.Suite_room;
import Hotel_v3.Utils.Menus;
import Hotel_v3.Modules.Room.Classes.Single_room;
import Hotel_v3.Modules.Room.Classes.Singleton;
import Hotel_v3.Modules.Room.Utils_arrays.CRUD.Create_arrays;
import Hotel_v3.Modules.Room.Utils_arrays.CRUD.Delete_arrays;
import Hotel_v3.Modules.Room.Utils_arrays.CRUD.Read_arrays;
import Hotel_v3.Modules.Room.Utils_arrays.CRUD.Update_arrays;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] opciones_menu_1 = {"Single", "Double", "Suite", "Eixit"};
		String[] opciones_menu_2 = {"Create", "Read", "Update", "Delete", "Exit"};
		int option = 0, op_menu_2 = 0, op_menu_3, op_menu_4;
		
		Single_room single = null;
		Double_room double_room = null;
		Suite_room suite = null;
		
		Singleton.a_single = new ArrayList <Single_room> ();
		Singleton.a_double = new ArrayList <Double_room> ();
		Singleton.a_suite = new ArrayList <Suite_room> ();
		
		do {
			option = Menus.menu_buttons_edit(opciones_menu_1, "What room do you want", "Hotel Salvador");
			switch (option) {
				case 0:  /// Single Room
					
					do {
						op_menu_2 = Menus.menu_buttons_edit(opciones_menu_2, "What do you want to do?", "Single Room");
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
						op_menu_3 = Menus.menu_buttons_edit(opciones_menu_2, "What do you want to do?", "Double Room");
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
						op_menu_4 = Menus.menu_buttons_edit(opciones_menu_2, "What do you want to do?", "Suite Room");
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
			}
		} while(option != 3);
		
		JOptionPane.showMessageDialog(null, "Thanks for visiting Hotel Salvador");
	}
}
