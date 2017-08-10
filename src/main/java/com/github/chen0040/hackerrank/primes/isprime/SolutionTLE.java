package com.github.chen0040.hackerrank.primes.isprime;


/**
 * Created by xschen on 10/8/2017.
 */
import java.util.*;


public class SolutionTLE {

   public static void main(String[] args) {
      Scanner in = new Scanner(SolutionTLE.class.getClassLoader().getResourceAsStream("primes/isprime/input07.txt"));
      int p = in.nextInt();
      int[] a = new int[p];
      for(int a0 = 0; a0 < p; a0++){
         int n = in.nextInt();
         a[a0] = n;
      }
      int max = Integer.MIN_VALUE;
      for(int i=0; i < p; ++i) {
         max = Math.max(max, a[i]);
      }

      boolean[] not_primes = new boolean[max+1];
      not_primes[1] = true;
      int upper = max;
      for(int i = 2; i < upper; ++i) {
         if(!not_primes[i]) {
            for(int j = 2; j < upper; ++j) {
               int k = i * j;
               if(k > max  || k < 0) break;
               not_primes[k] = true;
            }
         }
      }

      for(int i=0; i < a.length; ++i) {
         int val = a[i];
         System.out.println(not_primes[val] ? "Not prime" : "Prime");
      }
   }
}
