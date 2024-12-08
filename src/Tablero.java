import java.util.Random;

public class Tablero {
    private final int filas = 10;
    private final int columnas = 10;
    private Soldado[][] tablero = new Soldado[filas][columnas];
    private Random random = new Random();

    public boolean posicionValida(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    public boolean posicionOcupada(int fila, int columna) {
        return tablero[fila][columna] != null;
    }

    public void colocarSoldado(Soldado soldado, int fila, int columna) {
        if (posicionValida(fila, columna) && !posicionOcupada(fila, columna)) {
            tablero[fila][columna] = soldado;
            soldado.setNivelVida(random.nextInt(3) + 3); // Asignar vida aleatoria
        }
    }

    public void moverSoldado(int filaInicial, int columnaInicial, int filaDestino, int columnaDestino) {
        if (!posicionValida(filaInicial, columnaInicial) || !posicionValida(filaDestino, columnaDestino)) {
            System.out.println("Movimiento inválido. Fuera de los límites.");
            return;
        }

        Soldado soldado = tablero[filaInicial][columnaInicial];
        if (soldado == null) {
            System.out.println("No hay soldado en la posición inicial.");
            return;
        }

        if (posicionOcupada(filaDestino, columnaDestino)) {
            Soldado oponente = tablero[filaDestino][columnaDestino];
            realizarBatalla(soldado, oponente);
        } else {
            tablero[filaDestino][columnaDestino] = soldado;
            tablero[filaInicial][columnaInicial] = null;
        }
    }

    public void realizarBatalla(Soldado s1, Soldado s2) {
        double totalVida = s1.getNivelVida() + s2.getNivelVida();
        double probabilidadS1 = s1.getNivelVida() / totalVida;

        if (Math.random() < probabilidadS1) {
            System.out.println(s1.getNombre() + " ganó la batalla contra " + s2.getNombre());
            s1.setNivelVida(s1.getNivelVida() + 1);
        } else {
            System.out.println(s2.getNombre() + " ganó la batalla contra " + s1.getNombre());
            s2.setNivelVida(s2.getNivelVida() + 1);
        }
    }

    public void mostrarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j] != null) {
                    System.out.print(tablero[i][j].getSimbolo() + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}

