package com.github.chen0040.hackerrank.recursion.fibonacci;


/**
 * Created by xschen on 9/8/2017.
 *
 * link: https://leetcode.com/problems/compare-version-numbers/description/
 */
import java.util.*;

public class Solution {

   public static int fibonacci(int n) {
      if(n <= 1) return n;
      return fibonacci(n-1) + fibonacci(n-2);
      // Complete the function.
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      scanner.close();
      System.out.println(fibonacci(n));
   }
}
