package main.models;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class TemperatureConverter {

    private static final Map<String, Function<Double, Double>> conversions = new HashMap<>();
    static {
        // Inicializar el mapa de factores de conversión
        conversions.put("CF", c-> ((9.0 /5.0 )* c) + 32);
        conversions.put("CK", c -> c + 273.15);
        conversions.put("FC", f -> ((5.0 / 9.0) * (f - 32)));
        conversions.put("FK", f -> (5.0 / 9.0) * (f - 32) + 273.15);
        conversions.put("KC", k -> k - 273.15);
        conversions.put("KF", k -> ((9.0 / 5.0) * (k - 273.15) )+ 32);
    }
    public static double convert(double value, String fromScale, String toScale) {
        String key = String.valueOf(fromScale).toUpperCase() + toScale;
        Function<Double, Double> conversionFunction = conversions.get(key);
        if (conversionFunction == null) {
            throw new IllegalArgumentException("Conversion not supported from " + fromScale + " to " + toScale);
        }
        return conversionFunction.apply(value);
    }

}
