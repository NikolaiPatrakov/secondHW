import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
        Configuration.headless = false;
    }
    @Test
    void fillPracticeFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Nikolai");
        $("#lastName").setValue("Patrakov");
        $("#userEmail").setValue("testguru@auto.com").pressTab();
        $(byText("Male")).click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $("[class=react-datepicker__month-select]").selectOptionByValue("2");
        $("[class=react-datepicker__year-select]").selectOptionByValue("1991");
        $(byXpath("//div[contains(@aria-label, \"March 20\")]")).click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("e").pressTab();
        $(byText("Reading")).click();
        $("#uploadPicture").sendKeys("C:\\Users\\Administrator\\qaGuruReps\\secondHW\\src\\test\\resources\\test-picture.jpg");
        $("#currentAddress").setValue("some address");
        $("#state").scrollIntoView(true).click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Noida")).click();
        $("#submit").click();

        $(byText("Thanks for submitting the form")).shouldBe(visible);
        $(byXpath("//*[@class='modal-content']//tr[1]//td[2]")).shouldHave(text("Nikolai Patrakov"));
        $(byXpath("//*[@class='modal-content']//tr[2]//td[2]")).shouldHave(text("testguru@auto.com"));
        $(byXpath("//*[@class='modal-content']//tr[3]//td[2]")).shouldHave(text("Male"));
        $(byXpath("//*[@class='modal-content']//tr[4]//td[2]")).shouldHave(text("0123456789"));
        $(byXpath("//*[@class='modal-content']//tr[5]//td[2]")).shouldHave(text("20 March,1991"));
        $(byXpath("//*[@class='modal-content']//tr[6]//td[2]")).shouldHave(text("English"));
        $(byXpath("//*[@class='modal-content']//tr[7]//td[2]")).shouldHave(text("Reading"));
        $(byXpath("//*[@class='modal-content']//tr[8]//td[2]")).shouldHave(text("test-picture.jpg"));
        $(byXpath("//*[@class='modal-content']//tr[9]//td[2]")).shouldHave(text("some address"));
        $(byXpath("//*[@class='modal-content']//tr[10]//td[2]")).shouldHave(text("NCR Noida"));
    }
}