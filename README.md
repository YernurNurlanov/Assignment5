# Assignment5
## put()
Description: inserts a key-value pair into a binary search tree.
```
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
```
## get()
Description: takes the value related to the given key from the binary search tree.
```
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
```
## delete()
Description: removes the key-value pair from the binary search tree.
```
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
```
## iterator()
Description: returns an iterator to iterate through the binary search tree in traversal order.
```
public Iterable<K> iterator() {
        List<K> keys = new ArrayList<>();
        inOrderTraversal(root, keys);
        return keys;
    }
private void inOrderTraversal(Node node, List<K> keys) {
        if (node == null)
            return;
        inOrderTraversal(node.left, keys);
        keys.add(node.key);
        inOrderTraversal(node.right, keys);
    }
```
