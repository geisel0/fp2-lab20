public class Arquero extends Soldado {
    private int flechasDisponibles;
    private static int contador;


    public Arquero() {
        super();
        setNombre("Arquero" + contador);
        setNivelAtaque(4);
        setNivelDefensa(1);
        flechasDisponibles = 10; // Número inicial de flechas
    }

    public void disparar(Soldado objetivo) {
        if (flechasDisponibles > 0) {
            System.out.println(getNombre() + " dispara una flecha.");
            flechasDisponibles--;
            atacar(objetivo);
        } else {
            System.out.println(getNombre() + " se ha quedado sin flechas.");
        }
    }

    public int getFlechasDisponibles() {
        return flechasDisponibles;
    }

    public void setFlechasDisponibles(int flechasDisponibles) {
        this.flechasDisponibles = flechasDisponibles;
    }
}
