package day05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.Methotlar;

public class B00 extends Methotlar {



    @Test
    public void test1() {
        //https://demoqa.com/alerts
        driver.get("https://demoqa.com/alerts");

        //On button click, confirm box will appear karşısındaki butona tıklayalım.
        driver.findElement(By.xpath("(//button)[2]")).click();
        wait(2);


        // alert cikarsa tamam'a basalım.
        alertAccept();



    }

    @Test
    public void test2() {
        //https://demoqa.com/alerts
        driver.get("https://demoqa.com/alerts");

        //On button click, confirm box will appear karşısındaki butona tıklayalım.
        driver.findElement(By.xpath("(//button)[4]")).click();
        wait(2);


        // alert cikarsa iptale basalım.
        alertDismiss();

        // Sonuç yazısında You selected Cancel yazdığını doğrulayalım
        WebElement sonuc= driver.findElement(By.xpath("//*[@id='confirmResult']"));
        System.out.println(sonuc.getText());
    }

    @Test
    public void test3() {
        //https://demoqa.com/alerts
        driver.get("https://demoqa.com/alerts");

        //On button click, confirm box will appear karşısındaki butona tıklayalım.
        driver.findElement(By.xpath("(//button)[5]")).click();
        wait(2);


        // alert cikarsa tamam'a basalım ve isim girelim
         alertPrompt("Zulfiye");
         wait(2);
         alertAccept();




    }
}
