package Bewakoof;

import com.opencsv.exceptions.CsvException;
import io.restassured.response.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnerClass {
    public static void main(String[] args) throws IOException, CsvException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Future<Response>> futures = new ArrayList<>();

        for (String[] row : csvReader.copyCoupon("C:/Users/Administrator/Downloads/BKK.csv")) {
            for (String value : row) {
                Future<Response> future = (Future<Response>) executorService.submit(() -> PostApi.applyCoupon(value));
                futures.add(future);
            }
        }

        for (Future<Response> future : futures) {
            try {
                Response response = future.get();
                // Process the response as needed
            } catch (InterruptedException | ExecutionException ignored) {
            }
        }

        // Shut down the ExecutorService
        executorService.shutdown();
    }
}
