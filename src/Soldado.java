import java.util.Random;

public abstract class Soldado implements Comparable<Soldado> {
    protected String nombre;
    protected int nivelVida;
    protected int nivelAtaque;
    protected int nivelDefensa;
    protected int fila;
    protected int columna;
    protected static int contador = 0;

    public Soldado(int vidaMin, int vidaMax) {
        Random random = new Random();
        this.nivelVida = random.nextInt(vidaMax - vidaMin + 1) + vidaMin;
        this.fila = random.nextInt(10);
        this.columna = random.nextInt(10);
        contador++;
    }

    public abstract void accionEspecial();

    public String getNombre() {
        return nombre;
    }

    public int getNivelVida() {
        return nivelVida;
    }

    public int getNivelAtaque() {
        return nivelAtaque;
    }

    public int getNivelDefensa() {
        return nivelDefensa;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    @Override
    public int compareTo(Soldado o) {
        return o.nivelVida - this.nivelVida;
    }
}