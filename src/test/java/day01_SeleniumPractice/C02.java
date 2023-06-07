package day01_SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/Resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//herbir web elementin yuklenmesi icin max bekleme suresidir.


    // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);


    // arama motorunda nutella yazip aratınız
       WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));// buraya da .sendKeys("nutella",Keys.ENTER); diyebilirim.
       aramaKutusu.sendKeys("nutella", Keys.ENTER);
        Thread.sleep(2000);


    // Customer Service ve Registry butonlarına sırasıyla tıklayın ve title'larının "Amazon" icerdigini test edi
        for (int i = 0; i < 2; i++) {
            List<WebElement> buttonlar = driver.findElements(By.xpath("(//*[@class ='nav-a  '])[2] | (//*[@class ='nav-a  '])[3]"));//iki farkli webelementin locate'ini tek seferde almis olduk.
            buttonlar.get(i).click();

            if (driver.getTitle().contains("Amazon")){
                System.out.println("Title Amazon iceriyor.");
            }
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
        }


    // pencereyi kapatiniz
        driver.close();

    }
}
