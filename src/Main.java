public class Main {
    public static void main(String[] args) {
        BST<String, Integer> tree = new BST<>();
        tree.put("q", 1);
        tree.put("w", 2);
        tree.put("e", 3);
        tree.put("r", 4);
        tree.put("t",5);
        tree.put("y",6);
        System.out.println(tree.contains(7));
        System.out.println(tree.contains(2));
    }
}