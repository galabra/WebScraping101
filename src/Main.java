import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        FirefoxDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.navigate().to("http://www.galabra.co.il");

        String aboutButtonXpath = "//*[@id=\"about\"]/div/a";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(aboutButtonXpath)));
        driver.findElement(By.xpath(aboutButtonXpath)).click();

        String languagesParagraphXpath = "//*[@id=\"page1\"]/div[2]/div[5]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(languagesParagraphXpath)));
        List<WebElement> languagesNamesList = driver.findElements(By.xpath("//*[@id=\"page1\"]/div[2]/div[5]/p"));

        driver.close();

        for (WebElement languageElement : languagesNamesList) {
            String languageName = languageElement.getText();
            System.out.println(languageName);
        }
    }

}
