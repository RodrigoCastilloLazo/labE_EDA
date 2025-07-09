package lab08.arbolB;


import java.util.Scanner;

public class BTreeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BTree<Integer> btree = new BTree<>(5);
        while (true) {
            System.out.println("\n1.Insert\n2.Remove\n3.Search\n4.Min\n5.Max\n6.Predecessor\n7.Sucessor\n8.Show Tree\n9.Destroy\n10.Exit");
            int op = sc.nextInt();
            if (op == 1) {
                System.out.print("Insert: ");
                int x = sc.nextInt();
                btree.insert(x);
            } else if (op == 2) {
                System.out.print("Remove: ");
                int x = sc.nextInt();
                btree.remove(x);
            } else if (op == 3) {
                System.out.print("Search: ");
                int x = sc.nextInt();
                System.out.println(btree.search(x) ? "Found" : "Not Found");
            } else if (op == 4) {
                System.out.println("Min: " + btree.Min());
            } else if (op == 5) {
                System.out.println("Max: " + btree.Max());
            } else if (op == 6) {
                System.out.print("Predecessor of: ");
                int x = sc.nextInt();
                System.out.println("Predecessor: " + btree.Predecessor(x));
            } else if (op == 7) {
                System.out.print("Successor of: ");
                int x = sc.nextInt();
                System.out.println("Successor: " + btree.Sucesor(x));
            } else if (op == 8) {
                System.out.println("Tree:\n" + btree.toString());
            } else if (op == 9) {
                btree.destroy();
                System.out.println("Tree destroyed.");
            } else if (op == 10) {
                break;
            }
        }
    }
}
