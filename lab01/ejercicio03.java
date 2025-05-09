package lab01;

public class ejercicio03 {
  public static void main(String[] args) {
      int[] arreglo = {12, 11, 13, 5, 6};
      
      System.out.println("Arreglo original:");
      imprimirArreglo(arreglo);
      
      ordenarPorInsercion(arreglo);
      
      System.out.println("\nArreglo ordenado:");
      imprimirArreglo(arreglo);
  }
  
  public static void ordenarPorInsercion(int[] arreglo) {
      int n = arreglo.length;
      
      for (int i = 1; i < n; i++) {
          int clave = arreglo[i];
          int j = i - 1;
          while (j >= 0 && arreglo[j] > clave) {
              arreglo[j + 1] = arreglo[j];
              j--;
          }
          arreglo[j + 1] = clave;
          System.out.println("\nPaso " + i + ":");
          imprimirArreglo(arreglo);
      }
  }
  
  public static void imprimirArreglo(int[] arreglo) {
      for (int num : arreglo) {
          System.out.print(num + " ");
      }
      System.out.println();
  }
}