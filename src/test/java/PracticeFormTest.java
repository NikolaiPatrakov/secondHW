import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.headless = false;
    }
    @Test
    void fillPracticeFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Nikolai");
        $("#lastName").setValue("Patrakov");
        $("#userEmail").setValue("testguru@auto.com").pressTab();
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $("[class=react-datepicker__month-select]").selectOptionByValue("2");
        $("[class=react-datepicker__year-select]").selectOptionByValue("1991");
        $(".react-datepicker__day--020:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("test-picture.jpg");
        $("#currentAddress").setValue("some address");
        $("#state").scrollIntoView(true).click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        $(byText("Thanks for submitting the form")).shouldBe(visible);

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Nikolai Patrakov"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("testguru@auto.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("0123456789"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("20 March,1991"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("English"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("test-picture.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("some address"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Noida"));
    }
}