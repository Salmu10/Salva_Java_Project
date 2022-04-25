package Hotel_v3.Modules.Room.Utils;

import javax.swing.JOptionPane;
import Hotel_v3.Modules.Room.Classes.Room;
import Hotel_v3.Classes.Fecha;
import Hotel_v3.Modules.Room.Classes.Double_room;
import Hotel_v3.Modules.Room.Classes.Suite_room;
import Hotel_v3.Modules.Room.Utils_arrays.Ask_IDs;
import Hotel_v3.Utils.Menus;
import Hotel_v3.Modules.Room.Classes.Single_room;
import Hotel_v3.Modules.Room.Classes.Singleton;

public class CRUD_Room {

	/// CREATE ///
	
	public static Room create_room(int i) {
		
		Room room = null;

		String id = "";
		
		id = Singleton.ID;
		String m2 = Data_CRUD.ask_m2();
		String capacity = Data_CRUD.ask_capacity();
		Boolean available = Data_CRUD.ask_yes_no("Yes", "No", "Available?", "Available");
		Boolean wifi = Data_CRUD.ask_yes_no("Yes", "No", "Wifi?", "Wifi");
	 	Fecha f_inicio = Data_date.ask_fecha_inicio("Can you insert the start date?", "Start Date");
	 	Fecha f_fin = Data_date.ask_fecha_fin(f_inicio);
	 	
		if(i == 0) {  /// Single
			
			Boolean tv = Data_CRUD.ask_yes_no("Yes", "No", "Tv?", "TV");
			String excursion = Data_CRUD.ask_name("What excursión do you want to do?", "Excursion");
		 	
			room = new Single_room(id, m2, capacity, available, wifi, f_inicio, f_fin, tv, excursion);
		}
		
		else if(i == 1) {  /// Double
			
			Boolean tv = Data_CRUD.ask_yes_no("Yes", "No", "Tv?", "TV");
			Boolean bed_type = Data_CRUD.ask_yes_no("Singles", "Double", "Bed type?", "Bed");
			Boolean spa = Data_CRUD.ask_yes_no("Yes", "No", "Spa?", "SPA");
			
			Fecha start_date_spa = null;
			Fecha end_date_spa = null;
			
			if (spa == true) {
				start_date_spa = Data_date.ask_fecha_sub_inicio(f_inicio, f_fin);
				end_date_spa = Data_date.ask_fecha_sub_fin(start_date_spa, f_fin);
			}
			
			room = new Double_room(id, m2, capacity, available, wifi, f_inicio, f_fin, tv, bed_type, spa, start_date_spa, end_date_spa);
		}
		
		else if(i == 2) {  /// Suite
			
			Boolean champagne = Data_CRUD.ask_yes_no("Yes", "No", "Champagne?", "Champagne");
			Boolean bed_type = Data_CRUD.ask_yes_no("Singles", "Double", "Bed type?", "Bed");
			Boolean jacuzzi = Data_CRUD.ask_yes_no("Yes", "No", "Jacuzzi?", "Jacuzzi");
			Boolean spa = Data_CRUD.ask_yes_no("Yes", "No", "Spa?", "SPA");

			Fecha start_date_spa = null;
			Fecha end_date_spa = null;
			
			if (spa == true) {
				start_date_spa = Data_date.ask_fecha_sub_inicio(f_inicio, f_fin);
				end_date_spa = Data_date.ask_fecha_sub_fin(start_date_spa, f_fin);
			}
		 	
			room = new Suite_room(id, m2, capacity, available, wifi, f_inicio, f_fin, champagne, bed_type, jacuzzi, spa, start_date_spa, end_date_spa);
		}
		
		return room;
	}
	
	/// READ ///
	
	public static void read_room(Room room) {

		if(room instanceof Single_room) {  /// Read Single Room
			JOptionPane.showMessageDialog(null, ((Single_room)room).toString());
		}
		if(room instanceof Double_room) {  /// Read Double Room
			JOptionPane.showMessageDialog(null, ((Double_room)room).toString());
		}
		if(room instanceof Suite_room) {  /// Read Suite Room
			JOptionPane.showMessageDialog(null, ((Suite_room)room).toString());
		}
	}
	
	/// UPDATE ///
	
	public static Room update_room(Room room) {
		
		Single_room single = null;
		Double_room double_room = null;
		Suite_room suite = null;
		
		if (room instanceof Single_room) {  /// Update Single Room
			
			String [] opciones = {"Id", "M2", "Capacity", "Available", "Wifi", "Start date", "End date", "Tv", "Excursion", "Eixit"};
			String option = Menus.menu_combobox_edit(opciones, "What option do you want to update?", "Single room update");
			
			switch (option) {
			
			case "Id":
				Ask_IDs.set_ID_single(single);
				break;
				
			case "M2":
				((Single_room)room).setM2(Data_CRUD.ask_m2());
				break;
				
			case"Capacity":
				((Single_room)room).setCapacity(Data_CRUD.ask_capacity());
				break;
				
			case "Available":
				((Single_room)room).setAvailable(Data_CRUD.ask_yes_no("Yes", "No", "Available?", "Available"));
				break;
				
			case"Wifi":
				((Single_room)room).setWifi(Data_CRUD.ask_yes_no("Yes", "No", "Wifi?", "Wifi"));
				break;
				
			case "Start date":
				((Single_room)room).setF_inicio(Data_date.update_fecha_inicio(((Single_room)room).getF_fin()));
				break;
				
			case "End date":
				((Single_room)room).setF_fin(Data_date.ask_fecha_fin(((Single_room)room).getF_inicio()));
				break;
				
			case "Tv":
				((Single_room)room).setTv(Data_CRUD.ask_yes_no("Yes", "No", "Tv?", "TV"));
				break;
				
			case "Excursion":
				((Single_room)room).setExcursion(Data_CRUD.ask_name("What excursión do you want to do?", "Excursion"));
				break;
			}
		}
	 	
		if (room instanceof Double_room) {  /// Update Double Room

			String [] opciones = {"Id", "M2", "Capacity", "Available", "Wifi", "Start date", "End date", "Tv", "Bed type", "Spa", "Start date spa", "End date spa", "Eixit"};
			String option = Menus.menu_combobox_edit(opciones, "What option do you want to update?", "Double room update");
			
			switch (option) {
			
			case "Id":
				Ask_IDs.set_ID_double(double_room);
				break;
				
			case "M2":
				((Double_room)room).setM2(Data_CRUD.ask_m2());
				break;
				
			case"Capacity":
				((Double_room)room).setCapacity(Data_CRUD.ask_capacity());
				break;
				
			case "Available":
				((Double_room)room).setAvailable(Data_CRUD.ask_yes_no("Yes", "No", "Available?", "Available"));
				break;
				
			case"Wifi":
				((Double_room)room).setWifi(Data_CRUD.ask_yes_no("Yes", "No", "Wifi?", "Wifi"));
				break;
				
			case "Start date":
				if (((Double_room)room).getSpa() == false) {
					((Double_room)room).setF_inicio(Data_date.update_fecha_inicio(((Double_room)room).getF_fin()));
				} else {
					Fecha restriccion = Data_date.update_fecha_inicio_sub(((Double_room)room).getStart_date_spa(), ((Double_room)room).getF_fin());
					((Double_room)room).setF_inicio(restriccion);
				}
				break;
				
			case "End date":
				((Double_room)room).setF_fin(Data_date.ask_fecha_fin(((Double_room)room).getF_inicio()));
				break;
				
			case "Tv":
				((Double_room)room).setTv(Data_CRUD.ask_yes_no("Yes", "No", "Tv?", "TV"));
				break;
				
			case "Bed type":
				((Double_room)room).setBed_type(Data_CRUD.ask_yes_no("Singles", "Double", "Bed type?", "Bed"));
				break;
				
			case "Spa":
				((Double_room)room).setSpa(Data_CRUD.ask_yes_no("Yes", "No", "Spa?", "SPA"));
				if (((Double_room)room).getSpa() == true) {
					Fecha fechas_estancia = Data_date.ask_fecha_sub_inicio(((Double_room)room).getF_inicio(), ((Double_room)room).getF_fin());
					((Double_room)room).setStart_date_spa(fechas_estancia);
					Fecha fechas_estancia_2 = Data_date.ask_fecha_sub_fin(((Double_room)room).getStart_date_spa(), ((Double_room)room).getF_fin());
					((Double_room)room).setEnd_date_spa(fechas_estancia_2);
				}
				break;
				
			case "Start date spa":
				if (((Double_room)room).getSpa() == false) {
					JOptionPane.showMessageDialog(null, "You have to enable the SPA", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					Fecha fechas_estancia = Data_date.ask_fecha_sub_inicio(((Double_room)room).getF_inicio(), ((Double_room)room).getF_fin());
					((Double_room)room).setStart_date_spa(fechas_estancia);
				}
				break;
				
			case "End date spa":
				if (((Double_room)room).getSpa() == false) {
					JOptionPane.showMessageDialog(null, "You have to enable the SPA", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					Fecha fechas_estancia_2 = Data_date.ask_fecha_sub_fin(((Double_room)room).getStart_date_spa(), ((Double_room)room).getF_fin());
					((Double_room)room).setEnd_date_spa(fechas_estancia_2);
				}
				break;
			}
		}
		
		if (room instanceof Suite_room) {  /// Update Suite Room
			
			String [] opciones = {"Id", "M2", "Capacity", "Available", "Wifi", "Start date", "End date", "Champagne", "Bed type", "Jacuzzi", "Spa", "Start date spa", "End date spa", "Eixit"};
			String option = Menus.menu_combobox_edit(opciones, "What option do you want to update?", "Suite room update");
			
			switch (option) {
			
			case "Id":
				Ask_IDs.set_ID_suite(suite);
				break;
				
			case "M2":
				((Suite_room)room).setM2(Data_CRUD.ask_m2());
				break;
				
			case"Capacity":
				((Suite_room)room).setCapacity(Data_CRUD.ask_capacity());
				break;
				
			case "Available":
				((Suite_room)room).setAvailable(Data_CRUD.ask_yes_no("Yes", "No", "Available?", "Available"));
				break;
				
			case"Wifi":
				((Suite_room)room).setWifi(Data_CRUD.ask_yes_no("Yes", "No", "Wifi?", "Wifi"));
				break;
				
			case "Start date":
				if (((Suite_room)room).getSpa() == false) {
					((Suite_room)room).setF_inicio(Data_date.update_fecha_inicio(((Suite_room)room).getF_fin()));
				} else {
					Fecha restriccion = Data_date.update_fecha_inicio_sub(((Suite_room)room).getStart_date_spa(), ((Suite_room)room).getF_fin());
					((Suite_room)room).setF_inicio(restriccion);
				}
				break;
				
			case "End date":
				((Suite_room)room).setF_fin(Data_date.ask_fecha_fin(((Suite_room)room).getF_inicio()));
				break;
				
			case "Champagne":
				((Suite_room)room).setChampagne(Data_CRUD.ask_yes_no("Yes", "No", "Champagne?", "Champagne"));
				break;
				
			case "Bed type":
				((Suite_room)room).setBed_type(Data_CRUD.ask_yes_no("Singles", "Double", "Bed type?", "Bed"));
				break;
				
			case "Jacuzzi":
				((Suite_room)room).setJacuzzi(Data_CRUD.ask_yes_no("Yes", "No", "Jacuzzi?", "Jacuzzi"));
				break;

			case "Spa":
				((Suite_room)room).setSpa(Data_CRUD.ask_yes_no("Yes", "No", "Spa?", "SPA"));
				if (((Suite_room)room).getSpa() == true) {
					Fecha fechas_estancia = Data_date.ask_fecha_sub_inicio(((Suite_room)room).getF_inicio(), ((Suite_room)room).getF_fin());
					((Suite_room)room).setStart_date_spa(fechas_estancia);
					Fecha fechas_estancia_2 = Data_date.ask_fecha_sub_fin(((Suite_room)room).getStart_date_spa(), ((Suite_room)room).getF_fin());
					((Suite_room)room).setEnd_date_spa(fechas_estancia_2);
				}
				break;
				
			case "Start date spa":
				if (((Suite_room)room).getSpa() == false) {
					JOptionPane.showMessageDialog(null, "You have to enable the SPA", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					Fecha fechas_estancia = Data_date.ask_fecha_sub_inicio(((Suite_room)room).getF_inicio(), ((Suite_room)room).getF_fin());
					((Suite_room)room).setStart_date_spa(fechas_estancia);
				}
				break;
				
			case "End date spa":
				if (((Suite_room)room).getSpa() == false) {
					JOptionPane.showMessageDialog(null, "You have to enable the SPA", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					Fecha fechas_estancia_2 = Data_date.ask_fecha_sub_fin(((Suite_room)room).getStart_date_spa(), ((Suite_room)room).getF_fin());
					((Suite_room)room).setEnd_date_spa(fechas_estancia_2);
				}
				break;
			} 
		}

		return room;
	}
	
	/// DELETE ///
	
	public static Room delete_room(Room room) {
		
		if(room instanceof Single_room) {  /// Read Single Room
			room = null;
		}
		if(room instanceof Double_room) {  /// Read Double Room
			room = null;
		}
		if(room instanceof Suite_room) {  /// Read Suite Room
			room = null;
		}
		
		JOptionPane.showMessageDialog(null, "The room was deleted");
		
		return room;
	}
	
	
}
