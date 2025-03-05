package com.example;
import java.time.Duration;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC4_LoginUserPsw {
        WebDriver driver;
             
        @Before
        public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito"); 
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
        }
        
        @Test
        public void Lego3() {
        driver.get("https://www.lego.com/ro-ro");
        String title = driver.getTitle();
        assertEquals("Home | LEGO® Shop oficial din RO", title);
    
        WebElement button = driver.findElement(By.cssSelector("button[data-test='age-gate-grown-up-cta']"));
        button.click();
    
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement buttonx = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Doar necesare']")));
        buttonx.click();
    
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement buttony = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Conectează-te']")));
        buttony.click();

        WebDriverWait waita = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement connect = waita.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dialog\"]/div[1]/a")));
        connect.click();

        WebDriverWait usere = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement email = usere.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"username\"]")));
        email.sendKeys("evening25@yahoo.com");
        email.sendKeys(Keys.ENTER);

        try {
            WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
            password.sendKeys("Mistake25!");
            password.sendKeys(Keys.ENTER);
        }
        catch (Exception e) {
            System.out.println("Elementul nu a fost gasit");
        } 
        
        }

      @After
        public void teardown() {
        driver.quit();
        } 
    }


