package lab02;
import java.util.Scanner;

public class ejercicio03 {

    public static void trianguloRecursivo1(int base) {
        if (base < 1) {
            return;
        }
        trianguloRecursivo1(base - 1);
        for (int i = 0; i < base; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la base del triangulo: ");
        int var = sc.nextInt();
        trianguloRecursivo1(var);
        sc.close();
        
    }
}