import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC09_BrokenLinkTest {
	public static WebDriver driver;
	
	public static void testMethod(String link) throws IOException {
		if(link.isEmpty() || link.equals(" ")) {
			return;
		}
		
		 if (!link.startsWith("http://") && !link.startsWith("https://")) {
	            return;
	        }
		
		URL url = new URL (link);
		HttpURLConnection TestConnect = (HttpURLConnection) url.openConnection();
		TestConnect.setConnectTimeout(5000);
		TestConnect.connect();
		
		if(TestConnect.getResponseCode()>=400) {
			System.out.println(link+"-->"+TestConnect.getResponseMessage());
		}else {
			//System.out.println(link+"-->"+TestConnect.getResponseMessage());
		}
	}

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println(list.size());
		
		for(WebElement i : list) {
			String link = i.getAttribute("href");
			
			CompletableFuture.runAsync(() ->{
			try{
				testMethod(link);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			});
		
		}
		
		driver.quit();
		
	}

}
