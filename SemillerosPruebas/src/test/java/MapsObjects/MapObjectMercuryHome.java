package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ClasesBase.ClaseBase;

public class MapObjectMercuryHome extends ClaseBase 
{
	// CONSTRUCTOR DE LA CLASE
	public MapObjectMercuryHome(WebDriver driver) 
	{
		super(driver);
	}
	
	// ELEMENTOS DE LA PAGINA HOME DE MERCURY TOURS	
	protected By btnRegistrar=By.xpath("//td/a[@href='register.php']"); //BOTON DE REGISTRAR - NAVBAR

}
