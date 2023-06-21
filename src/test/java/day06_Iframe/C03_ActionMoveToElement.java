package day06_Iframe;

import com.beust.ah.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import util.Methots;

import java.util.Set;

public class C03_ActionMoveToElement extends Methots {
    @Test
    public void test() {
    // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        String ilkSayfaHandle = driver.getWindowHandle();
        System.out.println("ilkSayfaHandle = " + ilkSayfaHandle);
        String ilksayfaTitle = driver.getTitle();
        System.out.println("ilksayfaTitle = " + ilksayfaTitle);


    // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions = new Actions(driver);
       WebElement dilMenu=  driver.findElement(By.xpath("//div[text()='EN']"));
        actions.moveToElement(dilMenu).perform();



    // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]")).click();


    // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement ulkeler = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        Select select= new Select(ulkeler);
        select.selectByVisibleText("Turkey (Türkiye)");
        wait(2);


    // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("(//span[@class='a-text-bold'])[3]")).click();
        //Go to website  butonuna tiklayabilmem icin ulkeler penceresinin kapanmasi lazim.
        // bunun icin herhangi bir yere tiklama yapiyoruz.


        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();


    // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz

        Set<String> allHandles = driver.getWindowHandles();

        String ikinciSaydfaHandle = "";
        for (String w: allHandles) {
            if(!w.equals(ilkSayfaHandle)){
                ikinciSaydfaHandle=w;
            }
        }
        System.out.println("ikinciSaydfaHandle = " + ikinciSaydfaHandle);
        driver.switchTo().window(ikinciSaydfaHandle);
        wait(2);

        String ikincisayfaTitle = driver.getTitle();
        System.out.println("ikincisayfaTitle = " + ikincisayfaTitle);


        Assert.assertTrue(ikincisayfaTitle.contains("Elektronik"));

    }
}
