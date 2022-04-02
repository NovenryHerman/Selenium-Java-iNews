package POM;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cariberita {
	public WebDriver driver;
	By CariBerita = By.xpath("/html/body/section[3]/div[2]/div/div[2]/div/div[2]/div/div/div/div/div/div[5]/div[2]/div[1]/div/div[1]/div[4]/div[1]/div[1]/div/a");
	
	//driver.findElement(By.xpath("//*[@id=\"autocomplete-google\"]")).sendKeys("Sandy");		
			//driver.findElement(By.xpath("//*[@id=\"autocomplete-google\"]")).sendKeys(Keys.ENTER);
	
	public Cariberita(WebDriver driver) {
		this.driver = driver;
	}
	
	public void assert1()
	{
		
		driver.get("https://www.inews.id/find?q=herman#gsc.tab=0&gsc.q=herman&gsc.page=1");
		boolean vali2 = driver.findElements(CariBerita).size() > 0;
		assertTrue(vali2);
	}
	
	public void assert2()
	{
		String tes2 = driver.getCurrentUrl();
		String tes1 = "https://www.inews.id/find?q=herman#gsc.tab=0&gsc.q=herman&gsc.page=1";
		assertEquals(tes1, tes2);
	}
	
	public void assert3() {
		boolean vali = driver.getTitle().equalsIgnoreCase("Heran");
		assertFalse(vali);
	}
	
}
