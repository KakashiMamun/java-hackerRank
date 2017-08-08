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


   public static void main(String[] args) {
      InputStream fin = Solution.class.getClassLoader().getResourceAsStream("tries/contacts/input01.txt");
      InputStream fout = Solution.class.getClassLoader().getResourceAsStream("tries/contacts/output01.txt");
      Scanner out = new Scanner(fout);
      Scanner in = new Scanner(fin);
      TernaryTries trie = new TernaryTries();
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
               System.out.println("wrong ans: " + expected + " != " + ans +" given " + contact);
               break;
            } else {
               System.out.println(expected);
            }
         }
      }
   }
}
