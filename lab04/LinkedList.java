package lab04;
public class LinkedList<E> {
  static class Node<E> {
      E data;
      Node<E> next;

      Node(E data) {
          this.data = data;
          this.next = null;
      }
  }

  private Node<E> head;
  private int size;

  public LinkedList() {
      head = null;
      size = 0;
  }
  public void insert(E data) {
      addLast(data);
  }
  public void insert(E data, int position) {
      if (position < 0 || position > size) {
          throw new IndexOutOfBoundsException("Posición inválida: " + position);
      }

      if (position == 0) {
          addFirst(data);
      } else if (position == size) {
          addLast(data);
      } else {
          Node<E> newNode = new Node<>(data);
          Node<E> current = head;
          for (int i = 0; i < position - 1; i++) {
              current = current.next;
          }
          newNode.next = current.next;
          current.next = newNode;
          size++;
      }
  }
  public void addFirst(E data) {
      Node<E> newNode = new Node<>(data);
      newNode.next = head;
      head = newNode;
      size++;
  }
  public void addLast(E data) {
      Node<E> newNode = new Node<>(data);
      if (head == null) {
          head = newNode;
      } else {
          Node<E> current = head;
          while (current.next != null) {
              current = current.next;
          }
          current.next = newNode;
      }
      size++;
  }
  public void deleteByKey(E key) {
      if (head == null) return;

      if (head.data.equals(key)) {
          removeFirst();
          return;
      }

      Node<E> current = head;
      Node<E> prev = null;

      while (current != null && !current.data.equals(key)) {
          prev = current;
          current = current.next;
      }

      if (current == null) {
          System.out.println("Clave no encontrada: " + key);
          return;
      }

      prev.next = current.next;
      size--;
  }
  public void deleteAtPosition(int position) {
      if (position < 0 || position >= size) {
          throw new IndexOutOfBoundsException("Posición inválida: " + position);
      }

      if (position == 0) {
          removeFirst();
      } else {
          Node<E> current = head;
          for (int i = 0; i < position - 1; i++) {
              current = current.next;
          }
          current.next = current.next.next;
          size--;
      }
  }
  public void removeFirst() {
      if (head == null) return;
      head = head.next;
      size--;
  }
  public void removeLast() {
      if (head == null) return;
      
      if (head.next == null) {
          head = null;
      } else {
          Node<E> current = head;
          while (current.next.next != null) {
              current = current.next;
          }
          current.next = null;
      }
      size--;
  }
  public int size() {
      return size;
  }
  public void printList() {
      Node<E> current = head;
      System.out.print("Lista: [");
      while (current != null) {
          System.out.print(current.data);
          if (current.next != null) {
              System.out.print(" -> ");
          }
          current = current.next;
      }
      System.out.println("]");
  }
}