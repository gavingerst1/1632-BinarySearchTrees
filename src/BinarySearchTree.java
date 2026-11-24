public class BinarySearchTree {
    Node root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.data) {
            current.left = insert(current.left, value);
        } else if (value > current.data) {
            current.right = insert(current.right, value);
        }

        return current;
    }

    public int height() {
        return height(root);
    }

    private int height(Node current) {
        if (current == null) {
            return 0;
        }

        int leftHeight = height(current.left);
        int rightHeight = height(current.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Returns the number of nodes visited to find value
    public int find(int value) {
        Node current = root;
        int count = 0;

        while (current != null) {
            count++;

            if (value == current.data) {
                return count;
            } else if (value < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return count;
    }
}
