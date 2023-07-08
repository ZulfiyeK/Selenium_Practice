package day11_WebTable;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import util.Methods;

public class C02_WebTable extends Methods {

    @Test
    public void webTable() {

      girisYap();

      //input olarak verilen satir sayisi ve sutun sayisina sahip cell'deki text'i dinamik olarak yazdirin.

       int satir = 3;
       int sutun = 3;

       WebElement arananCell = driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
       System.out.println("Aranan Cell = " + arananCell.getText());

    }

    public void girisYap() {

        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();
        driver.findElement(By.xpath("(//*[@class='nav-link'])[7]")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//input[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();

    }


}
