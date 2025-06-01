package lab04;
import java.util.Scanner;

public class ejercicio06 {
    public static void main(String[] args) {
        DoubleLinkedList_v2<Integer> list = new DoubleLinkedList_v2<>();
        Scanner scanner = new Scanner(System.in);
        int choice, value, position;
        
        for (int i = 1; i <= 10; i++) {
            list.insert(i);
        }

        do {
            System.out.println("\n--- MENu LISTA DOBLEMENTE ENLAZADA ---");
            System.out.println("1. Insertar elemento al final");
            System.out.println("2. Insertar elemento en posicion");
            System.out.println("3. Eliminar por valor");
            System.out.println("4. Eliminar por posicion");
            System.out.println("5. Eliminar primer elemento");
            System.out.println("6. Eliminar ultimo elemento");
            System.out.println("7. Agregar al inicio");
            System.out.println("8. Agregar al final");
            System.out.println("9. Mostrar tamaño");
            System.out.println("10. Imprimir lista");
            System.out.println("0. Salir");
            System.out.print("Seleccione opcion: ");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Valor a insertar: ");
                    value = scanner.nextInt();
                    list.insert(value);
                    break;
                    
                case 2:
                    System.out.print("Valor a insertar: ");
                    value = scanner.nextInt();
                    System.out.print("Posicin: ");
                    position = scanner.nextInt();
                    list.insert(value, position);
                    break;
                    
                case 3:
                    System.out.print("Valor a eliminar: ");
                    value = scanner.nextInt();
                    list.deleteByKey(value);
                    break;
                    
                case 4:
                    System.out.print("Posición a eliminar: ");
                    position = scanner.nextInt();
                    list.deleteAtPosition(position);
                    break;
                    
                case 5:
                    list.removeFirst();
                    System.out.println("Primer elemento eliminado");
                    break;
                    
                case 6:
                    list.removeLast();
                    System.out.println("ultimo elemento eliminado");
                    break;
                    
                case 7:
                    System.out.print("Valor a agregar al inicio: ");
                    value = scanner.nextInt();
                    list.addFirst(value);
                    break;
                    
                case 8:
                    System.out.print("Valor a agregar al final: ");
                    value = scanner.nextInt();
                    list.addLast(value);
                    break;
                    
                case 9:
                    System.out.println("Tamaño de la lista: " + list.size());
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