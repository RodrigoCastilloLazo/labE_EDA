package lab02;
import java.util.Scanner;

public class ejercicio05 {

    public static void trianguloRecursivo3(int base) {
        trianguloRecursivo3(base, base);
    }
    
    private static void trianguloRecursivo3(int original, int actual) {
        if (actual < 1) return;
        trianguloRecursivo3(original, actual - 1);
        for (int i = 0; i < (int)(original - actual); i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < actual; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la base del triangulo: ");
        int var = sc.nextInt();
        trianguloRecursivo3(var);
        sc.close();        
    }
}