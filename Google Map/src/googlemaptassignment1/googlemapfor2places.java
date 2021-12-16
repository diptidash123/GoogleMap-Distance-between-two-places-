package googlemaptassignment1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class googlemapfor2places 
{

//	  Using Selenium, Chrome driver and Java, automate Google Maps to get the distance between 2 places.
//    User will pass 2 parameters i.e. name of 2 places and the program should return the distance between those places.
	public static void main(String[] args) throws AWTException, InterruptedException
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\LENOVO\\Downloads\\chromedriver\\chromedriver_win32\\chromedriver.exe");
		
        //incognito window for test execution result
//		ChromeOptions options=new ChromeOptions();
//		options.addArguments("==incognito");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/maps");
		driver.findElement(By.xpath("//img[@class=\"searchbox-directions-icon\"]")).click();
		WebElement startplace= driver.findElement(By.xpath("(//input[@class=\"tactile-searchbox-input\"])[4]"));
		System.out.println("enter first place-delhi");
		startplace.sendKeys("delhi");
		startplace.click();
		WebElement endplace=driver.findElement(By.xpath("(//input[@class=\"tactile-searchbox-input\"])[5]"));
		System.out.println("enter second place-bhubaneswar");
		endplace.sendKeys("bhubaneswar");
		endplace.click();
        //Robot class used for keyboard operation
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(10000);
//		driver.findElement(By.xpath("//span[@id=\"section-directions-trip-details-msg-1\"]")).click();
//		WebElement place=driver.findElement(By.xpath("(//span[@class=\"section-trip-summary-subtitle\"])[1]"));
//		System.out.println(place.getText());
        WebElement places=driver.findElement(By.xpath("//div[@class=\"section-directions-trip-distance section-directions-trip-secondary-text\"]"));
        places.click();
        System.out.println("Distance between two places=" + places.getText());
      
	}

}
