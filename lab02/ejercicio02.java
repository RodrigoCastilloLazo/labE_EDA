package lab02;
import java.util.Scanner;

public class ejercicio02 {

    public static int[] rotarIzquierdaArray(int[] A) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de posiciones a rotar (d): ");
        int d = scanner.nextInt();
        scanner.close();
        
        d = d % A.length;
        if (d == 0) {
            return A.clone();
        }
        return rotarRecursivo(A.clone(), d);
    }

    public static int[] rotarRecursivo(int[] arr, int rotaciones) {
        if (rotaciones == 0) {
            return arr;
        }
        int primerElemento = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = primerElemento;
        return rotarRecursivo(arr, rotaciones - 1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del arreglo (N): ");
        int N = scanner.nextInt();
        int[] A = new int[N];
        
        System.out.println("Ingrese los " + N + " elementos del arreglo:");
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        
        System.out.print("\nArreglo original: [");
        for (int i = 0; i < N; i++) {
            System.out.print(A[i]);
            if (i < N - 1) System.out.print(" ");
        }
        System.out.println("]");
        int[] rotado = rotarIzquierdaArray(A);
        System.out.print("Arreglo rotado: [");
        for (int i = 0; i < rotado.length; i++) {
            System.out.print(rotado[i]);
            if (i < rotado.length - 1) System.out.print(" ");
        }
        System.out.println("]");
        scanner.close();
    }
}