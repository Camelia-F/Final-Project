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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC3_AddToCart {
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
    
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement buttonx = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Doar necesare']")));
        buttonx.click();

        WebElement f1 = driver.findElement(By.cssSelector("a[id='blt94f681f3b5c2ca6f']"));
        f1.click();

        WebDriverWait waitb = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement masina = waitb.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"product-listing-grid\"]/li[1]/article/h3/a/span")));
        masina.click();

       /* JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");*/

        WebElement cantitate = driver.findElement(By.cssSelector("button[data-test='quantity-increase']"));
        for(int i = 0; i < 3; i++) {
            cantitate.click();
           /* try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }  */
        } 
    driver.findElement(By.cssSelector("button[data-test='add-to-cart-skroll-cta']")).click();

    driver.findElement(By.cssSelector("button[data-test ='view-my-bag']")).click();
       
    WebElement confirm = driver.findElement(By.cssSelector("#main-content > div > div > div.main--content > div.Cartstyles__Wrapper-sc-15zeyi1-2.eXyQwE > div.Cartstyles__ContentContainer-sc-15zeyi1-3.hbZEbQ > div > div > div.LineItemSection_lineItemsContentWrapper__w_XJ6 > div.LineItemDetailsWrapper_lineItemWrapper__lGJw8 > div > div > div.LineItemDetailsWrapper_lineItemDetailsContainer__2u0qy > div.LineItemCart_titleWrapper__DD2Vk > div > a > h3 > span"));
    String turn = confirm.getText();
    assertEquals("Mașina F1 Ferrari SF-24", turn);
    confirm.click();
    
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    WebElement buttonfinalizare = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#main-content > div > div > div.main--content > div.Cartstyles__Wrapper-sc-15zeyi1-2.eXyQwE > div.Cartstyles__OrderSummaryWrapper-sc-15zeyi1-11.hBrDTa > div.Cartstyles__OrderSummaryContainer-sc-15zeyi1-4.gjKoDU > div > div > div.OrderSummarystyles__Summary-sc-1z0xz5v-1.cbvjZQ > div > div.OrderSummarystyles__ButtonWrap-sc-1z0xz5v-3.iggtk > a")));
    buttonfinalizare.click();

    WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
    WebElement buttonguest = wait3.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#main-content > div > div > div > div > div > div:nth-child(2) > div.LoginReminderstyles__StyledButtonContainer-sc-13s8m9-2.erkiuY > button")));
    buttonguest.click();

    WebElement prenume = driver.findElement(By.id("firstName"));
    prenume.sendKeys("Ana");

    WebElement nume = driver.findElement(By.id("lastName"));
    nume.sendKeys("ana");

    WebElement tel = driver.findElement(By.id("phone"));
    tel.sendKeys("1234567890");

    WebElement em = driver.findElement(By.id("email"));
    em.sendKeys("test@gmail.com");

    WebElement adresa = driver.findElement(By.id("addressLine1"));
    adresa.sendKeys("casa 2");

    WebElement oras = driver.findElement(By.id("city"));
    oras.sendKeys("cluj-napoca");

    WebElement cod = driver.findElement(By.id("postalCode"));
    cod.sendKeys("400001");
    cod.sendKeys(Keys.ENTER);

    WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(30));
    WebElement buttonplata = wait4.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#main-content > div > div > div > div > section:nth-child(1) > div:nth-child(4) > div.shippingMethods_buttonContainer__WwMir > button")));
    buttonplata.click();

    WebElement radioButton = driver.findElement(By.id("Card de plată"));
    radioButton.click();

    }
      
    @After
    public void teardown() {
    driver.quit();
    }
    }


