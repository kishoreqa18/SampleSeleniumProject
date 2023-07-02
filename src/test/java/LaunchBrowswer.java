import com.amazonaws.services.opsworks.model.App;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LaunchBrowswer {
    static WebDriver driver;
    static Properties prop=null;

    public static void readDataFromPropertiesFile(){
        try {
FileInputStream file = new FileInputStream("C:\\Users\\kisho\\Downloads\\SerenityWithWebDriverJunit-master\\" +
        "SampleSeleniumProject\\src\\Constants.properties");
            prop = new Properties();
            prop.load(file);
        }catch (NullPointerException | IOException e){
            e.printStackTrace();
        }

    }
    public static void launch(String emailID, String password) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","D:\\SOFTWARES\\chromedriver_win32 (3)\\chromedriver.exe");
       driver = new ChromeDriver();
       driver.navigate().to("https://nextask.nextsphere.com/#/");
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       Thread.sleep(5000);
        driver.findElement(By.cssSelector("input[name='loginfmt'")).sendKeys(emailID);
        driver.findElement(By.cssSelector("input[type='submit'")).click();
// Tetsin
        driver.findElement(By.cssSelector("input[name='passwd'")).sendKeys(password);
        driver.findElement(By.cssSelector("input[type='submit'")).click();
    }

    public static void main(String[] args) throws InterruptedException {
        readDataFromPropertiesFile();
     launch(LaunchBrowswer.prop.getProperty("EmailID"),prop.getProperty("Password"));

    }
}
