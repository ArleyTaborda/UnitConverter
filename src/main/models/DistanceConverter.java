package main.models;

import java.util.HashMap;
import java.util.Map;
public class DistanceConverter {
    private static Map<String, Double> conversionMap = new HashMap<>();
    static{
        conversionMap.put("mm", 0.001);
        conversionMap.put("cm", 0.01);
        conversionMap.put("m", 1.0);
        conversionMap.put("km", 1000.0);
        conversionMap.put("in", 0.0254);
        conversionMap.put("ft", 0.3048);
        conversionMap.put("yd", 0.9144);
        conversionMap.put("mi", 1609.344);
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
