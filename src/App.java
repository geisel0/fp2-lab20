import java.util.Random;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero();
        Ejercito ejercito1 = new Ejercito("Rojo");
        Ejercito ejercito2 = new Ejercito("Azul");

        generarEjercito(tablero, ejercito1, 'R');
        generarEjercito(tablero, ejercito2, 'B');

        boolean juegoActivo = true;
        while (juegoActivo) {
            System.out.println("Estado del tablero:");
            tablero.mostrarTablero();

            System.out.println("Turno del jugador 1 (Ejército Rojo).");
            turnoJugador(tablero, scanner, ejercito1);

            if (ejercito2.getSoldados().isEmpty()) {
                System.out.println("¡El jugador 1 (Ejército Rojo) ganó!");
                break;
            }

            System.out.println("Turno del jugador 2 (Ejército Azul).");
            turnoJugador(tablero, scanner, ejercito2);

            if (ejercito1.getSoldados().isEmpty()) {
                System.out.println("¡El jugador 2 (Ejército Azul) ganó!");
                break;
            }
        }
    }

    public static void generarEjercito(Tablero tablero, Ejercito ejercito, char simbolo) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int fila = random.nextInt(10);
            int columna = random.nextInt(10);

            while (tablero.posicionOcupada(fila, columna)) {
                fila = random.nextInt(10);
                columna = random.nextInt(10);
            }

            Soldado soldado;
            int tipoSoldado = random.nextInt(3);
            if (tipoSoldado == 0) {
                soldado = new Espadachin();
            } else if (tipoSoldado == 1) {
                soldado = new Arquero();
            } else {
                soldado = new Caballero();
            }

            soldado.setSimbolo(simbolo);
            tablero.colocarSoldado(soldado, fila, columna);
        }
    }

    public static void turnoJugador(Tablero tablero, Scanner scanner, Ejercito ejercito) {
        System.out.println("Ingrese fila y columna del soldado a mover:");
        int filaInicial = scanner.nextInt();
        int columnaInicial = scanner.nextInt();

        System.out.println("Ingrese dirección de movimiento (arriba/abajo/izquierda/derecha):");
        String direccion = scanner.next();

        int filaDestino = filaInicial;
        int columnaDestino = columnaInicial;

        if (direccion.equals("arriba")) filaDestino--;
        else if (direccion.equals("abajo")) filaDestino++;
        else if (direccion.equals("izquierda")) columnaDestino--;
        else if (direccion.equals("derecha")) columnaDestino++;

        tablero.moverSoldado(filaInicial, columnaInicial, filaDestino, columnaDestino);
    }
}
