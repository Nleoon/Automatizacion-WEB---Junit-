package PagesObjects;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import MapsObjects.MapObjectCrearCuenta;
import utilidadesExcel.ReadExcelFile;

public class PageObjectCrearCuenta extends MapObjectCrearCuenta {

	public PageObjectCrearCuenta(WebDriver driver) 
	{
		super(driver);	
	}
	
/*	
	// PASO A PASO A SEGUIR PARA CREAR CUENTA
	public void crearCuenta(String email) throws InterruptedException
	{
				
		// ACEPTAR TERMINOS Y CONDICIONES
		click(clickTerminosCondiciones);
		tiempoEspera(1);
				
		// CLICK EN BOTON CONTINUAR
		click(clickContinuar);
				
		// CLICK EN BOTON VALIDAR EMAIL
		click(clickValidarEmail);
				
		// LIMPIAR CAJA DE TEXTO - EMAIL
		borrar(txtCajaEmail);
		sendkey(email,txtCajaEmail);
		tiempoEspera(3);
	}
	
*/
	
	// 3. METODO PARA CREAR CUENTA - EXCEL
	public void crearCuentaExcel(ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws Exception
	{		
		// ACEPTAR TERMINOS Y CONDICIONES
		click(clickTerminosCondiciones, rutaCarpeta);
		tiempoEspera(1);
				
		// CLICK EN BOTON CONTINUAR
		click(clickContinuar, rutaCarpeta);
				
		// CLICK EN BOTON VALIDAR EMAIL
		click(clickValidarEmail, rutaCarpeta);
				
		// LIMPIAR CAJA DE TEXTO - EMAIL
		borrar(txtCajaEmail, rutaCarpeta);
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercadolibre", 1, 1),txtCajaEmail,rutaCarpeta);
		tiempoEspera(3);
	}
}
