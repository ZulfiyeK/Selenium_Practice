package day01_SeleniumPractice;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class B00 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/Resources/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        // Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());
        Thread.sleep(2000);


        //Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setPosition(new Point(50, 50));
        driver.manage().window().setSize(new Dimension(100, 500));
        Thread.sleep(2000);


        //Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        String position = "driver.manage().window().getPosition()";
        String expectedpos = "driver.manage().window().setPosition(new Point(50,50))";

        String size = "driver.manage().window().getSize())";
        String newsize = "driver.manage().window().setSize(new Dimension(600, 600))";
        Thread.sleep(2000);

        if (!position.equals(expectedpos) && !size.equals(newsize)) {
            System.out.println("Test PASSED");
        } else System.out.println("Test FAILED -> " + position);


        Thread.sleep(2000);
        // Sayfayi kapatin
        driver.close();


    }
}