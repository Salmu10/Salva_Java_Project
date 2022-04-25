package Hotel_v3.Modules.Room.Utils_arrays.CRUD;


import Hotel_v3.Modules.Room.Utils.CRUD_Room;

import javax.swing.JOptionPane;

import Hotel_v3.Modules.Room.Classes.Double_room;
import Hotel_v3.Modules.Room.Classes.Single_room;
import Hotel_v3.Modules.Room.Classes.Singleton;
import Hotel_v3.Modules.Room.Classes.Suite_room;
import Hotel_v3.Modules.Room.Utils_arrays.Ask_IDs;
import Hotel_v3.Modules.Room.Utils_arrays.Find;

public class Update_arrays {

	public static void update_single(Single_room single) {
		
		int location1 = -1;
		
		if (Singleton.a_single.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No data, please create a room", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			location1 = -1;
			single = Ask_IDs.ask_id_single();
			location1 = Find.Find_single_id(single);
			if (location1 != -1) {
				single = Singleton.a_single.get(location1);
				CRUD_Room.update_room(single);
				Singleton.a_single.set(location1, single);
			} else {
				JOptionPane.showMessageDialog(null, "The room doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public static void update_double(Double_room double_room) {
		
		int location1 = -1;
		
		if (Singleton.a_double.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No data, please create a room", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			location1 = -1;
			double_room = Ask_IDs.ask_id_double();
			location1 = Find.Find_double_id(double_room);
			if (location1 != -1) {
				double_room = Singleton.a_double.get(location1);
				CRUD_Room.update_room(double_room);
				Singleton.a_double.set(location1, double_room);
			} else {
				JOptionPane.showMessageDialog(null, "The room doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public static void update_suite(Suite_room suite) {
		
		int location1 = -1;
		
		if (Singleton.a_suite.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No data, please create a room", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			location1 = -1;
			suite = Ask_IDs.ask_id_suite();
			location1 = Find.Find_suite_id(suite);
			if (location1 != -1) {
				suite = Singleton.a_suite.get(location1);
				CRUD_Room.update_room(suite);
				Singleton.a_suite.set(location1, suite);
			} else {
				JOptionPane.showMessageDialog(null, "The room doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
