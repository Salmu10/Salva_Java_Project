package Hotel_v3.Modules.Room.Utils_arrays;

import Hotel_v3.Modules.Room.Classes.Double_room;
import Hotel_v3.Modules.Room.Classes.Single_room;
import Hotel_v3.Modules.Room.Classes.Singleton;
import Hotel_v3.Modules.Room.Classes.Suite_room;

public class Find {
	
	public static int Find_single_id(Single_room single) { 
		
		int pos = -1;
		
		for (int i = 0; i <= (Singleton.a_single.size() - 1); i++) {
			if((Singleton.a_single.get(i).getId()).equals(single.getId())) {
				return i;
			}
		}
		return pos;
	}
	
	public static int Find_double_id(Double_room double_room) { 
		
		int pos = -1;
		
		for (int i = 0; i <= (Singleton.a_double.size() - 1); i++) {
			if((Singleton.a_double.get(i).getId()).equals(double_room.getId())) {
				return i;
			}
		}
		
		return pos;
	}

	public static int Find_suite_id(Suite_room suite) { 
		
		int pos = -1;
		
		for (int i = 0; i <= (Singleton.a_suite.size() - 1); i++) {
			if((Singleton.a_suite.get(i).getId()).equals(suite.getId())) {
				return i;
			}
		}
		
		return pos;
	}

}
