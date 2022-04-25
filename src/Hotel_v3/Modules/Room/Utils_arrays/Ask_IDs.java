package Hotel_v3.Modules.Room.Utils_arrays;

import javax.swing.JOptionPane;

import Hotel_v3.Modules.Room.Classes.Double_room;
import Hotel_v3.Modules.Room.Classes.Single_room;
import Hotel_v3.Modules.Room.Classes.Singleton;
import Hotel_v3.Modules.Room.Classes.Suite_room;
import Hotel_v3.Modules.Room.Utils.Data_CRUD;

public class Ask_IDs {
	
	public static Single_room ask_id_single() {
		
		Singleton.ID = Data_CRUD.ask_ID();
		
		return new Single_room(Singleton.ID);
	}		
	
	public static Double_room ask_id_double() {
		
		Singleton.ID = Data_CRUD.ask_ID();
		
		return new Double_room(Singleton.ID);
	}	
	
	public static Suite_room ask_id_suite() {
		
		Singleton.ID = Data_CRUD.ask_ID();
		
		return new Suite_room(Singleton.ID);
	}		
	
	public static void set_ID_single(Single_room single){
		int location = -1;
		single = ask_id_single();
		location = Find.Find_single_id(single);
		
		if (location != -1) {
			JOptionPane.showMessageDialog(null, "Couldn't update the ID because it already exists", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			single.setId(Singleton.ID);
		}
	}
	
	public static void set_ID_double(Double_room double_room){
		int location = -1;
		double_room = ask_id_double();
		location = Find.Find_double_id(double_room);
		if (location != -1) {
			JOptionPane.showMessageDialog(null, "Couldn't update the ID because it already exists", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			double_room.setId(Singleton.ID);
		}
	}
	
	public static void set_ID_suite(Suite_room suite){
		int location = -1;
		suite = ask_id_suite();
		location = Find.Find_suite_id(suite);
		if (location != -1) {
			JOptionPane.showMessageDialog(null, "Couldn't update the ID because it already exists", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			suite.setId(Singleton.ID);
		}
	}

}
