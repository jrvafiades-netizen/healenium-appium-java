package healenium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.URL;
import java.util.Locale;

import static java.time.Duration.ofMinutes;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class TestEmulatorLoginForm {

    private static AppiumDriver appiumDriver;

    private static String byXpath = "//android.widget.Button[@text = 'LOG IN']";

    @SneakyThrows
    @BeforeAll
    public static void setUp() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setAppPackage("com.spotify.music")
                .setAppActivity(".MainActivity")
                .setDeviceName("emulator-5554");

        String nodeURL = "http://localhost:8085";

        appiumDriver = new AppiumDriver(new URL(nodeURL), options);
    }


    @Test
    public void testSpotifyLoginForm() throws InterruptedException {
        String email = "test@example.com";

        WebElement emailField = appiumDriver.findElement(By.id("email"));
        WebElement loginButton = appiumDriver.findElement(By.xpath(byXpath));

        emailField.sendKeys(email);

        WebElement healedLoginButton = appiumDriver.findElement(By.xpath(byXpath));
        healedLoginButton.click();

        assertEquals("LOG IN", healedLoginButton.getText());
    }

    @AfterAll
    public static void tearDown() {
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }

}
