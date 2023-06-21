package tests.ui;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DuckDuckGoTest extends TestBase{
    @Test
    void duckDuckGoOpens1() {
        open("https://duckduckgo.com");
        assertTrue(true);
    }
    @Test
    void duckDuckGoOpens2() {
        open("https://duckduckgo.com");
        assertTrue(true);
    }
    @Test
    void duckDuckGoOpens3() {
        open("https://duckduckgo.com");
        assertTrue(false);
    }
}
