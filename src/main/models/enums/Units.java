package main.models.enums;

public enum Units {
    USD("Dólar estadunidense"),
    EUR("Euro"),
    GBP("Libra esterlina"),
    COP("Peso colombiano"),
    KRW("Won sur coreano"),
    YEN("Yen japonés"),
    BRL("Real brasileño"),
    ARS("Peso argentino");

    private String nombre;
    private Units(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }
}
