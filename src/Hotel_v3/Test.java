package Hotel_v3;

import Hotel_v3.Classes.Fecha;
import Hotel_v3.Modules.Room.Utils.Data_date;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*
		Fecha fecha = null;
		int edad = 0;
		String fecha_inicio, fecha_fin = "";

		fecha_inicio = Validates.validastring_edit("Can yoi insert the start date?", "Start Date");
		fecha = new Fecha(fecha_inicio);
		edad = fecha.restar_fecha_sistema();
		System.out.println(edad);
		*/
		
		Fecha fecha_inicio = Data_date.ask_fecha_inicio("Can you insert the start date?", "Start Date");
		Fecha fecha_fin = Data_date.ask_fecha_fin(fecha_inicio);
		Fecha fecha_inicio_spa = Data_date.ask_fecha_sub_inicio(fecha_inicio, fecha_fin);
		Fecha fecha_fin_spa = Data_date.ask_fecha_sub_fin(fecha_inicio_spa, fecha_fin);
	}

}
