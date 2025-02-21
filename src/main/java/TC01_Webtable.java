import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC01_Webtable {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='contactList']/tbody/tr"));
		List<WebElement> tableCols = driver.findElements(By.xpath("//table[@id='contactList']/tbody/tr/th"));
		
		String cell1 = "//table[@id='contactList']/tbody/tr[";
		String cell2 = "]/td[";
		String cell3 = "]";
		
		
		/*find salary of Maria Anders ?*/
						
		for(int i=2; i<=tableRows.size(); i++) {
			for(int j=1; j<=tableCols.size(); j++) {
				String path = cell1+i+cell2+j+cell3;
				String CellValue = driver.findElement(By.xpath(path)).getText();
				//System.out.println(CellValue);
				if(CellValue.equals("Maria Anders")) {
					String salaryOfMaria = "//table[@id='contactList']/tbody/tr["+i+"]/td[4]";
					WebElement salaryOfMariaTxt = driver.findElement(By.xpath(salaryOfMaria));
					System.out.println("salary of Maria Anders is "+salaryOfMariaTxt.getText());
				}
				
				
			}
			
		}
		/*list out all the country name ?*/
		
		Set<String> countryList = new HashSet<>();
		for(int i=2; i<=tableRows.size(); i++) {
			String countryPath = "//table[@id='contactList']/tbody/tr["+i+"]/td[3]";
			WebElement countryName = driver.findElement(By.xpath(countryPath));
			
			if(!countryList.contains(countryName.getText())) {
				countryList.add(countryName.getText());
			}
		}
		System.out.println(countryList);
		
		/*find the Sum of total salary ?*/
		int count = 0; 
		for(int i=2; i<=tableRows.size(); i++) {
			String salaryPath = "//table[@id='contactList']/tbody/tr["+i+"]/td[4]";
			WebElement salary = driver.findElement(By.xpath(salaryPath));
			count = count + Integer.parseInt(salary.getText());
		}
		System.out.println("Total is "+count);
		
				
		
		
		

	}

}
