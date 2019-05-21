package GoogleTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleVerify {
	@Test
	public void googleTestNG() {
//	public static void main(String[] args) {
		
	
	System.out.println("google is launched");
	System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Bangladesh"+Keys.ENTER);
		
		String actual= driver.findElement(By.xpath("//*[text()=\"Bangladesh - Wikipedia\"]")).getText();
//		String actual= driver.findElement(By.xpath("//*[text()="Bangladesh - Wikipedia"]")).getText();
		String Expected= "Bangladesh - Wikipedia";
		
		
		//*[text()="Bangladesh - Wikipedia"]
		
//		Assert.assertEquals(Expected, actual);
		System.out.println(" passed from Assert:......");
		
		if(actual.equals(Expected)) {
			System.out.println("------  Your test is Pass------ ");
		}
		
		else System.out.println("---FAIL----");
		driver.quit();
		}
		
		}

