import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;

public class ejercicio03<T extends Comparable<T>> {
    private Graph graph = new SingleGraph("AVL");
    public void plot(NodeAVL<T> root) {
        traverseAndAdd(root);
        graph.display();
    }

    private void traverseAndAdd(NodeAVL<T> node) {
        if (node == null) return;
        String id = node.data.toString();
        if (graph.getNode(id) == null) {
            graph.addNode(id).addAttribute("ui.label", id);
        }
        if (node.left != null) {
            String leftId = node.left.data.toString();
            graph.addEdge(id + "_L_" + leftId, id, leftId, true);
            traverseAndAdd(node.left);
        }
        if (node.right != null) {
            String rightId = node.right.data.toString();
            graph.addEdge(id + "_R_" + rightId, id, rightId, true);
            traverseAndAdd(node.right);
        }
    }
}
