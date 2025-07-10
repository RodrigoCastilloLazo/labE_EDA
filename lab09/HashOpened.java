package lab09;

import java.util.LinkedList;

public class HashOpened<E> {
  private LinkedList<Register<E>>[] table;

  @SuppressWarnings("unchecked")
public HashOpened(int capacity) {
    table = new LinkedList[capacity];
    for (int i = 0; i < capacity; i++) {
      table[i] = new LinkedList<>();
    }
  }

  private int hash(int key) {
    return key % table.length;
  }

  public void insert(Register<E> reg) {
    int index = hash(reg.getKey());
    for (Register<E> r : table[index]) {
      if (r.getKey() == reg.getKey()) {
        System.out.println("Error: Clave duplicada " + reg.getKey());
        return;
      }
    }
    table[index].add(reg);
    System.out.println("Insertado en posición " + index + ": " + reg);
  }

  public void delete(int key) {
    int index = hash(key);
    for (Register<E> r : table[index]) {
      if (r.getKey() == key) {
        table[index].remove(r);
        System.out.println("Eliminado en posición " + index + ": " + key);
        return;
      }
    }
    System.out.println("Clave " + key + " no encontrada para eliminar.");
  }

  public Register<E> search(int key) {
    int index = hash(key);
    for (Register<E> r : table[index]) {
      if (r.getKey() == key) {
        return r;
      }
    }
    return null;
  }

  public void showTable() {
    System.out.println("\n--- Tabla Hash Abierto ---");
    for (int i = 0; i < table.length; i++) {
      System.out.print(i + ": ");
      if (table[i].isEmpty()) {
        System.out.println("[VACÍO]");
      } else {
        for (Register<E> r : table[i]) {
          System.out.print(r + " -> ");
        }
        System.out.println("null");
      }
    }
  }
}
