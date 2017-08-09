package com.github.chen0040.hackerrank.linkedlists.cycles;


/**
 * Created by xschen on 9/8/2017.
 */
public class DetectCycle {
   class Node {
      int data;
      Node next;
   }


   boolean hasCycle(Node head) {
      Node x = head;
      Node x2 = head;
      while(x2 != null && x != null) {
         x = x.next;
         if(x2.next != null) {
            x2 = x2.next.next;
         } else {
            x2 = x2.next;
         }
         if(x == x2) {
            break;
         }
      }

      return x2 != null;
   }
}
