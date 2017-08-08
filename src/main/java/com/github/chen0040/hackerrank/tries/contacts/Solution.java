package com.github.chen0040.hackerrank.tries.contacts;


/**
 * Created by xschen on 8/8/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
   public final static int R = 256;
   public static class Node {
      boolean bit;
      Map<Character, Node> nodes = new HashMap<>();
   }

   public static class Trie {
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

   public static void main(String[] args) {
      InputStream fin = Solution.class.getClassLoader().getResourceAsStream("tries/contacts/input03.txt");
      InputStream fout = Solution.class.getClassLoader().getResourceAsStream("tries/contacts/output03.txt");
      Scanner out = new Scanner(fout);
      Scanner in = new Scanner(fin);
      Trie trie = new Trie();
      int n = in.nextInt();
      for(int a0 = 0; a0 < n; a0++){
         String op = in.next();
         String contact = in.next();
         if(op.equals("add")) {
            trie.put(contact);
         } else if(op.equals("find")) {
            int expected = trie.count(contact);
            int ans = out.nextInt();
            if(expected != ans) {
               System.out.println("wrong ans: " + expected + " != " + ans);
               break;
            } else {
               System.out.println(expected);
            }
         }
      }
   }
}
