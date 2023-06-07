package day02_MavenPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {



    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }



    @Test
    public void test1() throws InterruptedException {
        // https://www.techproeducation.com/ sayfasina gidin
        driver.get("https://www.techproeducation.com");

        // Title ve Url'ini alın ve yazdırın
        String techproeducationtitle = driver.getTitle();
        System.out.println("techproeducation title= " + techproeducationtitle);

        String techproeducationUrl =  driver.getCurrentUrl();
        System.out.println("techproeducationUrl = " + techproeducationUrl);


        // Title'in "Techpro" kelimesini içerip içermedigini test edin
        Assert.assertTrue(techproeducationtitle.contains("Techpro"));


        // Url'in "techproeducation" kelimesini içerip içermedigini test edin
        Assert.assertTrue(techproeducationUrl.contains("techproeducation"));


        Thread.sleep(2000);
        // https://www.amazon.com/ sayfasına gidin
        driver.get("https://www.amazon.com/");

        // Title'ini alın ve yazdırın
        String amazonTitle= driver.getTitle();
        System.out.println("amazonTitle = " + amazonTitle);


        // Title'in "more" kelimesini içerip içermedigini test edin
        Assert.assertTrue(amazonTitle.contains("more"));


        Thread.sleep(2000);
        // techproeducation.com'a geri dönün
        driver.navigate().back();
        Thread.sleep(2000);


        // sayfayı yenileyin
        driver.navigate().refresh();
        Thread.sleep(2000);

        // amazon.com'a tekrar gelin
        driver.navigate().forward();

    }
    @After
    public void tearDown() throws Exception {
        driver.close();
    }


}
