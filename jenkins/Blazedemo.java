import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class Blazedemo {
    WebDriver wd;
    
    @Before
    public void setUp() throws Exception {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @After
    public void tearDown() {
        wd.quit();
    }
    
    @Test
    public void Vacation() {
        wd.get("http://blazedemo.com/vacation.html");
    }

    @Test
    public void FillForm() throws Exception {
        // Open page and choose cities
        wd.get("http://blazedemo.com/");
        Thread.sleep(1500); // Think time looking at home page
        if (!wd.findElement(By.xpath("//div[3]/form/select[1]//option[3]")).isSelected()) {
            wd.findElement(By.xpath("//div[3]/form/select[1]//option[3]")).click();
        }
        if (!wd.findElement(By.xpath("//div[3]/form/select[2]//option[6]")).isSelected()) {
            wd.findElement(By.xpath("//div[3]/form/select[2]//option[6]")).click();
        }
        wd.findElement(By.cssSelector("input.btn.btn-primary")).click();
        Thread.sleep(1500); // Think time looking at city options page
        // click on chosen flight
        wd.findElement(By.xpath("//table[@class='table']/tbody/tr[4]/td[1]/input")).click();

	// Fill form and purchase
        wd.findElement(By.id("inputName")).sendKeys("FirstName LastName");
        wd.findElement(By.id("address")).sendKeys("123 Beautiful st.");
        wd.findElement(By.id("city")).sendKeys("San Diego");
        wd.findElement(By.id("state")).sendKeys("CA");
        wd.findElement(By.id("zipCode")).sendKeys("12345");
        wd.findElement(By.id("creditCardNumber")).sendKeys("1234 5678 8765 4321");
        wd.findElement(By.id("nameOnCard")).sendKeys("FirstName LastName");

        Thread.sleep(2500); // Think time looking at form and filling it out
        wd.findElement(By.cssSelector("input.btn.btn-primary")).click();
    }
}
