package tekrar;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import util.Methots;

public class B08_WindewHandle extends Methots {

    @Test
    public void yeniPencerede() {

    //  -"hepsiburada.com" adresine gidelim
        driver.get("https:/www.hepsiburada.com");
        String hepsiburadaHandle = driver.getWindowHandle();


    //  -bu web adresinin sayfa basligini(title) ve adres(url)ini alalim
       String sahibindenTitle =  driver.getTitle();
       String sahibindenUrl = driver.getCurrentUrl();


    //  -title ve url'nin "Oto" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(sahibindenTitle.contains("Oto"));
        Assert.assertFalse(sahibindenUrl.contains("Oto"));
        wait(2);


    //  -Ardindan "trendyol.com" adresine gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.trendyol.com");
        String trendyolHandle = driver.getWindowHandle();


    //  -bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        String baslik = driver.getTitle();
        Assert.assertFalse(baslik.contains("Sitesi"));
        wait(2);


    //  -Bi onceki web sayfamiza geri donelim
        driver.switchTo().window(hepsiburadaHandle);
        wait(2);


    //  -sayfayi yenileyelim
        driver.navigate().refresh();


    //  -Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        driver.switchTo().window(trendyolHandle);
        wait(2);
        driver.close();

    //  -En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();

    }


    @Test
    public void ayniSayfada() {
    //  -"hepsiburada.com" adresine gidelim
        driver.get("https:/www.hepsiburada.com");


    //  -bu web adresinin sayfa basligini(title) ve adres(url)ini alalim
        String sahibindenTitle =  driver.getTitle();
        String sahibindenUrl = driver.getCurrentUrl();


    //  -title ve url'nin "Oto" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(sahibindenTitle.contains("Oto"));
        Assert.assertFalse(sahibindenUrl.contains("Oto"));
        wait(2);


    //  -Ardindan "trendyol.com" adresine gidelim
        driver.get("https://www.trendyol.com");


    //  -bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        String baslik = driver.getTitle();
        Assert.assertFalse(baslik.contains("Sitesi"));
        wait(2);


    //  -Bi onceki web sayfamiza geri donelim
        driver.navigate().back();
        wait(2);


    //  -sayfayi yenileyelim
        driver.navigate().refresh();


    //  -Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        driver.navigate().forward();
        wait(2);
        driver.close();

    }


    @Test
    public void yeniSekmede() {

    //  -"hepsiburada.com" adresine gidelim
        driver.get("https:/www.hepsiburada.com");
        String hepsiburadaHandle = driver.getWindowHandle();


    //  -bu web adresinin sayfa basligini(title) ve adres(url)ini alalim
        String sahibindenTitle =  driver.getTitle();
        String sahibindenUrl = driver.getCurrentUrl();


    //  -title ve url'nin "Oto" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(sahibindenTitle.contains("Oto"));
        Assert.assertFalse(sahibindenUrl.contains("Oto"));
        wait(2);


    //  -Ardindan "trendyol.com" adresine gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.trendyol.com");
        String trendyolHandle = driver.getWindowHandle();


    //  -bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        String baslik = driver.getTitle();
        Assert.assertFalse(baslik.contains("Sitesi"));
        wait(2);


    //  -Bi onceki web sayfamiza geri donelim
        driver.switchTo().window(hepsiburadaHandle);
        wait(2);


    //  -sayfayi yenileyelim
        driver.navigate().refresh();


    //  -Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        driver.switchTo().window(trendyolHandle);
        wait(2);
        driver.close();

    //  -En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();

    }

}

