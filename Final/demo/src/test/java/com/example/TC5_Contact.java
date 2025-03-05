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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC5_Contact {
        WebDriver driver;
        
        @Before
        public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500)); 
        }
        
        @Test
        public void Lego3() {
        driver.get("https://www.lego.com/ro-ro");
        String title = driver.getTitle();
        assertEquals("Home | LEGO® Shop oficial din RO", title);
    
        WebElement button = driver.findElement(By.cssSelector("button[data-test='age-gate-grown-up-cta']"));
        button.click();
    
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement buttonx = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Doar necesare']")));
        buttonx.click();

        driver.findElement(By.linkText("Contactează-ne")).click();
 
        driver.findElement(By.linkText("Contactați-ne")).click();

        driver.findElement(By.cssSelector("#main-content > div.CommonLayoutstyles__LayoutGrid-sc-16t98zh-0.gPLHji > div.Bannerstyles__BannerContainer-sc-11vk9h7-0.drFpFn > div.Bannerstyles__Aside-sc-11vk9h7-1.eVxrQq > div > button")).click();
        
        WebElement dropdown1 = driver.findElement(By.id("topicDropdown-button"));
        dropdown1.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        WebElement dropdown2 = driver.findElement(By.id("subtopicDropdown-button"));
        dropdown2.click();
        Actions actions2 = new Actions(driver);
        actions2.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        driver.findElement(By.cssSelector("#main-content > div > div > div > div.AdditionalHelp_additionalHelpContainer__tCDCF > div:nth-child(2) > button")).click();
    
        WebElement text = driver.findElement(By.cssSelector("[data-test='caseDescription-input-text-area']"));
        text.sendKeys(".....");
    
        WebElement prenume = driver.findElement(By.cssSelector("[data-test='firstName-input-field']"));
        prenume.sendKeys("John");
    
        WebElement nume = driver.findElement(By.cssSelector("[data-test='lastName-input-field']"));
        nume.sendKeys("Ion");
    
        WebElement email = driver.findElement(By.cssSelector("[data-test='email-input-field']"));
        email.sendKeys("t@yahoo.com");
    
        WebElement street = driver.findElement(By.cssSelector("[data-test='address1-input-field']"));
        street.sendKeys("Strada");

        WebElement oras = driver.findElement(By.cssSelector("[data-test='city-input-field']"));
        oras.sendKeys("Cluj");

        WebElement cod = driver.findElement(By.cssSelector("[data-test='postcode-input-field']"));
        cod.sendKeys("400001");
    
        WebElement continua = driver.findElement(By.cssSelector("[data-test='form-submit-btn']"));
        continua.click();

        WebElement confirm = driver.findElement(By.cssSelector("#main-content > div > div.SectionLayout_sectionLayout__fQl9X > h1"));
        String msg = confirm.getText();
        assertEquals("Vă mulțumim că ne-ați contactat.", msg);
        
        WebElement back = driver.findElement(By.cssSelector("[data-test='back-to-home-link']"));
        back.click();
      }
      
     @After
     public void teardown() {
     driver.quit();
     }
 }
