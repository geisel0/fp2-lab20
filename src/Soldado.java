public class Soldado {
    private String nombre;
    private int nivelVida;
    private int nivelAtaque;
    private int nivelDefensa;
    private char simbolo;
    private static int contador=0;

    public Soldado() {
        contador++;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNivelVida(int nivelVida) {
        this.nivelVida = nivelVida;
    }

    public int getNivelVida() {
        return nivelVida;
    }

    public void setNivelAtaque(int nivelAtaque) {
        this.nivelAtaque = nivelAtaque;
    }

    public int getNivelAtaque() {
        return nivelAtaque;
    }

    public void setNivelDefensa(int nivelDefensa) {
        this.nivelDefensa = nivelDefensa;
    }

    public int getNivelDefensa() {
        return nivelDefensa;
    }

    public void atacar(Soldado otroSoldado) {
        int daño = nivelAtaque - otroSoldado.getNivelDefensa();
        if (daño > 0) {
            otroSoldado.setNivelVida(otroSoldado.getNivelVida() - daño);
        }
    }
}
