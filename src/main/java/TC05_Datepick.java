import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC05_Datepick {

public static WebDriver driver;

public static void myMethod(WebElement element, String value) {
	Select select = new Select(element);
	select.selectByVisibleText(value);
}

public static void myMethod(WebElement element, int value) {
	Select select = new Select(element);
	select.selectByIndex(value);
}
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Datepicker.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		WebElement searchBox = driver.findElement(By.xpath("//*[@id='datepicker2']"));
	
		String date = "09/10/2026";
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].value='"+date+"'", searchBox);
		
		
		}
		
	}


