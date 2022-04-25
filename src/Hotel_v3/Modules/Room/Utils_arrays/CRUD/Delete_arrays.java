package Hotel_v3.Modules.Room.Utils_arrays.CRUD;

import javax.swing.JOptionPane;

import Hotel_v3.Modules.Room.Classes.Double_room;
import Hotel_v3.Modules.Room.Classes.Single_room;
import Hotel_v3.Modules.Room.Classes.Singleton;
import Hotel_v3.Modules.Room.Classes.Suite_room;
import Hotel_v3.Modules.Room.Utils_arrays.Ask_IDs;
import Hotel_v3.Modules.Room.Utils_arrays.Find;

public class Delete_arrays {
	
	public static void delete_single(Single_room single) {
		int location = -1;
		
		if(Singleton.a_single.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No data, please create a room", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			location = -1;
			single = Ask_IDs.ask_id_single();
			location = Find.Find_single_id(single);
			if (location != -1) {
				Singleton.a_single.remove(location);
				JOptionPane.showMessageDialog(null, "Deleted");
			} else {
				JOptionPane.showMessageDialog(null, "The room doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static void delete_double(Double_room double_room) {
		int location = -1;
		
		if(Singleton.a_double.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No data, please create a room", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			location = -1;
			double_room = Ask_IDs.ask_id_double();
			location = Find.Find_double_id(double_room);
			if (location != -1) {
				Singleton.a_double.remove(location);
				JOptionPane.showMessageDialog(null, "Deleted");
			} else {
				JOptionPane.showMessageDialog(null, "The room doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public static void delete_suite(Suite_room suite) {
		int location = -1;
		
		if(Singleton.a_suite.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No data, please create a room", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			location = -1;
			suite = Ask_IDs.ask_id_suite();
			location = Find.Find_suite_id(suite);
			if (location != -1) {
				Singleton.a_suite.remove(location);
				JOptionPane.showMessageDialog(null, "Deleted");
			} else {
				JOptionPane.showMessageDialog(null, "The room doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
