public class BPlusTreeGraph {
    public static void main(String[] args) {
        BPlusTree<Integer> bptree = new BPlusTree<>(5);
        int[] data = {100, 200, 300, 400, 500, 50, 25, 350, 375, 360, 355, 150, 175, 120, 190};
        for (int x : data) bptree.insert(x);
        bptree.displayGraph();
    }
}
