package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public interface AppManager {
    WebDriver driver = new ChromeDriver();

    default void init(){
        driver.navigate().to("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    default void initAddOptions(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.navigate().to("https://demoqa.com/");



        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for (String element: tabs) {
            System.out.println(element);
        }
        driver.switchTo().window(tabs.get(1)).close();
        driver.switchTo().window(tabs.get(0));

        driver.navigate().refresh();  //back    forward

    }


    default void tearDown(){
        driver.quit();
    }
}
