package com.example;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

public class TC6_FilterSortCheck {
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

    WebElement toateprod = driver.findElement(By.xpath("//*[@id=\"bltc30c93929d4cad78\"]/section/ol/li[4]/a/span"));
    toateprod.click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement filterprod = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector (" #product-facet-productType-collapsible > li:nth-child(6) > label > div")));
    filterprod.click();

    WebDriverWait waitp = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement filterprice = waitp.until(ExpectedConditions.elementToBeClickable(By.cssSelector ("#product-facet-prices-collapsible > li:nth-child(1) > label > div")));
    filterprice.click();

    driver.findElement(By.id ("sortBy-label")).click();

    driver.findElement(By.id("sortBy_id2")).click();

    List<WebElement> priceElements = driver.findElements(By.cssSelector("[data-test ='product-leaf-price']"));
    List<WebElement> priceElements2 = driver.findElements(By.cssSelector("[data-test ='product-leaf-discounted-price']"));
   
    List<WebElement> allPriceElements = new ArrayList<>();
    allPriceElements.addAll(priceElements);
    allPriceElements.addAll(priceElements2);

    List<String> priceStrings = new ArrayList<>();
    List<Double> prices = new ArrayList<>();

    for (WebElement priceElement : allPriceElements) {
    String priceText = priceElement.getText().replaceAll("[^0-9,.]", "").replace(",", ".");
    double price = Double.parseDouble(priceText);

    if (price <= 100) { 
        priceStrings.add(priceText);
        prices.add(price);
    }
  }
    Collections.sort(prices); 
   
    boolean isSorted = true;
    for (int i = 0; i < prices.size() - 1; i++) {
    if (prices.get(i) > prices.get(i + 1)) {
        isSorted = false;
        break;
    }
}

    if (isSorted) {
        System.out.println("Produsele sunt sortate corect!");
    } else {
        System.out.println("Produsele NU sunt sortate corect!");
    }

    System.out.println("Prețurile extrase: " + priceStrings);
} 
  
    @After
    public void teardown() {
    driver.quit();
    } 
    }
  



