package github;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebStepsGitTest extends TestBaseGitHub {
    @Step("Open web-page")
    void openMainPage() {
        open("/");
    }

    @Step("Click on search button")
    void clickOnSearch() {
        $(".header-search-button").click();
    }

    @Step("Fill search field with {nameOfRepo}")
    void setValueSearch(String nameOfRepo) {
        $("#query-builder-test").setValue(nameOfRepo).pressEnter();
    }

    @Step("Click on link {nameOfRepo}")
    void clickOnRepoLink(String nameOfRepo) {
        $(linkText("/Marina24112021/allureRepost")).click();
    }

    @Step("Click on tab Issue")
    void clickOnIssueTab() {
        $("a#issues-tab").click();
    }

    @Step("Issue 2 should be exist")
    void shouldBeIssue2() {
        $("#issue_2").shouldHave(text("Issue2"));
    }
}
