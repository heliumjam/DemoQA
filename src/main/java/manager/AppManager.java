package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;

import java.util.concurrent.TimeUnit;

public interface AppManager {

  WebDriver wd = new ChromeDriver();
 //EventFiringWebDriver wd = new EventFiringWebDriver(new ChromeDriver());

 default void init(){
  wd.navigate().to("https://demoqa.com/");
  wd.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

 }

 @AfterSuite
 default void tearDown(){
//        wd.quit();
 }

}