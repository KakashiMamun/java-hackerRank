package com.github.chen0040.hackerrank.arrays.leftrotation;


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
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int k = in.nextInt();
      int a[] = new int[n];
      for(int a_i=0; a_i < n; a_i++){
         a[a_i] = in.nextInt();
      }
      if(k > n) {
         k %= n;
      }
      for(int i = 0; i < n; ++i) {
         int j = (i + k) % n;
         if(i != 0) {
            System.out.print(" ");
         }
         System.out.print(a[j]);
      }
      System.out.println();
   }
}
