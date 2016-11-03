package fire;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testfirefox {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://s-tv.yousee.dk");

	}

}
