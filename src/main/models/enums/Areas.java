package main.models.enums;

public enum Areas {
    mm2("Milimetros cadrados"),
    cm2("Centimetros cuadrados"),
    m2("Metros cuadrados"),
    km2("Kilometros cuadrados"),
    in2("Pulgadas cuadradas"),
    ft2("Pies cuadrados"),
    yd2("Yardas cuadradas"),
    mi2("Millas cuadradas");

    private String nombre;
    private Areas(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }
}
