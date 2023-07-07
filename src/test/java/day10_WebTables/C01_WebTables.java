package day10_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import util.Methods;

import java.util.List;

public class C01_WebTables extends Methods {
    @Test
  public void test() {

     // girisYap methodu olusturun
     // https://www.hotelmycamp.com adresine gidin
     // Log in butonuna tıklayın
     // Username: manager
     // Password: Manager1!

      girisYap();

     // sutun sayısını yazdırın
       List<WebElement> sutunBasliklari =  driver.findElements(By.xpath("//thead//tr[1]//th"));
       System.out.println("Sutun Basliklari = " + sutunBasliklari.size());


       System.out.println("******************************************");


       // tum body'i yazdiri
       WebElement tumBody = driver.findElement(By.xpath("//tbody"));
       System.out.println("Butun Body = " + tumBody.getText());


       System.out.println("******************************************");


      // body'de bulunan satır sayısını yazdırın
       List<WebElement>satirlar = driver.findElements(By.xpath("//tbody//tr"));
       System.out.println("Satir Sayisi = " + satirlar.size());


       System.out.println("******************************************");


        // body'de bulunan satırları yazdırın
        for (WebElement i: satirlar) {
            System.out.println("Satirlar = " + i.getText());
        }

       System.out.println("******************************************");


       // 4.satırdaki elementleri yazdırın
        List<WebElement> dorduncuSatirElemanleri = driver.findElements(By.xpath("//tbody//tr[4]//td"));
        dorduncuSatirElemanleri.stream().forEach(t-> System.out.print(t.getText()+","));

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
