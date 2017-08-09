package com.github.chen0040.hackerrank.heaps.medians;


/**
 * Created by xschen on 9/8/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

   private static void swim_min(int[] a, int k) {

      while(k > 1) {
         int parent = k / 2;
         if(a[parent] > a[k]) {
            exchange(a, parent, k);
            k = parent;
         } else {
            break;
         }
      }
   }

   private static void swim_max(int[] a, int k) {

      while(k > 1) {
         int parent = k / 2;
         if(a[parent] < a[k]) {
            exchange(a, parent, k);
            k = parent;
         } else {
            break;
         }
      }
   }

   private static void sink(int[] a, int k, int N) {
      k++;
      N++;
      while(k * 2 <= N) {
         int child = k * 2;
         if(child < N && a[child] < a[child-1]) {
            child++;
         }
         if(a[child-1] < a[k-1]) {
            exchange(a, child-1, k-1);
            k = child;
         } else {
            break;
         }
      }
   }

   private static void exchange(int[] a, int i, int j) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }

   private static void print(int[] a,int lo, int hi) {
      System.out.print("[");
      for(int i=lo; i <= hi; ++i) {
         if(i != lo) {
            System.out.print(", ");
         }
         System.out.print(a[i]);
      }
      System.out.println("]");
   }

   public static void main(String[] args) {
      Scanner in = new Scanner(Solution.class.getClassLoader().getResourceAsStream("heaps/medians/input04.txt"));
      Scanner out = new Scanner(Solution.class.getClassLoader().getResourceAsStream("heaps/medians/output04.txt"));
      int n = in.nextInt();
      int[] a = new int[n];
      double median = -1;
      int[] min_heap = new int[n];
      int[] max_heap = new int[n];
      int max_heap_index = 0;
      int min_heap_index = 0;
      for(int a_i=0; a_i < n; a_i++){
         if(a_i > 5) break;

         a[a_i] = in.nextInt();

         min_heap[++min_heap_index] = a[a_i];

         if(min_heap_index > max_heap_index+1) {

            swim_max(max_heap, max_heap_index);
         } else {
            min_heap[++min_heap_index] = a[a_i];
            swim_min(min_heap, min_heap_index);
         }

         if(a_i == 0) {
            median = (double)a[a_i];
         } else if(a_i == 1) {
            median = (a[0] + a[1]) / 2.0;
         } else {
            print(max_heap, 0, max_heap_index);
            print(min_heap, 0, min_heap_index);
            if(min_heap_index < max_heap_index) { // odd
               median = max_heap[1];
            } else if(min_heap_index > max_heap_index) {
               median = min_heap[1];
            } else { // even
               median = (max_heap[1] + min_heap[1]) / 2.0;
            }
         }
         System.out.printf("%.1f\t", median);
         System.out.println(out.next());

      }
   }
}
