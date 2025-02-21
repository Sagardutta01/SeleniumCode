import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC03_DropDown {

	public static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement searchBox = driver.findElement(By.id("Skills"));
		/*
		List<WebElement> list = driver.findElements(By.id("Skills"));
		for(WebElement i : list) {
			System.out.println(i.getText().toString().trim());
		}
		*/
		
		Select select = new Select(searchBox);
		List<WebElement> selectList = select.getOptions();
		System.out.println(selectList.size());
		for(WebElement i : selectList) {
			System.out.println(i.getText());
			
		}
		
		
	}
}
