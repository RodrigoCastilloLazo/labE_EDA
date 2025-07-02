public class NodeAVL<T extends Comparable<T>> {
    T data; int height;
    NodeAVL<T> left, right;
    NodeAVL(T d){ data=d; height=1; }
}