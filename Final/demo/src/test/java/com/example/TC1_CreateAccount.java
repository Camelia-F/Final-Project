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


public class TC1_CreateAccount {
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

    WebElement button = driver.findElement(By.cssSelector("button[data-test='age-gate-grown-up-cta']"));
    button.click();
    
    WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement buttonx = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Doar necesare']")));
    buttonx.click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement buttony = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Conectează-te']")));
    buttony.click();
    
    WebElement inreg = driver.findElement(By.linkText("Înregistrează-te"));
    inreg.click();
    
    WebDriverWait waitb = new WebDriverWait(driver, Duration.ofSeconds(30));
    WebElement day = waitb.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='dob-day']")));
    day.click();
    day.sendKeys("22");

    WebDriverWait waitl = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement luna = waitl.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='dob-month']")));
    luna.sendKeys("9");

    WebElement an = driver.findElement(By.cssSelector("[data-testid='dob-year']"));
    an.sendKeys("1940");

    WebElement continua = driver.findElement(By.cssSelector("#register_submit > span"));
    continua.click();

    WebElement prenume = driver.findElement(By.cssSelector("[data-testid='givenName']"));
    prenume.sendKeys("John");

    WebElement nume = driver.findElement(By.cssSelector("[data-testid='familyName']"));
    nume.sendKeys("Ion");

    WebElement email = driver.findElement(By.cssSelector("[data-testid='email']"));
    email.sendKeys("evening251@yahoo.com");

    WebElement psw = driver.findElement(By.cssSelector("[data-testid='password']"));
    psw.sendKeys("Lego19400!");

    WebElement create = driver.findElement(By.id("register_submit"));
    create.click();

    WebElement confirm = driver.findElement(By.cssSelector("#registerform > div:nth-child(3) > div.FieldError_errorContainer__5cl0yx0"));
    String turn = confirm.getText();
    assertEquals("Acest e-mail este deja folosit", turn);
    confirm.click();
    }
  
   @After
    public void teardown() {
    driver.quit();
    }
  }
    


