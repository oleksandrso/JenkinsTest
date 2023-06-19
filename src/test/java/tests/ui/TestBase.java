package tests.ui;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.remote;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static helpers.Attach.getSessionId;

public class TestBase {

    @BeforeEach
    public void setUp() throws MalformedURLException {
        // Создаем экземпляр ChromeOptions, который позволяет настроить различные параметры ChromeDriver
        ChromeOptions options = new ChromeOptions();

        // Указываем имя браузера и версию, которые мы хотим использовать
        options.setCapability("browserName", "chrome");
        options.setCapability("browserVersion", "114.0");

        // Используем Selenoid Options для настройки сессии.
        // Здесь мы включаем VNC и видеозапись, и добавляем метку "manual" к сессии
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});

            // Включаем запись видео
            put("enableVideo", true);

            // Включаем VNC для визуального отслеживания тестов
            put("enableVNC", true);
        }});

        // Задаем настройки браузера и URL удаленного сервера для Selenide
        Configuration.browserCapabilities = options;
        Configuration.remote = "http://176.36.164.107:4444/wd/hub";

        // Создаем новый экземпляр WebDriver, используя указанные настройки
        WebDriverRunner.setWebDriver(new RemoteWebDriver(new URL(Configuration.remote), options));
    }


    @AfterEach
    public void afterEach()  {
            closeWebDriver();
    }


}
