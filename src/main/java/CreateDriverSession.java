import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CreateDriverSession {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"mohan device");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID,"1742000095");
        caps.setCapability("appPackage", "cz.aevi.peckaposka");
        caps.setCapability("appActivity",".AndroidArtemaActivity");
        URL url = new URL(" http://0.0.0.0:4723/wd/hub");

        AppiumDriver driver = new AndroidDriver(url, caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By terminal = MobileBy.id("cz.aevi.peckaposka:id/fab_select_terminal");
        By item_name = MobileBy.id("cz.aevi.peckaposka:id/item_name");
        By sale =  MobileBy.id("cz.aevi.peckaposka:id/start_sale");
        By pay_now =  MobileBy.id("com.aevi.app.chase.xac.appflow:id/confirmBtn");
        By navigate_up = MobileBy.AccessibilityId("Navigate up");
        By manual_entry =  MobileBy.id("com.aevi.app.chase.xac.appflow:id/manualBtn");
        By card_number = MobileBy.id("com.aevi.app.chase.xac.appflow:id/cardNumberEdt");
        By month = MobileBy.id("com.aevi.app.chase.xac.appflow:id/mmEdt");
        By year = MobileBy.id("com.aevi.app.chase.xac.appflow:id/yyEdt");



        TouchAction t = new TouchAction(driver);
            t.press(ElementOption.element(driver.findElement(terminal)))
                   .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000))).release().perform();
            t.press(ElementOption.element(driver.findElement(item_name)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000))).release().perform();
            t.longPress(ElementOption.element(driver.findElement(sale)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000))).release().perform();
        MobileElement currency = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout");

            currency.click();
        MobileElement usd_cur = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[4]");

        usd_cur.click();

        t.press(ElementOption.element(driver.findElement(navigate_up)))
                  .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000))).release().perform();

        driver.findElement(sale).click();

        t.press(ElementOption.element(driver.findElement(pay_now)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000))).release().perform();
        t.press(ElementOption.element(driver.findElement(manual_entry)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000))).release().perform();

        driver.findElement(card_number).sendKeys("341111597242000");
        driver.findElement(month).sendKeys("12");
        driver.findElement(year).sendKeys("21");
        t.press(ElementOption.element(driver.findElement(pay_now)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(10000))).release().perform();

        driver.quit();


    }
}
