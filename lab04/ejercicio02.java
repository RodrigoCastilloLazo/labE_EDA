package lab04;

public class ejercicio02 {
    public static void main(String[] args) {
        CircularLinkedList_v1<Integer> list = new CircularLinkedList_v1<>();
        for (int i = 1; i <= 12; i++) {
            list.add(i);
        }
        list.imprimirLista();
    }    
}