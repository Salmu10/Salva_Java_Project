package Hotel_v3.Classes;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;


public class Fecha {
	
		// attributes
		private String fecha;
		private int dia;
		private int mes;
		private int anyo;

		private SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");

		public String getfecha() {
			return fecha;
		}

		public void setfecha(String fecha) {
			this.fecha = fecha;
		}

		public Fecha(String fecha) {

			String[] SplitArray = null;

			SplitArray = fecha.split("/");

			this.dia = Integer.parseInt(SplitArray[0]);
			this.mes = Integer.parseInt(SplitArray[1]);
			this.anyo = Integer.parseInt(SplitArray[2]);
			this.fecha = fecha;

		}

		public Calendar deStringToCalendar(String fecha) {
			
			Date fechaDate = new Date();
			Calendar fechaCalendar = new GregorianCalendar();
			
			try {
				fechaDate = formato.parse(fecha);
				fechaCalendar.setTime(fechaDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			return fechaCalendar;
		}

		public String deCalendartoString() {
			
			Calendar cal = Calendar.getInstance();
			
			return (cal.getTime().toString());
		}
		

		/// Restar una fecha a la fecha del sistema
		
		public int restar_fecha_sistema() {

			int dia1, dia2, diferencia = 0;
			Calendar fecha1 = Calendar.getInstance();
			Calendar fecha2 = this.deStringToCalendar(fecha);

			dia1 = fecha1.get(Calendar.YEAR);
			dia2 = fecha2.get(Calendar.YEAR);
			diferencia = (dia2 - dia1);

			return diferencia;
		}
		
		/// Restar una fecha a la fecha del sistema
		
		public int restar_fecha_sistema_2() {

			int dia1, dia2, diferencia = 0;
			Calendar fecha1 = Calendar.getInstance();
			Calendar fecha2 = this.deStringToCalendar(fecha);

			dia1 = fecha1.get(Calendar.YEAR);
			dia2 = fecha2.get(Calendar.YEAR);
			diferencia = (dia1 - dia2);

			return diferencia;
		}
		
		/// Restar dos fechas para saber la diferencia de dias

		public int restar2Fechas(Fecha fecha2) {

			int dia1, dia2, diferencia = 0;
			Calendar fecha1 = this.deStringToCalendar(fecha);
			Calendar fecha2Calen = fecha2.deStringToCalendar(fecha2.toString());

			dia1 = fecha1.get(Calendar.DAY_OF_MONTH);
			dia2 = fecha2Calen.get(Calendar.DAY_OF_MONTH);
			diferencia = (dia2 - dia1);

			return diferencia;

		}
		
		/// Restar dos fechas para saber la diferencia de dias

		public int restar2Fechas_años(Fecha fecha2) {

			int dia1, dia2, diferencia = 0;
			Calendar fecha1 = this.deStringToCalendar(fecha);
			Calendar fecha2Calen = fecha2.deStringToCalendar(fecha2.toString());

			dia1 = fecha1.get(Calendar.YEAR);
			dia2 = fecha2Calen.get(Calendar.YEAR);
			diferencia = (dia2 - dia1);

			return diferencia;

		}
		
		/// Año actual

		public int anyo_actual() {
			
			Calendar fecha = new GregorianCalendar();
			int anyo = fecha.get(Calendar.YEAR);
			
			return anyo;
		}
		
		/// Dia actual
		
		public int dia_actual() {
			
			Calendar fecha = new GregorianCalendar();
			int dia = fecha.get(Calendar.DAY_OF_MONTH);
			
			return dia;
		}

		public int compara_fechas(Fecha fecha2) {

			Calendar cal1 = this.deStringToCalendar(fecha);
			Calendar cal2 = this.deStringToCalendar(fecha2.toString());

			if (cal1.before(cal2)) {
				return 1;
			} else if (cal1.after(cal2)) {
				return 2;
			} else {
				return 3;
			}
		}
		
		/// Validación de que la fecha introducida existe

		public boolean valida_fecha(){
			
			GregorianCalendar calendar = new GregorianCalendar();
			
			int dias[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			
			if (calendar.isLeapYear(this.anyo)) {
				dias[2]	= 29;
			}
			
			if((this.dia >= 1) && (this.dia <= dias[this.mes])) {
				return true;
			} else {
				return false;
			}
		}

		/// ToString
		
		@Override
		public String toString() {

			String fecha = null;

			fecha = this.dia + "/" + this.mes + "/" + this.anyo;

			return fecha;
		}
		
}
