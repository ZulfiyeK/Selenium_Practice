package day05_WindowHandle_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import util.Methots;

public class C02_WindowHandle extends Methots {

    @Test
    public void test() {

    // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        String amazonHandle = driver.getWindowHandle();


    // 2- url'in 'amazon' icerdigini test edelim
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));


    // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(" https://www.bestbuy.com");
        String bestbuyHandle = driver.getWindowHandle();


    // 4- title'in 'Best Buy' icerdigini test edelim
        String bestbuyTitle = driver.getTitle();
        Assert.assertTrue(bestbuyTitle.contains("Best Buy"));

    // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(amazonHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);


    // 6- arama sonuclarının 'Java' icerdigini test edelim
        WebElement aramaSonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(aramaSonucu.getText().contains("Java"));

    // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(bestbuyHandle);


    // 8- logonun gorundugunu test edelim
        WebElement logo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());





    }
}
