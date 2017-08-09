package com.github.chen0040.hackerrank.trees.isbst;


/**
 * Created by xschen on 9/8/2017.
 *
 * link: https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem
 */
public class Solution {
   class Node {
      int data;
      Node left;
      Node right;
   }

   boolean checkBST(Node root) {
      if(root == null) return true;
      if(root.left != null && max(root.left) >= root.data) return false;
      if(root.right != null && min(root.right) <= root.data) return false;

      return checkBST(root.left) && checkBST(root.right);
   }

   int max(Node x) {
      if(x == null) return Integer.MIN_VALUE;
      return Math.max(Math.max(x.data, max(x.left)), max(x.right));
   }

   int min(Node x) {
      if(x == null) return Integer.MAX_VALUE;
      return Math.min(Math.min(x.data, min(x.left)), min(x.right));
   }

}
