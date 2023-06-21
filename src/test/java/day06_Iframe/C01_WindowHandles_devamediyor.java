package day06_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import util.Methots;

import java.util.Set;

public class C01_WindowHandles_devamediyor extends Methots {
    @Test
    public void test1() {

        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        String n11Handle= driver.getWindowHandle();
        String sayfa1ilkTitle= driver.getTitle();
        System.out.println("sayfa1ilkTitle = " + sayfa1ilkTitle);


        // arama motoruna 'Oppo' yazıp aratın
        driver.findElement(By.xpath("//input[@id='searchData']")).sendKeys("Oppo", Keys.ENTER);
        String sayfa1ikinciTitle = driver.getTitle();
        System.out.println("sayfa1ikinciTitle = " + sayfa1ikinciTitle);


        // ilk ürüne tıklayın
        driver.findElement(By.xpath("//h3[@class='productName']")).click();


        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("allHandles = " + allHandles);

        String ikincisayfaHandle= "";
        for (String w : allHandles) {
            if(!w.equals(n11Handle)){
                ikincisayfaHandle = w;
            }
        }

        System.out.println(ikincisayfaHandle);
        driver.switchTo().window(ikincisayfaHandle);
        wait(7);

        /*
        //String sayfa2Handle = driver.getWindowHandle();
        //System.out.println("SAYFA2HANDLE: " + sayfa2Handle);
        //driver hala ilk sayfada bunu anlıyorum

        Set<String> windowHandleSeti = driver.getWindowHandles();
        System.out.println(windowHandleSeti);

        String sayfa2Handle="";

        for (String each:windowHandleSeti) {
            if(!each.equals(sayfa1Handle)){
                sayfa2Handle = each;
            }
        }

        System.out.println("SAYFA2HANDLE: " + sayfa2Handle);

        driver.switchTo().window(sayfa2Handle);
*/


        // ikinci sayfa title'nin 'Türkiye' icerdigini test edin.
        String ikincisayfaTitle = driver.getTitle();
        System.out.println("ikincisayfaTitle = " + ikincisayfaTitle);
        Assert.assertTrue(ikincisayfaTitle.contains("Türkiye"));


        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(n11Handle);
        String sayfa1sonTitle = driver.getTitle();
        System.out.println("sayfa1sonTitle = " + sayfa1sonTitle);


    }
}
