package ClasesBase;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

	public class ClaseBase {

	protected static WebDriver driver;
	
	// CONSTRUCTOR DE CLASE
	public ClaseBase(WebDriver driver) 
	{
		super();		
	}
	
	// METODO DE NAVEGADOR
	public static WebDriver chromeDriverConnetion() 
	{
		// SATEAR LAS OPCIONES DE NAVEGADOR
		ChromeOptions chromeOptions = new ChromeOptions ();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		// SATEAR LAS PROPIEDADES DEL NAVEGADOR
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		driver = new ChromeDriver();
		
		// MAXIMIZAR NAVEGADOR
		driver.manage().window().maximize();
		return driver;
	}
	
	
// SCREENSHOT -->
	
	// METODOD PARA GUARDAR LA FECHA DEL SISTEMA
	public String fechaHora() {
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();
		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
		// DAR FORMATO A LA FECHA DEL SISTEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}
		
	// METODO PARA GUARDAR LA HORA DEL SISTEMA
	public String HoraSistema() {
		// TOMAMOS LA HORA DEL SISTEMA
		LocalTime horaSistema = LocalTime.now();
		// DEFINIR FORMATO DE HORA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HH-mm-ss");
		// DAR FORMATO A LA HORA DEL SISTEMA
		String hora = fecha.format(horaSistema);
		return hora;
	}
	
	
	// METODO PARA GUARDAR LA FECHA DEL SISTEMA
	public String fechaSistema() {
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalDate fechaSistema = LocalDate.now();
		// DEFINIR FORMATO DE HORA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		// DAR FORMATO A LA HORA DEL SISTEMA
		String fechaSistem = fecha.format(fechaSistema);
		return fechaSistem;
	}
	
	
	// METODO DE FECHA MENOS x TIEMPO
	public String widgetsPruebaFecha(int restaAño, int restaMes, int restaDia, File rutaCarpeta) throws Exception
	{    
		String fecha = fechaSistema();
		String[] fechaVector = fecha.split("-");
		
		int dia = Integer.parseInt(fechaVector[0]);
		int mes = Integer.parseInt(fechaVector[1]);	
		int year = Integer.parseInt(fechaVector[2]);
		
		dia = dia-restaDia;
		mes = mes-restaMes;
		year = year-restaAño;
		
		String fechaFinal = mes+"/"+dia+"/"+year;
		
		return fechaFinal;
	}
	
	// METODO DE FECHA MENOS x TIEMPO
	public String widgetsPruebaFechaSinMes(int restaAño, int restaDia, File rutaCarpeta) throws Exception
	{    
		String fecha = fechaSistema();
		String[] fechaVector = fecha.split("-");
		
		int dia = Integer.parseInt(fechaVector[0]);
		//int mes = Integer.parseInt(fechaVector[1]);	
		int year = Integer.parseInt(fechaVector[2]);
		
		dia = dia-restaDia;
		//mes = mes-restaMes;
		year = year-restaAño;
		
		String fechaFinal = "  "+dia+", "+year;
		
		return fechaFinal;
	}
	
	// METODO DE FECHA MENOS x TIEMPO
	public String widgetsPruebaFechaHora(int restaAño, int restaMes, int restaDia, File rutaCarpeta) throws Exception
	{    
		String fecha = fechaHora();
		String[] fechaVector = fecha.split("-");
		
		int dia = Integer.parseInt(fechaVector[0]);
		int mes = Integer.parseInt(fechaVector[1]);	
		int year = Integer.parseInt(fechaVector[2]);
		
		dia = dia-restaDia;
		mes = mes-restaMes;
		year = year-restaAño;
		
		String fechaFinal = mes+"/"+dia+"/"+year;
		
		return fechaFinal;
	}

	
	
	// METODO PARA TOMAR LA CAPTURA DE PANTALLA
	public void ScreenShot(File rutaCarpeta) throws Exception {
		String hora = HoraSistema();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(rutaCarpeta+"\\"+hora+".png"));
	}
	
	
	// METODO PARA CREAR LA CARPETA DONDE SE ALMACENAN LOS SCREEN'S
	public File crearCarpeta(Properties propiedades, String nomTest) {
		// ALMACENAMOS LA FECHA DEL SISTEMA
		String fecha = fechaHora();
		// CREAMOS EL NOMBRE DE LA CARPETA
		String nomCarpeta = nomTest+"-"+fecha;
		// OBTENEMOS LA RETA DE ALOJAMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR
		File directorio = new File("./output/"+nomCarpeta);
		// CREAMOS LA CARPETA
		directorio.mkdir();
		return directorio;
	}
	
	
// METODOS BASE -->
	
		// METODO CLICK
		public void click(By locator, File rutaCarpeta) throws Exception
		{
			//ScreenShot(rutaCarpeta);
			driver.findElement(locator).click();
			tiempoEspera(2);
			ScreenShot(rutaCarpeta);
		}
		
		
		
		// METODO BORRAR
		public void borrar(By locator, File rutaCarpeta) throws Exception
		{
			driver.findElement(locator).clear();
			tiempoEspera(2);
			ScreenShot(rutaCarpeta);
		}
		
		
		// METODO REEMPLAZAR
		public void reemplazar(By locator, File rutaCarpeta) throws Exception
		{
			driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
			//driver.findElement(locator).clear();
			tiempoEspera(2);
			ScreenShot(rutaCarpeta);
		}
		
		
		// METODO ENTER
		public void enter(By locator, File rutaCarpeta) throws Exception
		{
			driver.findElement(locator).sendKeys(Keys.chord(Keys.ENTER));
			//driver.findElement(locator).clear();
			tiempoEspera(2);
			ScreenShot(rutaCarpeta);
		}
		
		
		
		// METODO ENVIAR-TEXTO (SENDKEY))
		public void sendkey(String inputText, By locator, File rutaCarpeta) throws Exception
		{
			driver.findElement(locator).sendKeys(inputText);
			tiempoEspera(2);
			ScreenShot(rutaCarpeta);
		}
		
		
		
		// METODO ENTER (SUBMIT)
		public void submit(By locator, File rutaCarpeta) throws Exception
		{
			driver.findElement(locator).submit();
			tiempoEspera(2);
			ScreenShot(rutaCarpeta);
		}
		
		
		
		// METODO TIEMPO DE ESPERA
		public void tiempoEspera(long tiempo) throws InterruptedException
		{
			Thread.sleep(tiempo*1000);
		}
		

		
		// METODO SCROLL
		public void scroll(int y, int numMovimiento) throws InterruptedException
		{
			// SCROLL DE PAGINA
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			// EL FOR SIRVE PARA DESPLAZARNOS MUCHAS MAS VECES
			for (int i=0; i<=numMovimiento; i++) {
		    js.executeScript("window.scrollBy(0,"+y+")");
			}
		}
		
		
		// METODO DE LEER UNA LISTA
		public List<WebElement> listaElementos(By locator) throws Exception
        {
          
            List<WebElement> elemento=driver.findElements(locator);
            return elemento;
            
        }
		
}
