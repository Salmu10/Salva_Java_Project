package Hotel_v3.Modules.Users.Classes;

import Hotel_v3.Classes.Fecha;

public class User {
	
	private String user_name;
	private String password;
	private String name;
	private String surname;
	private String email;
	private Fecha fecha_nacimiento;
	
	/// CONSTRUCTOR ///
	
	public User(String user_name, String password, String name, String surname, String email, Fecha fecha_nacimiento) {
		
		super();
		this.user_name = user_name;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.fecha_nacimiento = fecha_nacimiento;
	}
	
	public User(String user_name, String password) {
		
		super();
		this.user_name = user_name;
		this.password = password;
	}
	
	/// GETTERS AND SETTERS ///

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Fecha getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Fecha fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	/// TO STRING ///
	
	@Override
	public String toString() {
		return "User [user_name=" + user_name + ", password=" + password + ", name=" + name + ", surname=" + surname
				+ ", email=" + email + ", fecha_nacimiento=" + fecha_nacimiento + "]";
	}
	

}
