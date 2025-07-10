package lab09;

import java.util.Scanner;

public class testHashClosed {
  public static void main(String[] args) {
    HashClosed<String> hash = new HashClosed<>(10);
    Scanner sc = new Scanner(System.in);
    int opcion;
    do {
      System.out.println("\n--- Menú Hash Cerrado ---");
      System.out.println("1. Insertar");
      System.out.println("2. Buscar");
      System.out.println("3. Eliminar");
      System.out.println("4. Mostrar tabla");
      System.out.println("0. Salir");
      System.out.print("Seleccione: ");
      opcion = sc.nextInt();

      switch (opcion) {
        case 1:
          System.out.print("Clave: ");
          int key = sc.nextInt();
          sc.nextLine();
          System.out.print("Valor: ");
          String value = sc.nextLine();
          hash.insert(new Register<>(key, value));
          break;
        case 2:
          System.out.print("Clave a buscar: ");
          int keyB = sc.nextInt();
          Register<String> found = hash.search(keyB);
          if (found != null)
            System.out.println("Encontrado: " + found);
          else
            System.out.println("No encontrado.");
          break;
        case 3:
          System.out.print("Clave a eliminar: ");
          int keyD = sc.nextInt();
          hash.delete(keyD);
          break;
        case 4:
          hash.showTable();
          break;
        case 0:
          System.out.println("Saliendo...");
          break;
      }
    } while (opcion != 0);
    sc.close();
  }
}
