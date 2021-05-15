public class Main {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        addElementsToTree(bt);

        //System.out.println(bt);
        //System.out.println(bt.contains(111));
        //bt.delete(4);
        //System.out.println(bt);
        bt.traverseInOrder(bt.getRoot());
        System.out.println("\n");
        bt.traversePreOrder(bt.getRoot());

    }

    private static void addElementsToTree(BinaryTree tree){
        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(7);
        tree.add(9);
    }
}
