package Hotel_v3.Modules.Users.Classes;

import Hotel_v3.Classes.Fecha;

public class Client extends User {
	
	/// Atributos ///
	
	private String DNI;
	private Boolean sex;
	private String mobilephone;
	private Boolean shopping;
	private Fecha fecha_alta;
	
	/// Atributos recalculados ///
	
	private int old;
	
	/// CONSTRUCTOR ///
	
	
	public Client(String user_name, String password, String name, String surname, String email, Fecha fecha_nacimiento,
			String DNI, Boolean sex, String mobilephone, Boolean shopping, Fecha fecha_alta) {
		
		super(user_name, password, name, surname, email, fecha_nacimiento);
		this.DNI = DNI;
		this.sex = sex;
		this.mobilephone = mobilephone;
		this.shopping = shopping;
		this.fecha_alta = fecha_alta;
		this.old = this.calcular_antiguedad();
	}

	public Client(String user_name, String password) {
		
		super(user_name, password);
	}

	/// GETTERS AND SETTERS ///
	
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	
	public Boolean getShopping() {
		return shopping;
	}

	public void setShopping(Boolean shopping) {
		this.shopping = shopping;
	}


	public Fecha getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(Fecha fecha_alta) {
		this.fecha_alta = fecha_alta;
		this.old = this.calcular_antiguedad();
	}

	/// Atributos recalculados ///
	
	public int getOld() {
		return old;
	}

	public void setOld(int old) {
		this.old = this.calcular_antiguedad();
	}
	
	/// Funciones para atributos recalculados ///
	
	public int calcular_antiguedad() {
		return this.getFecha_alta().restar_fecha_sistema() * -1;
	}
	
	/// TO STRING ///
		
	@Override
	public String toString() {
			return "Client: " + super.getUser_name() + "\n" + "Password = " + super.getPassword() + "\n" + "Name = " + super.getName() + "\n" + "Surname = " + super.getSurname() + "\n" +
					"Email = " + super.getEmail() + "\n" + "Birth date = " + super.getFecha_nacimiento() + "\n" + "DNI = " + DNI + "\n" + "Sex = " + sex + "\n" + "Mobilephone: " + mobilephone + "\n"
					+ "Shopping = " + shopping + "\n" + "Date of birthday = " + fecha_alta + "\n" + "Old = " + old;
	}
}
