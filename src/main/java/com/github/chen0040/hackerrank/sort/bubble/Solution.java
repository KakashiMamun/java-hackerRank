package com.github.chen0040.hackerrank.sort.bubble;


/**
 * Created by xschen on 9/8/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

   private static void exchange(int[] a, int i, int j) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int a[] = new int[n];
      for(int a_i=0; a_i < n; a_i++){
         a[a_i] = in.nextInt();
      }
      int count = 0;
      boolean isSorted = false;
      while(!isSorted) {
         isSorted = true;
         for(int j=1; j < n; ++j) {
            if(a[j] < a[j-1]) {
               exchange(a, j, j-1);
               count++;
               isSorted = false;
            }
         }
      }
      System.out.println("Array is sorted in " + count + " swaps.");
      System.out.println("First Element: " + a[0]);
      System.out.println("Last Element: " + a[a.length-1]);
   }
}
