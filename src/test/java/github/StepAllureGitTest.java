package github;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepAllureGitTest extends TestBaseGitHub {
    private static final String nameOfRepo = "Marina24112021/allureRepost";

    @Feature("Feature lable")
    @Story("Check of existing issue tab in github ")
    @Owner("chenmarina")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "issue", url = "https://github.com/Marina24112021/allureRepost")
    @DisplayName("Test issue tab using allure report (lambda Step)")
    @Test
    void lambdaStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open github.com", () -> {
            open("/");
        });
        step("Click on search button", () -> {
            $(".header-search-button").click();
        });
        step("Fill search field with" + nameOfRepo, () -> {
            $("#query-builder-test").setValue(nameOfRepo).pressEnter();
        });
        step("Click on link " + nameOfRepo, () -> {
            $(linkText("/Marina24112021/allureRepost")).click();
        });
        step("Click on tab Issue", () -> {
            $("a#issues-tab").click();
        });
        step("Issue 2 should be exist", () -> {
            $("#issue_2").shouldHave(text("Issue2"));
        });
    }
    @Feature("Feature lable")
    @Story("Check of existing issue tab in github ")
    @Owner("chenmarina")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "issue", url = "https://github.com/Marina24112021/allureRepost")
    @DisplayName("Test issue tab using allure report (annotation @Step)")
    @Test
    void annotatedStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebStepsGitTest step = new WebStepsGitTest();
        step.openMainPage();
        step.clickOnSearch();
        step.setValueSearch(nameOfRepo);
        step.clickOnRepoLink(nameOfRepo);
        step.clickOnIssueTab();
        step.shouldBeIssue2();
    }
}
