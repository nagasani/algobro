package com.trees;

public class BinaryTree {

    class Node {
        int data;
        Node left;
        Node right;        
    }

   class BST {
        public Node addNode(Node node, int data){
            if(node == null){
                return createNode(data);
            }
            if(data < node.data){
                node.left = addNode(node.left, data);
            }
            if(data > node.data){
                node.right = addNode(node.right, data);
            }
            return node;
        }

        public Node createNode(int data){
            Node node = new Node();
            node.left = null;
            node.right = null;
            node.data = data;
            return node;
        }
   }

    public static void main(String[] args){

        BST bst = new BinaryTree().new BST();
        Node root = null;
        root = bst.addNode(root, 7);//--> 1 call to addNode
        root = bst.addNode(root, 1);// --> 2 calls to addNode
        root = bst.addNode(root, 4);
        root = bst.addNode(root, 9);
        root = bst.addNode(root, 2);
        root = bst.addNode(root, 21);
        printTree2(root, "");
    }

    public static void printTree1(Node node, String prefix){
        if(node == null) return;
        System.out.println(prefix+node.data);
        printTree1(node.left, prefix+ " ");
        printTree1(node.right, prefix+ " ");
    }

    public static void printTree(Node node, int level) {
        if (node == null) return;
    
        // Print the right subtree first, moving it "up" in the output
        printTree(node.right, level + 1);
    
        // Print the current node
        System.out.println(" ".repeat(level * 4) + node.data);
    
        // Print the left subtree next, moving it "down" in the output
        printTree(node.left, level + 1);
    }

    public static void printTree2(Node node, String prefix) {
    if (node == null) {
        return;
    }

    System.out.println(prefix + node.data);
    printTree2(node.left, prefix + "  |---"); // Add branches for visualization
    printTree2(node.right, prefix + "  `---"); // Add branches for visualization
}
    
    
}
