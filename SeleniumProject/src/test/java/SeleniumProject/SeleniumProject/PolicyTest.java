package SeleniumProject.SeleniumProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PolicyTest {

    public String baseUrl = "http://localhost:8080/seeddata";
    String driverPath = "C:\\Users\\jrskm\\Downloads\\chromedriver-win64_2\\chromedriver-win64\\chromedriver.exe";

    public WebDriver driver;

    @Test
    public void testGoogle() {
        // Specify the ChromeDriver path directly
        System.setProperty("webdriver.chrome.driver", driverPath);

        // Create a ChromeDriver instance
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        // Use WebDriverWait to wait for the element to be visible
        WebDriverWait wait = new WebDriverWait(driver, 20); // Adjust the timeout as needed

        // Wait for the element with text 'Data seeded successfully!!!'
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Data seeded successfully!!!']")));

        // Assert that the text matches the expected value
        Assert.assertEquals("Data seeded successfully!!!", successMessage.getText());

        // Close the browser
        driver.quit();
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After test");
    }
}
