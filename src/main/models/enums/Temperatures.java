package main.models.enums;

public enum Temperatures {
    C("Celsius"),
    F("Fahrenheit"),
    K("Kelvin");


    private String nombre;
    private Temperatures(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }
}
