import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//newquick oness
public class QuickWork {
	
	public static WebDriver driver;

public static void main(String[] args) {
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\cc305906\\Documents\\Selinium\\geckodriver.exe");
	driver = new FirefoxDriver();
	
	driver.get("http://www.rediff.com/");

	}

}
