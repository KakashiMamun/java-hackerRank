package com.github.chen0040.hackerrank.strings.anagrams;


/**
 * Created by xschen on 8/8/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
   public static int numberNeeded(String first, String second) {
      Map<Character, Integer> count1 = new HashMap<Character, Integer>();
      Map<Character, Integer> count2 = new HashMap<Character, Integer>();
      for(int i=0; i < first.length(); ++i) {
         char c = first.charAt(i);
         count1.put(c, count1.getOrDefault(c, 0) + 1);
      }
      for(int j=0; j < second.length(); ++j) {
         char c = second.charAt(j);
         count2.put(c, count2.getOrDefault(c, 0) + 1);
      }
      int result = 0;
      for(Map.Entry<Character, Integer> entry : count1.entrySet()) {
         char c = entry.getKey();
         int count = entry.getValue();
         if(!count2.containsKey(c)) {
            result+=count;
         } else if(count2.get(c).intValue() > count){
            result += (count2.get(c) - count);
         }
      }
      for(Map.Entry<Character, Integer> entry : count2.entrySet()) {
         char c = entry.getKey();
         int count = entry.getValue();
         if(!count1.containsKey(c)) {
            result += count;
         } else if(count1.get(c).intValue() > count) {
            result += (count1.get(c) - count);
         }
      }
      return result;
   }

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      String a = in.next();
      String b = in.next();
      System.out.println(numberNeeded(a, b));
   }
}
