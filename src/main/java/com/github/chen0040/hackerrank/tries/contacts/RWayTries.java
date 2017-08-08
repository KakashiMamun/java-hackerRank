package com.github.chen0040.hackerrank.tries.contacts;


import java.util.HashMap;
import java.util.Map;


/**
 * Created by xschen on 8/8/2017.
 */
public class RWayTries {
   public final static int R = 256;
   public static class Node {
      boolean bit;
      Map<Character, Node> nodes = new HashMap<>();
   }


      Node root;

      public void put(String key){
         root = _put(root, key, 0);
      }

      private Node _put(Node x, String key, int d) {

         char c = key.charAt(d);
         if(x == null) {
            x = new Node();
         }
         if(d == key.length() - 1) {
            x.bit = true;
            return x;
         }

         x.nodes.put(c, _put(x.nodes.getOrDefault(c, null), key, d+1));
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
         if(d == prefix.length()) {
            return x;
         }

         char c = prefix.charAt(d);
         return _get(x.nodes.getOrDefault(c, null), prefix, d+1);
      }

      private int _count(Node x) {
         if(x == null) return 0;
         int count = 0;
         if(x.bit) {
            count++;
         }


         for(Map.Entry<Character, Node> entry : x.nodes.entrySet()) {
            count+=_count(entry.getValue());
         }
         return count;
      }


}
