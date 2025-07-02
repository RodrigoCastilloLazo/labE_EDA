public class AVLTree<T extends Comparable<T>> {
    private static class Node<T> {
        T data; int height;
        Node<T> left, right;
        Node(T d){ data=d; height=1; }
    }
    private Node<T> root;

    public void destroy() { root = null; }
    public boolean isEmpty() { return root == null; }
    public void insert(T x) { root = insert(root, x); }
    private Node<T> insert(Node<T> n, T x) {
        if (n == null) return new Node<>(x);
        int cmp = x.compareTo(n.data);
        if (cmp < 0) n.left = insert(n.left, x);
        else if (cmp > 0) n.right = insert(n.right, x);
        return rebalance(n);
    }
    public void remove(T x) { root = remove(root, x); }
    private Node<T> remove(Node<T> n, T x) {
        if (n == null) return null;
        int cmp = x.compareTo(n.data);
        if (cmp < 0) n.left = remove(n.left, x);
        else if (cmp > 0) n.right = remove(n.right, x);
        else {
            if (n.left == null) return n.right;
            if (n.right == null) return n.left;
            Node<T> succ = minNode(n.right);
            n.data = succ.data;
            n.right = remove(n.right, succ.data);
        }
        return rebalance(n);
    }
    public Node<T> search(T x) { return search(root, x); }
    private Node<T> search(Node<T> n, T x) {
        if (n == null) return null;
        int cmp = x.compareTo(n.data);
        if (cmp == 0) return n;
        return (cmp < 0) ? search(n.left, x) : search(n.right, x);
    }
    public T Min() { return root == null ? null : minNode(root).data; }
    public T Max() { return root == null ? null : maxNode(root).data; }
    private Node<T> minNode(Node<T> n){ while(n.left!=null) n=n.left; return n; }
    private Node<T> maxNode(Node<T> n){ while(n.right!=null) n=n.right; return n; }
    public T Predecessor(T x) {
        Node<T> n = search(x), pred = null;
        while (n != null && n.left != null) { pred = maxNode(n.left); break; }
        return pred == null ? null : pred.data;
    }
    public T Sucesor(T x) {
        Node<T> n = search(x), succ = null;
        while (n != null && n.right != null) { succ = minNode(n.right); break; }
        return succ == null ? null : succ.data;
    }
    public void InOrder() { traverse(root, "in"); System.out.println(); }
    public void PreOrder() { traverse(root, "pre"); System.out.println(); }
    public void PostOrder(){ traverse(root, "post"); System.out.println(); }
    private void traverse(Node<T> n, String o) {
        if (n == null) return;
        if (o.equals("pre")) System.out.print(n.data+" ");
        traverse(n.left,o);
        if (o.equals("in")) System.out.print(n.data+" ");
        traverse(n.right,o);
        if (o.equals("post")) System.out.print(n.data+" ");
    }
    private Node<T> rebalance(Node<T> n) {
        updateHeight(n);
        int bf = balanceFactor(n);
        if (bf > 1) return balanceLeft(n);
        if (bf < -1) return balanceRight(n);
        return n;
    }
    private void updateHeight(Node<T> n) { n.height = 1 + Math.max(h(n.left), h(n.right)); }
    private int h(Node<T> n){ return n==null?0:n.height; }
    private int balanceFactor(Node<T> n){ return h(n.left)-h(n.right); }
    public Node<T> balanceLeft(Node<T> n) {
        if (balanceFactor(n.left) < 0) n.left = rotacionSimpleIzquierda(n.left);
        return rotacionSimpleDerecha(n);
    }
    public Node<T> balanceRight(Node<T> n) {
        if (balanceFactor(n.right) > 0) n.right = rotacionSimpleDerecha(n.right);
        return rotacionSimpleIzquierda(n);
    }
    public Node<T> rotacionSimpleIzquierda(Node<T> x) {
        Node<T> y = x.right; x.right = y.left; y.left = x;
        updateHeight(x); updateHeight(y);
        return y;
    }
    public Node<T> rotacionSimpleDerecha(Node<T> y) {
        Node<T> x = y.left; y.left = x.right; x.right = y;
        updateHeight(y); updateHeight(x);
        return x;
    }
}
