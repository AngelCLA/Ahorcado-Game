package ahorcadogame;

import java.util.Scanner;

public class AhorcadoGame {
    
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Declaraciones
        String palabraSecreta = "cinco";
        int intentosMaximos = 6;
        int intentos = 0;
        boolean palabraAdivinada = false;
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        // Inicializar letras adivinadas con '-'
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '-';
        }

        // Mensaje de bienvenida
        System.out.println("════════════════════════════════════");
        System.out.println("       ¡Bienvenido al Juego del Ahorcado!");
        System.out.println("════════════════════════════════════");

        // Bucle principal del juego
        while (!palabraAdivinada && intentos < intentosMaximos) {
            System.out.println("Contiene: " + palabraSecreta.length() + " letras" + " | Intentos restantes: " + (intentosMaximos - intentos));
            System.out.println("\nPalabra a adivinar: " + String.valueOf(letrasAdivinadas));

            System.out.println("────────────────────────────────────");

            // Pedir letra al usuario
            System.out.print("Introduce una letra: ");
            char letra = Character.toLowerCase(sc.next().charAt(0));

            // Verificar si la letra ya fue ingresada
            boolean letraYaIngresada = false;
            for (char c : letrasAdivinadas) {
                if (c == letra) {
                    letraYaIngresada = true;
                    break;
                }
            }

            if (letraYaIngresada) {
                intentos++;
                System.out.println("¡La letra '" + letra + "' ya fue ingresada! Intentos restantes: "
                        + (intentosMaximos - intentos));
                continue;
            }

            // Verificar si la letra es correcta
            boolean letraCorrecta = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            // Mensaje según si la letra es correcta o no
            if (!letraCorrecta) {
                intentos++;
                System.err.println("¡Incorrecto!");
            } else {
                System.out.println(ANSI_GREEN + "¡Correcto!" + ANSI_RESET);
            }
            System.out.println("────────────────────────────────────");

            // Verificar si se ha adivinado la palabra
            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("\n¡Felicidades! Has adivinado la palabra secreta: " + palabraSecreta);
            }

        }

        // Mensaje final
        if (!palabraAdivinada) {
            System.out.println("\nTe has quedado sin intentos. GAME OVER ");
        }

        sc.close();
    }
}
