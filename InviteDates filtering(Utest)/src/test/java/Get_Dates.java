import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
public class Get_Dates {
    public static void main(String[] args) throws InterruptedException {
        //** SetUP Phase **
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //** Access utest website **
        driver.get("https://utest.com");
        Thread.sleep(1000);
        //** Login Phase **
        driver.findElement(By.linkText("Log In")).click();
        driver.findElement(By.id("username")).sendKeys("Your email");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("YourPassword");
        driver.findElement(By.id("rememberMe")).click();
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(1000);
        //** Access the 'Project' section from left sidebar **
        driver.findElement(By.xpath("//div[@class='nav-sidebar-item__text' and normalize-space(text())='Projects']")).click();
        Thread.sleep(2000);
        //** Access the 'Test Cycles' section from left sidebar **
        driver.findElement(By.xpath("//a[contains(.,'Test Cycles')]")).click();
        Thread.sleep(2000);
        // ** Opening the 'Status' section **
        driver.findElement(By.xpath("//span[@data-toggle='tooltip']")).click();
        Thread.sleep(1000);
        // ** Select the ' Closed ' Test Cycles from dropdown list **
        driver.findElement(By.xpath("//span[contains(text(),'Closed')]")).click();
        Thread.sleep(1000);
        // ** Access the Dates column Called 'Planned Start' and saving all Data on this column in 'all_column' list
        List<WebElement> all_columns =driver.findElements(By.xpath("//td[@data-column-title='Planned Start ']"));
        //** Loop on all data on the 'all_columns' variable **
        int i = 0;
        //## (Note) The number [81] putted on the While loop that is number of rows for this column on my Utest account u can change it to the true number in your account ##
        while(i<=81) {
            System.out.println(all_columns.get(i).getText());
            i++;
        }
        driver.close();

    }
}
