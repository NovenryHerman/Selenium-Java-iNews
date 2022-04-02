package iNews.Berita;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM.Cariberita;
import POM.Beranda;
import POM.Travel;

public class TestcasePOM {
	
	public static WebDriver driver;
	public static Beranda web;
	public static Travel menu;
	public static Cariberita terbaru;

	@BeforeTest()
	public void before() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\novenry.herman\\Documents\\09Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void test1() throws InterruptedException{
		web = new Beranda(driver);
		web.assert1();
		web.assert2(); 
		web.assert3(); 
		
		 
		Thread.sleep(3000);
	}
	
	@Test(priority = 2)
	public void test2(){
		menu = new Travel(driver);
		menu.assert1();
		menu.assert2(); 
		menu.assert3(); 
		 
	}
	
	@Test(priority = 3)
	public void test3() throws InterruptedException{
		terbaru = new Cariberita(driver);
		terbaru.assert1();
		terbaru.assert2(); 
		terbaru.assert3(); 
				
	}
	
	
	@AfterTest()
	public void tutup() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}

}
