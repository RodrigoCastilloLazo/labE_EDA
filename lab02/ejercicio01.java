package lab02;

import java.util.Scanner;

public class ejercicio01 {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el tamaño del vector (N): ");
        int N = scanner.nextInt();
        
        int[] A = new int[N];
        
        System.out.println("Ingrese los " + N + " elementos del vector:");
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        
        System.out.print("\nVector original: [");
        for (int i = 0; i < N; i++) {
            System.out.print(A[i]);
            if (i < N - 1) System.out.print(" ");
        }
        System.out.println("]");
        
        int[] invertido = invertirArray(A);
        
        System.out.print("Vector invertido: [");
        for (int i = 0; i < invertido.length; i++) {
            System.out.print(invertido[i]);
            if (i < invertido.length - 1) System.out.print(" ");
        }
        System.out.println("]");       
        scanner.close();
    }
    public static int[] invertirArray(int[] A) {
        if (A.length <= 1) {
            return A.clone(); 
        }        
        int[] invertido = new int[A.length];
        invertido[0] = A[A.length - 1];
        int[] subArray = new int[A.length - 1];
        System.arraycopy(A, 0, subArray, 0, A.length - 1);
        int[] subArrayInvertido = invertirArray(subArray);
        System.arraycopy(subArrayInvertido, 0, invertido, 1, subArrayInvertido.length);
        return invertido;
    }
}