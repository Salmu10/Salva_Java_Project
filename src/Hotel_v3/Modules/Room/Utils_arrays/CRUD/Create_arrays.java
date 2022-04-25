package Hotel_v3.Modules.Room.Utils_arrays.CRUD;

import javax.swing.JOptionPane;

import Hotel_v3.Modules.Room.Classes.Double_room;
import Hotel_v3.Modules.Room.Classes.Single_room;
import Hotel_v3.Modules.Room.Classes.Singleton;
import Hotel_v3.Modules.Room.Classes.Suite_room;
import Hotel_v3.Modules.Room.Utils.CRUD_Room;
import Hotel_v3.Modules.Room.Utils_arrays.Ask_IDs;
import Hotel_v3.Modules.Room.Utils_arrays.Find;

public class Create_arrays {

	public static void create_single(Single_room single) {
		
		int location = -1;
		single = Ask_IDs.ask_id_single();
		location = Find.Find_single_id(single);
		
		if (location != -1) {
			JOptionPane.showMessageDialog(null, "Couldn't create the single room because it already exists", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			single = (Single_room)CRUD_Room.create_room(0);
			Singleton.a_single.add(single);
		}
	}
	
	public static void create_double(Double_room double_room) {
		
		int location = -1;
		double_room = Ask_IDs.ask_id_double();
		location = Find.Find_double_id(double_room);
		
		if (location != -1) {
			JOptionPane.showMessageDialog(null, "Couldn't create the single room because it already exists", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			double_room = (Double_room)CRUD_Room.create_room(1);
			Singleton.a_double.add(double_room);
		}
	}
	
	public static void create_suite(Suite_room suite) {
		
		int location = -1;
		suite = Ask_IDs.ask_id_suite();
		location = Find.Find_suite_id(suite);
		
		if (location != -1) {
			JOptionPane.showMessageDialog(null, "Couldn't create the single room because it already exists", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			suite = (Suite_room)CRUD_Room.create_room(2);
			Singleton.a_suite.add(suite);
		}
	}
	
}
