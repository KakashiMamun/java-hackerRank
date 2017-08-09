package com.github.chen0040.hackerrank.hashtables.ransomnotes;


/**
 * Created by xschen on 9/8/2017.
 *
 * link: https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 */
import java.util.*;

public class Solution {
   Map<String, Integer> magazineMap;
   Map<String, Integer> noteMap;

   private int getOrDefault(Map<String, Integer> map, String key, int defaultValue) {
      if(map.containsKey(key)) return map.get(key);
      return defaultValue;
   }

   public Solution(String magazine, String note) {
      magazineMap = new HashMap<String, Integer>();
      noteMap = new HashMap<String, Integer>();
      String[] magazine_words = magazine.split(" ");
      String[] note_words = note.split(" ");

      for(int i=0; i < magazine_words.length; ++i) {
         String word = magazine_words[i];
         magazineMap.put(word, getOrDefault(magazineMap, word, 0) + 1);
      }
      for(int i =0; i < note_words.length; ++i) {
         String word = note_words[i];
         noteMap.put(word, getOrDefault(noteMap, word, 0) + 1);
      }
   }

   public boolean solve() {
      for(Map.Entry<String, Integer> entry : noteMap.entrySet()) {
         String word = entry.getKey();
         if(!magazineMap.containsKey(word)) return false;
         if(magazineMap.get(word).intValue() < entry.getValue()) return false;
      }
      return true;
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int m = scanner.nextInt();
      int n = scanner.nextInt();

      // Eat whitespace to beginning of next line
      scanner.nextLine();

      Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
      scanner.close();

      boolean answer = s.solve();
      if(answer)
         System.out.println("Yes");
      else System.out.println("No");

   }
}
