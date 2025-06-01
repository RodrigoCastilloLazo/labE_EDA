package lab04;
public class DoubleLinkedList_v2<E> {
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

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoubleLinkedList_v2() {
        head = null;
        tail = null;
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
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    public void addLast(E data) {
        Node<E> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void deleteByKey(E key) {
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(key)) {
                if (current == head) {
                    removeFirst();
                } else if (current == tail) {
                    removeLast();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                }
                return;
            }
            current = current.next;
        }
        System.out.println("Clave no encontrada: " + key);
    }

    public void deleteAtPosition(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Posición inválida: " + position);
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
        if (head == null) return;
        
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void removeLast() {
        if (tail == null) return;
        
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    public int size() {
        return size;
    }

    public void printList() {
        Node<E> current = head;
        System.out.print("Lista (adelante): [");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" ⇄ ");
            current = current.next;
        }
        System.out.println("]");
    }

    private Node<E> getNodeAt(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Posición inválida: " + position);
        }

        Node<E> current;
        if (position < size / 2) {
            current = head;
            for (int i = 0; i < position; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > position; i--) {
                current = current.prev;
            }
        }
        return current;
    }
}