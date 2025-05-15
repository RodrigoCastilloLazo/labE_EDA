package lab02;
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
        System.out.println("Triángulo recursivo con base 5:");
        trianguloRecursivo1(5);
        
    }
}