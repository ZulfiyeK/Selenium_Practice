package day08_Files;

import org.junit.Assert;
import org.junit.Test;
import util.Methods;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_Files extends Methods {

    @Test
    public void test() {

        // masaustunde bir text dosyası olusturunuz
        // masaustunde text dosyasının olup olmadıgını test ediniz

        //1.yol-dinamik degildir.
        // Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\zulfi\\OneDrive\\Masaüstü\\teamSelenium.txt")));

        //2. yol
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\OneDrive\\Masaüstü\\teamSelenium.txt";
        String yol = farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(yol)));






    }
}
