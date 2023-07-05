package day09_ExcelRead_Write;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import util.Methods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C04_WriteExcel extends Methods {
    @Test
    public void writeExcel() throws IOException {

     //Ulkeler dosyasindaki 0. satir index'in 4. hucre index'ine yeni bir cell olusturalim,
     // olusturdugumuz hucreye "NUFUS" yazdiralim,


      String dosyaYolu = "src/Resources/ulkeler.xlsx";
      FileInputStream fis = new FileInputStream(dosyaYolu);
      Workbook workbook = WorkbookFactory.create(fis);


      //1.satirda 4.stunda yeni bir hucre olusturuyorum ve icine de "NUFUS" yaziyorum.
      workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("NUFUS");


      //1. Satir Index'in 4. hucre index'ine yeni bir cell olusturun olusturdugunuz hucreye "15000" yazdirin
      workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("15000");//String


      //2. Satir Index'in 4. hucre index'ine yeni bir cell olusturun olusturdugunuz hucreye "25000" yazdirin
      workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue(55000);//int


      FileOutputStream fos = new FileOutputStream(dosyaYolu);
      //yapilan degisiklikleri bizim calss'imizdan ulkeler doayasina gonderiyoruz.

      workbook.write(fos);


      fos.close();
      fis.close();
      workbook.close();


    }
}
