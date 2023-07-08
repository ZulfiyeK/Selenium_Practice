package day11_WebTable;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import util.Methods;

import java.util.List;

public class C01_WebTable extends Methods {
    @Test
    public void webTable() {
        girisYap();

        //Not : Web Tablede indesk 1 den baslar.

        //email basligindaki tum elementleri(sutunu) yazdiriniz.

        List<WebElement>basliklar = driver.findElements(By.xpath("//thead//tr[1]//th"));

        int emailSutunNo = 0;
        for (int i = 0; i < basliklar.size(); i++) {
            if(basliklar.get(i).getText().equals("Email")){// hangi stunun adini yazarsak o sutunun elementlerini yazdiracak
                emailSutunNo=i;
            }
        }

        List<WebElement> email = driver.findElements(By.xpath("//tbody//tr//td["+(emailSutunNo+1)+"]"));
        //daha dinamik olmasi icin once Email sutunun indeksini buluyorum ve onu buraya yaziyorum
        email.stream().forEach(t-> System.out.println(t.getText()));




    }



    public void girisYap() {

        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();
        driver.findElement(By.xpath("(//*[@class='nav-link'])[7]")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//input[@id='UserName']"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();

    }




}
