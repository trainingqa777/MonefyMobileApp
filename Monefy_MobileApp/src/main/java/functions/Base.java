package functions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Base {
	
	public static AppiumDriver<MobileElement> driver;

	public void InitilizeAndOpenAppliction(String appLocation) {	
		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			
			cap.setCapability("deviceName", "emulator-5554");
			cap.setCapability("deviceOrientation", "portrait");
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "11");
			cap.setCapability("app", appLocation);
			
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url,cap);
			System.out.println("Application started...");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	public boolean isPresent(List<WebElement> element) {
		return element.size()>0;		
	}
}
