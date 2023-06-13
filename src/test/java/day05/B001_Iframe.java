package day05;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import util.Methotlar;

public class B001_Iframe extends Methotlar {
    @Test
    public void test() {


        //Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");


        //Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonHandle = driver.getWindowHandle();
        System.out.println("amazonHandle = " + amazonHandle);


        //Sayfa title’nin “Amazon” icerdigini test edin
        String amazonTitle = driver.getTitle();
        Assert.assertTrue(amazonTitle.contains("Amazon"));
        wait(2);



        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");


        //Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String tecproTitle = driver.getTitle();
        Assert.assertFalse(tecproTitle.contains("TECHPROEDUCATION"));
        wait(2);


        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");



        //Sayfa title’nin “Walmart” icerdigini test edin
        String walmartTitle = driver.getTitle();
        Assert.assertTrue(walmartTitle.contains("Walmart"));
        wait(2);


        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonHandle);
        wait(2);


    }
}
