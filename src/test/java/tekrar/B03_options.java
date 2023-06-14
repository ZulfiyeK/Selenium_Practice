package tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class B03_options {
    /*

    Bir class oluşturun: DropDown
●
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

        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");


        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement options = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select option = new Select(options);
        option.selectByIndex(1);
        System.out.println("Option 1 = " + option.getFirstSelectedOption().getText());


        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        Select option2 = new Select(options);
        option2.selectByValue("2");
        System.out.println("Option 2 = " + option2.getFirstSelectedOption().getText());



        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve  yazdırın
        Select option3 = new Select(options);
        option3.selectByVisibleText("Option 1");
        System.out.println("Option 1 = " + option3.getFirstSelectedOption().getText());


        System.out.println("*****************************");
       // 4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> allValues = driver.findElements(By.xpath("//select[@id='dropdown']//option"));
        allValues.stream().forEach(t-> System.out.println(t.getText()));


       // 5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,degilse False yazdırın.
        List<WebElement> tagname1 =option.getOptions();
        tagname1.stream().forEach(t-> System.out.println(t.getText()));

        int tagname = option.getOptions().size();
        if (tagname == 4){


            System.out.println("True");
        }else{
            System.out.println("false");
        }
        Assert.assertFalse(tagname==4);


    }


    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
