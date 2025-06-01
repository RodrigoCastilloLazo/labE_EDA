package lab04;

public class ejercicio04 {
    public static void main(String[] args) {
        CircularLinkedList_v2<Integer> circularList = new CircularLinkedList_v2<>();
        
        for (int i = 1; i <= 12; i++) {
            circularList.add(i);
        }
        circularList.imprimirCircular(15);          
    }    
}