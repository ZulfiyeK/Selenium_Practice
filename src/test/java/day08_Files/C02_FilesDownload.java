package day08_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.Methods;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FilesDownload extends Methods {

    @Test
    public void test() {
        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");
        wait(2);


        // some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();
        wait(2);


        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz
        //String dosyaYolu = "C:\\Users\\zulfi\\Downloads\\some-file.txt";
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\some-file.txt";
        String yol = farkliKisim+ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(yol)));

    }

    @Test
    public void test01() {
        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");
        wait(2);


        // some-file.txt dosyasini indirelim
        File silinecekDosya = new File("C:\\Users\\zulfi\\Downloads\\some-file.txt");
        silinecekDosya.delete();//asagida indirilecek  dosya locate'i var. eger bu dosya bilg.'da varsa once sil,
                                // sonra indirme islemini yapabilirsin demis oluyorum.

        driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();
        wait(2);


        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz
        //String dosyaYolu = "C:\\Users\\zulfi\\Downloads\\some-file.txt";
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\some-file.txt";
        String yol = farkliKisim+ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(yol)));

    }
}
