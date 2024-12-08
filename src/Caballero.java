public class Caballero extends Soldado {
    private String armaActual; // "espada" o "lanza"
    private boolean montado;
    private static int contador;

    public Caballero() {
        super();
        setNombre("Caballero" + contador);
        setNivelAtaque(5);
        setNivelDefensa(3);
        armaActual = "lanza";
        montado = true; // Inicia montado por defecto
    }

    public void montar() {
        if (!montado) {
            montado = true;
            armaActual = "lanza";
            System.out.println(getNombre() + " monta y cambia a lanza.");
        } else {
            System.out.println(getNombre() + " ya está montado.");
        }
    }

    public void desmontar() {
        if (montado) {
            montado = false;
            armaActual = "espada";
            System.out.println(getNombre() + " desmonta y cambia a espada.");
        } else {
            System.out.println(getNombre() + " ya está desmontado.");
        }
    }

    public void envestir(Soldado objetivo) {
        System.out.println(getNombre() + " realiza una envestida.");
        int ataques = montado ? 3 : 2;
        for (int i = 0; i < ataques; i++) {
            atacar(objetivo);
        }
    }

    public String getArmaActual() {
        return armaActual;
    }

    public boolean isMontado() {
        return montado;
    }
}
