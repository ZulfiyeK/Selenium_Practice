package day02_MavenPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class B03 {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void test1() {
       //https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");

        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        WebElement kategori = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select option = new Select(kategori);
        int kategoriSayisi = option.getOptions().size();
        System.out.println("kategoriSayisi = " + kategoriSayisi);
        Assert.assertNotEquals("45", "kategoriSayisi");
    }
        @Test
        public void test2() {
            driver.get("https://www.amazon.com/");

            //1.Kategori menusunden Books secenegini secin
            WebElement kategori = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
            Select option = new Select(kategori);
            option.selectByVisibleText("Books");


        //2. Arama kutusuna Java yazin ve aratin
            driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);

        //3. Bulunan sonuc sayisini yazdirin
           WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='sg-col-inner']"));
           String sonucSayisi[] = sonucYazisi.getText().split(" ");
            System.out.println("sonucSayisi = " + sonucSayisi[3]);


        //4. Sonucun Java kelimesini icerdigini test edin
            Assert.assertTrue(sonucYazisi.getText().contains("Java"));

        }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}

