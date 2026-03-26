import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero();
        Jugador j1 = new Jugador("Jugador 1", 'X');
        Jugador j2 = new Jugador("Jugador 2", 'O');
        Jugador turnoActual = j1;

        boolean juegoTerminado = false;

        System.out.println("=== TRES EN RAYA SUPREMO ===");

        while (!juegoTerminado) {
            tablero.imprimirTablero();
            System.out.println("Turno de " + turnoActual.getNombre() + " (" + turnoActual.getSimbolo() + ")");
            
            int fila = -1, columna = -1;
            boolean jugadaValida = false;

            // Bucle para forzar una entrada válida
            while (!jugadaValida) {
                try {
                    System.out.print("Ingresa fila (0-2): ");
                    fila = scanner.nextInt();
                    System.out.print("Ingresa columna (0-2): ");
                    columna = scanner.nextInt();

                    if (tablero.colocarFicha(fila, columna, turnoActual.getSimbolo())) {
                        jugadaValida = true;
                    } else {
                        System.out.println("[!] Movimiento inválido. Celda ocupada o fuera de rango. Intenta de nuevo.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("[!] ERROR: Ingresa solo números enteros.");
                    scanner.next(); // Limpiar el buffer del scanner
                }
            }

            if (tablero.hayGanador(turnoActual.getSimbolo())) {
                tablero.imprimirTablero();
                System.out.println("¡¡¡" + turnoActual.getNombre() + " HA GANADO LA PARTIDA!!!");
                juegoTerminado = true;
            } else if (tablero.estaLleno()) {
                tablero.imprimirTablero();
                System.out.println("¡Es un EMPATE! El tablero está lleno.");
                juegoTerminado = true;
            } else {
                // Cambiar de turno
                turnoActual = (turnoActual == j1) ? j2 : j1;
            }
        }
        scanner.close();
    }
}
