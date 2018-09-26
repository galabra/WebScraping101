import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // As a part of preparing the workflow, collect the relevant XPaths
        String aboutButtonXpath = "//*[@id=\"about\"]/div/a";
        String languagesParagraphXpath = "//*[@id=\"page1\"]/div[2]/div[5]";
        String languagesXpath = "//*[@id=\"page1\"]/div[2]/div[5]/p";

        // Open a new browser window
        FirefoxDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.navigate().to("http://www.galabra.co.il");

        // Click the "ABOUT" button (after it's loaded)
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(aboutButtonXpath)));
        driver.findElement(By.xpath(aboutButtonXpath)).click();

        // Copy a list of all the languages (after they're loaded)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(languagesParagraphXpath)));
        List<WebElement> languagesNamesList = driver.findElements(By.xpath(languagesXpath));

        // Print the languages
        for (WebElement languageElement : languagesNamesList) {
            String languageName = languageElement.getText();
            System.out.println(languageName);
        }
        
        // Close the browser window
        driver.close();

    }

}
