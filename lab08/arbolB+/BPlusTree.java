import java.util.*;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class BPlusTree<E extends Comparable<E>> {
    BPlusNode<E> root;
    int m;

    public BPlusTree(int m) {
        this.m = m;
        root = new BPlusNode<>(m, true);
    }

    public boolean isEmpty() {
        return root.count == 0;
    }

    public void destroy() {
        root = new BPlusNode<>(m, true);
    }

    public void insert(E key) {
        BPlusNode<E> r = root;
        if (r.isFull()) {
            BPlusNode<E> s = new BPlusNode<>(m, false);
            s.children.set(0, r);
            splitChild(s, 0);
            insertNonFull(s, key);
            root = s;
        } else {
            insertNonFull(r, key);
        }
    }

    void insertNonFull(BPlusNode<E> node, E key) {
        int i = node.count - 1;
        if (node.isLeaf) {
            while (i >= 0 && key.compareTo(node.keys.get(i)) < 0) {
                node.keys.set(i + 1, node.keys.get(i));
                i--;
            }
            node.keys.set(i + 1, key);
            node.count++;
        } else {
            while (i >= 0 && key.compareTo(node.keys.get(i)) < 0) i--;
            i++;
            if (node.children.get(i).isFull()) {
                splitChild(node, i);
                if (key.compareTo(node.keys.get(i)) > 0) i++;
            }
            insertNonFull(node.children.get(i), key);
        }
    }

    void splitChild(BPlusNode<E> parent, int idx) {
        BPlusNode<E> y = parent.children.get(idx);
        BPlusNode<E> z = new BPlusNode<>(m, y.isLeaf);
        int t = (m - 1) / 2;
        for (int j = 0; j < m - 1 - t; j++) z.keys.set(j, y.keys.get(j + t));
        if (!y.isLeaf) {
            for (int j = 0; j < m - t; j++) z.children.set(j, y.children.get(j + t));
        } else {
            z.next = y.next;
            y.next = z;
        }
        y.count = t;
        z.count = m - 1 - t;
        for (int j = parent.count; j >= idx + 1; j--) parent.children.set(j + 1, parent.children.get(j));
        parent.children.set(idx + 1, z);
        for (int j = parent.count - 1; j >= idx; j--) parent.keys.set(j + 1, parent.keys.get(j));
        parent.keys.set(idx, y.keys.get(t));
        parent.count++;
    }

    public boolean search(E key) {
        return search(root, key);
    }

    boolean search(BPlusNode<E> node, E key) {
        int i = 0;
        while (i < node.count && key.compareTo(node.keys.get(i)) > 0) i++;
        if (node.isLeaf) {
            if (i < node.count && key.compareTo(node.keys.get(i)) == 0) return true;
            return false;
        }
        return search(node.children.get(i), key);
    }

    public E Min() {
        BPlusNode<E> curr = root;
        while (!curr.isLeaf) curr = curr.children.get(0);
        return curr.count > 0 ? curr.keys.get(0) : null;
    }

    public E Max() {
        BPlusNode<E> curr = root;
        while (!curr.isLeaf) curr = curr.children.get(curr.count);
        return curr.count > 0 ? curr.keys.get(curr.count - 1) : null;
    }

    public E Predecessor(E key) {
        ArrayList<E> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i).compareTo(key) == 0) return inorder.get(i - 1);
        }
        return null;
    }

    public E Sucesor(E key) {
        ArrayList<E> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        for (int i = 0; i < inorder.size() - 1; i++) {
            if (inorder.get(i).compareTo(key) == 0) return inorder.get(i + 1);
        }
        return null;
    }

    void inorderTraversal(BPlusNode<E> node, ArrayList<E> list) {
        if (node.isLeaf) {
            for (int i = 0; i < node.count; i++) list.add(node.keys.get(i));
        } else {
            for (int i = 0; i < node.count; i++) {
                inorderTraversal(node.children.get(i), list);
                list.add(node.keys.get(i));
            }
            inorderTraversal(node.children.get(node.count), list);
        }
    }

    public String toString() {
        return writeTree(root, 0);
    }

    String writeTree(BPlusNode<E> node, int depth) {
        if (node == null) return "";
        StringBuilder sb = new StringBuilder();
        if (node.isLeaf) {
            for (int j = 0; j < depth; j++) sb.append("  ");
            for (int i = 0; i < node.count; i++) sb.append(node.keys.get(i)).append(" ");
            sb.append("\n");
        } else {
            for (int i = node.count - 1; i >= 0; i--) {
                sb.append(writeTree(node.children.get(i + 1), depth + 1));
                for (int j = 0; j < depth; j++) sb.append("  ");
                sb.append(node.keys.get(i)).append("\n");
            }
            sb.append(writeTree(node.children.get(0), depth + 1));
        }
        return sb.toString();
    }

public void displayGraph() {
    Graph graph = new SingleGraph("BPlusTree");
    graph.setAttribute("ui.stylesheet", "node{text-alignment: center;}");
    traverseGraph(root, graph, "root");
    graph.display();
}

void traverseGraph(BPlusNode<E> node, Graph graph, String id) {
    if (node == null) return;
    String label = "";
    for (int i = 0; i < node.count; i++) label += node.keys.get(i) + " ";
    Node n = graph.addNode(id);
    n.setAttribute("ui.label", label.trim());
    for (int i = 0; i <= node.count; i++) {
        if (!node.isLeaf && node.children.get(i) != null) {
            String childId = id + "." + i;
            graph.addEdge(id + "-" + childId, id, childId, true);
            traverseGraph(node.children.get(i), graph, childId);
        }
    }
}
}