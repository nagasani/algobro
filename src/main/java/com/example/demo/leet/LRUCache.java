package com.example.demo.leet;

import java.util.*;

public class LRUCache {
    private int capacity;
    private Map<Integer, Node> map;
    private DoublyLinkedList lst;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        lst = new DoublyLinkedList();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        lst.moveNodeToFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            lst.moveNodeToFront(node);
            return;
        }
        Node newNode = new Node(key, value);
        if(map.size() == capacity){
            map.remove(lst.getTailNode().key);  
            lst.removeLastNode();                                     
        }          
        lst.addNodeToFront(newNode);                
        map.put(key, newNode);
    }

    public class Node{
        int val;
        int key;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    public class DoublyLinkedList {
        private Node head;
        private Node tail;



        public void moveNodeToFront(Node node){
            // if(head == node){
            //     return;
            // }
            node.prev.next = node.next;
            //head.prev = null;            
            head = node;
        }

        public void removeLastNode(){
            tail = tail.prev;
            //tail.next = null;
        }

        public void addNodeToFront(Node node) { //(3:30, 2:20, 1:10, 
            
            if(head == null){
                head = node;
                tail = node;
                printNode();
                return;
            }
            head.prev = node;
            head = node;
            printNode();
        }

        public Node getTailNode(){
            return tail;
        }
         public void printNode(){
            Node temp = head;
            while(temp != null){
                System.out.println(temp.key + " " + temp.val);
                temp = temp.next;
            }
         }
    }


    public static void main(String[] args) {
        // Create an LRU Cache with a capacity of 3
        LRUCache lruCache = new LRUCache(3);

        // Add some key-value pairs
        lruCache.put(1, 10); // Cache: {1=10}
        lruCache.put(2, 20); // Cache: {1=10, 2=20}
        lruCache.put(3, 30); // Cache: {1=10, 2=20, 3=30}

        
        // Access elements
        System.out.println(lruCache.get(1)); // Output: 10, Cache: {2=20, 3=30, 1=10}

        // Add another element, causing the least recently used (key 2) to be evicted
        lruCache.put(4, 40); // Cache: {3=30, 1=10, 4=40}

        // Access elements to test eviction
        System.out.println(lruCache.get(1)); // Output: -1 (key 2 was evicted)
        System.out.println(lruCache.get(3)); // Output: 30, Cache: {1=10, 4=40, 3=30}

        // Add another element, causing another eviction
        lruCache.put(5, 50); // Cache: {4=40, 3=30, 5=50}

        // Access elements to verify the state of the cache
        System.out.println(lruCache.get(1)); // Output: -1 (key 1 was evicted)
        System.out.println(lruCache.get(4)); // Output: 40
        System.out.println(lruCache.get(5)); // Output: 50
    }
}  