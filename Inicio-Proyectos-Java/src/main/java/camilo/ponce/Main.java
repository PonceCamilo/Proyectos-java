package camilo.ponce;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Creamos el objeto scanner para leer la entrada de la consola
    Scanner scanner = new Scanner(System.in);
    String continuar;

    do {
      System.out.println("por favor introduce 2 numeros");

      System.out.print("Introduce el primer número (a): ");
      double a = Integer.parseInt(scanner.nextLine());

      System.out.print("Introduce el segundo número (b): ");
      double b = Integer.parseInt(scanner.nextLine());

      System.out.println("por favor selecciona el operador: + - * /");

      String operador = scanner.nextLine();

      while (!operador.matches("[+\\-*/]")) {
        System.out.println("Operador no válido. Por favor selecciona +, -, *, o /.");
        operador = scanner.nextLine();
      }

      switch (operador) {
        case "+":
          System.out.println("El resultado es: " + (a + b));
          break;
        case "-":
          System.out.println("El resultado es: " + (a - b));
          break;
        case "*":
          System.out.println("El resultado es: " + (a * b));
          break;
        case "/":
          if (b != 0) {
            System.out.println("El resultado es: " + (a / b));
          } else {
            System.out.println("Error: No se puede dividir por cero.");
          }
          break;
      }

      System.out.println("Desea continuar? (s/n)");

      continuar = scanner.nextLine();

      while (!continuar.equalsIgnoreCase("s") && !continuar.equalsIgnoreCase("n")) {
        System.out.println("Entrada no válida. Por favor ingresa 's' para continuar o 'n' para salir.");
        continuar = scanner.nextLine();
      }

    } while (continuar.equalsIgnoreCase("s"));

    scanner.close(); // Es buena práctica cerrar el scanner al terminar
  }
}