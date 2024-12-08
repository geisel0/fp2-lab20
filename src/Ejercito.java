import java.util.ArrayList;

public class Ejercito {
    private String nombre;
    private ArrayList<Soldado> soldados;
    private char simbolo;

    public Ejercito(String nombre) {
        this.nombre = nombre;
        this.soldados = new ArrayList<>();
    }

    public void agregarSoldado(Soldado soldado) {
        soldados.add(soldado);
    }

    public ArrayList<Soldado> getSoldados() {
        return soldados;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public String getNombre() {
        return nombre;
    }
}
