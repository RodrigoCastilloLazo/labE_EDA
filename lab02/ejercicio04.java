package lab02;
import java.util.Scanner;

public class ejercicio04 {

    public static void trianguloRecursivo2(int base) {
        trianguloRecursivo2(base, base);
    }
    
    private static void trianguloRecursivo2(int original, int actual) {
        if (actual < 1) return;
        trianguloRecursivo2(original, actual - 1);
        for (int i = 0; i < (int)(original - actual); i++) {
            System.out.print("  ");
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
        trianguloRecursivo2(var);
        sc.close();        
    }
}