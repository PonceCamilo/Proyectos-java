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
      double a = Double.parseDouble(scanner.nextLine());

      System.out.print("Introduce el segundo número (b): ");
      double b = Double.parseDouble(scanner.nextLine());

      System.out.println("por favor selecciona el operador: + - * /");

      String operador = scanner.nextLine();

      while (!operador.matches("[+\\-*/]")) {
        System.out.println("Operador no válido. Por favor selecciona +, -, *, o /.");
        operador = scanner.nextLine();
      }

      switch (operador) {
        case "+":
          System.out.printf("El resultado es: %.2f\n", sumar(a, b));
          break;
        case "-":
          System.out.printf("El resultado es: %.2f\n", restar(a, b));
          break;
        case "*":
          System.out.printf("El resultado es: %.2f\n", multiplicar(a, b));
          break;
        case "/":
          System.out.printf("El resultado es: %.2f\n", dividir(a, b));
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

  static double sumar(double a, double b) {
    return a + b;
  }

  static double restar(double a, double b) {
    return a - b;
  }

  static double multiplicar(double a, double b) {
    return a * b;
  }

  static double dividir(double a, double b) {
    if (b != 0) {
      return a / b;
    } else {
      System.out.println("Error: No se puede dividir por cero.");
      return 0;
    }
  }
}