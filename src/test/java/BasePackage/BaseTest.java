package BasePackage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class BaseTest {
	public static WebDriver driver;
	public Logger logger;
	public Properties properties;

	@BeforeClass(groups = { "sanity", "regression", "master" })
	@Parameters({ "os", "browser" })
	public void setUp(String os, String browser) throws IOException {

		FileReader file = new FileReader(".//src/test/resources/config.properties");
		properties = new Properties();
		properties.load(file);

		logger = LogManager.getLogger(this.getClass());

		if (properties.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities cap = new DesiredCapabilities();

			if (os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN10);
			} else if (os.equalsIgnoreCase("Mac")) {
				cap.setPlatform(Platform.MAC);
			} else if (os.equalsIgnoreCase("Linux")) {
				cap.setPlatform(Platform.LINUX);
			} else {
				System.out.println("No mactching OS present");
				return;
			}
			switch (browser.toLowerCase()) {
			case "chrome":
				cap.setBrowserName("chrome");
				break;
			case "edge":
				cap.setBrowserName("MicrosoftEdge");
				break;
			case "firefox":
				cap.setBrowserName("firefox");
				break;
			default:
				System.out.println("choose Valid browser ");
				return;
			}
			 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		}
		if (properties.getProperty("execution_env").equalsIgnoreCase("local")) {

			switch (browser.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("choose Valid browser ");
				return;
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(properties.getProperty("appUrl"));
	}

	@AfterClass(groups = { "sanity", "regression", "master" })
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
	}

	public String randomString() {
		return RandomStringUtils.randomAlphabetic(6);

	}

	public String randomNumeric() {
		return RandomStringUtils.randomNumeric(10);

	}

	public String randomPassword() {
		return RandomStringUtils.randomNumeric(3) + "@" + RandomStringUtils.randomNumeric(3);

	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + " - " + timeStamp + ".png";
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);

		return targetFilePath;
	}

}
