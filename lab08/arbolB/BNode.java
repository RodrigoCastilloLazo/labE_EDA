package lab08.arbolB;

import java.util.*;

public class BNode<E extends Comparable<E>> {
    ArrayList<E> keys;
    ArrayList<BNode<E>> children;
    int count;
    int m;

    BNode(int m) {
        this.m = m;
        keys = new ArrayList<>(Collections.nCopies(m - 1, null));
        children = new ArrayList<>(Collections.nCopies(m, null));
        count = 0;
    }

    boolean isFull() {
        return count == m - 1;
    }

    boolean isEmpty() {
        return count == 0;
    }

    int findKey(E key) {
        int idx = 0;
        while (idx < count && key.compareTo(keys.get(idx)) > 0) idx++;
        return idx;
    }
}
