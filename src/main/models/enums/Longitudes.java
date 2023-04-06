package main.models.enums;

public enum Longitudes {
    mm("Milimetros"),
    cm("Centimetros"),
    m("Metros"),
    km("Kilometros"),
    in("Pulgadas"),
    ft("Pies"),
    yd("Yardas"),
    mi("Millas");
    private String nombre;
    private Longitudes(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }
}
