import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class Registration {

    public static void main(String[] args) {

        // creating driver object
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" + currentDir);
        System.setProperty("webdriver.chrome.driver", currentDir + "\\src\\main\\resources\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // don't touch the code above this line.
        // Locators
        By acceptAll =  By.xpath("//*[@id=\"js-cookie-modal-level-one\"]/div/main/div/button[2]");
        By signInLocator = By.xpath("//*[@id=\"__next\"]/div[2]/header/div/div[2]/div[3]/ul/li[2]");
        By signUpLocator = By.xpath("//*[@id=\"kc-login-form\"]/div[2]/p[1]/a");
        By emailAddressLocator = By.xpath("//*[@id=\"email\"]");
        By passwordAuthentication = By.xpath("//*[@id=\"password\"]");
        By termsOfUse = By.xpath("//*[@id=\"kc-register-form\"]/div[1]/div[3]/label/span[1]");
        By createAccount = By.xpath("//*[@id=\"kc-form-buttons\"]/input");

        try {
            // launch chrome and go to url
            driver.get("https://daft.ie"); // Step 1
            driver.findElement(acceptAll).click(); // Step 2
            driver.findElement(signInLocator).click(); //Step 3
            driver.findElement(signUpLocator).click(); // Step 4
            driver.findElement(emailAddressLocator).sendKeys("anusta@yahoo.com");
            driver.findElement(passwordAuthentication).sendKeys("Bangladesh1$");
            driver.findElement(termsOfUse).click();
            driver.findElement(createAccount).click();

            // Don't touch the code below this line
            System.out.println("Your Test Passed");
            // sleeping the execution for 4000 milly sec
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            System.out.println("Your Test Failed");
        }
        //close chrome
        //driver.close();
    }
}