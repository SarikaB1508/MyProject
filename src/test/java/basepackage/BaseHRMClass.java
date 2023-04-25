package basepackage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseHRMClass {
	public static Properties prop= new Properties();
	public static WebDriver driver;
	
	public BaseHRMClass() {
		
		try    {
			FileInputStream file = new FileInputStream("C:\\Users\\Suraj\\eclipse-workspace-ROICIANS\\HRmanagement\\src\\test\\java\\environmentvariables\\Config.properties");
			prop.load(file);
		}
		catch (FileNotFoundException e) {
			System.out.println("We will be back-1");
		}
		catch(IOException a) {
			System.out.println("We will be back-2");
		}
	}
	public static void initiation() {
		String browsername = prop.getProperty("browser");
		//int time = Integer.parseInt(prop.getProperty("time"));
		
		if (browsername.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver= new FirefoxDriver();}
		else if(browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			ChromeOptions op=new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
			driver= new ChromeDriver(op);
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("time"))));
		driver.get(prop.getProperty("url"));
	}
	
		public static void screenshots(String Filename) {
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File("C:\\Users\\Suraj\\eclipse-workspace-ROICIANS\\HRmanagement\\src\\test\\java\\screenshot\\Screenshots\\pics\\" + Filename + ".jpg"));
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	

