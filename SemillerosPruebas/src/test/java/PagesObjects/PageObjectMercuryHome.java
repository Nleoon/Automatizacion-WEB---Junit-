package PagesObjects;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import MapsObjects.MapObjectMercuryHome;
import utilidadesExcel.ReadExcelFile;

public class PageObjectMercuryHome extends MapObjectMercuryHome
{

	public PageObjectMercuryHome(WebDriver driver) 
	{
		super(driver);
	}
	
	
	// METODO INICIAL - URL
	public void urlAcceso(String url)
	{
		driver.get(url);
		//busquedaInicial();
	}
	
	// METODO INICIAL - URL EXCEL
	public void urlAccesoExcelMercury(ReadExcelFile leer, Properties propiedades) throws IOException
	{
		driver.get(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercurytours", 1, 0));
		//busquedaInicial();
	}
	
	
	// METODO DE INGRESAR AL FORMULARIO DE REGISTRAR USUARIO
	public void registrarUsuario(ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws Exception
	{
		// CLICK PARA ACCEDER AL FORMULARIO DE REGISTRAR USUARIO
		click(btnRegistrar, rutaCarpeta);
	}
}
