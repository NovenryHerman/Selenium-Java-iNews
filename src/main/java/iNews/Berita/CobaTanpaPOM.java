package iNews.Berita;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CobaTanpaPOM 

{
	
	public static WebDriver driver;
	
	@BeforeTest
	public void beforetest () throws InterruptedException
	{
				
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\novenry.herman\\Documents\\09Selenium\\chromedriver.exe");   
		
		driver = new ChromeDriver(options);
	}
	
	
	@SuppressWarnings("deprecation")
	@Test (priority=1)
	public void test1 () throws InterruptedException
	{
		//ini buat buka webnya
		driver.manage().window().maximize();
		String expectedtitle = "Berita Hari ini - iNews Portal" ;
		driver.get("https://www.inews.id/");
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	
    	String actualtitle = driver.getTitle(); 
		Assert.assertEquals(actualtitle, expectedtitle);
		
		boolean test1 = driver.findElements(By.xpath("/html/body/section[1]/div/nav/div[2]/ul/li[1]/a")).size() > 0;
		Assert.assertTrue(test1);
	}
	
	@Test(priority=2)
	public void test2 () throws InterruptedException
	{
				//ini untuk klik menu travel 2
				String titletravel1 = "Berita Travel Terbaru Hari Ini - iNews Portal" ;
				WebElement travel = driver.findElement(By.xpath("/html/body/section[1]/div/nav/div[2]/ul/li[6]/a"));
				travel.click();
				Thread.sleep(3000);
				//driver.get("https://www.inews.id/travel");
				//ini uncuk scrool ke bawah kalo mau ke atas tambah min contoh -400
				//INI untuk Scrool YAH
				JavascriptExecutor jse1 = (JavascriptExecutor) driver;
				jse1.executeScript("windows.scrollBy(0,7000)");
				 
				//jse.executeScript("window.scrollBy(0,-400)");
				String titletravel2 = driver.getTitle(); 
				Assert.assertEquals(titletravel2, titletravel1);
				Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void test3 () throws InterruptedException
	
	{
		//ini klik berita terbaru travel 3
			WebElement beritabaru = driver.findElement(By.xpath("//*[@id=\"news-list\"]/li[1]"));
			String titletravel3 = "Sandiaga Uno Jajal Wisata Kekinian Lounge In The Sky: Keindahan yang Belum Tereksplorasi"; 				
			beritabaru.click();
			
			Thread.sleep(3000);
				//driver.get("https://www.inews.id/travel/kuliner/mengenang-sosok-chef-lucky-andreono-juara-masterchef-indonesia-season-1-pernah-jadi-tukang-cuci-piring");
				
				
				  driver.findElement(By.xpath("//*[@id=\"onesignal-slidedown-cancel-button\"]")).click(); 
				  Alert alertCancel = driver.switchTo().alert();
				  alertCancel.dismiss();
				 JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("windows.scrollBy(0,1000)");
				Thread.sleep(3000);
				jse.executeScript("windows.scrollBy(0,-1000)");
				
				
				//ini untuk cari berita
				
			
				driver.findElement(By.xpath("//*[@id=\"autocomplete-google\"]")).sendKeys("Sandy");		
				driver.findElement(By.xpath("//*[@id=\"autocomplete-google\"]")).sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				String titletravel4 = driver.getTitle(); 
				Assert.assertEquals(titletravel4, titletravel3);
	}
	
	@AfterTest 
	public void aftertest () throws InterruptedException
	{
				driver.close();
	}
	
	
	
}
