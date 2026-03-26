public class Tablero {
    private char[][] matriz;

    public Tablero() {
        matriz = new char[3][3];
        inicializar();
    }

    public void inicializar() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = '-';
            }
        }
    }

    public void imprimirTablero() {
        System.out.println("\n  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean colocarFicha(int fila, int columna, char simbolo) {
        if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && matriz[fila][columna] == '-') {
            matriz[fila][columna] = simbolo;
            return true;
        }
        return false;
    }

    public boolean hayGanador(char s) {
        // Validar filas y columnas
        for (int i = 0; i < 3; i++) {
            if ((matriz[i][0] == s && matriz[i][1] == s && matriz[i][2] == s) ||
                (matriz[0][i] == s && matriz[1][i] == s && matriz[2][i] == s)) {
                return true;
            }
        }
        // Validar diagonales
        if ((matriz[0][0] == s && matriz[1][1] == s && matriz[2][2] == s) ||
            (matriz[0][2] == s && matriz[1][1] == s && matriz[2][0] == s)) {
            return true;
        }
        return false;
    }

    public boolean estaLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j] == '-') return false;
            }
        }
        return true;
    }
}
