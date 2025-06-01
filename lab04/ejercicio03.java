package lab04;

public class ejercicio03 {
    public static void main(String[] args) {
        DoubleLinkedList_v1<Integer> lista = new DoubleLinkedList_v1<>();
        
        for (int i = 1; i <= 10; i++) {
            lista.add(i);
        }
        lista.imprimirLista();
    }   
}