import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps extends TestBase {
    @Step("Open web-page")
    void openMainPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    @Step("Set address value {address}")
    void setAddress(String address) {
        $("#currentAddress").setValue(address);
    }

    @Step("Click on submit button")
    void submit() {
        $("#submit").click();
    }

    @Step("Check input address value {address} in result output")
    void shouldSeeAddress(String address) {
        $("#output #currentAddress").shouldHave(text(address));
    }
}
