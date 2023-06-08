package day02_MavenPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class B04 {

    static WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test1() throws InterruptedException {

        //1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        Thread.sleep(1500);



        //2. Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        Thread.sleep(1500);


        //3. Login kutusuna “username” yazin
        //4. Password kutusuna “password.” yazin
        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username",Keys.TAB,"password",Keys.ENTER);
        Thread.sleep(1500);
        driver.navigate().back();
        Thread.sleep(1500);



        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='onlineBankingMenu']")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        Thread.sleep(1500);



        //7. “Purchase Foreign Currency” tusuna basin


        //8. “Currency” drop down menusunden Eurozone’u secin


        //9. “amount” kutusuna bir sayi girin


        //10.“US Dollars” in secilmedigini test edin


        //11.“Selected currency” butonunu secin


        //12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin


        //13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin


    }

    @After
    public void tearDown() throws Exception {
       // driver.close();
    }
}
