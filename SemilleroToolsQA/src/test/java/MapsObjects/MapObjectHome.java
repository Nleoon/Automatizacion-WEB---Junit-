package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClasesBase.ClaseBase;

public class MapObjectHome extends ClaseBase {

	public MapObjectHome(WebDriver driver) 
	{
		super(driver);		
	}
	
	// ELEMENTOS DE PAGINA HOME
	protected By cardAlertsFrameWindows=By.xpath("//*[text()='Alerts, Frame & Windows']"); // CARD DE ALERTS FRAME & WINDOWS
	protected By cardWidgets=By.xpath("//*[text()='Widgets']"); // CARD DE ALERTS FRAME & WINDOWS
}
