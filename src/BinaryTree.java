public class BinaryTree {

  private Node root;


    private Node addElement(Node current, int value){
        if(current == null){
            return new Node(value);
        }
        if (value < current.getValue()){
            current.setLeft(addElement(current.getLeft(), value));
        }else if (value > current.getValue()){
            current.setRight(addElement(current.getRight(),value));
        }else{
            return current;
        }
        return current;
    }

    public void add(int value){
        root = addElement(root,value);
    }


    private boolean containsNode(Node current, int value){
        if(current == null){
            return false;
        }
        if(value == current.getValue()){
            return true;
        }
        return value < current.getValue()
                ? containsNode(current.getLeft(), value)
                : containsNode(current.getRight(),value);
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }

    public boolean contains(int value){
        return containsNode(root, value);
    }


}
