package com.github.chen0040.hackerrank.bits.lonelyinteger;


/**
 * Created by xschen on 10/8/2017.
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
      int a[] = new int[n];
      for(int a_i=0; a_i < n; a_i++){
         a[a_i] = in.nextInt();
      }
      int result = a[0];
      for(int i = 1; i < a.length; ++i) {
         result = result ^ a[i];
      }
      System.out.println(result);
   }
}

