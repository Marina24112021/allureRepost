package demoqa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class AllurePracticeTest extends TestBase {
    @Feature("Feature lable")
    @Story("Fill address field")
    @Owner("chenm")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "text-box", url = "https://demoqa.com")
    @DisplayName("Test address field check using allure report")
    @Test
    void shouldAddressExistTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#currentAddress").setValue("USA");
        $("#submit").click();
        $("#output #currentAddress").shouldHave(text("USA"));
    }
}