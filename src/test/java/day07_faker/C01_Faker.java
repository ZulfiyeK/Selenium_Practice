package day07_faker;

import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.K;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import util.Methods;

public class C01_Faker extends Methods {

    @Test
    public void test() {
        // 'https://www.facebook.com' sayfasina gidiniz
        driver.get("https://www.facebook.com");


        // yeni hesap olustur butonuna basin
        driver.findElement(By.xpath("//*[@class ='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();


        // isim kutusunu locate ediniz
        WebElement isim = driver.findElement(By.xpath("(//input[@class= 'inputtext _58mg _5dba _2ph-'])[1]"));





        // geriye kalan alanlari TAB ile dolasarak faker bilgilerle formu doldurun
        Faker faker = new Faker();

        String email = faker.internet().emailAddress(); //mail adresini burada atadim,cunku ilerlemek istedigimde tekrar mail istiyor
                                                        // faker kodda her seferinde farkli mail adresi verecegi icin, bunu bir String'e atayip
                                                        // her iki yere de ayni mail'i girmis olurum.

        Actions actions = new Actions(driver);

        actions.click(isim).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("25").
                sendKeys(Keys.TAB).
                sendKeys("Nisan").
                sendKeys(Keys.TAB).
                sendKeys("1999").
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();










    }
}
