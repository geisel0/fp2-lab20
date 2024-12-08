import java.util.Random;

public class Tablero {
    private final int filas;
    private final int columnas;
    private final Soldado[][] grid;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.grid = new Soldado[filas][columnas];
    }

    public boolean posicionarSoldado(Soldado soldado, int fila, int columna) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas || grid[fila][columna] != null) {
            return false;
        }
        grid[fila][columna] = soldado;
        soldado.setPosicion(fila, columna);
        return true;
    }

    public boolean moverSoldado(int filaActual, int columnaActual, int nuevaFila, int nuevaColumna) {
        if (filaActual < 0 || filaActual >= filas || columnaActual < 0 || columnaActual >= columnas ||
            nuevaFila < 0 || nuevaFila >= filas || nuevaColumna < 0 || nuevaColumna >= columnas ||
            grid[filaActual][columnaActual] == null || grid[nuevaFila][nuevaColumna] != null) {
            return false;
        }
        Soldado soldado = grid[filaActual][columnaActual];
        grid[filaActual][columnaActual] = null;
        grid[nuevaFila][nuevaColumna] = soldado;
        soldado.setPosicion(nuevaFila, nuevaColumna);
        return true;
    }

    public Soldado obtenerSoldado(int fila, int columna) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            return null;
        }
        return grid[fila][columna];
    }

    public void mostrarTablero() {
        System.out.println("Estado del Tablero:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (grid[i][j] == null) {
                    System.out.print("[  ] ");
                } else {
                    System.out.print("[" + grid[i][j].getSimbolo() + "] ");
                }
            }
            System.out.println();
        }
    }

    public boolean posicionarSoldadosAleatoriamente(Ejercito ejercito) {
        Random random = new Random();
        for (Soldado soldado : ejercito.getSoldados()) {
            boolean colocado = false;
            while (!colocado) {
                int fila = random.nextInt(filas);
                int columna = random.nextInt(columnas);
                colocado = posicionarSoldado(soldado, fila, columna);
            }
        }
        return true;
    }
}
