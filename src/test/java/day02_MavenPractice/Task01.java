package day02_MavenPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Task01 {
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
        WebElement electronics = driver.findElement(By.xpath("(//*[text()='Electronics'])[2]"));
        electronics.click();


       /* rusya sayfasi icin gecerli kod
        List<WebElement> resimler = driver.findElements(By.xpath("(//*[@class='b-img'])[position()>=1 and position()<=10]"));
        for (int i = 0; i <resimler.size() ; i++) {
            resimler = driver.findElements(By.xpath("(//*[@class='b-img'])[position()>=1 and position()<=10]"));
            resimler.get(i).click();
            String title = driver.getTitle();
            System.out.println(title);
            driver.navigate().back();
        }
*/
//      2. yol
        List<WebElement> images = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
        for (int i = 0; i < images.size(); i++) {
            images = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
            images.get(i).click();
            Thread.sleep(1000);
            String pageTitle = driver.getTitle();
            System.out.println("Sayfa Başlığı: " + pageTitle);
            driver.navigate().back();
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }


}