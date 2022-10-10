package RunPruebas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import ClasesBase.ClaseBase;
import PagesObjects.PageObjectCrearCuenta;
import PagesObjects.PageObjectHome;
import PagesObjects.PageObjectMercuryCrearCuenta;
import PagesObjects.PageObjectMercuryHome;
import utilidadesExcel.MyScreenRecorder;
import utilidadesExcel.ReadExcelFile;
import utilidadesExcel.WriteExcelFile;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RunPrueba {
	
	// 	CREAR OBJETO TIPO WEB DRIVER
	private WebDriver driver;
	
	// MERCADO LIBRE
	PageObjectHome Home;
	PageObjectCrearCuenta crearCuenta;
	
	// MERCURY
	PageObjectMercuryHome mercuryHome;
	PageObjectMercuryCrearCuenta mercuryCrearCuenta;
	
	// PROPIERTIES
	Properties propiedades;
	
	// EXCEL
	ReadExcelFile leer;
	WriteExcelFile escribir;
	InputStream entrada = null;
	
	// SCREENSHOTS
	ClaseBase claseBase;
	
	
	
	// CREAR ANOTACIONES JUNIT
	@Before
	public void setUp() throws IOException
	{
		// EXCEL -->
		// INSTANCIAR LAS CLASES DE EXCEL Y CONVERTIRLAS EN OBJETOS		
		leer = new ReadExcelFile();
		escribir = new WriteExcelFile();
		
		// CREAR VARIABLE TIPO INPUTSTREAM
		InputStream entrada = null;
		
		// PROPERTIES -->
		// INSTANCIAR LA CLASE PROPIEDADES DE JAVA UTIL
		propiedades = new Properties();
		// VALIDAR SI GENERA ERROR AL NO ENCONTRAR EL ARCHIVO
		try {
			entrada = new FileInputStream("./Properties/datos.properties");
			propiedades.load(entrada);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
		}

		// MERCADOLIBRE -->
//		ACCEDER AL METODOD DE ABRIR PAGINA		
//		DRECCTO
// 		Home.urlAcceso("https://www.mercadolibre.com.co/"); 
//		CON PROPERTIES
// 		Home.urlAcceso(propiedades.getProperty("urlMer")); 		
//		CON EXCEL
//		Home.urlAccesoExcel(leer,propiedades);
		
		
		// MERCURY -->
//		INSTRANCIAR LA CLASE PAGE OBJECT MERCURY
//		mercuryHome = new PageObjectMercuryHome(driver);
//		ACCEDER AL METODO DE ABRIR PAGINA
//		mercuryHome.urlAccesoExcelMercury(leer, propiedades);
//		ACCEDER AL METODO DE CREAR CUENTA
//		mercuryCrearCuenta = new PageObjectMercuryCrearCuenta(driver);

	}
	
	
	// ACCEDER AL METODO DE BUSCAR PRODUCTO Y CREAR CUENTA CON EXCEL
	@Test
	public void AseleccionarProductoMER() throws Exception
	{		
		// ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
		driver = ClaseBase.chromeDriverConnetion();		
		// CLASE BASE - (ScreenShots)
		claseBase = new ClaseBase(driver);
		// INSTANCIAR LA CLASE PAGEOBJECT-HOME
		Home = new PageObjectHome(driver);
		// INSTANCIAR LA CLASE PAGEOBJECT-CREAR CUENTA
		crearCuenta = new PageObjectCrearCuenta(driver);
		
		
		// OBTENER EL NOMBRE DEL TEST - (ScreenShot's)
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(propiedades,nomTest);
		
		
		// INICIAR EL PROCESO DE GRABACION
		MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
		
		// LLAMADO DE METODOS -->
		// ACCEDER A ABRIR PAGINA
		Home.urlAccesoExcel(leer,propiedades);
		// SE LLAMA AL METODO DE BUSCAR PRODUCTO Y SELECCIONAR AL PRIMERO
		Home.pruebaExcel(leer,propiedades, rutaCarpeta);
		// SE LLAMA AL METODO DEL PASO A PASO PARA CREAR CUENTA
		crearCuenta.crearCuentaExcel(leer,propiedades, rutaCarpeta);
		
		// FINALIZAR EL PROCESO DE GRABACION
		MyScreenRecorder.stopRecording();
	}



	// ACCEDER AL METODO DE CREAR CUENTA DESDE HOME CON EXCEL
	@Test
	public void BcrearCuentaHomeMER() throws Exception
	{	
		// ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
		driver = ClaseBase.chromeDriverConnetion();		
		// CLASE BASE - (ScreenShots)
		claseBase = new ClaseBase(driver);
		// INSTANCIAR LA CLASE PAGEOBJECT-HOME
		Home = new PageObjectHome(driver);
		// INSTANCIAR LA CLASE PAGEOBJECT-CREAR CUENTA
		crearCuenta = new PageObjectCrearCuenta(driver);
		
		
		// OBTENER EL NOMBRE DEL TEST - (ScreenShot's)
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(propiedades,nomTest);
		
		
		// INICIAR EL PROCESO DE GRABACION
		MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
		
		// LLAMADO DE METODOS -->
		// ACCEDER A ABRIR PAGINA
		Home.urlAccesoExcel(leer,propiedades);		
		// SE LLAMA AL METODO DE CREAR CUENTA DESDE HOME
		Home.creaTuCuenta(leer,propiedades, rutaCarpeta);
		// SE LLAMA AL METODO DEL PASO A PASO PARA CREAR CUENTA
		crearCuenta.crearCuentaExcel(leer,propiedades, rutaCarpeta);
		
		// FINALIZAR EL PROCESO DE GRABACION
		MyScreenRecorder.stopRecording();
	}



	
	// ACCEDER AL METODO DE REGISTRAR UN USUARIO EN MERCURY
	@Test
	public void CregistrarUsuarioMercury() throws Exception
	{	
		// ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
		driver = ClaseBase.chromeDriverConnetion();		
		// CLASE BASE - (ScreenShots)
		claseBase = new ClaseBase(driver);
		// INSTRANCIAR LA CLASE PAGE OBJECT MERCURY
		mercuryHome = new PageObjectMercuryHome(driver);
		// ACCEDER AL METODO DE CREAR CUENTA
		mercuryCrearCuenta = new PageObjectMercuryCrearCuenta(driver);
		
		
		// OBTENER EL NOMBRE DEL TEST - (ScreenShot's)
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
		File rutaCarpeta = claseBase.crearCarpeta(propiedades,nomTest);
		
		
		// INICIAR EL PROCESO DE GRABACION
		MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
		
		// LLAMADO DE METODOS -->
		// ACCEDER A ABRIR PAGINA
		mercuryHome.urlAccesoExcelMercury(leer, propiedades);
		// SE LLAMA AL METODO DE ACCERDER AL FORMULARIO DE REGISTRO
		mercuryHome.registrarUsuario(leer,propiedades, rutaCarpeta);
		// SE LLAMA AL METODO DE RELLENAR EL FORMULARIO
		mercuryCrearCuenta.crearCuentaMercury(leer,propiedades, rutaCarpeta);
		
		// FINALIZAR EL PROCESO DE GRABACION
		MyScreenRecorder.stopRecording();
	}
	
	

	@After
	public void cerrar()
	{
		// CERRAR PROCESO
		driver.quit();
	}
}
