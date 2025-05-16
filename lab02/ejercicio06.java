package lab02;

import java.util.Scanner;

public class ejercicio06 {

    public static void cuadradoRecursivo(int base) {
        cuadradoRecursivo(base, 0, 0);
    }
    public static void cuadradoRecursivo(int base, int fila, int columna) {
        if (fila >= base) return;
        if (columna >= base) {
            System.out.println();
            cuadradoRecursivo(base, fila + 1, 0);
            return;
        }
        boolean esBorde = fila == 0 || fila == base - 1 || 
                         columna == 0 || columna == base - 1;        
        System.out.print(esBorde ? "*" : " ");
        
        cuadradoRecursivo(base, fila, columna + 1);
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese los lados del cuadrado: ");
        int var = sc.nextInt();
        cuadradoRecursivo(var);
        sc.close();        
    }
}