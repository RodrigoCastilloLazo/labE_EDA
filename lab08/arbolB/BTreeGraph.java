package lab08.arbolB;


import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import java.util.*;

public class BTreeGraph {
    public static void main(final String[] args) {
        final BTree<Integer> btree = new BTree<>(5);
        final int[] data = {100, 200, 300, 400, 500, 50, 25, 350, 375, 360, 355, 150, 175, 120, 190};
        for (final int x : data) btree.insert(x);
        btree.displayGraph();
    }
}
