package day01_SeleniumPractice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
public class B01 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/Resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

        //Amazon sayfasına gidiniz
        driver.get("https://www.amazon.com");

        //samsung aratınız
        WebElement aramaMotoru = driver.findElement(By.id("twotabsearchtextbox"));
        aramaMotoru.sendKeys("samsung");
        aramaMotoru.submit();

        //çıkan sonuç yazısını konsola yazdırınız
        List<WebElement> sonucYazisi = driver.findElements(By.className("sg-col-inner"));
        System.out.println(sonucYazisi.get(0).getText());


        //çıkan ürünlerden ilk 5 tanesine tıklayıp sayfa başlıklarını yazdırınız

        for (int i = 0; i < 5; i++) {
            List<WebElement> urunler = driver.findElements(By.className("s-image"));

            urunler.get(i).click();
            System.out.println((i + 1) + ".urun basligi" + driver.getTitle());
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
        }


        //sayfayi kapatiniz
        driver.close();


    }
}
