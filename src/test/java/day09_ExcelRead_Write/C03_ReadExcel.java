package day09_ExcelRead_Write;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import util.Methods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C03_ReadExcel extends Methods {
    @Test
    public void readExcel() throws IOException {

        //Ulkeler dosyasindaki tum datalari map'a aliniz ve yazdiriniz.

        Map<String,String> ulkeler = new HashMap<>();

        String dosyaYolu = "src/Resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();

        //1 sutun key, 1 sutun value olsaydi
        for (int i = 0; i <=sonSatir; i++) {
            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();

            ulkeler.put(key,value);
            //System.out.println(key+"/"+value);
        }
        System.out.print("ulkeler = " + ulkeler);


        System.out.println("**************************************************");


        //1 sutun key, 3 sutun value olsaydi
        for (int i = 0; i <=sonSatir; i++) {
            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+"/"
                         + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+"/"
                         + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ulkeler.put(key,value);
           //System.out.println(key+"/"+value);
        }
        System.out.print("ulkeler = " + ulkeler);


    }




}
