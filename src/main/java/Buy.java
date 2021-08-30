import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class Buy {

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
        By buyLocator = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[1]/div/div[2]/div/ul/li[1]");
        By dublinCity = By.xpath("//*[@id=\"search-box-item-0\"]/span/span[1]");
        By cancelCalculateBudget =By.xpath("//*[@id=\"attraction-modal-create-buying-budget\"]/div[1]/button/svg");



        try {
            // launch chrome and go to url
            driver.get("https://daft.ie"); // Step 1
            driver.findElement(acceptAll).click(); // Step 2
            driver .findElement(buyLocator).click();
            driver .findElement(dublinCity).click();
            driver.findElement(cancelCalculateBudget).click();


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
