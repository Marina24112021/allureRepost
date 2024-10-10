import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class StepAllureTest extends TestBase {
    private final String address = "USA";
    @Feature("Feature lable")
    @Story("Fill address field")
    @Owner("chenm")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "text-box", url = "https://demoqa.com")
    @DisplayName("Test address field check using allure report (lambda Step)")
    @Test
    void lambdaStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open web-page", () -> {
            open("/text-box");
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });
        step("Set address value " + address, () -> {
            $("#currentAddress").setValue("USA");
        });
        step("Click on submit button ", () -> {
            $("#submit").click();
        });
        step("Check input address value " + address + " in result output", () -> {
            $("#output #currentAddress").shouldHave(text(address));
        });
    }
    @Feature("Feature lable")
    @Story("Fill address field")
    @Owner("chenm")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "text-box", url = "https://demoqa.com")
    @DisplayName("Test address field check using allure report (annotation @STEP)")
    @Test
    void annotatedStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps step = new WebSteps();
        step.openMainPage();
        step.setAddress(address);
        step.submit();
        step.shouldSeeAddress(address);
    }
}
