package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class Methods {
    protected WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @After
    public void tearDown() throws Exception {
       // driver.quit();
    }


    public void wait(int saniye) {
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void alertAccept(){
        driver.switchTo().alert().accept();
    }


    public void alertDismiss(){
        driver.switchTo().alert().dismiss();
    }


    public void alertPrompt(String text){
        driver.switchTo().alert().sendKeys(text);
    }


    public void alertText(){
        System.out.println(driver.switchTo().alert().getText());
    }


    public void ddmVisibleText(WebElement ddm, String secenek){
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }


    public void ddmIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }


    public void ddmValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }


    //switchTo Window -1 (istemsiz acilan sekmeyi handle etme)
    public void SwitchToWindow(int index){
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(index));
    }


    //SwitchTo Window-2 (istemsiz acilan sekmeyi handle etme)
    public void switchToWindow2(int index){
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }




}
