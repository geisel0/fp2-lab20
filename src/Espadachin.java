public class Espadachin extends Soldado {
    private int longitudEspada;

    public Espadachin() {
        super(3, 4);
        this.longitudEspada = new Random().nextInt(50) + 50;
        this.nombre = "Espadachin" + contador;
    }

    @Override
    public void accionEspecial() {
        this.nivelDefensa += 1;
    }
}

// Clase Arquero
public class Arquero extends Soldado {
    private int flechas;

    public Arquero() {
        super(1, 3);
        this.flechas = 10;
        this.nombre = "Arquero" + contador;
    }

    public void dispararFlecha() {
        if (flechas > 0) flechas--;
    }

    @Override
    public void accionEspecial() {
        this.dispararFlecha();
    }
}