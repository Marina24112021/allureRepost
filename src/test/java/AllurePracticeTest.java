import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AllurePracticeIssueTest {
    @Test
    void shouldIssueNumExist(){
        open("https://music.yandex.ru/home");
        $(".section-1__title").shouldHave(text("Музыка зазвучит с подпиской Яндекс Плюс"));
        /*open("https://github.com/");
        $(".search-input").click();
        $("#query-builder-test").sendKeys("Marina24112021/allureRepost");
        $("#query-builder-test").submit();
        $(linkText("Marina24112021/allureRepost")).click();
        $("#issues-tab").click();
        $("#issue_2").shouldHave(text("#2"));
        */
    }
}