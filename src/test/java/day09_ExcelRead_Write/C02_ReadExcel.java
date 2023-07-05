package day09_ExcelRead_Write;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import util.Methods;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel extends Methods {


    @Test
    public void ReadExcel() throws IOException {

        String dosyaYolu = "src/Resources/ulkeler.xlsx";
        FileInputStream fis= new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        int sonSatirNo= workbook.getSheet("Sayfa1").getLastRowNum();

        System.out.println("sonSatirNo = " + sonSatirNo);//190--> indeks

        //1.yol
        for (int i = 0; i <=sonSatirNo; i++) {
           String ingilizceBaskent =  C01_ReadExcel.banaDataGetir(i,1);//Baskent(ingilizce) sutununu yazdiracagim, i satiri, 1 de sutunu ifade eder.
            //Bu sekilde kullanabilmek icin --> C01_ReadExcel class'indaki methodu baska classlarda kullanabilmek icin static yapmak zorundayiz. Boylece method'u class ismi ile cagirabiliriz.
           System.out.println("ingilizceBaskent = " + ingilizceBaskent);

           /*
             instins bir methodu static yapmadan baska classlardan kullanabilmek icin obje olusturmaliyiz.
                C01_ReadExcel obj = new C01_ReadExcel();
                String ingilizceBaskent =  C01_ReadExcel.banaDataGetir(i,1);
                System.out.println("ingilizceBaskent = " + ingilizceBaskent);
            */

        }

        //2.yol
        for (int i = 0; i <=sonSatirNo; i++) {
            String ingilizceBaskentSatiri =  workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            //baskent ingilizce stununu yazdiracagim, i satiri, 1 de sutunu ifade eder.
            System.out.println("ingilizceBaskentSatiri = " + ingilizceBaskentSatiri);

        }

















    }
}
