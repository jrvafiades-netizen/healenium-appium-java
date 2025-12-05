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

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class TestEmulatorLoginForm {

    private static AppiumDriver appiumDriver;

    @SneakyThrows
    @BeforeAll
    public static void setUp() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setAppPackage("com.plymouthrock.mobile")
                .setAppActivity(".MainActivity")
                .setDeviceName("emulator-5554");

        String nodeURL = "http://localhost:4723";

        appiumDriver = new AppiumDriver(new URL(nodeURL), options);
    }

    @Test
    public void testPlymouthRockLoginForm() throws InterruptedException {
        log.info("Starting Plymouth Rock Assurance login test");
        
        // Wait for app to load
        Thread.sleep(2000);
        
        try {
            // Look for login button or email field
            WebElement loginButton = appiumDriver.findElement(By.id("com.plymouthrock.mobile:id/login_button"));
            loginButton.click();
            
            // Enter email/username
            WebElement emailField = appiumDriver.findElement(By.id("com.plymouthrock.mobile:id/email_input"));
            emailField.sendKeys("test@example.com");
            
            // Verify login form is displayed
            assertTrue(emailField.isDisplayed(), "Email field should be visible");
            log.info("Login form verification passed");
        } catch (Exception e) {
            log.error("Error during login form test: " + e.getMessage());
            throw e;
        }
    }

    @AfterAll
    public static void tearDown() {
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }

}
