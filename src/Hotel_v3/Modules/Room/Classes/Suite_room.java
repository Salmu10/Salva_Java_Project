package Hotel_v3.Modules.Room.Classes;

import javax.swing.JOptionPane;

import Hotel_v3.Classes.Fecha;
import Hotel_v3.Modules.Room.Utils.Data_CRUD;
import Hotel_v3.Utils.Menus;

public class Suite_room extends Room {

	/// Atributos ///
	
	private boolean spa;
	private boolean bed_type;
	private boolean jacuzzi;
	private boolean champagne;
	private Fecha start_date_spa;
	private Fecha end_date_spa;
	
	/// Atributos recalculados ///
	
	private float discount;
	private int numofdays;
	private int price;
	private float coupon;
	private float total_price;
	
	/// CONSTRUCTOR ///
	
	public Suite_room(String id, String m2, String capacity, boolean available, boolean wifi, Fecha f_inicio, Fecha f_fin,
			boolean champagne, boolean bet_type, boolean jacuzzi, boolean spa, Fecha start_date_spa, Fecha end_date_spa) {
		
		super(id, m2, capacity, available, wifi, f_inicio, f_fin);

		this.champagne = champagne;
		this.bed_type = bet_type;
		this.jacuzzi = jacuzzi;
		this.spa = spa;
		this.start_date_spa = start_date_spa;
		this.end_date_spa = end_date_spa;
		this.numofdays = this.calcular_numofdays();
		this.discount = this.calcular_discount(numofdays);
		this.price = this.calcular_price(numofdays);
		this.coupon = this.calcular_coupon(numofdays);
		this.total_price = this.calcular_total_price(price, discount, coupon);
	}
	
	public Suite_room (String id) {
		
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
	
	public boolean getSpa() {
		return this.spa;
	}

	public void setSpa(Boolean spa) {
		this.spa = spa;
		this.numofdays = this.calcular_numofdays();
		this.discount = this.calcular_discount(numofdays);
		this.price = this.calcular_price(numofdays);
		this.coupon = this.calcular_coupon(numofdays);
		this.total_price = this.calcular_total_price(price, discount, coupon);
	}

	public boolean getBed_type() {
		return this.bed_type;
	}

	public void setBed_type(Boolean bed_type) {
		this.bed_type = bed_type;
	}

	public boolean getJacuzzi() {
		return this.jacuzzi;
	}

	public void setJacuzzi(Boolean jacuzzi) {
		this.jacuzzi = jacuzzi;
	}

	public boolean getChampagne() {
		return this.champagne;
	}

	public void setChampagne(Boolean champagne) {
		this.champagne = champagne;
	}

	public Fecha getStart_date_spa() {
		return this.start_date_spa;
	}

	public void setStart_date_spa(Fecha start_date_spa) {
		this.start_date_spa = start_date_spa;
	}

	public Fecha getEnd_date_spa() {
		return this.end_date_spa;
	}

	public void setEnd_date_spa(Fecha end_date_spa) {
		this.end_date_spa = end_date_spa;
	}
	
	/// Atributos recalculados
	
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
	
	/// Funciones para atributos recalculados
	
	public int calcular_numofdays() {
		return this.getF_inicio().restar2Fechas(getF_fin());
	}
	
	public int calcular_price(int num_dies) {
		
		int precio_base = 500;
		Boolean spa = this.getSpa();
		Boolean jacuzzi = this.getJacuzzi();
		Boolean champagne = this.getChampagne();

		if (champagne == true) {
			precio_base = precio_base + 50;
		}
		if (jacuzzi == true) {
			precio_base = precio_base + 50;
		}
		if (spa == true) {
			precio_base = precio_base + 50;
		}
		
		return precio_base * num_dies;
	}
	
	public float calcular_discount(int num_dies) {
		
		float discount = 0.0f;
		
		if (num_dies > 3) {
			discount = 0.1f;
		} else if (num_dies > 7) {
			discount = 0.2f;
		} else if (num_dies <= 3) {
			discount = 0.0f;
		}
		
		return discount;
	}
	
	public float calcular_coupon(int num_dies) {
		
		float coupon = 0.0f;
		Boolean spa = this.getSpa();
		
		if ((num_dies > 5) && (spa == true)) {
			coupon = 0.05f;
		} else if ((num_dies > 5) && (spa == false)){
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
		String [] opciones = {"Id", "M2", "Capacity", "Available", "Wifi", "Start date", "End date", "Champagne", "Bed type", "Jacuzzi", "Spa", "Start date spa", "End date spa", "Price", "Discount", "Coupon", "Total price"};
		String option = "";
		String resultado = "";
		boolean continuar = false;
		
		float descuento = this.discount * 100;
		float cupon = this.coupon * 100;
		
		do {
			option_1 = Menus.menu_buttons_edit(opciones_1, "Read of the room with the ID: " + super.getId(), "Read");
			
			switch (option_1) {
				case 0:
					resultado = "Single room: " + "\n" + "ID = " + super.getId() + "\n" + "M2 = " + super.getM2() + "\n" + "Capacity = " + super.getCapacity() + "\n" + "Available = " + super.getAvailable() + "\n" + "Wifi = "
					+ super.getWifi() + "\n" + "Start date = " + super.getF_inicio() + "\n" + "End date = " + super.getF_fin() + "\n";

					if (this.getChampagne() == true) {
						resultado = resultado + "Champagne = You want Champagne.\n";
					} else {
						resultado = resultado + "Champagne = You don't want Champagne.\n";
					}
					
					if (this.getBed_type() == true) {
						resultado = resultado + "Bed type = You want two single beds\n";
					} else {
						resultado = resultado + "Bed type = You want a one double bed.\n";
					}	
					
					if (this.getJacuzzi() == true) {
						resultado = resultado + "Jacuzzi = You want a Jacuzzi.\n";
					} else {
						resultado = resultado + "Jacuzzi = You don't want a Jacuzzi.\n";
					}

					if (this.getSpa() == true) {
						resultado = resultado + "Spa = You want SPA.\n";
					} else {
						resultado = resultado + "Spa = You don't want SPA.\n";
					}
					
					if (this.getSpa() == true) {
						resultado = resultado + "Start date spa = " + this.getStart_date_spa() + "\n";
					} else {
						resultado = resultado + "Start date spa = The SPA is not enabled." + "\n"; 
					}
					
					if (this.getSpa() == true) {
						resultado = resultado + "End date spa = " + this.getEnd_date_spa() + "\n";
					} else {
						resultado = resultado + "End date spa = The SPA is not enabled." + "\n"; 
					}
					
					resultado = resultado + "Price = " + price + " €" + "\n" + "Discount = " + (int)descuento + " %" + "\n" + "Coupon = " + (int)cupon + " %" + "\n" + "Total price = " + total_price + " €" + "\n";
					
					option_1 = 2;
					break;
					
				case 1:
					do{
						
						option = Menus.menu_combobox(opciones);
						
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
							
							case "Champagne":
								if (this.getChampagne() == true) {
									resultado = resultado + "Champagne = You want Champagne.\n";
								} else {
									resultado = resultado + "Champagne = You don't want Champagne.\n";
								}
							break;	
								
							case "Bed type":
								if (this.getBed_type() == true) {
									resultado = resultado + "Bed type = You want two single beds\n";
								}else {
									resultado = resultado + "Bed type = You want a one double bed.\n";
								}				
								break;
								
							case "Jacuzzi":
								if (this.getJacuzzi() == true) {
									resultado = resultado + "Jacuzzi = You want a Jacuzzi.\n";
								}else {
									resultado = resultado + "Jacuzzi = You don't want a Jacuzzi.\n";
								}
								break;			
								
							case "Spa":
								if (this.getSpa() == true) {
									resultado = resultado + "Spa = You want SPA.\n";
								}else {
									resultado = resultado + "Spa = You don't want SPA.\n";
								}
								break;
								
							case "Start date spa":
								if (this.getSpa() == true) {
									resultado = resultado + "Start date spa = " + this.getStart_date_spa() + "\n";
								} else {
									JOptionPane.showMessageDialog(null, "The SPA is not enabled", "Error", JOptionPane.ERROR_MESSAGE);
								}
								break;
								
							case "End date spa":
								if (this.getSpa() == true) {
									resultado = resultado + "End date spa = " + this.getEnd_date_spa() + "\n";
								} else {
									JOptionPane.showMessageDialog(null, "The SPA is not enabled", "Error", JOptionPane.ERROR_MESSAGE);
								}
								break;
								
							case "Price":
								resultado = resultado + "Price = " + this.price + " €" + "\n";
								break;
								
							case "Discount":
								resultado = resultado + "Discount = " + (int)descuento + " %" + "\n";
								break;
							
							case "Coupon":
								resultado = resultado + "Coupon = " + (int)cupon + " %" + "\n";
								break;
								
							case "Total price":
								resultado = resultado + "Total price = " + this.total_price + " €" + "\n";
								break;
						}
						continuar = Data_CRUD.ask_yes_no("Yes", "No", "Do you want to continue reading?", "Read");
					} while (continuar == true);  // Permanecerá en la aplicación mientras no se pulse el botón salir de cualquiera de los dos menús
					option_1 = 2;
					break;
			}
		} while (option_1 != 2);
		
		return resultado;
	}
}
