package tests.ui;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class DuckDuckGoTest extends TestBase{
    @Test
    @Tag("simpleTests")
    void duckDuckGoOpens() {
        open("https://duckduckgo.com");
        sleep(100000);
    }
}
