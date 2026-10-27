import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.TestData.*;

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
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail).pressTab();
        $("#genterWrapper").$(byText(genderOption)).click();
        $("#userNumber").setValue(userMobileNumber);
        $("#dateOfBirthInput").click();
        $("[class=react-datepicker__month-select]").selectOptionByValue(dateOfBirthMonthOption);
        $("[class=react-datepicker__year-select]").selectOptionByValue(dateOfBirthYearOption);
        $(".react-datepicker__day--020:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(subjectOption).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbiesOption)).click();
        $("#uploadPicture").uploadFromClasspath("test-picture.jpg");
        $("#currentAddress").setValue(currentAddress);
        $("#state").scrollIntoView(true).click();
        $("#stateCity-wrapper").$(byText(stateOption)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(cityOption)).click();
        $("#submit").click();

        $(byText("Thanks for submitting the form")).shouldBe(visible);

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName +
                " " + lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(userEmail));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(genderOption));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userMobileNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(fullDateOfBirth));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subjectOption));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobbiesOption));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("test-picture.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(stateOption +
                " " + cityOption));
    };
}