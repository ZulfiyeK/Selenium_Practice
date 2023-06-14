package day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import util.Methots;

import javax.swing.*;

public class C03_Iframe extends Methots {
    @Test
    public void test() {

      // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");


      // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);//sayfa icinde hareket edebilmek icin actions objesi olusturup,
                                              // sendKeys(Keys.PAGE_DOWN) ile sayfayi asagi kaydiriyoruz.
                                              // gerekirse sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN) seklinde tekrar kullanilir.

        actions.sendKeys(Keys.PAGE_DOWN).perform();//action isleminin bittigini perform() ile belirtiyoruz.


      // Videoyu izlemek icin Play tusuna basiniz
        WebElement iframe = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iframe);
        WebElement play = driver.findElement(By.xpath("//*[@class ='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        wait(2);
        play.click();


        /*
         Play'i dogru locate edip click yapmamıza ragmen videoyu calıstırmadı bunun üzerine HTML kodlarını inceleyince
         play'in aslında bir iframe icerisinde oldugunu gördük. Bu durumda once iframe'i locate edip switchTo() ile
         iframe'e gecmeliyiz
        */


      // Videoyu calistirdiginizi test ediniz
        WebElement youTubeYazisi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youTubeYazisi.isDisplayed());


      // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();//iframe'den disari cikiyoruz.

        WebElement powerYazisi = driver.findElement(By.xpath("//*[@id='Powerful_but_easy_to_misuse']"));
        Assert.assertTrue(powerYazisi.isDisplayed());


    }
}
