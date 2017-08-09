package com.github.chen0040.hackerrank.binarysearch.icecreamparlor;


/**
 * Created by xschen on 9/8/2017.
 *
 * link: https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int t = in.nextInt();
      for(int a0 = 0; a0 < t; a0++){
         int m = in.nextInt();
         int n = in.nextInt();
         int a[] = new int[n];
         for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
         }

         Map<Integer, Integer> map = new HashMap<Integer, Integer>();
         for(int i=0; i < a.length; ++i) {
            int val = a[i];
            if(map.containsKey(val)) {
               System.out.println((map.get(val) + 1) + " " + (i+1));
               break;
            }
            int val_c = m - val;
            map.put(val_c, i);
         }
      }


   }
}

