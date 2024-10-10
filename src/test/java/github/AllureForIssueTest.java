package github;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class AllureForIssueTest extends TestBaseGitHub {
    private static final String nameOfRepo = "Marina24112021/allureRepost";
    @Feature("Feature lable")
    @Story("Check of existing issue tab in github ")
    @Owner("chenmarina")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "issue", url = "https://github.com")
    @DisplayName("Test issue tab using allure report")
    @Test
    void shouldIssueNumExistTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("/");
        $(".header-search-button").click();
        $("#query-builder-test").setValue(nameOfRepo).pressEnter();
        $(linkText("/Marina24112021/allureRepost")).click();
        $("a#issues-tab").click();
        $("#issue_2").shouldHave(text("Issue2"));
    }
}
