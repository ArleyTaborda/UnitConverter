package main.models;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ApiRequest {

    public ApiRequest(String currency1, String currency2) {
    }

    public static double currencyRequest(String currency1, String currency2) {

        String apiKey = "cVFZH49EO3SWppAWt0s3WJqwpR04iCdLgXD2YKNM";
        String url = "https://api.currencyapi.com/v3/latest?apikey=" + apiKey + "&currencies=" + currency2 + "&base_currency=" + currency1;

        double currencyValue = 0;
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            String[] currencies = {"USD", "EUR", "GBP", "JPY"}; // Lista de divisas a consultar

            StringBuilder sb = new StringBuilder();
            for (String moneda : currencies) {
                sb.append("&currency=").append(URLEncoder.encode(moneda, "UTF-8"));
            }
            String query = sb.toString();

            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String json = response.toString();
            JSONObject jsonObj = new JSONObject(json);

            currencyValue = jsonObj.getJSONObject("data").getJSONObject(currency2).getDouble("value");
            currencyValue = Double.parseDouble(String.valueOf(currencyValue));
            System.out.println(currencyValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currencyValue;
    }
}
