package lab04;
import java.util.Scanner;

public class ejercicio07 {
    public static void main(String[] args) {
        CircularLinkedList_v3<Integer> list = new CircularLinkedList_v3<>();
        Scanner scanner = new Scanner(System.in);
        int choice, value, position;
        
        for (int i = 1; i <= 12; i++) {
            list.insert(i);
        }

        do {
            System.out.println("\n--- MENU DE LISTA CIRCULAR ---");
            System.out.println("1. Insertar al final");
            System.out.println("2. Insertar en posicion");
            System.out.println("3. Eliminar por valor");
            System.out.println("4. Eliminar en posicion");
            System.out.println("5. Eliminar primer elemento");
            System.out.println("6. Eliminar ultimo elemento");
            System.out.println("7. Agregar al inicio");
            System.out.println("8. Agregar al final");
            System.out.println("9. Mostrar tamano");
            System.out.println("10. Imprimir lista");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Valor: ");
                    value = scanner.nextInt();
                    list.insert(value);
                    break;
                    
                case 2:
                    System.out.print("Valor: ");
                    value = scanner.nextInt();
                    System.out.print("Posicion: ");
                    position = scanner.nextInt();
                    list.insert(value, position);
                    break;
                    
                case 3:
                    System.out.print("Valor a eliminar: ");
                    value = scanner.nextInt();
                    list.deleteByKey(value);
                    break;
                    
                case 4:
                    System.out.print("Posicion: ");
                    position = scanner.nextInt();
                    list.deleteAtPosition(position);
                    break;
                    
                case 5:
                    list.removeFirst();
                    System.out.println("Primer elemento eliminado");
                    break;
                    
                case 6:
                    list.removeLast();
                    System.out.println("Ultimo elemento eliminado");
                    break;
                    
                case 7:
                    System.out.print("Valor: ");
                    value = scanner.nextInt();
                    list.addFirst(value);
                    break;
                    
                case 8:
                    System.out.print("Valor: ");
                    value = scanner.nextInt();
                    list.addLast(value);
                    break;
                    
                case 9:
                    System.out.println("Tamano: " + list.size());
                    break;
                    
                case 10:
                    list.printList();
                    break;
                    
                case 0:
                    System.out.println("Saliendo...");
                    break;
                    
                default:
                    System.out.println("Opcion invalida");
            }
            
        } while (choice != 0);
        
        scanner.close();
    }
}
