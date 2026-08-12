package uiTesting.pom.hw.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFormPage extends BaseForFormTest{
    TextFormPage textFormPage;
    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        textFormPage = new TextFormPage(getDriver());
    }

    @Test
    public void MyTestForFormPage() {
        textFormPage.open()
                .setName("Ivan")
                .setLastName("Popov")
                .setEmail("afaf@mail.com")
                .setGender()
                .setNumber("12121212")
                .setDayOfBirth("May", "1999")
                .setHobbies()
                .setAddress("Moscow")
                .setSubmit();
    }
}
