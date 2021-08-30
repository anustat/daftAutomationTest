import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Daft {
    public static void main(String[] args) {
        // Locators
        By loginLinkLocator = By.xpath("//*[@id=\"__next\"]/div[2]/header/div/div[2]/div[3]/ul/li[2]/a");
        By cookiePopUpLocator =  By.xpath("//*[@id=\"js-cookie-modal-level-one\"]/div/main/div/button[2]");
        By loginUserNameInputLocator = By.xpath("//*[@id=\"username\"]");
        By loginPasswordInputLocator = By.xpath("//*[@id=\"password\"]");
        By loginButtonLocator = By.xpath("//*[@id=\"kc-login-form\"]/div[2]/input");
        // creating driver object
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" + currentDir);
        System.setProperty("webdriver.chrome.driver", currentDir + "\\src\\main\\resources\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //setting up url
        String baseUrl = "https://daft.ie";
        // launch chrome and execute the test steps
        driver.get(baseUrl);  // step 1
        driver.findElement(cookiePopUpLocator).click(); // step 2
        driver.findElement(loginLinkLocator).click(); // step 3
        driver.findElement(loginUserNameInputLocator).sendKeys("anustat@yahoo.com"); // step 4
        driver.findElement(loginPasswordInputLocator).sendKeys("Bangladesh1$"); // step 5
        driver.findElement(loginButtonLocator).click();  // step 6
        // get the actual value of the title
        String actualTitle = driver.getTitle();
        System.out.println("actual title is: " + actualTitle);
        String expectedTitle = "DoneDeal | Ireland's Largest Motor & Classifieds Marketplace";
        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        // sleeping the execution for 4000 milly sec
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //close chrome
        driver.close();
    }
}

