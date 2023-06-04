package day01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/Resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//herbir web elementin yuklenmesi icin max bekleme suresidir.


        // "https://testpages.herokuapp.com/styled/calculator" adresine gidin
        driver.get("https://testpages.herokuapp.com/styled/calculator");
        Thread.sleep(3000);

        // ilk kutucuga 20 giriniz
         WebElement ilkKutu = driver.findElement(By.id("number1"));//xpath ile de locate alinabilir.
         ilkKutu.sendKeys("20");
        Thread.sleep(3000);


        // ikinci kutucuga 30 giriniz
        WebElement ikinciKutu = driver.findElement(By.xpath("//input[@id='number2']"));//xpath ile yazimi
        ikinciKutu.sendKeys("30");
        Thread.sleep(3000);


        // calculate'e tıklayınız
        driver.findElement(By.id("calculate")).click();
        Thread.sleep(3000);


        // sonucu yazdırınız
        WebElement sonuc = driver.findElement(By.id("answer"));
        System.out.println("Sonuc :"+sonuc.getText());
        Thread.sleep(3000);

        // sayfayi kapatiniz
        driver.close();













    }
}
