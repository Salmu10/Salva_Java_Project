package Hotel_v3.Modules.Users.Classes;


import Hotel_v3.Classes.Fecha;

public class Admin extends User {
	
	/// Atributos ///
	
	private String DNI;
	private Fecha fecha_contratacion;
	private String mobilephone;
	
	/// Atributos recalculados ///
	
	private int old;

	/// CONSTRUCTOR ///
	
	public Admin(String user_name, String password, String name, String surname, String email, Fecha fecha_nacimiento,
			String DNI, Fecha fecha_contratacion, String mobilephone) {
		
		super(user_name, password, name, surname, email, fecha_nacimiento);
		this.DNI = DNI;
		this.fecha_contratacion = fecha_contratacion;
		this.mobilephone = mobilephone;
		this.old = this.calcular_antiguedad();
	}

	public Admin(String user_name, String password) {
		
		super(user_name, password);
	}

	/// GETTERS AND SETTERS ///
	
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public Fecha getFecha_contratacion() {
		return fecha_contratacion;
	}

	public void setFecha_contratacion(Fecha fecha_contratacion) {
		this.fecha_contratacion = fecha_contratacion;
		this.old = this.calcular_antiguedad();
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
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
		return this.getFecha_contratacion().restar_fecha_sistema() * -1;
	}

	/// TO STRING ///

	@Override
	public String toString() {
		return "Admin: " + this.getUser_name() + "\n" + "Password = " + super.getPassword() + "\n" + "Name = " + super.getName() + "\n" + "Surname = " + super.getSurname() + "\n" +
				"Email = " + super.getEmail() + "\n" + "Birth date = " + super.getFecha_nacimiento() + "\n" + "DNI = " + DNI + "\n" + "Date of hiring: " + fecha_contratacion + "\n" + "Mobilephone: " + mobilephone;
	}
}
