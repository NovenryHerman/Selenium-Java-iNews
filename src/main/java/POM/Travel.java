package POM;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Travel {
	public WebDriver driver;
	@FindBy (how = How.XPATH, using = "//*[@id=\"___gcse_0\"]/div/div/div/div[5]/div[2]/div[1]/div/div[1]/div[3]/div[1]/div[1]/div/a") WebElement Cariberita;
	By BeritaBaru = By.xpath("/html/body/section[1]/div/nav/div[2]/ul/li[6]/a");
	By Travel = By.xpath("/html/body/section[3]/div[2]/div/div[3]/div/div[1]/ul/li[1]/a");
	
	public Travel(WebDriver driver) {
		this.driver = driver;
	}
	
	public void assert1()
	{
		
		driver.get("https://www.inews.id/travel");
		boolean vali = driver.findElements(BeritaBaru).size() > 0;
		assertTrue(vali);
	}
	
	public void assert2()
	{
		String tes2 = driver.getCurrentUrl();
		String tes1 = "https://www.inews.id/travel";
		assertEquals(tes1, tes2);
	}
	
	public void assert3() {
		boolean vali = driver.getTitle().equalsIgnoreCase("Berita Travel Terbru Hari Ini - iNews Porta");
		assertFalse(vali);
	}
				
}
