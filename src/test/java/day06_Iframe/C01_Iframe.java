package day06_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.Methods;

public class C01_Iframe extends Methods {

    @Test
    public void iframe() {

      // https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/ sayfasına gidiniz
        driver.get("https://www.jqueryscript.net/demo/jQuery-Plugin-For-Responsive-Flexible-Iframes-Flexy/");


      // Videoyu görecek kadar asagiya ininiz
      //  Actions actions = new Actions(driver);
      //  actions.sendKeys(Keys.PAGE_DOWN).perform();


      // Videoyu izlemek icin Play tusuna basiniz

        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/x3kfyZJhC3U?rel=0&showinfo=0']"));
        driver.switchTo().frame(iframe);

        WebElement play = driver.findElement(By.xpath("//button[@class ='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));

        play.click();
        wait(2);



      // videoyu durdurunuz
        driver.findElement(By.xpath("//*[@title='Duraklat (k)']")).click();
        wait(2);


      // videoyu tam ekran yapınız
        driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']")).click();



      // videoyu calıstırınız
        driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button'] ")).click();
        wait(2);


      // videoyu kucultunuz
        // videoyu tam ekran yapınız
        driver.findElement(By.xpath("//button[@class='ytp-fullscreen-button ytp-button']")).click();
        wait(1);


      // videoyu durdurunuz
        driver.findElement(By.xpath("//*[@title='Duraklat (k)']")).click();
        wait(2);


      // Videoyu calistirdiginizi test ediniz
        WebElement dahaFazla = driver.findElement(By.xpath("//h2[@class='ytp-related-title']"));
        Assert.assertTrue(dahaFazla.isDisplayed());



      // 'jQuery Flexy Plugin Demos' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
        WebElement flexyPlugin = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(flexyPlugin.isDisplayed());



    }
}
