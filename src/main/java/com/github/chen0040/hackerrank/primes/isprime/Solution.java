package com.github.chen0040.hackerrank.primes.isprime;


/**
 * Created by xschen on 10/8/2017.
 *
 * link: https://www.hackerrank.com/challenges/ctci-big-o/problem
 */
import java.util.Scanner;


public class Solution {

   public static void main(String[] args) {
      Scanner in = new Scanner(Solution.class.getClassLoader().getResourceAsStream("primes/isprime/input09.txt"));
      Scanner out = new Scanner(Solution.class.getClassLoader().getResourceAsStream("primes/isprime/output09.txt"));
      int p = in.nextInt();
      for(int a0 = 0; a0 < p; a0++){
         int n = in.nextInt();
         int upper = (int)Math.sqrt(n) + 1;
         if(n == 1) {
            System.out.println("Not prime");
         }
         else if(n == 2) System.out.println("Prime");
         else if(n % 2 == 0) System.out.println("Not prime");
         else {
            boolean prime = true;
            for(int i = 3; i <= upper; i+=2) {
               if(n % i == 0) {
                  prime = false;
                  break;
               }
            }
            if(prime) System.out.println("Prime");
            else System.out.println("Not prime");
         }
      }
   }
}
