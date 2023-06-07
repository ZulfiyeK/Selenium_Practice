package day02_MavenPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01 {
//BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
//Before methodunda http://www.google.com adresine gidin
//Üç farklı test methodu ile;
//arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
//arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
//arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
//After method'u ile başlıkları yazdırınız
//AfterClass ile browser'ı kapatınız

WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Before
    public void setUp() throws Exception {
        driver.get("https://www.google.com");
    }

    @Test
    public void aramakutusu1() {
    }
    @Test
    public void aramakutusu2() {
    }
    @Test
    public void aramakutusu3() {
    }

    @AfterClass
    public static void afterClass() throws Exception {

    }

    public static class C03 {
     /*
        *** Aşağıdaki Task'i Junit framework'u ile yapınız

    - Before methodu ile drive'i olusturup ayarlamalari yapiniz
    - ebay sayfasına gidiniz
    - electronics bölümüne tıklayınız
    - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
    - Her sayfanın sayfa başlığını yazdıralım
    - After methodu ile sayfayı kapatalım

      */

        WebDriver driver;
        @Before
        public void setUp() throws Exception {
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }


        @Test
        public void ebay() throws InterruptedException {
            driver.get("https://www.ebay.com");
            WebElement electronics = driver.findElement(By.xpath("(//*[@class='hl-cat-nav__js-tab'])[1]"));
            electronics.click();


           // WebElement width= driver.findElement(By.xpath("(//*[@width='225'])[1]"));
            List<WebElement> resimler = driver.findElements(By.xpath("(//*[@class='b-img'])[position()>=1 and position()<=10]"));
            for (int i = 0; i <resimler.size() ; i++) {
                resimler = driver.findElements(By.xpath("(//*[@class='b-img'])[position()>=1 and position()<=10]"));
                resimler.get(i).click();
                String title = driver.getTitle();
                System.out.println(title);
                driver.navigate().back();
            }

    /*      2. yol
            List<WebElement> images = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
            for (int i = 0; i < images.size(); i++) {
                images = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
                images.get(i).click();
                Thread.sleep(1000);
                String pageTitle = driver.getTitle();
                System.out.println("Sayfa Başlığı: " + pageTitle);
                driver.navigate().back();
            }*/
        }

            @After
            public void tearDown() throws Exception {
            driver.close();
            }


    }
}
