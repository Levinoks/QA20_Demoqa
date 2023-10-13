package manager;

import models.StudentDTO;
import models.StudentDTOLombok;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public interface HelperStudent extends HelperBase {


    default void selectForm() {
        if (isElementPresent(By.id("adplus-anchor")))
            hideAds();
        if (isElementPresent(By.cssSelector("footer")))
            hideFooter();
        if (isElementPresent(By.id("close-fixedban")))
            hideDiv();
        click(By.xpath("//div[@class='category-cards']/div[2]"));
    }

    default void selectPracticeForm() {
      //  hideAds();
        hideFooter();
click(By.xpath("//div[@class='header-wrapper']/div[text()='Forms']"));

        click(By.xpath("//span[text()='Practice Form']"));
    }

  default void  fillStudentForm(StudentDTO student){
type(By.xpath("//input[@id='firstName']"), student.getFirstName());
      type(By.id("lastName"), student.getLastName());
      type(By.id("userEmail"), student.getEmail());

      selectGender(student.getGender());
      type(By.id("userNumber"), student.getMobile());

      //type(By.id("dateOfBirthInput"), student.getDateOfB());
      typeBDay(student.getDateOfB());
      addSubject(student.getSubject());
      selectHobby(student.getHobbies());
      loadPicture();

      type(By.id("currentAddress"), student.getAddress());
      typeState(student.getState());
      typeCity(student.getCity());
  }

    default void fillStudentForm(StudentDTOLombok student) {
        //hideFooter();
        type(By.id("firstName"), student.getFirstName());
        type(By.id("lastName"), student.getLastName());
        type(By.id("userEmail"), student.getEmail());

        selectGender(student.getGender());
        type(By.id("userNumber"), student.getMobile());

        //type(By.id("dateOfBirthInput"), student.getDateOfB());
        typeBDay(student.getDateOfB());
        addSubject(student.getSubject());
        selectHobby(student.getHobbies());
        loadPicture();

        type(By.id("currentAddress"), student.getAddress());
        typeState(student.getState());
        typeCity(student.getCity());


    }

    default void clickBtnCloseJS(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#closeLargeModal').click();");
    }
    default boolean isElementPresent_ThanksForSubmit(){
        return isElementPresent(By.id("example-modal-sizes-title-lg"));
    }



    default void clickButtonSubmit(){
        click(By.id("submit"));
    }

    default void typeCity(String city){
        driver.findElement(By.id("react-select-4-input")).sendKeys(city);
        driver.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);

    }

    default void typeState(String state){
        driver.findElement(By.id("react-select-3-input")).sendKeys(state);
        driver.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);

    }

    default void loadPicture() {
        driver.findElement(By.id("uploadPicture")).
                sendKeys("C://Users//nosni//Data//TelRan//Automation//QA_20_DemoQA//cat_cat_face_cats_eyes_240527.jpg");
    }

    default void selectHobby(String hobbies) {
        String [] hobbiesArray = hobbies.split(",");
        for (String element:hobbiesArray) {
            switch (element) {
                case "Sports":
                    click(By.xpath("//label[@for='hobbies-checkbox-1']"));
                    break;
                case "Reading":
                    click(By.xpath("//label[@for='hobbies-checkbox-2']"));
                    break;
                case "Music":
                    click(By.xpath("//label[@for='hobbies-checkbox-3']"));
                    break;
            }
        }

    }

    default void addSubject(String subject) {
        String[] subjectsArray = subject.split(",");
        WebElement sub = driver.findElement(By.id("subjectsInput"));
        sub.click();
        for (String element : subjectsArray) {
            sub.sendKeys(element);
            sub.sendKeys(Keys.ENTER);
        }

    }

    default void typeBDay(String birthday) {
        WebElement date = driver.findElement(By.id("dateOfBirthInput"));
        date.click();
        date.sendKeys(Keys.CONTROL, "a");
        date.sendKeys(birthday);
        date.sendKeys(Keys.ENTER);
    }

    default void selectGender(String gender) {
        if (gender.equals("Male")) {
            click(By.xpath("//label[@for='gender-radio-1']"));
        } else if (gender.equals("Female")) {
            click(By.xpath("//label[@for='gender-radio-2']"));
        } else {
            click(By.xpath("//label[@for='gender-radio-3']"));
        }
    }

}
