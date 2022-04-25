package Hotel_v3.Modules.Users.Utils;


import javax.swing.JOptionPane;
import Hotel_v3.Classes.Fecha;
import Hotel_v3.Modules.Users.Utils_arrays.Ask_UserName;
import Hotel_v3.Modules.Users.Classes.User;
import Hotel_v3.Utils.Menus;
import Hotel_v3.Modules.Users.Classes.Admin;
import Hotel_v3.Modules.Users.Classes.Client;
import Hotel_v3.Modules.Users.Classes.Prenium;
import Hotel_v3.Modules.Users.Classes.Singleton_users;

public class CRUD_Users {

	/// CREATE ///
	
	public static User register_user(int i) {
		
		User user = null;

		String user_name = "";
		String password = "";
		
		user_name = Singleton_users.UserName;
		password = Singleton_users.Password;
		String name = Data_CRUD.ask_name("Can you enter your name?", "The name");
		String surname = Data_CRUD.ask_name("Can you enter your first surname?", "The surname");
		String email = Data_CRUD.ask_email();
	 	Fecha fecha_nacimiento = Data_date.ask_fecha_nacimiento("Can you insert your date of birth?", "Date of birth");
	 	
		if(i == 0) {  /// Admin
			
			String DNI = Data_CRUD.ask_dni();
			Fecha fecha_contratacion = Data_date.ask_fecha_contratacion(fecha_nacimiento);
			String mobilephone = Data_CRUD.ask_telephone();
		 	
			user = new Admin(user_name, password, name, surname, email, fecha_nacimiento, DNI, fecha_contratacion, mobilephone);
		}
		
		else if(i == 1) {  /// Client
			
			String DNI = Data_CRUD.ask_dni();
			Boolean sex = Data_CRUD.ask_yes_no("Man", "Woman", "Sex?", "Sex");
			String mobilephone = Data_CRUD.ask_telephone();
			Boolean shopping = Data_CRUD.ask_yes_no("Yes", "No", "Will you buy something??", "Shopping");
			Fecha fecha_alta = Data_date.ask_fecha_alta(fecha_nacimiento);
			
			
			user = new Client(user_name, password, name, surname, email, fecha_nacimiento, DNI, sex, mobilephone, shopping, fecha_alta);
		}
		
		else if(i == 2) {  /// Prenium
			
			String DNI = Data_CRUD.ask_dni();
			Boolean sex = Data_CRUD.ask_yes_no("Man", "Woman", "Sex?", "Sex");
			String mobilephone = Data_CRUD.ask_telephone();
			String address = Data_CRUD.ask_address();
			Boolean shopping = Data_CRUD.ask_yes_no("Yes", "No", "Will you buy something??", "Shopping");
			Fecha fecha_alta = Data_date.ask_fecha_alta(fecha_nacimiento);
			
			user = new Prenium(user_name, password, name, surname, email, fecha_nacimiento, DNI, sex, mobilephone, address, shopping, fecha_alta);
		}
		
		return user;
	}
	
	/// READ ///
	
	public static void read_user(User user) {

		if(user instanceof Admin) {  /// Read Admin
			JOptionPane.showMessageDialog(null, ((Admin)user).toString());
		}
		if(user instanceof Client) {  /// Read Client
			JOptionPane.showMessageDialog(null, ((Client)user).toString());
		}
		if(user instanceof Prenium) {  /// Read Prenium
			JOptionPane.showMessageDialog(null, ((Prenium)user).toString());
		}
	}
	
	/// UPDATE ///
	
	public static User profile_user(User user) {
		
		Admin admin = null;
		Client client = null;
		Prenium prenium = null;
		
		if (user instanceof Admin) {  /// Update Admin profile
			
			String [] opciones = {"User name", "Password", "Name", "Surname", "Email", "Date of birthday", "DNI", "Fecha contratacion", "Mobile phone", "Eixit"};
			String option = Menus.menu_combobox_edit(opciones, "What option do you want to update?", "Admin profile: update");
			
				switch (option) {
			
					case "User name":
						Ask_UserName.set_username_admin(admin);
						break;
						
					case "Password":
						((Admin)user).setPassword(Data_CRUD.ask_password());
						break;
						
					case "Name":
						((Admin)user).setName(Data_CRUD.ask_name("Can you enter your name?", "The name"));
						break;
						
					case "Surname":
						((Admin)user).setSurname(Data_CRUD.ask_name("Can you enter your first surname?", "The surname"));
						break;
						
					case "Email":
						((Admin)user).setEmail(Data_CRUD.ask_email());
						break;
						
					case "Date of birthday":
						((Admin)user).setFecha_nacimiento(Data_date.update_fecha_nacimiento_contratacion(((Admin)user).getFecha_contratacion()));
						break;
						
					case "DNI":
						((Admin)user).setDNI(Data_CRUD.ask_dni());
						break;
						
					case "Fecha contratacion":
						((Admin)user).setFecha_contratacion(Data_date.ask_fecha_contratacion(((Admin)user).getFecha_nacimiento()));
						break;
						
					case "Mobile phone":
						((Admin)user).setMobilephone(Data_CRUD.ask_telephone());
						break;
				}
		}
	 	
		if (user instanceof Client) {  /// Update Client profile

			String [] opciones = {"User name", "Password", "Name", "Surname", "Email", "Date of birthday", "DNI", "Sex", "Mobile phone", "Shopping", "Registration date", "Eixit"};
			String option = Menus.menu_combobox_edit(opciones, "What option do you want to update?", "Client profile: update");
			
			switch (option) {
			
				case "User name":
					Ask_UserName.set_username_client(client);
					break;
					
				case "Password":
					((Client)user).setPassword(Data_CRUD.ask_password());
					break;
					
				case "Name":
					((Client)user).setName(Data_CRUD.ask_name("Can you enter your name?", "The name"));
					break;
					
				case "Surname":
					((Client)user).setSurname(Data_CRUD.ask_name("Can you enter your first surname?", "The surname"));
					break;
					
				case "Email":
					((Client)user).setEmail(Data_CRUD.ask_email());
					break;
					
				case "Date of birthday":
					((Client)user).setFecha_nacimiento(Data_date.update_fecha_nacimiento_alta(((Client)user).getFecha_alta()));
					break;
					
				case "DNI":
					((Client)user).setDNI(Data_CRUD.ask_dni());
					break;
					
				case "Sex":
					((Client)user).setSex(Data_CRUD.ask_yes_no("Man", "Woman", "Sex?", "Sex"));
					break;
					
				case "Mobile phone":
					((Client)user).setMobilephone(Data_CRUD.ask_telephone());
					break;
								
				case "Shopping":
					((Client)user).setShopping(Data_CRUD.ask_yes_no("Yes", "No", "Will you buy something?", "Shopping"));
					break;
					
				case "Registration date":
					((Client)user).setFecha_alta(Data_date.ask_fecha_alta(((Client)user).getFecha_nacimiento()));
					break;
				
			}
		}
		
		if (user instanceof Prenium) {  /// Update Prenium profile
			
			String [] opciones = {"User name", "Password", "Name", "Surname", "Email", "Date of birthday", "DNI", "Sex", "Mobile phone", "Address", "Shopping", "Registration date", "Eixit"};
			String option = Menus.menu_combobox_edit(opciones, "What option do you want to update?", "Prenium profile: update");
			
			switch (option) {
			
				case "User name":
					Ask_UserName.set_username_prenium(prenium);
					break;
					
				case "Password":
					((Prenium)user).setPassword(Data_CRUD.ask_password());
					break;
					
				case "Name":
					((Prenium)user).setName(Data_CRUD.ask_name("Can you enter your name?", "The name"));
					break;
					
				case "Surname":
					((Prenium)user).setSurname(Data_CRUD.ask_name("Can you enter your first surname?", "The surname"));
					break;
					
				case "Email":
					((Prenium)user).setEmail(Data_CRUD.ask_email());
					break;
					
				case "Date of birthday":
					((Prenium)user).setFecha_alta(null);
					break;
					
				case "DNI":
					((Prenium)user).setDNI(Data_CRUD.ask_dni());
					break;
					
				case "Sex":
					((Prenium)user).setSex(Data_CRUD.ask_yes_no("Man", "Woman", "Sex?", "Sex"));
					break;
					
				case "Mobile phone":
					((Prenium)user).setMobilephone(Data_CRUD.ask_telephone());
					break;
					
				case "Address":
					((Prenium)user).setAddress(Data_CRUD.ask_name("Can you enter your address?", "The address"));
					break;
								
				case "Shopping":
					((Prenium)user).setShopping(Data_CRUD.ask_yes_no("Yes", "No", "Will you buy something?", "Shopping"));
					break;
					
				case "Registration date":
					((Prenium)user).setFecha_alta(Data_date.ask_fecha_alta(((Prenium)user).getFecha_nacimiento()));
					break;

			} 
		}

		return user;
	}
	
	/// DELETE ///
	
	public static User delete_user(User user) {
		
		if(user instanceof Admin) {  /// Delete Admin
			user = null;
		}
		if(user instanceof Client) {  /// Delete Client
			user = null;
		}
		if(user instanceof Prenium) {  /// Delete Prenium
			user = null;
		}
		
		JOptionPane.showMessageDialog(null, "The user was deleted");
		
		return user;
	}
	
	
}
