package com.trees;

public class PreOrderTraversal {

    class Node{
        Node left;
        Node right;
        int data;
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
            node.data = data;
            node.left = node.right = null;
            return node;
        }
    }

    public static void main(String[] args) {
        BST bst = new PreOrderTraversal().new BST();
        Node root = null; 

        root = bst.addNode(root, 3);
        root = bst.addNode(root, 2);        
        root = bst.addNode(root, 6);
        root = bst.addNode(root, 25);
        root = bst.addNode(root, 5);
        root = bst.addNode(root, 8);        
        preOrderPrint(root);
    }
        
        
    public static void preOrderPrint(Node root) {
      if(root == null) return;
        System.out.print(root.data+" --> ");
        preOrderPrint(root.left);
        preOrderPrint(root.right);

    }
}
