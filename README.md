# 🎮 Guía de Usuario: Tres en Raya Supremo (Java)

Bienvenido al clásico juego de **Tres en Raya** desarrollado en Java, mi Nombre es Raúl Heredia. Esta guía te explicará todo lo necesario para ejecutar, entender y jugar esta aplicación desde tu computadora.

---

## 🛠️ Requisitos del Sistema

Para poder jugar a este juego en tu computadora, necesitas cumplir con los siguientes requisitos mínimos:

1. **Java Development Kit (JDK):** Necesitas tener instalado Java en tu sistema (versión 8 o superior es suficiente, aunque funciona perfectamente con Java 11, 17 o 21).
   - Puedes verificar si tienes Java instalado abriendo tu terminal o consola y escribiendo:
     ```bash
     java -version
     ```
2. **Entorno de Ejecución:**
   - Puedes usar cualquier IDE como **IntelliJ IDEA**, **Eclipse** o **Visual Studio Code** (con la extensión de Java).
   - O simplemente usar la **Terminal / Línea de comandos** de tu sistema operativo (Linux, Windows o macOS).

---

## 🚀 Cómo compilar y ejecutar el juego (Desde Terminal)

Si no estás usando un IDE con un botón de "Play", puedes correr el juego manualmente desde tu terminal siguiendo estos pasos:

1. **Abre tu terminal** y navega hasta la carpeta donde guardaste los archivos del juego (`Main.java`, `Tablero.java` y `Jugador.java`).
2. **Compila los archivos Java:**
   ```bash
   javac *.java
   ```
   *(Esto generará los archivos `.class` que la computadora puede entender).*
3. **Ejecuta el juego:**
   ```bash
   java Main
   ```

---

## 🕹️ Cómo Jugar

Una vez que el juego se inicie en la consola, verás el título **"=== TRES EN RAYA SUPREMO ==="** y aparecerá el tablero vacío.

### 1. El Tablero
El tablero es una cuadrícula de 3x3. Las filas y columnas están numeradas del **0 al 2**:

```text
  0 1 2
0 - - - 
1 - - - 
2 - - - 
```

### 2. Los Turnos
- El juego es para **dos jugadores locales** en la misma computadora.
- El **Jugador 1** siempre usa la letra `X`.
- El **Jugador 2** siempre usa la letra `O`.

### 3. Ingresar tu jugada
Cuando sea tu turno, el juego te pedirá ingresar la **Fila** y luego la **Columna** en la que deseas colocar tu ficha. Solo puedes ingresar números enteros del `0` al `2`.

**Ejemplo de jugada exitosa:**
```text
Turno de Jugador 1 (X)
Ingresa fila (0-2): 1
Ingresa columna (0-2): 1
```
*(Esto colocará una 'X' exactamente en el centro del tablero).*

### 4. Reglas y Validaciones
- **Ganar:** El primer jugador que logre alinear 3 de sus fichas (horizontal, vertical o diagonalmente) gana la partida.
- **Empate:** Si las 9 casillas se llenan y nadie ha logrado hacer tres en raya, el juego declarará un empate.
- **Movimientos Inválidos:**
  - Si intentas poner una ficha en una celda que ya está ocupada, el juego te dirá que es inválido y te dejará intentar de nuevo.
  - Si ingresas un número fuera de rango (ej. `5`) o una letra (ej. `A`), el juego detectará el error (`InputMismatchException`), no se cerrará de golpe, y te pedirá amablemente que ingreses únicamente números enteros válidos.

---

## 🧠 ¿Cómo funciona internamente?

El juego está diseñado bajo el paradigma de **Programación Orientada a Objetos** separando responsabilidades:
- **`Jugador`:** Simplemente almacena la información de quién está jugando (su nombre y si es X u O).
- **`Tablero`:** Es el "cerebro" gráfico y lógico. Se encarga de dibujar el tablero en la consola, guardar dónde están las fichas, y revisar constantemente si alguien ya ganó o si el tablero se llenó.
- **`Main`:** Es el "árbitro". Controla el flujo de los turnos, maneja la entrada del teclado a través de `Scanner`, y mantiene el juego en un bucle (`while`) hasta que alguien gane o haya un empate.
