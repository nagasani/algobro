package com.trees;

public class InOderTraversal {

    class Node{
        int data;
        Node left;
        Node right;

    }

    class BST{

        public Node addNode(Node node, int data){

            if(node == null){
                return createNode(data);
            }
            if(data < node.data){
                node.left = addNode(node.left, data);
            }
            if(data> node.data){
                node.right = addNode(node.right, data);
            }
            return node;
        }

        public Node createNode(int data){
            Node node = new Node();
            node.data = data;
            node.left = null;
            node.right = null;
            return node;
        }

    }

    public static void main(String[] args) {
        BST bst = new InOderTraversal().new BST();
        Node root = null; 

        root = bst.addNode(root, 5);
        root = bst.addNode(root, 4);
        root = bst.addNode(root, 8);
        root = bst.addNode(root, 1);
        root = bst.addNode(root, 7);
        root = bst.addNode(root, 3);
        root = bst.addNode(root, 6);
        inOrderPrint(root);

    }

    public static void inOrderPrint(Node node){

        if(node == null) return;

        inOrderPrint(node.left);

        System.out.print(node.data+" --> ");

        inOrderPrint(node.right);

    }

}
