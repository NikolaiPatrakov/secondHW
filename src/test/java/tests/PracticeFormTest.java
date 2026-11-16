package tests;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PracticeFormTest extends TestBase {

    String firstName = "Nikolai";
    String lastName = "Patrakov";
    String userEmail = "testguru@auto.com";
    String gender = "Male";
    String userNumber = "0123456789";
    String dayOfBirth = "20";
    String monthOfBirth = "March";
    String yearOfBirth = "1991";
    String subject = "Biology";
    String hobbies = "Sports";
    String uploadImage = "test-picture.jpg";
    String currentAddress = "some address";
    String state = "NCR";
    String city = "Delhi";
    String submitFormTitle = "Thanks for submitting the form";


    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject)
                .setHobbie(hobbies)
                .uploadPicture(uploadImage)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submit()
                .checkSubmitFormAppear(submitFormTitle)
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", uploadImage)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }
}