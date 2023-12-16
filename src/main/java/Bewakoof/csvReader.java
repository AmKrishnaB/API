package Bewakoof;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class csvReader {
    public static List<String[]> copyCoupon(String path) throws IOException, CsvException {
        // Create a CSV reader
        CSVReaderBuilder builder = new CSVReaderBuilder(new FileReader(path));
        builder.withCSVParser(new CSVParserBuilder().build());
        CSVReader reader = builder.build();

        List<String[]> allData = reader.readAll();
        System.out.println("CSV Loaded");
        return allData;
    }

}
