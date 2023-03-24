package main.models;


import java.util.HashMap;
import java.util.Map;

public class AreaConverter {
    private static Map<String, Double> conversionMap = new HashMap<>();
    static {
        conversionMap.put("mm2", 0.000001d);
        conversionMap.put("cm2", 0.0001d);
        conversionMap.put("m2", 1.0d);
        conversionMap.put("km2", 1000000.0d);
        conversionMap.put("in2", 0.00064516d);
        conversionMap.put("ft2", 0.09290304d);
        conversionMap.put("yd2", 0.83612736d);
        conversionMap.put("mi2", 2589988.110336d);
    }

    public static double convert(double value, String fromUnit, String toUnit) {
        if (!conversionMap.containsKey(fromUnit)) {
            throw new IllegalArgumentException("Invalid unit: " + fromUnit);
        }
        if (!conversionMap.containsKey(toUnit)) {
            throw new IllegalArgumentException("Invalid unit: " + toUnit);
        }
        double fromValue = value * conversionMap.get(fromUnit);
        double toValue = fromValue / conversionMap.get(toUnit);
        return toValue;
    }
}
