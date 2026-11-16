package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbieWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateInput = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            submitButton = $("#submit"),
            modalDialog = $(".modal-dialog"),
            modalDialogTitle = $("#example-modal-sizes-title-lg");



    CalendarComponent calendarComponent = new CalendarComponent();
    TableComponent tableComponent = new TableComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbie(String value) {
        hobbieWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage submit() {
        submitButton.click();

        return this;
    }

    public RegistrationPage checkSubmitFormAppear(String value) {
        modalDialog.should(appear);
        modalDialogTitle.shouldHave(text(value));

        return this;
    }

    public RegistrationPage checkSubmitFormNotAppear() {
        modalDialog.shouldNot(appear);

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        tableComponent.checkTableResult(key,value);

        return this;
    }
}