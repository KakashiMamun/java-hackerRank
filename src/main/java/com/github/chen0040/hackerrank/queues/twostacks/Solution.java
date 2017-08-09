package com.github.chen0040.hackerrank.queues.twostacks;


/**
 * Created by xschen on 9/8/2017.
 *
 * link: https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
   public static class MyQueue<T> {
      Stack<T> stack1 = new Stack<T>();
      Stack<T> stack2 = new Stack<T>();

      public void enqueue(T value) { // Push onto newest stack
         stack1.push(value);
      }

      public T peek() {
         if(stack2.isEmpty()) {
            while(!stack1.isEmpty()){
               stack2.push(stack1.pop());
            }
         }
         return stack2.peek();
      }

      public T dequeue() {
         if(stack2.isEmpty()){
            while(!stack1.isEmpty()) {
               stack2.push(stack1.pop());
            }
         }
         return stack2.pop();
      }
   }


   public static void main(String[] args) {
      MyQueue<Integer> queue = new MyQueue<Integer>();

      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();

      for (int i = 0; i < n; i++) {
         int operation = scan.nextInt();
         if (operation == 1) { // enqueue
            queue.enqueue(scan.nextInt());
         } else if (operation == 2) { // dequeue
            queue.dequeue();
         } else if (operation == 3) { // print/peek
            System.out.println(queue.peek());
         }
      }
      scan.close();
   }
}
