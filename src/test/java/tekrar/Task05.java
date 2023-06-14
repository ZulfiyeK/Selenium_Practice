package tekrar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import util.Methots;

public class Task05 extends Methots {
    @Test
    public void task05() {
      // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");


      // ikinci emojiye tıklayın

        WebElement frame = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();


      // İkinci emoji öğelerini yazdırınız
        String emoji = driver.findElement(By.xpath("//*[@class='mdl-tabs__panel is-active']")).getText();
        System.out.println("emoji = " + emoji);

      // Parent iframe e geri donun
        driver.switchTo().parentFrame();


      // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
        WebElement form = driver.findElement(By.xpath("//*[@id='text']"));
        form.sendKeys("A", Keys.TAB,"B",Keys.TAB,"C",Keys.TAB,"D",Keys.TAB,"E",Keys.TAB,"F",Keys.TAB,"G",Keys.TAB,"H",Keys.TAB,"I",Keys.TAB,"J",Keys.TAB,"K",Keys.ENTER);
        wait(2);


      // Apply button a basiniz
        driver.findElement(By.id("send")).click();


















    }
}
