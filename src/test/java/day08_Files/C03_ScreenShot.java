package day08_Files;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import util.Methods;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ScreenShot extends Methods {

    @Test
    public void test() throws IOException {
       // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");

        try {
            driver.findElement(By.xpath("//div[@id='ins-editable-button-1580496494']")).click();
        } catch (Exception e) {
            System.out.println("cookies cıkmadı");
        }//cookies cikarsa handle etmek icin bu kodu yazdik.


       // arama cubuguna oppo yazip enter'a basınız
        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("oppo", Keys.ENTER);


       // sonuc yazısını yazdiriniz
        WebElement sonucYazisi =  driver.findElement(By.xpath("//div[@class='plp-panel-block1']"));
        System.out.println(sonucYazisi.getText());

        // ilk urunun fotografını cekin
        WebElement ilkUrun = driver.findElement(By.xpath("(//a[@class=' prd-link '])[1]"));

        //1.yol
        String tarih = new SimpleDateFormat("_ddMMyyyy_hh_mm_ss").format(new Date());
        String dosyaYolu = "src/test/java/tumWebElementResimleri/WebElementScreenshot" + tarih+ ".jpg" ;
        FileUtils.copyFile(ilkUrun.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

        //2.yol
        //File kayit = new File("src/test/java/tumWebElementResimleri.ilkUrun.jpeg");
        //File geciciDosya = ilkUrun.getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(geciciDosya,kayit);










    }
}
