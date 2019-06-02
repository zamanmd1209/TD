package multiBrowserTest;

import java.io.File;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;






public class MultiBrowserTestNG {
	
	WebDriver driver=null;
	SoftAssert softAss;
	
//	String path="FailedScreenShot";
//	File destFile;

	
	@BeforeTest
	public void setupTest() {
		System.out.println("google is launched");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			 driver= new ChromeDriver();
		
	}
		@Test
	public void googleSearch(Method testmethod) throws Exception {
		String tesmethd=testmethod.getName();
			DateTimeFormatter format= DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
			LocalDateTime currTime= LocalDateTime.now();
		String prefix=format.format(currTime);
		System.out.println(prefix);
	
	
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Bangladesh"+Keys.ENTER);
		
		String actual= driver.findElement(By.xpath("//*[text()=\"Bangladesh - Wikipedia\"]")).getText();
//		String actual= driver.findElement(By.xpath("//*[text()="Bangladesh - Wikipedia"]")).getText();
		String Expected= "Bangladesh - Wikipedia";
		
		softAss= new SoftAssert();
		// new line added
		System.out.println("new line added");
		
		softAss.assertEquals(actual, Expected);
		
		softAss.assertAll();
		//*[text()="Bangladesh - Wikipedia"]
		
		
		
		if(actual.equals(Expected)) {
			System.out.println("------  Your test is Pass------ ");
		}
		
		else System.out.println("---FAIL----");
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		destFile= new File(path + "/simpleScreenShot.png");
		
		FileUtils.copyFile(scr, new File("./FailedScreenShot/"+tesmethd+prefix+"_ss.png"));
		
		System.out.println(prefix);
		}
		
	@AfterTest
	public void tearDown() {
		
		driver.quit();
		System.out.println("Test completed Successfully......");
		
	}
		}

