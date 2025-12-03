package healenium;

import io.appium.java_client.AppiumDriver;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;

import java.net.URL;

import static java.time.Duration.ofMinutes;
import static java.time.Duration.ofSeconds;

public class TestEmulatorWebPage {

    private static AppiumDriver appiumDriver;

    @SneakyThrows
    @BeforeAll
    public static void setUp() {
        MutableCapabilities dc = new MutableCapabilities();
        dc.setCapability("nativeWebScreenshot",true);

        String nodeURL = "http://localhost:8085";

        appiumDriver = new AppiumDriver(new URL(nodeURL), dc);
        appiumDriver.manage().timeouts()
                .pageLoadTimeout(ofMinutes(5))
                .implicitlyWait(ofSeconds(10));
    }

    @Test
    public void testSpotifyWebPage() {
        String mainPageUrl = "https://open.spotify.com";

        appiumDriver.get(mainPageUrl);

        appiumDriver.findElement(By.xpath("//button[contains(@class, 'ButtonInline-button')]"));
        appiumDriver.findElement(By.xpath("//a[contains(@href, '/login')]")).click();
        appiumDriver.findElement(By.xpath("//input[@type='email']"));
    }

    @AfterAll
    public static void tearDown() {
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }
}
