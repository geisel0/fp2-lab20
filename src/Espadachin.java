public class Espadachin extends Soldado {
    private int longitudEspada;
    private static int contador=0;

    public Espadachin() {
        super();
        setNombre("Espadachin" + contador);
        setNivelAtaque(3);
        setNivelDefensa(2);
        longitudEspada = 100; // Longitud en centímetros
    }

    public void muroDeEscudos() {
        System.out.println(getNombre() + " crea un muro de escudos.");
    }

    public int getLongitudEspada() {
        return longitudEspada;
    }

    public void setLongitudEspada(int longitudEspada) {
        this.longitudEspada = longitudEspada;
    }
}
