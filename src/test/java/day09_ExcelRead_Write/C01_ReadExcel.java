package day09_ExcelRead_Write;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import util.Methods;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel extends Methods {
    @Test
    public void ReadExcel() throws IOException {

        //Ulkeler dosyasindaki 3. satir indeksin 3. sutundaki indeksinin "Cezair" oldugunu test eden methodu olusturunuz.


        int satirNoIndeks = 3;
        int sutunNoIndeks = 3;

        String actuelData = banaDataGetir(satirNoIndeks,sutunNoIndeks);
        String expectedData = "Cezayir";

        Assert.assertEquals(expectedData,actuelData);

    }

    public static String banaDataGetir(int satirNoIndeks, int sutunNoIndeks) throws IOException {

        String dosyaYolu = "src/Resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        String istenenData = workbook.getSheet("Sayfa1").getRow(satirNoIndeks).getCell(sutunNoIndeks).toString();

        return istenenData;

    }
}
