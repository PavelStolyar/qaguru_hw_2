package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTests {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successFullFillTest() {
        // test data
        String firstName = "testFirstName";
        String lastName = "testLastName";
        String userEmail = "testemail@test.com";
        String userNumber = "1234567890";
        String subjectItem = "History";
        String fileName = "testImage.png";
        String address = "testCurrentAddress";
        String state = "NCR";
        String city = "Delhi";

        //open page
        open("https://demoqa.com/automation-practice-form");

        // fill fields on page
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("2019");
        $("[aria-label='Choose Tuesday, May 7th, 2019']").click();
        $("#subjectsInput").setValue(subjectItem).pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath(fileName);
        $("#currentAddress").setValue(address);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        //check modal
        $(".modal-body").shouldHave(text(firstName),
                text(lastName),
                text(userEmail),
                text("Male"),
                text(userNumber),
                text("7 May,2019"),
                text(subjectItem),
                text("Sports"),
                text(fileName),
                text(address),
                text(state),
                text(city));


    }
}
