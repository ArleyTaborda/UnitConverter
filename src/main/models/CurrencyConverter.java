package main.models;

public class CurrencyConverter {
   public static double convert(double value, String currency1, String currency2) {
      double currencyReq = ApiRequest.currencyRequest(currency1, currency2);
      double cValue = value * currencyReq;
      return  cValue;
   }
}
