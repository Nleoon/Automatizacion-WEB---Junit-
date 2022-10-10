package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClasesBase.ClaseBase;

public class MapObjectAlertsFrameWindows extends ClaseBase
{

	public MapObjectAlertsFrameWindows(WebDriver driver) 
	{
		super(driver);
	}

	// ELEMENTOS DE PAGINA HOME
	protected By btnAlerts=By.xpath("//*[@id='item-1']/span[text()='Alerts']"); // BOTON PARA ACCEDER AL APARTADO DE ALERTS
	protected By btnAlertButton1=By.id("alertButton"); // PRIMER BOTON DE LA SECCION DE ALERTS
	protected By btnAlertButton2=By.id("timerAlertButton"); // SEGUNDO BOTON DE LA SECCION DE ALERTS
	protected By btnAlertButton3=By.id("confirmButton"); // TERCER BOTON DE LA SECCION DE ALERTS
	protected By btnAlertButton4=By.id("promtButton"); // CUARTO BOTON DE LA SECCION DE ALERTS
}
