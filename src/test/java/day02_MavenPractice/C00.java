package day02_MavenPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C00 {
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
    public static void before() throws Exception {
        WebDriverManager.chromedriver().setup();

    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.google.com");
    }

    @Test
    public void aramaMotoru1() {
        driver.findElement(By.xpath("//*[@id='APjFqb']")).sendKeys("The God Father", Keys.ENTER);
        WebElement sonucYazisi1 = driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println(sonucYazisi1.getText());

    }
    @Test
    public void aramaMotoru2() {
        driver.findElement(By.xpath("//*[@id='APjFqb']")).sendKeys("Lord of the Rings", Keys.ENTER);
        WebElement sonucYazisi2 = driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println(sonucYazisi2.getText());

    }
    @Test
    public void aramaMotoru3() {
        driver.findElement(By.xpath("//*[@id='APjFqb']")).sendKeys("Kill Bill", Keys.ENTER);
        WebElement sonucYazisi3 = driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println(sonucYazisi3.getText());

    }

    @After
    public void tearDown() throws Exception {
        String TheGodfather = driver.getTitle();
        System.out.println("TheGodfather Title = " + TheGodfather);

        String LordOfTheRings = driver.getTitle();
        System.out.println("LordOfTheRings Title = " + LordOfTheRings);

        String KillBill = driver.getTitle();
        System.out.println("KillBill Title = " + KillBill);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        driver.quit();
    }
}
