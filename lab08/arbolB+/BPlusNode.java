import java.util.ArrayList;
import java.util.Collections;

public class BPlusNode <E extends Comparable<E>>{
    ArrayList<E> keys;
    ArrayList<BPlusNode<E>> children;
    BPlusNode<E> next;
    boolean isLeaf;
    int count;
    int m;

    BPlusNode(int m, boolean isLeaf) {
        this.m = m;
        this.isLeaf = isLeaf;
        keys = new ArrayList<>(Collections.nCopies(m - 1, null));
        children = new ArrayList<>(Collections.nCopies(m, null));
        count = 0;
        next = null;
    }

    boolean isFull() {
        return count == m - 1;
    }
}
