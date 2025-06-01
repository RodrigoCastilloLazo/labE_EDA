package lab04;
import java.util.LinkedList;

public class DoubleLinkedList<E> {
    private LinkedList<E> lista = new LinkedList<>();

    public void add(E elemento) {
        lista.addLast(elemento);
    }

    public void imprimirLista() {
        System.out.print("Lista completa: ");
        for (E elemento : lista) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }
}