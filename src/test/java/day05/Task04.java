package day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import util.Methots;

public class Task04 extends Methots {

    @Test
    public void task04() {
        //-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");
        wait(2);


        //-"Alert with OK" karşısındaki "click the button to display an alert box:" butonuna tıklayınız
        driver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();
        wait(2);



        //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        alertText();
        alertAccept();
        wait(2);


        //-"Alert with OK & Cancel" butonuna basınız ve sonrasında "click the button to display a confirm box" "butonuna basınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        wait(2);
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        wait(2);


        //-Çıkan alert'te iptal butonuna basınız
        alertDismiss();


        //-Alert with Textbox butonuna basınız ve sonrasında "click the button to demonstrate the prompt box" butonuna basınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
        wait(2);
        driver.findElement(By.xpath("//*[@class='btn btn-info']")).click();
        wait(2);


        //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız

        alertPrompt("Zulfiye");
        alertAccept();


        //-Çıkan mesajı konsola yazdırınız
        String sonucYazisi = driver.findElement(By.xpath("//*[@id='demo1']")).getText();
        System.out.println("sonucYazisi = " + sonucYazisi);


        //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        String expectedResult = "Hello Zulfiye How are you today";
        Assert.assertEquals(expectedResult,sonucYazisi);






















    }
}
