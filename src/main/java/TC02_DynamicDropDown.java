import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC02_DynamicDropDown {

public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("vivo mobile 5g");
		
		
		
		//List<WebElement> listSearch = driver.findElements(By.xpath("//ul[starts-with(@class,'_1sFryS _2x2Mmc')]/child::li/descendant::div[@class='YGcVZO _2VHNef']"));
		List<WebElement> listSearch = driver.findElements(By.xpath("//ul[starts-with(@class,'_1sFryS _2x2Mmc')]/child::li/descendant::div/a"));
		
		for(WebElement i : listSearch) {
			String Text = i.getText();
			System.out.println(Text);
	
		}
			for(WebElement i : listSearch) {
								
				if(i.getText().equals("vivo mobile 5g")) {
					i.click();
					break;
				}

	}
}

}
