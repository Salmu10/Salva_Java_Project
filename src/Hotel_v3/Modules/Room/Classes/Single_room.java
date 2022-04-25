package Hotel_v3.Modules.Room.Classes;

import Hotel_v3.Classes.Fecha;
import Hotel_v3.Modules.Room.Utils.Data_CRUD;
import Hotel_v3.Utils.Menus;

public class Single_room extends Room {
	
	/// Atributos ///
	
	private Boolean tv;
	private String excursion;
	
	/// Atributos recalculados ///
	
	private float discount;
	private int numofdays;
	private int price;
	private float coupon;
	private float total_price;
	
	/// CONSTRUCTOR ///
	
	public Single_room(String id, String m2, String capacity, Boolean available, Boolean wifi, Fecha f_inicio, Fecha f_fin,
			Boolean tv, String excursion) {
		
		super (id, m2, capacity, available, wifi, f_inicio, f_fin);
		
		this.tv = tv;
		this.excursion = excursion;
		this.numofdays = this.calcular_numofdays();
		this.discount = this.calcular_discount(numofdays);
		this.price = this.calcular_price(numofdays);
		this.coupon = this.calcular_coupon(numofdays);
		this.total_price = this.calcular_total_price(price, discount, coupon);
	}
	
	public Single_room (String id) {
		
		super(id);
	}

	/// Sobresicribir las fechas para actualizar los atributos recalculados ///

	public void setF_inicio(Fecha f_inicio) {
		super.setF_inicio(f_inicio);
		this.numofdays = this.calcular_numofdays();
		this.discount = this.calcular_discount(numofdays);
		this.price = this.calcular_price(numofdays);
		this.coupon = this.calcular_coupon(numofdays);
		this.total_price = this.calcular_total_price(price, discount, coupon);
	}
	
	public void setF_fin(Fecha f_fin) {
		super.setF_fin(f_fin);
		this.numofdays = this.calcular_numofdays();
		this.discount = this.calcular_discount(numofdays);
		this.price = this.calcular_price(numofdays);
		this.coupon = this.calcular_coupon(numofdays);
		this.total_price = this.calcular_total_price(price, discount, coupon);
	}
	
	/// GETTERS AND SETTERS ///
	
	public Boolean getTv() {
		return tv;
	}

	public void setTv(Boolean tv) {
		this.tv = tv;
	}

	public String getExcursion() {
		return excursion;
	}

	public void setExcursion(String excursion) {
		this.excursion = excursion;
	}
	
	/// Atributos recalculados ///
	
	public int getNumofdays() {
		return price;
	}

	public void setNumofdays(int numofdays) {
		this.numofdays = this.calcular_numofdays();
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = this.calcular_price(numofdays);
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = this.calcular_discount(numofdays);
	}
	
	public float getCoupon() {
		return coupon;
	}

	public void setCoupon(float coupon) {
		this.coupon = this.calcular_coupon(getNumofdays());
	}
	
	public float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(float total_price) {
		this.total_price = this.calcular_total_price(price, discount, coupon);
	}
	
	/// Funciones para atributos recalculados ///
	
	public int calcular_numofdays() {
		return this.getF_inicio().restar2Fechas(getF_fin());
	}
	
	public int calcular_price(int num_dies) {
		
		int precio_base = 150;
		
		return precio_base * num_dies;
	}
	
	public float calcular_discount(int num_dies) {
		
		float discount = 0.0f;
		
		if (num_dies > 3) {
			discount = 0.1f;
		} else if (num_dies > 8) {
			discount = 0.2f;
		} else if (num_dies <= 3) {
			discount = 0.0f;
		}
		
		return discount;
	}
	
	public float calcular_coupon(int num_dies) {
		
		float coupon = 0.0f;
		
		if ((num_dies > 7)) {
			coupon = 0.05f;
		} else {
			coupon = 0.0f;
		}
		
		return coupon;
	}
	
	public float calcular_total_price(int precio_base, float discount, float coupon) {
		
		float precio_cou = 0.0f;
		float precio_dis = 0.0f;
		float precio_total = 0.0f;
		
		precio_dis = (float)precio_base * discount;
		precio_cou = (float)precio_base * coupon;
		precio_total = precio_base - precio_dis - precio_cou;
		
		return precio_total;
	}
	
	/// TO STRING ///
	
	@Override
	public String toString() {
		
		
		String [] opciones_1 = {"Read all the atributes", "Choose the atribute", "Eixit"};
		int option_1 = 0;
		String [] opciones = {"Id", "M2", "Capacity", "Available", "Wifi", "Start date", "End date", "Price", "Discount", "Coupon", "Tv", "Excursion", "Total price"};
		String option = "";
		String resultado = "";
		Boolean continuar = false;
		
		float descuento = this.discount * 100;
		float cupon = this.coupon * 100;
		
		do {
			option_1 = Menus.menu_buttons_edit(opciones_1, "Read of the room with the ID: " + super.getId(), "Read");
			
			switch (option_1) {
				case 0:
					resultado = "Single room: " + "\n" + "ID = " + super.getId() + "\n" + "M2 = " + super.getM2() + "\n" + "Capacity = " + super.getCapacity() + "\n" + "Available = " + super.getAvailable() + "\n" + "Wifi = "
					+ super.getWifi() + "\n" + "Start date = " + super.getF_inicio() + "\n" + "End date = " + super.getF_fin() + "\n"; 
					
					if (this.getTv() == true) {
						resultado = resultado + "TV = You choose TV on the room.\n";
					} else {
						resultado = resultado + "TV = You don't want a TV in the room.\n";
					}		
					
					resultado = resultado + "Excursion = " + excursion + "\n" + "Price = " + price + " €" + "\n" + "Discount = " + (int)descuento + " %" + "\n" + "Coupon = " + (int)cupon + " %" + "\n" + "Total price = " + total_price + " €" + "\n";
					
					option_1 = 2;
					break;
					
				case 1:
					do{
						option = Menus.menu_combobox_edit(opciones, "Select the atribute of the room with ID: " + super.getId(), "Read");
						
						switch (option) {
							case "Id":
								resultado = resultado + "Id = " + super.getId() + "\n";
								break;
								
							case "M2":
								resultado = resultado + "M2 = " + super.getM2() + "\n";
								break;
								
							case "Capacity":
								resultado = resultado + "Capacity = " + super.getCapacity() + "\n";
								break;
								
							case "Available":
								if (super.getAvailable() == true) {
									resultado = resultado + "Available = The room is available\n";
								}else {
									resultado = resultado + "Available = The room isn't available\n";
								}
								break;
								
							case "Wifi":
								if (super.getWifi() == true) {
									resultado = resultado + "Wifi = You choose wifi on the room\n";
								}else {
									resultado = resultado + "Wifi = You don't want wifi in the room\n";
								}	
								break;
								
							case "Start date":
								resultado = resultado + "Start date = " + super.getF_inicio() + "\n";
								break;
								
							case "End date":
								resultado = resultado + "End date = " + super.getF_fin() + "\n";
								break;
								
							case "Price":
								resultado = resultado + "Price = " + this.price + " €" + "\n";
								break;
								
							case "Discount":
								resultado = resultado + "Discount = " + (int)descuento + " %"  + "\n";
							break;
							
							case "Coupon":
								resultado = resultado + "Coupon = " + (int)cupon + " %" + "\n";
							break;
						
							case "Tv":
								if (this.getTv() == true) {
									resultado = resultado + "TV = You choose TV on the room.\n";
								}else {
									resultado = resultado + "TV = You don't want a TV in the room.\n";
								}				
								break;
								
							case "Excursion":
								resultado = resultado + "Excursion = " + this.getExcursion() + "\n";
								break;
								
							case "Total price":
								resultado = resultado + "Total price = " + this.total_price + " €" + "\n";
								break;
						}
						continuar = Data_CRUD.ask_yes_no("Yes", "No", "Do you want to continue reading?", "Read");
					} while (continuar == true);   /// El usuario quiere leer los datos
					
					option_1 = 2;
					break;
			}
		} while (option_1 != 2);
		
		return resultado;
	}
	
	
}
