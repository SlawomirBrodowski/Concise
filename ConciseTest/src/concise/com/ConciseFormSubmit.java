package concise.com;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConciseFormSubmit{
	
	private WebDriver driver;
	private String url = "http://tst.agrifirm.soot.pl";
	
	public ConciseFormSubmit() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				".//Resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@After
	public void tearDown() throws Exception {
		if (driver != null) {
			driver.quit();
		}
	}
	
	

	@Test
	public void test() {
		driver.get(url);
		driver.findElement(By.cssSelector("#ctl00_Zgloszenie")).click();
		driver.findElement(By.cssSelector("#zgloszenie_temat_Arrow")).click();
		driver.findElement(By.xpath("/html/body/form/div[1]/div/div/ul/li[3]")).click();
		driver.findElement(By.cssSelector("#ctl00_ContentPage_ctl00_zgloszenie_tresc")).sendKeys("Zg³oszenie testowe");
		driver.findElement(By.cssSelector("#ctl00_ContentPage_ctl00_zgloszenie_dane_firma")).sendKeys("Firma Concise");
		driver.findElement(By.cssSelector("#ctl00_ContentPage_ctl00_zgloszenie_kontakt")).sendKeys("slawomir.brodowski@yahoo.co.uk");
		driver.findElement(By.cssSelector("#ctl00_ContentPage_ctl00_zgloszenie_osoba_kontaktowa")).sendKeys("S³awomir Brodowski");
		driver.findElement(By.cssSelector("#ctl00_ContentPage_ctl00_ButtonZgloszenie")).click();
		String potwierdzenie = driver.findElement(By.cssSelector("#ctl00_ContentPage_ctl00_label_komunikat_ok")).getText();
		Assert.assertTrue(potwierdzenie.contentEquals("Zg³oszenie zosta³o wys³ane"));	

	}

}
