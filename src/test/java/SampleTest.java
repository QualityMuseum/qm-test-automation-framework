import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;


public class SampleTest {

    @Test
    public void testSearchText() throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://duckduckgo.com");
        String title = driver.getTitle();
        System.out.println(title);

        //Write Van Gogh in textbox
        WebElement textBox = driver.findElement(By.id("search_form_input_homepage"));
        textBox.sendKeys("Van Gogh");

        //Click on searchButton
        WebElement searchButton = driver.findElement(By.id("search_button_homepage"));
        searchButton.click();

        //Get first results
        WebElement firstResult = driver.findElement(By.id("r1-0"));
        String result = firstResult.getText();

        //Verify that Van Gogh is written in the results
        Assert.assertTrue(result.contains("Van Gogh"));


        sleep(1000);
        driver.quit();
    }
}
