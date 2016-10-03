import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 4/15/2016.
 */
public class parseSite {

    public static List<WebElement> allBuild;

    public static List<WebElement> parseSite(String s) throws Exception {
       DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\Users\\Admin\\Desktop\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        WebDriver driver = new PhantomJSDriver(caps);
        driver.get(s);

        driver.findElement(By.id("username")).sendKeys();
        driver.findElement(By.id("password")).sendKeys();
        driver.findElement(By.xpath("//input[@class='btn loginButton']")).click();

        Thread.sleep(1000);
        driver.navigate().to("");
        List<WebElement> allElement = driver.findElements(By.xpath("//tr[@class='lastFinished']/descendant::span[@class='buildNumberInner']"));
        List<WebElement> allBuilds = driver.findElements(By.className("buildTypeName "));
        allBuild=allBuilds;
        System.out.println(driver.getCurrentUrl());
        return allElement;

    }

}
