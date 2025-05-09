package lab01;

import java.util.Scanner;

public class ejercicio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el límite superior: ");
        int n = scanner.nextInt();
        
        if (n < 2) {
            System.out.println("No hay números primos en el rango especificado.");
        }
        
        boolean[] esPrimo = cribaEratostenes(n);
        
        System.out.println("Números primos hasta " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (esPrimo[i]) {
                System.out.print(i + " ");
            }
        }
        
        scanner.close();
    }
    
    public static boolean[] cribaEratostenes(int n) {
        boolean[] esPrimo = new boolean[n + 1];        
        for (int i = 2; i <= n; i++) {
            esPrimo[i] = true;
        }
        for (int p = 2; p * p <= n; p++) {
            if (esPrimo[p]) {
                for (int i = p * p; i <= n; i += p) {
                    esPrimo[i] = false;
                }
            }
        }
        return esPrimo;
    }
}