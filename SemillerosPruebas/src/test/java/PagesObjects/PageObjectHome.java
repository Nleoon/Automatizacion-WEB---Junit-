package PagesObjects;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import MapsObjects.MapObjectHome;
import utilidadesExcel.ReadExcelFile;

public class PageObjectHome extends MapObjectHome 
{
	// CREAR CONSTRUCTOR DE LA CLASE
	public PageObjectHome(WebDriver driver) 
	{
		super(driver);
	}
	
	
	// METODO INICIAL - URL PROPERTIES
	public void urlAcceso(String url)
	{
		driver.get(url);
		//busquedaInicial();
	}
	
	
	// METODO INICIAL - URL EXCEL
	public void urlAccesoExcel(ReadExcelFile leer, Properties propiedades) throws IOException
	{
		driver.get(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercadolibre", 1, 2));
		//busquedaInicial();
	}
	
/*	
	// 1.METODO PARA LA BUSQUEDA Y SELECCION DE PRODUCTO
	public void busquedaInicial(String busqueda) throws InterruptedException
	{
		// LIMPIAR LA CAJA DE BUSQUEDA
		borrar(txtCajaBusqueda);
		
		// ENVIAR EL VALOR A BUSCAR
		sendkey(busqueda,txtCajaBusqueda);
		submit(txtCajaBusqueda);
		tiempoEspera(2);
		
		// ACEPTAR LAS COOKIES
		click(clickAceptarCookies);
		
		// CERRAR VENTANA DE UBICACION
		click(clickCerrarUbicacion);
		
		// SELECCIONAR PRODUCTO
		click(clickPrimerProducto);
		tiempoEspera(1);
		
		// AGREGAR AL CARRITO
		click(clickAgregarCarrito);	
		
		//CREAR CUENTA
		click(clickCrearCuenta);
	}
*/	
	

	
	// 2.METODO DE CREA TU CUENTA - HOME
	public void creaTuCuenta(ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws Exception
	{
		// LIMPIAR LA CAJA DE BUSQUEDA
		click(clickCreaTuCuenta, rutaCarpeta);
		tiempoEspera(2);
		
		// ACEPTAR LAS COOKIES
		click(clickAceptarCookies, rutaCarpeta);
		
	}
	

	
	// 3.METODO DE PRUEBA EXCEL - BUSCAR PRODUCTO
	public void pruebaExcel(ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws Exception
	{			
		// LIMPIAR LA CAJA DE BUSQUEDA
		borrar(txtCajaBusqueda, rutaCarpeta);
		
		// ENVIAR EL VALOR A BUSCAR
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"mercadolibre", 1, 0), txtCajaBusqueda, rutaCarpeta);
		submit(txtCajaBusqueda, rutaCarpeta);
		tiempoEspera(2);
		
		// ACEPTAR LAS COOKIES
		click(clickAceptarCookies, rutaCarpeta);
		
		// CERRAR VENTANA DE UBICACION
		click(clickCerrarUbicacion, rutaCarpeta);
		
		// SELECCIONAR PRODUCTO
		click(clickPrimerProducto, rutaCarpeta);
		tiempoEspera(1);
		
		// AGREGAR AL CARRITO
		click(clickAgregarCarrito, rutaCarpeta);	
		
		//CREAR CUENTA
		click(clickCrearCuenta, rutaCarpeta);
		
	}
	
} 	
