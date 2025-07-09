package lab08.arbolB;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;


import java.util.*;

public class BTree<E extends Comparable<E>> {
  BNode<E> root;
  int m;

  public BTree(int m) {
    this.m = m;
    root = null;
  }

  public boolean isEmpty() {
    return root == null;
  }

  public void destroy() {
    root = null;
  }

  public void insert(E key) {
    if (root == null) {
      root = new BNode<>(m);
      root.keys.set(0, key);
      root.count = 1;
    } else {
      if (root.isFull()) {
        BNode<E> s = new BNode<>(m);
        s.children.set(0, root);
        splitChild(s, 0);
        insertNonFull(s, key);
        root = s;
      } else {
        insertNonFull(root, key);
      }
    }
  }

  void insertNonFull(BNode<E> node, E key) {
    int i = node.count - 1;
    if (node.children.get(0) == null) {
      while (i >= 0 && key.compareTo(node.keys.get(i)) < 0) {
        node.keys.set(i + 1, node.keys.get(i));
        i--;
      }
      node.keys.set(i + 1, key);
      node.count++;
    } else {
      while (i >= 0 && key.compareTo(node.keys.get(i)) < 0)
        i--;
      i++;
      if (node.children.get(i).isFull()) {
        splitChild(node, i);
        if (key.compareTo(node.keys.get(i)) > 0)
          i++;
      }
      insertNonFull(node.children.get(i), key);
    }
  }

  void splitChild(BNode<E> parent, int i) {
    BNode<E> y = parent.children.get(i);
    BNode<E> z = new BNode<>(m);
    z.count = m / 2 - 1;
    for (int j = 0; j < m / 2 - 1; j++)
      z.keys.set(j, y.keys.get(j + m / 2));
    if (y.children.get(0) != null) {
      for (int j = 0; j < m / 2; j++)
        z.children.set(j, y.children.get(j + m / 2));
    }
    y.count = m / 2 - 1;
    for (int j = parent.count; j >= i + 1; j--)
      parent.children.set(j + 1, parent.children.get(j));
    parent.children.set(i + 1, z);
    for (int j = parent.count - 1; j >= i; j--)
      parent.keys.set(j + 1, parent.keys.get(j));
    parent.keys.set(i, y.keys.get(m / 2 - 1));
    parent.count++;
  }

  public boolean search(E key) {
    return search(root, key);
  }

  boolean search(BNode<E> node, E key) {
    if (node == null)
      return false;
    int i = 0;
    while (i < node.count && key.compareTo(node.keys.get(i)) > 0)
      i++;
    if (i < node.count && key.compareTo(node.keys.get(i)) == 0)
      return true;
    if (node.children.get(0) == null)
      return false;
    return search(node.children.get(i), key);
  }

  public E Min() {
    BNode<E> curr = root;
    while (curr != null && curr.children.get(0) != null)
      curr = curr.children.get(0);
    return curr != null ? curr.keys.get(0) : null;
  }

  public E Max() {
    BNode<E> curr = root;
    while (curr != null && curr.children.get(0) != null)
      curr = curr.children.get(curr.count);
    return curr != null ? curr.keys.get(curr.count - 1) : null;
  }

  public E Predecessor(E key) {
    ArrayList<E> inorder = new ArrayList<>();
    inorderTraversal(root, inorder);
    for (int i = 1; i < inorder.size(); i++) {
      if (inorder.get(i).compareTo(key) == 0)
        return inorder.get(i - 1);
    }
    return null;
  }

  public E Sucesor(E key) {
    ArrayList<E> inorder = new ArrayList<>();
    inorderTraversal(root, inorder);
    for (int i = 0; i < inorder.size() - 1; i++) {
      if (inorder.get(i).compareTo(key) == 0)
        return inorder.get(i + 1);
    }
    return null;
  }

  void inorderTraversal(BNode<E> node, ArrayList<E> list) {
    if (node != null) {
      int i;
      for (i = 0; i < node.count; i++) {
        inorderTraversal(node.children.get(i), list);
        list.add(node.keys.get(i));
      }
      inorderTraversal(node.children.get(i), list);
    }
  }

  public String toString() {
    return writeTree(root, 0);
  }

  String writeTree(BNode<E> node, int depth) {
    if (node == null)
      return "";
    StringBuilder sb = new StringBuilder();
    for (int i = node.count - 1; i >= 0; i--) {
      sb.append(writeTree(node.children.get(i + 1), depth + 1));
      for (int j = 0; j < depth; j++)
        sb.append("  ");
      sb.append(node.keys.get(i)).append("\n");
    }
    sb.append(writeTree(node.children.get(0), depth + 1));
    return sb.toString();
  }

  void FuzeNode() {
  }

  void dividedNode() {
  }

  public void remove(E key) {
    remove(root, key);
    if (root.count == 0 && root.children.get(0) != null)
      root = root.children.get(0);
    if (root.count == 0 && root.children.get(0) == null)
      root = null;
  }

  void remove(BNode<E> node, E key) {
    int idx = node.findKey(key);
    if (idx < node.count && node.keys.get(idx).compareTo(key) == 0) {
      if (node.children.get(0) == null) {
        for (int i = idx; i < node.count - 1; i++)
          node.keys.set(i, node.keys.get(i + 1));
        node.keys.set(node.count - 1, null);
        node.count--;
      } else {
        BNode<E> pred = node.children.get(idx);
        while (pred.children.get(pred.count) != null)
          pred = pred.children.get(pred.count);
        E predKey = pred.keys.get(pred.count - 1);
        node.keys.set(idx, predKey);
        remove(node.children.get(idx), predKey);
      }
    } else {
      if (node.children.get(0) == null)
        return;
      boolean flag = (idx == node.count);
      if (node.children.get(idx).count < m / 2)
        fill(node, idx);
      if (flag && idx > node.count)
        remove(node.children.get(idx - 1), key);
      else
        remove(node.children.get(idx), key);
    }
  }

  void fill(BNode<E> node, int idx) {
    if (idx != 0 && node.children.get(idx - 1).count >= m / 2)
      borrowFromPrev(node, idx);
    else if (idx != node.count && node.children.get(idx + 1).count >= m / 2)
      borrowFromNext(node, idx);
    else {
      if (idx != node.count)
        merge(node, idx);
      else
        merge(node, idx - 1);
    }
  }

  void borrowFromPrev(BNode<E> node, int idx) {
    BNode<E> child = node.children.get(idx);
    BNode<E> sibling = node.children.get(idx - 1);
    for (int i = child.count - 1; i >= 0; i--)
      child.keys.set(i + 1, child.keys.get(i));
    if (child.children.get(0) != null) {
      for (int i = child.count; i >= 0; i--)
        child.children.set(i + 1, child.children.get(i));
    }
    child.keys.set(0, node.keys.get(idx - 1));
    if (child.children.get(0) != null)
      child.children.set(0, sibling.children.get(sibling.count));
    node.keys.set(idx - 1, sibling.keys.get(sibling.count - 1));
    sibling.keys.set(sibling.count - 1, null);
    sibling.count--;
    child.count++;
  }

  void borrowFromNext(BNode<E> node, int idx) {
    BNode<E> child = node.children.get(idx);
    BNode<E> sibling = node.children.get(idx + 1);
    child.keys.set(child.count, node.keys.get(idx));
    if (child.children.get(0) != null)
      child.children.set(child.count + 1, sibling.children.get(0));
    node.keys.set(idx, sibling.keys.get(0));
    for (int i = 1; i < sibling.count; i++)
      sibling.keys.set(i - 1, sibling.keys.get(i));
    if (sibling.children.get(0) != null) {
      for (int i = 1; i <= sibling.count; i++)
        sibling.children.set(i - 1, sibling.children.get(i));
    }
    sibling.keys.set(sibling.count - 1, null);
    sibling.count--;
    child.count++;
  }

  void merge(BNode<E> node, int idx) {
    BNode<E> child = node.children.get(idx);
    BNode<E> sibling = node.children.get(idx + 1);
    child.keys.set(m / 2 - 1, node.keys.get(idx));
    for (int i = 0; i < sibling.count; i++)
      child.keys.set(i + m / 2, sibling.keys.get(i));
    if (child.children.get(0) != null) {
      for (int i = 0; i <= sibling.count; i++)
        child.children.set(i + m / 2, sibling.children.get(i));
    }
    for (int i = idx + 1; i < node.count; i++)
      node.keys.set(i - 1, node.keys.get(i));
    for (int i = idx + 2; i <= node.count; i++)
      node.children.set(i - 1, node.children.get(i));
    child.count += sibling.count + 1;
    node.count--;
  }
public void displayGraph() {
    Graph graph = new SingleGraph("BTree");
    graph.setAttribute("ui.stylesheet", "node{text-alignment: center;}");
    traverseGraph(root, graph, "root");
    graph.display();
}

void traverseGraph(BNode<E> node, Graph graph, String id) {
    if (node == null) return;
    String label = "";
    for (int i = 0; i < node.count; i++) label += node.keys.get(i) + " ";
    Node n = graph.addNode(id);
    n.setAttribute("ui.label", label);
    for (int i = 0; i <= node.count; i++) {
        if (node.children.get(i) != null) {
            String childId = id + "." + i;
            graph.addEdge(id + "-" + childId, id, childId, true);
            traverseGraph(node.children.get(i), graph, childId);
        }
    }
}
}
