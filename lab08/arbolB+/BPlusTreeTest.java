import java.util.Scanner;

public class BPlusTreeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BPlusTree<Integer> bptree = new BPlusTree<>(5);
        while (true) {
            System.out.println("\n1.Insert\n2.Search\n3.Min\n4.Max\n5.Predecessor\n6.Successor\n7.Show Tree\n8.Destroy\n9.Exit");
            int op = sc.nextInt();
            if (op == 1) {
                System.out.print("Insert: ");
                int x = sc.nextInt();
                bptree.insert(x);
            } else if (op == 2) {
                System.out.print("Search: ");
                int x = sc.nextInt();
                System.out.println(bptree.search(x) ? "Found" : "Not Found");
            } else if (op == 3) {
                System.out.println("Min: " + bptree.Min());
            } else if (op == 4) {
                System.out.println("Max: " + bptree.Max());
            } else if (op == 5) {
                System.out.print("Predecessor of: ");
                int x = sc.nextInt();
                System.out.println("Predecessor: " + bptree.Predecessor(x));
            } else if (op == 6) {
                System.out.print("Successor of: ");
                int x = sc.nextInt();
                System.out.println("Successor: " + bptree.Sucesor(x));
            } else if (op == 7) {
                System.out.println("Tree:\n" + bptree.toString());
            } else if (op == 8) {
                bptree.destroy();
                System.out.println("Tree destroyed.");
            } else if (op == 9) {
                break;
            }
        }
    }
}
