package com.github.chen0040.hackerrank.brackets.balancedbrackets;


/**
 * Created by xschen on 8/8/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

   public static boolean isBalanced(String expression) {
      Stack<Character> stack = new Stack<Character>();
      for(int i = 0; i < expression.length(); ++i) {
         char c = expression.charAt(i);
         if("{[(".indexOf(c) != -1) {
            stack.push(c);
         } else {
            if(stack.isEmpty()) return false;
            char c2 = stack.pop();
            if(c2 == '{' && c != '}') return false;
            if(c2 == '(' && c != ')') return false;
            if(c2 == '[' && c != ']') return false;
         }
      }
      return stack.isEmpty();
   }

   public static void main(String[] args) {
      Scanner in = new Scanner(Solution.class.getClassLoader().getResourceAsStream("stacks.balancedbrackets/input05.txt"));
      Scanner out = new Scanner(Solution.class.getClassLoader().getResourceAsStream("stacks.balancedbrackets/output05.txt"));
      int t = in.nextInt();
      for (int a0 = 0; a0 < t; a0++) {
         String expression = in.next();
         String my = isBalanced(expression) ? "YES" : "NO";
         String their = out.next();
         if(!my.equals(their)){
            System.out.println("wrong ans: " + my + " != " + their + " given " + expression);
            break;
         }
      }
   }
}
