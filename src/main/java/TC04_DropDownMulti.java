import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC04_DropDownMulti {

public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement searchBox = driver.findElement(By.id("msdd"));
		searchBox.click();
		
		boolean boxVislible = driver.findElement(By.xpath("//div[@id='msdd']/following-sibling::div/child::ul"))
				.isDisplayed();
		System.out.println(boxVislible);
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='msdd']/following-sibling::div/child::ul/descendant::li/a"));
		
		String [] array = {"Bulgarian","Arabic","English"};
		if(boxVislible) {
				
			
			for(int i=0 ; i<list.size(); i++) {
				for(int j=0 ; j<array.length; j++) {
					if(list.get(i).getText().equals(array[j])) {
						list.get(i).click();
					}
				}
			}
		}
		
		
		

}
}
