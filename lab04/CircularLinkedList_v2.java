package lab04;

import java.util.LinkedList;

public class CircularLinkedList_v2<E> {
    private LinkedList<E> list = new LinkedList<>();
    private int currentIndex = 0;

    public void add(E element) {
        list.addLast(element);
    }

    public E next() {
        if (list.isEmpty()) return null;
        E element = list.get(currentIndex);
        currentIndex = (currentIndex + 1) % list.size();
        return element;
    }
    public void reset() {
        currentIndex = 0;
    }
    public void imprimirCircular(int elementos) {
        if (list.isEmpty()) {
            System.out.println("Lista vacía");
            return;
        }
        
        System.out.print("Lista :");
        for (int i = 0; i < elementos; i++) {
            System.out.print(next() + " ");
        }
        System.out.println();
    }
}
