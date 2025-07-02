import java.util.Scanner;
public class TestAVL_ejercicio02 {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.Insert 2.Remove 3.Search 4.Min 5.Max 6.PreOrder 7.InOrder 8.PostOrder 9.Exit");
            int op = sc.nextInt();
            if (op == 9) break;
            System.out.print("Valor: "); int v = sc.nextInt();
            switch (op) {
                case 1: tree.insert(v); tree.PreOrder(); break;
                case 2: tree.remove(v); tree.InOrder(); break;
                case 3: System.out.println(tree.search(v) != null ? "Encontrado" : "No encontrado"); break;
                case 4: System.out.println("Min: " + tree.Min()); break;
                case 5: System.out.println("Max: " + tree.Max()); break;
                case 6: tree.PreOrder(); break;
                case 7: tree.InOrder(); break;
                case 8: tree.PostOrder(); break;
                default: System.out.println("Opcion invalida");
            }
        }
        sc.close();
    }
}