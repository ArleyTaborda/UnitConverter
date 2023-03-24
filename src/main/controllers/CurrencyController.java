package main.controllers;

import main.models.*;

import java.util.Arrays;
import java.util.Scanner;

public class CurrencyController {

    public static void convert() {
        Scanner input = new Scanner(System.in);

        System.out.println("Seleccione el tipo de conversión: ");
        System.out.println("1. Monedas");
        System.out.println("2. Distancia");
        System.out.println("3. Temperatura");
        System.out.println("4. Peso");
        System.out.println("5. Area");

        int selection = input.nextInt();

        switch (selection){
            case 1:
                currencyConversion();
                break;
            case 2:
                distanceConversion();
                break;
            case 3:
                temperatureConversion();
                break;
            case 4:
                weightConversion();
                break;
            case 5:
                areaConversion();
                break;
            default:
                System.out.println("Por favor selecciona un tipo de conversión.");
        }
    }

    public static void distanceConversion(){
        Scanner input = new Scanner(System.in);

        String[] units = {"Milimetros: km", "Centrimetros: cm", "Metros: m", "Kilometros: km", "Pulgadas: in", "Pies: ft", "Yardas: yd", "Millas: mi"};

        System.out.println("Por favor selecciona la unidad de medida: ");
        System.out.println(Arrays.toString(units));
        String fromUnit = input.nextLine().toString();

        System.out.println("Por favor selecciona la unidad de medida destino: ");
        System.out.println(Arrays.toString(units));
        String toUnit = input.nextLine().toString();

        System.out.println("Por favor ingrese el valor a convertir: ");
        double value = input.nextDouble();

        try {
            double nValue = Double.parseDouble(String.valueOf(value));
            double convertedValue = DistanceConverter.convert(nValue,fromUnit,toUnit);
            System.out.println(convertedValue);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }

    public static void temperatureConversion(){
        Scanner input = new Scanner(System.in);

        String[] units = {"Celsius: c", "Fahrenheit: f", "Kelvin: k"};

        System.out.println("Por favor selecciona la unidad de medida: ");
        System.out.println(Arrays.toString(units));
        String fromUnit = input.nextLine().toUpperCase();

        System.out.println("Por favor selecciona la unidad de medida destino: ");
        System.out.println(Arrays.toString(units));
        String toUnit = input.nextLine().toUpperCase();

        System.out.println("Por favor ingrese el valor a convertir: ");
        double value = input.nextDouble();

        try {
            double nValue = Double.parseDouble(String.valueOf(value));
            double convertedValue = TemperatureConverter.convert(nValue,fromUnit,toUnit);
            System.out.println(convertedValue);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

    }

    public static void weightConversion(){
        Scanner input = new Scanner(System.in);

        String[] units = {"Gramos: gr","Libras: lb", "Kilos: k", "Onzas: oz", "Toneladas: tn"};

        System.out.println("Por favor selecciona la unidad de medida: ");
        System.out.println(Arrays.toString(units));
        String fromUnit = input.nextLine().toLowerCase();

        System.out.println("Por favor selecciona la unidad de medida destino: ");
        System.out.println(Arrays.toString(units));
        String toUnit = input.nextLine().toLowerCase();

        System.out.println("Por favor ingrese el valor a convertir: ");
        double value = input.nextDouble();

        try {
            double nValue = Double.parseDouble(String.valueOf(value));
            double convertedValue = WeightConverter.convert(nValue,fromUnit,toUnit);
            System.out.println(convertedValue);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }

    public static void areaConversion(){
        Scanner input = new Scanner(System.in);

        String[] units = {"Milimetros Cadrados: mm2","Centimetros Cuadrados: cm2","Metros Cuadrados: m2","Kilometros Cuadraros: km2", "Pulgadas Cuadradas: in2", "Pies Cuadrados: ft2", "Yardas Cuadradas: yd2", "Millas cuadradas: mi2"};

        System.out.println("Por favor selecciona la unidad de medida: ");
        System.out.println(Arrays.toString(units));
        String fromUnit = input.nextLine().toLowerCase();

        System.out.println("Por favor selecciona la unidad de medida destino: ");
        System.out.println(Arrays.toString(units));
        String toUnit = input.nextLine().toLowerCase();

        System.out.println("Por favor ingrese el valor a convertir: ");
        double value = input.nextDouble();
        input.nextLine();

        try {
            double nValue = Double.parseDouble(String.valueOf(value));
            double convertedValue = AreaConverter.convert(nValue,fromUnit,toUnit);
            System.out.println(convertedValue);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }

    public static void currencyConversion(){
        Scanner input = new Scanner(System.in);

        String[] units = {"Dolar: USD","Peso Colombiano: COP ","Dolar Canadience: CAD","Won Sur Coreano: KRW", "Libras Esterlinas: GBP", "Yen Japones: YEN", "Real Brasileño: BRL", "Peso Argentino: ARS"};

        System.out.println("Por favor selecciona la unidad de medida: ");
        System.out.println(Arrays.toString(units));
        String fromUnit = input.nextLine().toUpperCase();

        System.out.println("Por favor selecciona la unidad de medida destino: ");
        System.out.println(Arrays.toString(units));
        String toUnit = input.nextLine().toUpperCase();

        System.out.println("Por favor ingrese el valor a convertir: ");
        double value = input.nextDouble();
        input.nextLine();

        try {
            double nValue = Double.parseDouble(String.valueOf(value));
            double convertedValue = CurrencyConverter.convert(nValue,fromUnit,toUnit);
            System.out.println(convertedValue);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }
}
