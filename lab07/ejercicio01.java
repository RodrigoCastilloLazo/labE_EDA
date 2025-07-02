public class ejercicio01 {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();
        int[] seq = {100,200,300,400,500,50,25,350,375,360,355,150,175,120,190};
        System.out.println("-- Insercin secuencial y recorridos --");
        for (int x : seq) {
            avl.insert(x);
            System.out.print("Insertado " + x + ": "); avl.PreOrder();
        }
        System.out.println("-- Eliminacion secuencial y recorridos --");
        for (int x : seq) {
            avl.remove(x);
            System.out.print("Eliminado " + x + ": "); avl.InOrder();
        }
    }
}