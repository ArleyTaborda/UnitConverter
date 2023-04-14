package main.controllers;

import main.models.*;

public class CurrencyController {

    public static double convert(String type, double value, String fromUnit, String toUnit) {
        double result = 0;
        switch (type) {
            case "Divisas" -> result = currencyConversion(value, fromUnit, toUnit);
            case "Longitud" -> result = distanceConversion(value, fromUnit, toUnit);
            case "Temperatura" -> result = temperatureConversion(value, fromUnit, toUnit);
            case "Peso" -> result = weightConversion(value, fromUnit, toUnit);
            case "Area" -> result = areaConversion(value, fromUnit, toUnit);
            default -> System.out.println("Por favor selecciona un tipo de conversión.");
        }
        return result;
    }


    public static double distanceConversion(double value, String fromUnit, String toUnit) {
        double convertedValue = 0;
        try {
            double nValue = Double.parseDouble(String.valueOf(value));
            convertedValue = DistanceConverter.convert(nValue, fromUnit, toUnit);
            System.out.println(convertedValue);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return convertedValue;
    }

    public static double temperatureConversion(double value, String fromUnit, String toUnit){

        double convertedValue = 0;
        try {
            double nValue = Double.parseDouble(String.valueOf(value));
            convertedValue = TemperatureConverter.convert(nValue,fromUnit,toUnit);
            System.out.println(convertedValue);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        return convertedValue;
    }

    public static double weightConversion(double value, String fromUnit, String toUnit){

        double convertedValue = 0;
        try {
            double nValue = Double.parseDouble(String.valueOf(value));
            convertedValue = WeightConverter.convert(nValue,fromUnit,toUnit);
            System.out.println(convertedValue);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        return convertedValue;
    }

    public static double areaConversion(double value, String fromUnit, String toUnit){

        double convertedValue = 0;
        try {
            double nValue = Double.parseDouble(String.valueOf(value));
            convertedValue = AreaConverter.convert(nValue,fromUnit,toUnit);
            System.out.println(convertedValue);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        return convertedValue;
    }
    public static double currencyConversion(double value, String fromUnit, String toUnit){

        double convertedValue = 0;
        try {
            double nValue = Double.parseDouble(String.valueOf(value));
            convertedValue = CurrencyConverter.convert(nValue,fromUnit,toUnit);
            System.out.println(convertedValue);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        return convertedValue;
    }
}
