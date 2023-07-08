package day11_WebTable;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import util.Methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ScreenShot extends Methods {

    @Test
    public void screenShot() throws IOException {
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");


        // arama kutusuna Nutella yazip aratın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);


        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();


        // tüm sayfanın fotografını cekin
        String tarih = new SimpleDateFormat("_ddMMyyyy_hh_mm_ss").format(new Date());//fotograflari ust uste kaydetmemesi icin
        String dosyaYolu = "src/test/java/tumWebElementResimleri/tamekran"+tarih+".jpg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

        File kayit = new File(dosyaYolu);
        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya,kayit);


    }
}
