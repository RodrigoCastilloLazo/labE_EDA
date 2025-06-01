package lab04;
public class CircularLinkedList<E> {
    private static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    private Node<E> last; 

    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (last == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            last = newNode;
        } else {
            Node<E> first = last.next;
            newNode.next = first;
            newNode.prev = last;
            last.next = newNode;
            first.prev = newNode;
            last = newNode; 
        }
    }
    public void imprimirLista() {
        if (last == null) {
            System.out.println("Lista vacía");
            return;
        }
        Node<E> current = last.next; 
        System.out.print("Lista circular: ");
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != last.next);
        System.out.println();
    }
}