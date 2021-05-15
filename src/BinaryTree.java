public class BinaryTree {

    private Node root;


    private Node addElement(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.getValue()) {
            current.setLeft(addElement(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setRight(addElement(current.getRight(), value));
        } else {
            return current;
        }
        return current;
    }

    public void add(int value) {
        root = addElement(root, value);
    }

    private boolean containsNode(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.getValue()) {
            return true;
        }
        return value < current.getValue()
                ? containsNode(current.getLeft(), value)
                : containsNode(current.getRight(), value);
    }

    public boolean contains(int value) {
        return containsNode(root, value);
    }

    private Node deleteNode(Node current, int value) {
        if (current == null)
            return null;

        if (value == current.getValue()) {
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            } else if (current.getRight() == null) {
                return current.getLeft();
            } else if (current.getLeft() == null) {
                return current.getRight();
            }

            if (current.getLeft() != null && current.getRight() != null) {
                int smallestValue = findTheSmallestValueForDeletion(current.getRight());
                current.setValue(smallestValue);
                current.setRight(deleteNode(current.getRight(), smallestValue));
                return current;
            }

        } else if (value < current.getValue()) {
            current.setLeft(deleteNode(current.getLeft(), value));
            return current;

        } else {
            current.setRight(deleteNode(current.getRight(), value));
        }
        return current;
    }

    public void delete(int value) {
        root = deleteNode(root, value);
    }

    private int findTheSmallestValueForDeletion(Node root) {
        return root.getLeft() == null ? root.getValue() : findTheSmallestValueForDeletion(root.getLeft());
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            System.out.print(" " + node.getValue());
            traverseInOrder(node.getRight());
        }
    }

    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.getValue());
            traversePreOrder(node.getLeft());
            traversePreOrder(node.getRight());
        }
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }

    public Node getRoot() {
        return root;
    }
}
