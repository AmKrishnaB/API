package Bewakoof;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ProxyChecker {
        public static void main(String[] args) {
            // List of proxies in the format "host:port"
            String[] proxies = {};


            for (String proxyString : proxies) {
                try {
                    // Split the proxy string into host and port
                    String[] proxyParts = proxyString.split(":");
                    String proxyHost = proxyParts[0];
                    int proxyPort = Integer.parseInt(proxyParts[1]);

                    // Set the proxy
                    RestAssured.proxy(proxyHost, proxyPort);

                    // Rest of your code
                    RestAssured.baseURI = "https://www.bewakoof.com/v1/carts/apply_coupon?wallet_applied=true";

                    String requestBody="{\n" +
                            "    \"param\": \"apply_coupon\",\n" +
                            "    \"cart\": {\n" +
                            "        \"coupon\": \"BWKFWV5AGFTR500\"\n" +
                            "    }\n" +
                            "}";

                    RestAssured.config().httpClient(HttpClientConfig.httpClientConfig().setParam("http.connection.timeout", 10000 ));

                    Response response=given()
                            .header("Ab-Id","60")
                            .header("Accept","*/*")
                            .header("Accept-Encoding","gzip, deflate, br")
                            .header("Accept-Language","en-GB,en-US;q=0.9,en;q=0.8,hi;q=0.7,mr;q=0.6")
                            .header("Access-Token","M2QxNmQ3NWEyNjQ2NGNjZGI1MWNlYzYyMTVjMGQ2ZjI6YmhheWVrYXIzQGdtYWlsLmNvbQ==")
                            .header("Api-Token","MWY5ZTNmNzFmN2M1ZTUyMjkwNjM2NGMzNmNjZTA3N2Q6M2RhMmI3OTgtNTY2MC00ZDRhLWJhZWQtNTZlMDI2MWRlYmZm")
                            .header("Client-Device-Token","MWY5ZTNmNzFmN2M1ZTUyMjkwNjM2NGMzNmNjZTA3N2Q6M2RhMmI3OTgtNTY2MC00ZDRhLWJhZWQtNTZlMDI2MWRlYmZm")
                            //.header("Content-Length","60")
                            .header("Content-Type","application/json")
                            .header("Cookie","_gcl_au=1.1.1298881265.1702560355; _gid=GA1.2.1496931767.1702560356; _scid=c8292ab1-7b0e-4587-a5fc-39528e39aea4; _sctr=1%7C1702492200000; jwt_token=eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoxMjUzOTA3NywiZXhwIjoxNzAzMTY1MTkyfQ.2yCf9nqm7P2Il02uL7QgCTPudV4n7XLhVBymmqDAbAw; WZRK_G=fa18433663a74912b8a4ff1a49123de5; userType=new_user_score; isMember=false; abId=60; isNewUser=true; _scid_r=c8292ab1-7b0e-4587-a5fc-39528e39aea4; _ga=GA1.1.136487986.1702560356; _gat=1; WZRK_S_8R9-845-Z84Z=%7B%22p%22%3A1%2C%22s%22%3A1702575699%2C%22t%22%3A1702575699%7D; _ga_H9S2VC0HED=GS1.1.1702575699.3.1.1702575741.18.0.0")
                            .header("Dnt","1")
                            .header("Isbshotsapp","false")
                            .header("Microapp","")
                            .header("Newrelic","eyJ2IjpbMCwxXSwiZCI6eyJ0eSI6IkJyb3dzZXIiLCJhYyI6IjI1NjM0MTMiLCJhcCI6IjExMzQwODMwMDkiLCJpZCI6IjBlNzg0NDUyNjBkMWJhNTEiLCJ0ciI6Ijg2ZjRiNTc4ZGY2ZjVhM2Q4NGE1MjE0MzhlZWE3ZjAwIiwidGkiOjE3MDI1NzU3NTM3NDh9fQ==")
                            .header("Origin","https","//www.bewakoof.com")
                            .header("Preferred-Location","IN")
                            .header("Referer","https","//www.bewakoof.com/cart")
                            .header("Sec-Ch-Ua","\"Not_A Brand\";v=\"8\", \"Chromium\";v=\"120\", \"Google Chrome\";v=\"120\"")
                            .header("Sec-Ch-Ua-Mobile","?0")
                            .header("Sec-Ch-Ua-Platform","\"Windows\"")
                            .header("Sec-Fetch-Dest","empty")
                            .header("Sec-Fetch-Mode","cors")
                            .header("Sec-Fetch-Site","same-origin")
                            .header("Switch-Platform","false")
                            .header("Token","3d16d75a26464ccdb51cec6215c0d6f2")
                            .header("Traceparent","00-86f4b578df6f5a3d84a521438eea7f00-0e78445260d1ba51-01")
                            .header("Tracestate","2563413@nr=0-1-2563413-1134083009-0e78445260d1ba51----1702575753748")
                            .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
                            .header("X-Http-Method-Override","PATCH")
                            .header("X-Newrelic-Id","VgMBUlJSCxABVFRSBQIBUFUE")
                            .header("X-Requested-With","XMLHttpRequest")
                            .body(requestBody).
                            when().post().
                            then().extract().response();

                    // Print the response details
                    String responseBody = response.getBody().asString();
                    long responseTime = response.getTime();
                    int responseStatus = response.getStatusCode();
                    System.out.println("Proxy: " + proxyString + " - " + responseTime + " - " + responseBody + " - " + responseStatus);

                    // Check if the response code is 200
                    if (responseStatus == 200) {
                        // Call the method to write to CSV
                        CsvWriter.writeToCSV("C:/Users/Administrator/Downloads/WorkingProxy.csv", proxyString);
                    }

                } catch (Exception e) {
                    // Handle proxy-related exceptions
                    System.out.println("Proxy " + proxyString + " error: " + e.getMessage());
                }
            }
        }
    }
