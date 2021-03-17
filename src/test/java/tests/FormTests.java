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
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("testFirstName");
        $("#lastName").setValue("testLastName");
        $("#userEmail").setValue("testemail@test.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("2019");
        $("[aria-label='Choose Tuesday, May 7th, 2019']").click();
        $("#subjectsInput").setValue("History").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("testImage.png");
        $("#currentAddress").setValue("testCurrentAddress");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $(".modal-body").shouldHave(text("testFirstName"),
                text("testLastName"),
                text("testemail@test.com"),
                text("Male"),
                text("1234567890"),
                text("7 May,2019"),
                text("History"),
                text("Sports"),
                text("testImage.png"),
                text("testCurrentAddress"),
                text("NCR"),
                text("Delhi"));

        $("#closeLargeModal").click();

    }
}
