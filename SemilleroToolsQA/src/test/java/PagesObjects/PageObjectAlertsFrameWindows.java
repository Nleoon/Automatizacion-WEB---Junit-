package PagesObjects;

import java.io.File;

import org.openqa.selenium.WebDriver;

import MapsObjects.MapObjectAlertsFrameWindows;

public class PageObjectAlertsFrameWindows extends MapObjectAlertsFrameWindows
{

	public PageObjectAlertsFrameWindows(WebDriver driver) 
	{
		super(driver);
	}
	
	// METODO DE INGRESAR AL APARTADO DE ALERTS
	public void pruebaAlerts(File rutaCarpeta) throws Exception
	{    
		try {
			
			// CLICK PARA ACCEDER AL APARTADO DE ALERTS
			click(btnAlerts, rutaCarpeta);
			
			// CLICK EN EL PRIMER BOTON DE ALERTA
			click(btnAlertButton1, rutaCarpeta);	
			tiempoEspera(2);
			// ACEPTAR LA ALERTA
			driver.switchTo().alert().accept();		
			tiempoEspera(1);
			
			// CLICK EN EL SEGUNDO BOTON DE ALERTA
			click(btnAlertButton2, rutaCarpeta);
			tiempoEspera(6);
			driver.switchTo().alert().accept();	
			
			// CLICK EN EL TERCER BOTON DE ALERTA - ACEPTAR
			click(btnAlertButton3, rutaCarpeta);
			driver.switchTo().alert().accept();	
			tiempoEspera(2);
			
			// CLICK EN EL TERCER BOTON DE ALERTA - CANCELAR
			click(btnAlertButton3, rutaCarpeta);
			driver.switchTo().alert().dismiss();
			tiempoEspera(2);
			
			// CLICK EN EL CUARTO BOTON DE ALERTA Y ENVIO DE INFORMACION
			click(btnAlertButton4, rutaCarpeta);
			driver.switchTo().alert().sendKeys("PRUEBA");
			tiempoEspera(2);
			driver.switchTo().alert().accept();	
			tiempoEspera(2);
			
			// SCREENSHOT
			ScreenShot(rutaCarpeta);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
