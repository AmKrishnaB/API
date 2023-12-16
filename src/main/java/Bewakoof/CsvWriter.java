package Bewakoof;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {
        public static void writeToCSV(String filePath, String inputString) {
            try (CSVWriter writer = new CSVWriter(new FileWriter(filePath, true))) {
                // Writing the string to the CSV file as a single-element string array
                writer.writeNext(new String[]{inputString});
            } catch (IOException ignored) {
            }
        }
}
