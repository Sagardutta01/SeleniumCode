import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC06_MMTDate {
	public static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement close = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
		WebElement ad = driver.findElement(By.xpath("//*[@class='modalMain tcnFooter']"));
		
		if(ad.isDisplayed()) {
			close.click();
		}
		
		WebElement dept = driver.findElement(By.xpath("//*[contains(@data-cy,'departureDate')]"));
		dept.click();
		
		WebElement back = driver.findElement(By.xpath("//*[@aria-label=\"Previous Month\"]"));
		WebElement fwd = driver.findElement(By.xpath("//*[@aria-label=\"Next Month\"]"));
		
		//*[@class='DayPicker-Month'][1]//*[@class='DayPicker-Week']
		WebElement heading = driver.findElement(By.xpath("//div[@class='DayPicker-NavBar']/following-sibling::div[@class='DayPicker-Months']/div[1]/div[@class='DayPicker-Caption']"));
		
		while(!heading.getText().equals("March 2025")) {
			fwd.click();
		}
		
		String date = "//div[@class='DayPicker-Day']/div[@class='dateInnerCell']/p";
		String price = "//div[@class='DayPicker-Day']/div[@class='dateInnerCell']//*[@class=' todayPrice']";
		
		
		List<WebElement> dates = driver.findElements(By.xpath(date));
		List<WebElement> prices = driver.findElements(By.xpath(price));
		
		for(int i=0 ; i<dates.size(); i++) {
			boolean check=dates.get(i).isEnabled();
			if(check && dates.get(i).getText().equals("25")) {
				
				dates.get(i).click();
				break;
			}
		}
		
	}

}
