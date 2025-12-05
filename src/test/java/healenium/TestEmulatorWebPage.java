package healenium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.net.URL;

import static java.time.Duration.ofMinutes;
import static java.time.Duration.ofSeconds;

@Slf4j
public class TestEmulatorWebPage {

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
        appiumDriver.manage().timeouts()
                .pageLoadTimeout(ofMinutes(5))
                .implicitlyWait(ofSeconds(10));
    }

    @Test
    public void testPlymouthRockAppNavigation() throws InterruptedException {
        log.info("Starting Plymouth Rock Assurance app navigation test");
        
        // Wait for app to fully load
        Thread.sleep(2000);
        
        try {
            // Find and interact with main menu elements
            appiumDriver.findElement(By.id("com.plymouthrock.mobile:id/home_tab"));
            log.info("Home tab found");
            
            // Look for policy or account section
            appiumDriver.findElement(By.id("com.plymouthrock.mobile:id/policy_tab"));
            log.info("Policy tab found");
            
            // Verify app is responsive
            appiumDriver.findElement(By.id("com.plymouthrock.mobile:id/menu_button")).click();
            log.info("Menu navigation test passed");
        } catch (Exception e) {
            log.error("Error during app navigation test: " + e.getMessage());
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
