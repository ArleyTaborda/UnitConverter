package main.models.enums;

public enum Pesos {
    gr("Gramos"),
    lb("Libras"),
    kl("Kilos"),
    oz("Onzas"),
    tn("Toneladas");

    private String nombre;
    private Pesos(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }
}
