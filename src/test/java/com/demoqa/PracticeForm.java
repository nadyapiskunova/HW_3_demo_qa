package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm {
    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "720x1080";
    }
    @Test
    void FormTest(){
        open("/automation-practice-form");
        $("#firstName").setValue("Nadya");
        $("#lastName").setValue("Piskunova");
        $("#userEmail").setValue("test@mail.com");
        $("[for=gender-radio-2]").click();
        $("#userNumber").setValue("7123456788");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption(05);
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOptionContainingText("1999");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__day--002").click();
        $("#subjectsInput").scrollTo().setValue("English").pressEnter();
        $("[for=hobbies-checkbox-1]").scrollTo().click();
        $("#uploadPicture").scrollTo().uploadFile(new File("src/test/resources/pin.png"));
        $("#currentAddress").scrollTo().setValue("Taganrog");
        $("#state").scrollTo().click();
        $(byText("NCR")).click();
        $("#city").scrollTo().click();
        $(byText("Delhi")).scrollTo().click();
        $("#submit").scrollTo().click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(
                text("Nadya Piskunova"),
                text("test@mail.com"),
                text("Female"),
                text("7123456788"),
                text("02 June,1999"),
                text("English"),
                text("Taganrog"),
                text("Sports"),
                text("pin.png"),
                text("NCR Delhi"));










    }
}
