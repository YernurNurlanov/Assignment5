public class BST<K extends Comparable<K>, V> {
    private Node root;
    private int size = 0;
    private class Node {
        private K key;
        private V val;
        private Node left, right;
        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
        @Override
        public String toString() {
            return "Node{" + "key=" + key + ", val=" + val + '}';
        }
    }
    public void put(K key, V val) {
        root = put(root, key, val);
    }
    public Node put(Node node, K key, V val){
        if (node == null) {
            size++;
            return new Node(key, val);
        }
        int x = key.compareTo(node.key);
        if (x < 0)
            node.left = put(node.left, key, val);
        else if (x > 0)
            node.right = put(node.right, key, val);
        else
            node.val = val;

        return node;
    }
    public V get(K key) {
        Node node = get(root, key);
        return node == null ? null : node.val;
    }
    private Node get(Node node, K key) {
        if (node == null)
            return null;
        int x = key.compareTo(node.key);
        if (x < 0)
            return get(node.left, key);
        else if (x > 0)
            return get(node.right, key);
        else
            return node;
    }
    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null)
            return null;
        int x = key.compareTo(node.key);
        if (x < 0)
            node.left = delete(node.left, key);
        else if (x > 0)
            node.right = delete(node.right, key);
        else {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            else {
                Node min = findMin(node.right);
                node.key = min.key;
                node.val = min.val;
                node.right = deleteMin(node.right);
            }
        }
        return node;
    }
    private Node findMin(Node node) {
        if (node.left == null)
            return node;
        return findMin(node.left);
    }
    private Node deleteMin(Node node) {
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        return node;
    }
}
