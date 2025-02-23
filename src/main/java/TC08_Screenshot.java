import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.util.concurrent.SimpleTimeLimiter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC08_Screenshot {
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://jqueryui.com/tooltip/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String image = time.format(new Date());

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file,
				new File("C:\\Users\\sagar\\eclipse-workspace\\CodeDownload\\src\\Screenshot\\" + image + ".png"));
		System.out.println("Done");
		driver.quit();
	}
}
