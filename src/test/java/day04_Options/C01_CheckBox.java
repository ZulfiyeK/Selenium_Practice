package day04_Options;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_CheckBox {

    //CheckBox da tum kutucuklar secilebilir,
    //Radio buttunlarda ise sadece bir tane secilebilir.


    static WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test1() {
        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");


        // checkbox elementlerini locate edin
        WebElement checbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        WebElement checbox3 = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));


        // checkbox1 ve checkbox3  secili degil ise secin
        if(!checbox1.isSelected()){
            checbox1.click();
        }
        if(!checbox3.isSelected()){
            checbox3.click();
        }



        // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(checbox1.isSelected());
        Assert.assertTrue(checbox3.isSelected());


        // checkbox2 elementinin secili olmadıgını test edin
        Assert.assertFalse(checbox2.isSelected());

    }


    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
