package POM;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Beranda
{
	public WebDriver driver;
	
	@FindBy (how = How.XPATH, using = "/html/body/section[1]/div/nav/div[2]/ul/li[6]/a") WebElement Travel;
	By Travel0 = By.xpath("/html/body/section[1]/div/nav/div[2]/ul/li[6]/a");
	By home1 = By.xpath("/html/body/section[1]/div/nav/div[2]/ul/li[1]/a");
	public Beranda(WebDriver driver) {
		this.driver = driver;
	}
	
	public void Homepage(WebDriver driver)
    {
		PageFactory.initElements(driver, this);
    }
	public void assert1() {
		driver.get("https://www.inews.id/");
		boolean home = driver.findElements(home1).size() > 0;
		assertTrue(home);
	}
	
	public void assert2() {
		String tes1 = driver.getCurrentUrl();
		String tes2 = "https://www.inews.id/";
		assertEquals(tes2, tes1);
	}


	public void assert3() {
		
		boolean home = driver.getTitle().equalsIgnoreCase("Berita Hari ini - iNews Porta");
		assertFalse(home);
	}
	
	public void MenuTravel()
    {
		driver.findElement(Travel0).click();
    }


	
}
