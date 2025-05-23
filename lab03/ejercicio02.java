package lab03;
import java.util.Scanner;

public class ejercicio02{
    private static Scanner scanner = new Scanner(System.in);

    public static <T extends Number> double suma(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static <T extends Number> double resta(T a, T b) {
        return a.doubleValue() - b.doubleValue();
    }

    public static <T extends Number> double producto(T a, T b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static <T extends Number> double division(T a, T b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return a.doubleValue() / b.doubleValue();
    }

    public static <T extends Number> double potencia(T base, T exponente) {
        return Math.pow(base.doubleValue(), exponente.doubleValue());
    }

    public static <T extends Number> double raizCuadrada(T a) {
        return Math.sqrt(a.doubleValue());
    }

    public static <T extends Number> double raizCubica(T a) {
        return Math.cbrt(a.doubleValue());
    }

    private static double obtenerNumero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Entrada erronea");
                scanner.nextLine(); 
            }
        }
    }

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n=== Menu de Operaciones Genericas ===");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Producto");
            System.out.println("4. Division");
            System.out.println("5. Potencia");
            System.out.println("6. Raiz Cuadrada");
            System.out.println("7. Raiz Cúbica");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                if (opcion == 8) {
                    System.out.println("Saliendo del programa...");
                    break;
                }

                if (opcion < 1 || opcion > 8) {
                    System.out.println("Opcion invalida. Intente nuevamente.");
                    continue;
                }

                double resultado = 0;
                double valor1, valor2;

                if (opcion >= 1 && opcion <= 5) {
                    valor1 = obtenerNumero("Ingrese el primer valor: ");
                    valor2 = obtenerNumero("Ingrese el segundo valor: ");

                    Operador<Double> operador = new Operador<>(valor1, valor2);

                    switch (opcion) {
                        case 1:
                            resultado = suma(operador.getValor1(), operador.getValor2());
                            break;
                        case 2:
                            resultado = resta(operador.getValor1(), operador.getValor2());
                            break;
                        case 3:
                            resultado = producto(operador.getValor1(), operador.getValor2());
                            break;
                        case 4:
                            resultado = division(operador.getValor1(), operador.getValor2());
                            break;
                        case 5:
                            resultado = potencia(operador.getValor1(), operador.getValor2());
                            break;
                    }
                } else if (opcion == 6 || opcion == 7) {
                    valor1 = obtenerNumero("Ingrese el valor: ");

                    switch (opcion) {
                        case 6:
                            resultado = raizCuadrada(valor1);
                            break;
                        case 7:
                            resultado = raizCubica(valor1);
                            break;
                    }
                }

                System.out.printf("Resultado: %.4f%n", resultado);

            } catch (ArithmeticException e) {
                System.out.println("Error matematico: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                scanner.nextLine(); 
            }

        } while (true);

        scanner.close();
    }
}