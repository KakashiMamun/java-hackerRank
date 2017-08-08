package com.github.chen0040.hackerrank.tries.contacts;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 8/8/2017.
 */
public class TernaryTries {

   public static class Node {
      char key;
      Node left;
      Node right;
      Node mid;
      boolean value = false;

      public Node(char key) {
         this.key = key;
      }
   }

      Node root;
      public void put(String key){
         root = _put(root, key, 0);
      }

      private Node _put(Node x, String key, int d) {

         if(d == key.length()){
            return x;
         }

         char c = key.charAt(d);
         if(x == null) {
            x = new Node(c);
         }
         int cmp = Character.compare(c, x.key);
         if(cmp < 0) {
            x.left = _put(x.left, key, d);
         } else if(cmp > 0) {
            x.right = _put(x.right, key, d);
         } else {
            if(d == key.length()-1) {
               x.value = true;
            }
            x.mid = _put(x.mid, key, d+1);
         }

         return x;

      }

      public int count(String prefix) {
         Node x = _get(root, prefix, 0);
         if(x == null) return 0;
         return _count(x);
      }

      private Node _get(Node x, String prefix, int d) {
         if(x == null) {
            return null;
         }

         char c = prefix.charAt(d);
         int cmp = Character.compare(c, x.key);
         if(cmp < 0){
            return _get(x.left, prefix, d);
         } else if(cmp > 0) {
            return _get(x.right, prefix, d);
         } else {
            if(d == prefix.length()-1) {
               return x;
            }
            return _get(x.mid, prefix, d+1);
         }
      }

      private int _count(Node x) {
         if(x == null) return 0;
         int count = 0;
         if(x.value) {
            count++;
         }

         return count + _count(x.left) + _count(x.right) + _count(x.mid);
      }
}
