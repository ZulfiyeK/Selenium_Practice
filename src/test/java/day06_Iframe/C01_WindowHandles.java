package day06_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import util.Methots;

import java.util.Set;

public class C01_WindowHandles extends Methots {
    @Test
    public void test1() {

        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        String n11Handle= driver.getWindowHandle();


        // arama motoruna 'Oppo' yazıp aratın
        driver.findElement(By.xpath("//input[@id='searchData']")).sendKeys("Oppo", Keys.ENTER);


        // ilk ürüne tıklayın
        driver.findElement(By.xpath("//h3[@class='productName']")).click();

        String ikincisayfaHandle= "";
        Set<String> allHandles = driver.getWindowHandles();
        for (String w : allHandles) {
            if(!w.equals(n11Handle)){
                ikincisayfaHandle = w;
            }
        }

        System.out.println(ikincisayfaHandle);
        driver.switchTo().window(ikincisayfaHandle);
        wait(4);

        // ikinci sayfa title'nin 'Oppo' icerdigini test edin.
       String ikincisayfaTitle = driver.getTitle();
        System.out.println("ikincisayfaTitle = " + ikincisayfaTitle);
        Assert.assertTrue(ikincisayfaTitle.contains("Oppo"));


        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(n11Handle);
        String ilksayfaTitle = driver.getTitle();
        System.out.println("ilksayfaTitle = " + ilksayfaTitle);


    }
}
