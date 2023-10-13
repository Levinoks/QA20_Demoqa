package tests;

import manager.HelperStudent;
import models.StudentDTO;
import models.StudentDTOLombok;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentRegFormTests extends TestBase implements HelperStudent {

    @BeforeMethod
    public void precondition() {
        selectForm();
        selectPracticeForm();
    }


    @Test
    public void StudentRegFormPositiveTest(){
        StudentDTO student = new StudentDTO("Frodo", "Baggins", "frodobaggins@mail.com","Male","1234567890",
                "11 Sep 2021","Maths,Physics","Sports,Music","J.Washington street, 10","NCR", "Delhi");
        StudentDTOLombok studentLombok = StudentDTOLombok.builder()
                .firstName("Frodo")
                .lastName("Beggins")
                .email("qwe123@gmail.com")
                .gender("Male")
                .mobile("12309856748")
                .dateOfB("27 Mar 1994")
                .subject("Math")
                .hobbies("Music")
                .address("Street")
                .state("NCR")
                .city("Delhi")
                .build();
        //fillStudentForm(student);
        fillStudentForm(student);
        //pause(3);

        clickButtonSubmit();
        Assert.assertTrue(isElementPresent_ThanksForSubmit());


    }
    @AfterTest
    public void postconditions (){
        pause(3);
        clickBtnCloseJS();
    }

}
