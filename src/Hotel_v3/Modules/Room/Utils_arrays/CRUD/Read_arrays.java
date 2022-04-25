package Hotel_v3.Modules.Room.Utils_arrays.CRUD;

import javax.swing.JOptionPane;

import Hotel_v3.Modules.Room.Classes.Double_room;
import Hotel_v3.Modules.Room.Classes.Single_room;
import Hotel_v3.Modules.Room.Classes.Singleton;
import Hotel_v3.Modules.Room.Classes.Suite_room;
import Hotel_v3.Modules.Room.Utils_arrays.Ask_IDs;
import Hotel_v3.Modules.Room.Utils_arrays.Find;
import Hotel_v3.Utils.Menus;

public class Read_arrays {

	public static void read_single(Single_room single) {
		
		int menu = 0; 
		int	location = -1;
		String [] opciones = {"All", "One"};
		
		if (Singleton.a_single.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No data, please create a room", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			
			menu = Menus.menu_buttons_edit(opciones, "What will you do like?", "Read");
			
			switch (menu){
			
				case 0:
					for (int i = 0; i < Singleton.a_single.size(); i++){
						String cad = "";
						cad = cad + (Singleton.a_single.get(i).toString());
						JOptionPane.showMessageDialog(null, cad);
					}
					break;
					
				case 1:
					location = -1;
					single = Ask_IDs.ask_id_single();
					location = Find.Find_single_id(single);
					
					if (location != -1) {
						single = Singleton.a_single.get(location);
						JOptionPane.showMessageDialog(null, single.toString());
					} else {
						JOptionPane.showMessageDialog(null, "The room doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
					}
					break;
			}
		}
	}
	
	public static void read_double(Double_room double_room) {
		
		int menu = 0; 
		int	location = -1;
		String [] opciones = {"All", "One"};
		
		if (Singleton.a_double.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No data, please create a room", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			
			menu = Menus.menu_buttons_edit(opciones, "What will you do like?", "Read");
			
			switch (menu){
			
				case 0:
					for (int i = 0; i < Singleton.a_double.size(); i++){
						String cad = "";
						cad = cad + (Singleton.a_double.get(i).toString());
						JOptionPane.showMessageDialog(null, cad);
					}
					break;
					
				case 1:
					location = -1;
					double_room = Ask_IDs.ask_id_double();
					location = Find.Find_double_id(double_room);
					
					if (location != -1) {
						double_room = Singleton.a_double.get(location);
						JOptionPane.showMessageDialog(null, double_room.toString());
					} else {
						JOptionPane.showMessageDialog(null, "The room doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
					}
					break;
			}
		}
	}
	
	public static void read_suite(Suite_room suite) {
		
		int menu = 0; 
		int	location = -1;
		String [] opciones = {"All", "One"};
		
		if (Singleton.a_suite.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No data, please create a room", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			
			menu = Menus.menu_buttons_edit(opciones, "What will you do like?", "Read");
			
			switch (menu){
			
				case 0:
					for (int i = 0; i < Singleton.a_suite.size(); i++){
						String cad = "";
						cad = cad + (Singleton.a_suite.get(i).toString());
						JOptionPane.showMessageDialog(null, cad);
					}
					break;
					
				case 1:
					location = -1;
					suite = Ask_IDs.ask_id_suite();
					location = Find.Find_suite_id(suite);
					
					if (location != -1) {
						suite = Singleton.a_suite.get(location);
						JOptionPane.showMessageDialog(null, suite.toString());
					} else {
						JOptionPane.showMessageDialog(null, "The room doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
					}
					break;
			}
		}
	}
	
}
