package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public interface HelperBase extends AppManager{
    default void pause(int second){
        try {
            Thread.sleep(second*1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    default void hideAds(){
        JavascriptExecutor hideAdd = (JavascriptExecutor) driver;
        hideAdd.executeScript("document.querySelector('#adplus-anchor').style.display='none'");

    }

    default void hideFooter(){
        JavascriptExecutor hideFoot = (JavascriptExecutor) driver;
        hideFoot.executeScript("document.querySelector('footer').style.display='none'");
    }

    default void hideDiv(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "document.querySelector('#close-fixedban').style.display='none'");
    }


    default  boolean isElementPresent (By locator){

       // return driver.findElements(locator).size()>0;
       return !driver.findElements(locator).isEmpty();
    }


    default  void click(By locator){
        driver.findElement(locator).click();

    }

    default void type(By locator, String text){
        WebElement elem =driver.findElement(locator);
        elem.click();
        elem.clear();;
        elem.sendKeys(text);


    }

}
