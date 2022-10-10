package RunPruebas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import ClasesBase.ClaseBase;
import PagesObjects.PageObjectAlertsFrameWindows;
import PagesObjects.PageObjectHome;
import PagesObjects.PageObjectWidgets;
import UtilidadesExcel.MyScreenRecorder;

public class RunPrueba {

	// CREAR OBJETO TIPO WEB DRIVER
	private WebDriver driver;
	
	// PAGINAS TOOLS QA
	PageObjectHome homeToolsQA;
	PageObjectAlertsFrameWindows alertsToolsQA;
	PageObjectWidgets widgetsToolsQA;
	
	// PROPIERTIES
	Properties propiedades;
	InputStream entrada = null;
	
	// SCREENSHOTS
	ClaseBase claseBase;
	
	
// CREAR ANOTACIONES JUNIT
	@Before
		public void setUp() throws IOException
		{
			
			// PROPERTIES -->
			// INSTANCIAR LA CLASE PROPIEDADES DE JAVA UTIL
			propiedades = new Properties();
			// CREAR VARIABLE TIPO INPUTSTREAM
			InputStream entrada = null;
			// VALIDAR SI GENERA ERROR AL NO ENCONTRAR EL ARCHIVO
			try {
				entrada = new FileInputStream("./Properties/datos.properties");
				propiedades.load(entrada);
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}
		
	
	// ACCEDER AL METODO DE PRUEBAS DE LAS ALERTAS Y POP-up's
		@Test
		public void pruebaAlertsFrameWindows() throws Exception
		{	
			// ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
			driver = ClaseBase.chromeDriverConnetion();	
			// CLASE BASE - (ScreenShots)
			claseBase = new ClaseBase(driver);
			// INSTANCIAR LAS CLASES DE LAS PAGINAS
			homeToolsQA = new PageObjectHome(driver);
			alertsToolsQA = new PageObjectAlertsFrameWindows(driver);
			
			
			// OBTENER EL NOMBRE DEL TEST - (ScreenShot's)
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(propiedades,nomTest);
			
			
			// LLAMADO DE METODOS -->
			// ACCEDER A ABRIR PAGINA
			homeToolsQA.urlAcceso(propiedades.getProperty("url"));
			// METODO DE ENTRAR AL APARTADO DE AlertsFrame & Windows
			homeToolsQA.AlertsFrameWindows(rutaCarpeta);
			// MEOTODO DE ENTRAR AL APARTADO DE ALERTS
			alertsToolsQA.pruebaAlerts(rutaCarpeta);
		}


/*
	// ACCEDER AL METODO DE PRUEBAS DE WIDGETS - (SOLO CLICKS)
		@Test
		public void pruebaWidgets() throws Exception
		{	
			// OBTENER EL NOMBRE DEL TEST - (ScreenShot's)
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(propiedades,nomTest);
			
			
			// LLAMADO DE METODOS -->
			// ACCEDER A ABRIR PAGINA
			homeToolsQA.urlAcceso(propiedades.getProperty("url"));
			// METODO DE ENTRAR AL APARTADO DE WIDGETS
			homeToolsQA.Widgets(rutaCarpeta);
			// METODO DE INICIAR LA PRUEBA DE DATES Y HOURS
			widgetsToolsQA.pruebaDatesAndHours(rutaCarpeta);
		}
*/		
		
	
		// ACCEDER AL METODO DE PRUEBAS DE WIDGETS
		@Test
		public void pruebaWidgets() throws Exception
		{	
			// ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
			driver = ClaseBase.chromeDriverConnetion();	
			// CLASE BASE - (ScreenShots)
			claseBase = new ClaseBase(driver);
			// INSTANCIAR LAS CLASES DE LAS PAGINAS
			homeToolsQA = new PageObjectHome(driver);
			widgetsToolsQA = new PageObjectWidgets(driver);
			
			
			// OBTENER EL NOMBRE DEL TEST - (ScreenShot's)
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(propiedades,nomTest);
			
			// INICIAR LA GRABACION DE VIDEO
			MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
			
			// LLAMADO DE METODOS -->
			// ACCEDER A ABRIR PAGINA
			homeToolsQA.urlAcceso(propiedades.getProperty("url"));
			// METODO DE ENTRAR AL APARTADO DE WIDGETS
			homeToolsQA.Widgets(rutaCarpeta);
			// METODO DE INICIAR LA PRUEBA DE DATES Y HOURS
			widgetsToolsQA.prueba2(rutaCarpeta);
			
			// FINALIZAR LA GRABACION DE VIDEO
			MyScreenRecorder.stopRecording();
		}

	
	@After
  	public void cerrar()
 	{
	 // CERRAR PROCESO
	 driver.quit();
 	}
}
