package Hotel_v3.Modules.Room.Classes;

import Hotel_v3.Classes.Fecha;

public abstract class Room {
	
	private String id;
	private String m2;
	private String capacity;
	private Boolean available;
	private Boolean wifi;
	private Fecha f_inicio;
	private Fecha f_fin;
	
	/// CONSTRUCTOR ///
	
	public Room (String id, String m2, String capacity, Boolean available, Boolean wifi, Fecha f_inicio, Fecha f_fin) {
		
		super();
		this.id = id;
		this.m2 = m2;
		this.capacity = capacity;
		this.available = available;
		this.wifi = wifi;
		this.f_inicio = f_inicio;
		this.f_fin = f_fin;
	}
	
	public Room (String id) {
		
		super();
		this.id = id;
	}
	
	/// GETTERS AND SETTERS ///

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getM2() {
		return m2;
	}

	public void setM2(String m2) {
		this.m2 = m2;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Boolean getWifi() {
		return wifi;
	}

	public void setWifi(Boolean wifi) {
		this.wifi = wifi;
	}

	public Fecha getF_inicio() {
		return f_inicio;
	}

	public void setF_inicio(Fecha f_inicio) {
		this.f_inicio = f_inicio;

	}

	public Fecha getF_fin() {
		return f_fin;
	}

	public void setF_fin(Fecha f_fin) {
		this.f_fin = f_fin;

	}
	
	/// TO STRING ///
	
	 public abstract String toString();
	
}
