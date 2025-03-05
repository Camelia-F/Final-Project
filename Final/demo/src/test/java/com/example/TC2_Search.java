package com.example;
import java.time.Duration;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC2_Search {
    WebDriver driver;
        
    @Before
    public void setup() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500)); 
    }
    
    @Test
    public void Lego() {
    driver.get("https://www.lego.com/ro-ro");
    String title = driver.getTitle();
    assertEquals("Home | LEGO® Shop oficial din RO", title);

    WebElement button = driver.findElement(By.id("age-gate-grown-up-cta"));
    button.click();

    WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement buttonx = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Doar necesare']")));
    buttonx.click();

    WebElement find = driver.findElement(By.cssSelector("button[data-test='search-input-button']"));
    find.click();

    WebElement input = driver.findElement(By.id("desktop-search-search-input"));
    input.sendKeys("Turnul Eiffel");

    driver.findElement(By.cssSelector ("button[type='submit']")).click();

     WebElement confirm = driver.findElement(By.cssSelector("#product-listing-grid > li:nth-child(1) > article > h3 > a > span"));
     String turn = confirm.getText();
     assertEquals("Turnul Eiffel", turn);
     confirm.click();

     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
     WebElement button2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-test='mediagallery-viewall']")));
     button2.click();

    }
  
    @After
    public void teardown() {
    driver.quit();
    }
    }
    


