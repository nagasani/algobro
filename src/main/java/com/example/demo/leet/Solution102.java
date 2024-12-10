package com.example.demo.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution102 {
    
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);                        
        while(!queue.isEmpty()){
            int size = queue.size(); 
            List<Integer> levelList = new ArrayList<>();
            for(int i=0; i < size; i++){
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if(node.left != null) queue.add(node.left);  
                if(node.right != null) queue.add(node.right);
            } 
            System.out.println(levelList);
            result.add(levelList);
        }           
        return result;
    }

        public static void main(String[] args) {
            TreeNode root = new Solution102().new TreeNode(3);
            root.left = new Solution102().new TreeNode(9);
            root.right = new Solution102().new TreeNode(20);
            root.right.left = new Solution102().new TreeNode(15);
            root.right.right = new Solution102().new TreeNode(7);
            System.out.println("Hello");
            levelOrder(root);
        }
}
