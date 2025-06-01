package lab04;
public class CircularLinkedList_v3<E> {
    static class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node<E> last;
    private int size;

    public CircularLinkedList_v3() {
        last = null;
        size = 0;
    }

    public void insert(E data) {
        addLast(data);
    }

    public void insert(E data, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Posicion invalida: " + position);
        }

        if (position == 0) {
            addFirst(data);
        } else if (position == size) {
            addLast(data);
        } else {
            Node<E> newNode = new Node<>(data);
            Node<E> current = getNodeAt(position);
            
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            
            size++;
        }
    }

    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data);
        if (last == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            last = newNode;
        } else {
            newNode.next = last.next;
            newNode.prev = last;
            last.next.prev = newNode;
            last.next = newNode;
        }
        size++;
    }

    public void addLast(E data) {
        addFirst(data);
        last = last.next;
    }

    public void deleteByKey(E key) {
        if (last == null) return;

        Node<E> current = last.next;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(key)) {
                if (size == 1) {
                    last = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    if (current == last) last = last.prev;
                }
                size--;
                return;
            }
            current = current.next;
        }
    }

    public void deleteAtPosition(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Posicion invalida: " + position);
        }

        if (position == 0) {
            removeFirst();
        } else if (position == size - 1) {
            removeLast();
        } else {
            Node<E> nodeToDelete = getNodeAt(position);
            nodeToDelete.prev.next = nodeToDelete.next;
            nodeToDelete.next.prev = nodeToDelete.prev;
            size--;
        }
    }

    public void removeFirst() {
        if (last == null) return;
        
        if (size == 1) {
            last = null;
        } else {
            last.next = last.next.next;
            last.next.prev = last;
        }
        size--;
    }

    public void removeLast() {
        if (last == null) return;
        
        if (size == 1) {
            last = null;
        } else {
            last = last.prev;
            last.next = last.next.next;
            last.next.prev = last;
        }
        size--;
    }

    public int size() {
        return size;
    }

    public void printList() {
        if (last == null) {
            System.out.println("[]");
            return;
        }
        
        Node<E> current = last.next;
        System.out.print("[");
        do {
            System.out.print(current.data);
            if (current != last) System.out.print(" ⇄ ");
            current = current.next;
        } while (current != last.next);
        System.out.println("]");
    }

    private Node<E> getNodeAt(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Posicion invalida: " + position);
        }

        Node<E> current = last.next;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current;
    }
}