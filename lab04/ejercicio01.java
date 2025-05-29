package lab04;
public class ejercicio01<E> {
    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    private Node<E> head;
    private Node<E> tail;

    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void imprimirLista() {
        Node<E> current = head;
        System.out.print("Lista completa: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ejercicio01<Integer> list = new ejercicio01<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        list.imprimirLista();
    }
}