package ClasesBase;

import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");
		// DAR FORMATO A LA HORA DEL SISTEMA
		String hora = fecha.format(horaSistema);
		return hora;
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
	
	
}
