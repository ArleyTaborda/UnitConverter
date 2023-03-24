package main.models;

import java.util.HashMap;
import java.util.Map;
public class WeightConverter {
    private static Map<String, Double> conversionMap = new HashMap<>();
    static{
        conversionMap.put("gr", 0.001);
        conversionMap.put("lb", 0.4539237);
        conversionMap.put("oz", 0.028349523125);
        conversionMap.put("tn", 1000.0);
        conversionMap.put("kl", 1.0);
    }

    public static double convert(double value, String fromUnit, String toUnit){

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
