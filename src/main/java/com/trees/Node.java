package com.trees;

import java.util.LinkedList;
import java.util.Queue;

//import javax.naming.LinkException;

public class Node {

    public int data;
    public Node left;
    public Node right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(8);
        root.right = new Node (4);
        Node leftNode = root.left;
        Node rightNode = root.right;
        leftNode.left = new Node(3);
        leftNode.right = new Node(7);
        rightNode.right = new Node(1);
        rightNode.right.left = new Node(6);
        printLevelOrderTraversal(root);
    }
        
        private static void printLevelOrderTraversal(Node root) {
           Queue<Node> queue = new LinkedList<>();
           queue.offer(root);

           while(!queue.isEmpty()){
            Node node = queue.poll(); //8

            System.out.print(node.data+ " --> ");

            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
            
           }
           
        }
}
