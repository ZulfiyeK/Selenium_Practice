package tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task02 {
     /*
    Junit ile testlerimizi yapabilmek icin assertion'lari kullanabilir hale geldik..if lerden kurtulduk
    mainden kurtulduk.

     */
//BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
//Before methodunda http://www.google.com adresine gidin
//Üç farklı test methodu ile;
//arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
//arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
//arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
//After method'u ile başlıkları yazdırınız
//AfterClass ile browser'ı kapatınız

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Before
    public void setUp() throws Exception {
        driver.get("http://www.google.com");
        Thread.sleep(1500);
    }


    @Test
    public void test1() throws InterruptedException {
        WebElement aramakutusu=  driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramakutusu.sendKeys("The God Father");
        aramakutusu.submit();

        WebElement sonucYazisi1 = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String []sonucSayisi1 = sonucYazisi1.getText().split(" ");
        System.out.println("Sonuc Sayisi1 : "+ sonucSayisi1[1]);
        Thread.sleep(1500);
    }



    @Test
    public void test2() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Kill Bill",Keys.ENTER);

        WebElement sonucYazisi3 = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String []sonucSayisi3 = sonucYazisi3.getText().split(" ");
        System.out.println("Sonuc Sayisi3 : "+ sonucSayisi3[1]);
        Thread.sleep(1500);
    }
    @Test
    public void test3() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Lord of the Rings",Keys.ENTER);

        WebElement sonucYazisi2 = driver.findElement(By.xpath("//div[@id='result-stats']"));
        String []sonucSayisi2 = sonucYazisi2.getText().split(" ");
        System.out.println("Sonuc Sayisi2 : "+ sonucSayisi2[1]);
        Thread.sleep(1500);
    }

    @After
    public void tearDown() throws Exception {
        String TheGodfather = driver.getTitle();
        System.out.println("TheGodfather Title = " + TheGodfather);

        String LordOfTheRings = driver.getTitle();
        System.out.println("LordOfTheRings Title = " + LordOfTheRings);

        String KillBill = driver.getTitle();
        System.out.println("KillBill Title = " + KillBill);

       // System.out.println(driver.getTitle()); sadece bu haliyle de tum title'lari yazdirabiliriz.'
    }

    @AfterClass
    public static void afterClass() throws Exception {

        driver.close();
    }
}
