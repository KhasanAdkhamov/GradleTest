package uiTesting.pom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TextBoxTest extends BaseTest{
    TextBookPage bookPage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        bookPage = new TextBookPage(getDriver(), getDriverWait());
    }
    @Test
    public void myTest() {
        bookPage.open()
                .setFullName("masha")
                .setFullCurrentAddress("moscow")
                .setFullPermanentAddress("teplichniy lane")
                .setFullEmail("has@email.com");
    }



}
