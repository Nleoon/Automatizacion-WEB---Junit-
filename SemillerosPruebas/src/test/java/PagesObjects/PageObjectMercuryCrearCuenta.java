package PagesObjects;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import MapsObjects.MapObjectMercuryCrearCuenta;
import utilidadesExcel.ReadExcelFile;

public class PageObjectMercuryCrearCuenta extends MapObjectMercuryCrearCuenta 
{

	public PageObjectMercuryCrearCuenta(WebDriver driver) 
	{
		super(driver);
	}
	
	
	public void crearCuentaMercury(ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws Exception
	{
		// RELLENAR LA CAJA DE TEXTO DE FIRTS NAME
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercurytours", 1, 1), textBoxFirstName, rutaCarpeta);
		// RELLENAR LA CAJA DE TEXTO DE LAST NAME
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercurytours", 1, 2), textBoxLastName, rutaCarpeta);
		// RELLENAR LA CAJA DE TEXTO DE PHONE
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercurytours", 1, 3), textBoxPhone, rutaCarpeta);
		// RELLENAR LA CAJA DE TEXTO DE EMAIL
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercurytours", 1, 4), textBoxEmail, rutaCarpeta);
		// RELLENAR LA CAJA DE TEXTO DE ADDRESS
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercurytours", 1, 5), textBoxAddress, rutaCarpeta);
		// RELLENAR LA CAJA DE TEXTO DE CITY
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercurytours", 1, 6), textBoxCity, rutaCarpeta);
		// RELLENAR LA CAJA DE TEXTO DE STATE
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercurytours", 1, 7), textBoxState, rutaCarpeta);
		// RELLENAR LA CAJA DE TEXTO DE POSTAL CODE
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercurytours", 1, 8), textBoxPostalCode, rutaCarpeta);
		// SELECCIONAR PAIS
		click(textBoxCountry, rutaCarpeta);
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercurytours", 1, 9), textBoxCountry, rutaCarpeta);
		// RELLENAR LA CAJA DE TEXTO DE USER NAME
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercurytours", 1, 10), textBoxUserName, rutaCarpeta);
		// RELLENAR LA CAJA DE TEXTO DE PASSWORD
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercurytours", 1, 11), textBoxPassword, rutaCarpeta);
		// RELLENAR LA CAJA DE TEXTO DE CONFIRM PASSWORD
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercurytours", 1, 12), textBoxConfirmPassword, rutaCarpeta);
		// ENVIAR EL FORMULARIO
		click(btnEnviar, rutaCarpeta);
		
	}
}
