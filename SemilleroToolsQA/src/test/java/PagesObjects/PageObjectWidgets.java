package PagesObjects;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MapsObjects.MapObjectWidgets;

public class PageObjectWidgets extends MapObjectWidgets
{

	public PageObjectWidgets(WebDriver driver)
	{
		super(driver);
	}
	
	// METODO DE INICIAR PRUEBA DE DATE Y HOUR
		public void pruebaDatesAndHours(File rutaCarpeta) throws Exception
		{    
			// CLICK PARA ACCEDER AL APARTADO DE ALERTS
			scroll(300, 1);
			click(btnDatePicker, rutaCarpeta);
			
			// CLICK EN EL CALENDARIO 
			click(boxDate, rutaCarpeta);
			
			// CLICK EN EL SELECCIONADOR DEL MES
			//click(selectMes, rutaCarpeta);
			
			// SELECCIONAMOS EL MES
			tiempoEspera(1);
			List<WebElement> mes = listaElementos(selectMes);			
			tiempoEspera(1);
			mes.get(7).click();
			tiempoEspera(1);
			//System.out.println(mese.get(7).getText());
			
			// SELECCIONAMOS EL MES
			tiempoEspera(1);
			List<WebElement> año = listaElementos(selectAño);			
			tiempoEspera(1);
			año.get(122).click();
			tiempoEspera(1);
	
		/*
			// CLICK EN EL SELECCIONADOR DEL AÑO
			click(selectAño3, rutaCarpeta);
			sendkey("2022", selectAño3, rutaCarpeta);
		*/
			// CLICK EN EL SELECCIONADOR DEL DIA
			click(selectDia, rutaCarpeta);
			
			// CLICK EN LA CAJA DE DATE AND TIME
			click(boxDateAndTime, rutaCarpeta);
			
			// CLICK EN EL SELECCIONADOR DEL MES
			click(boxDateAndTime, rutaCarpeta);
			
			// CLICK EN VOLVER ATRAS MES
			click(volverAtrasMes,rutaCarpeta);
			
			// CLICK EN VOLVER ATRAS MES
			click(selectDia2,rutaCarpeta);
			
			// CLICK EN LA HORA
			click(selectHora,rutaCarpeta);

		}


		
		
		// METODO DE INICIAR PRUEBA DE DATE Y HOUR
		public void prueba2(File rutaCarpeta) throws Exception 
		{
			// CLICK PARA ACCEDER AL APARTADO DE ALERTS
			scroll(300, 1);
			click(btnDatePicker, rutaCarpeta);
			
			// SE ALMACENA LA NUEVAFECHA
			String fechaFinal = widgetsPruebaFecha(1, 1, 1, rutaCarpeta);
			tiempoEspera(1);
		System.out.println(fechaFinal);
			
			// SE BORRA LA FECHA PREDETERMINADA
			reemplazar(boxDate, rutaCarpeta);
			// SE ENVIA LA NUEVA FECHA 
			sendkey(fechaFinal, boxDate, rutaCarpeta);
			// SE DA ENTER PARA GUARDAR LA FECHA ENVIADA
			enter(boxDate, rutaCarpeta);
			
			
			// SEGUNDA FECHA A MANDAR
			// CLICK EN EL BOX DE LA FECHA
			click(boxDateAndTime, rutaCarpeta);
			// SE BORRA LA FECHA PREDETERMINADA
			reemplazar(boxDateAndTime, rutaCarpeta);
			// SE ALMACENA EL MES EN LETRA
			Month mesLetra= LocalDate.now().minusMonths(1).getMonth();
		System.out.println(mesLetra);
		
			// SE ALMACENA EL DIA Y EL AÑO DE LA HORA LOCAL 
			String fechaDiaAño = widgetsPruebaFechaSinMes(1, 1, rutaCarpeta);
			// SE ALAMACENA LA HORA ACTUAL
			String horaActual = HoraSistema();
			// SE CONCADENA EL MES DE LETRA MAS EL DIA Y EL AÑO
			String fechaFinal2 = mesLetra + fechaDiaAño + " " + horaActual;
			tiempoEspera(1);
			
			// SE ENVIA LA FECHA CONCADENADA AL BOX DE LA SEGUNDA FECHA
			sendkey(fechaFinal2, boxDateAndTime, rutaCarpeta);
			tiempoEspera(2);
			// LISTA DE HORA
						
			enter(boxDateAndTime, rutaCarpeta);
			tiempoEspera(2);

		}
}
