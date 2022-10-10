package PagesObjects;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import MapsObjects.MapObjectHome;


public class PageObjectHome extends MapObjectHome
{

	public PageObjectHome(WebDriver driver) 
	{
		super(driver);
	}
	
	// METODO INICIAL - URL
	public void urlAcceso(String url)
	{
		driver.get(url);
		//busquedaInicial();
	}
	

	
	// METODO DE INGRESAR AL APARTADO DE ALERTS FRAME & WINDOWS
	public void AlertsFrameWindows(File rutaCarpeta) throws Exception
	{
		// SCROLL DE PAGINA
	    scroll(200, 1);
	    // TIEMPO DE ESPERA PARA VISUALIZAR
	    tiempoEspera(2);	    
		// CLICK PARA ACCEDER AL FORMULARIO DE REGISTRAR USUARIO
		click(cardAlertsFrameWindows, rutaCarpeta);
	}
	
	
	// METODO DE INGRESAR AL APARTADO DE WIDGETS
	public void Widgets(File rutaCarpeta) throws Exception
	{
		// SCROLL DE PAGINA
	    scroll(200, 1);
	    // TIEMPO DE ESPERA PARA VISUALIZAR
	    tiempoEspera(2);	    
		// CLICK PARA ACCEDER AL FORMULARIO DE REGISTRAR USUARIO
		click(cardWidgets, rutaCarpeta);
	}
}
