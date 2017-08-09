package com.github.chen0040.hackerrank.bfs.shortestpaths;


/**
 * Created by xschen on 9/8/2017.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * link: https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem
 */
public class Solution {
   public static class Graph {
      int V;
      List<Integer>[] adj;

      public Graph(int size) {
         V = size;
         adj = (List<Integer>[])new List[size];
         for(int i=0; i < size; ++i) {
            adj[i] = new ArrayList<Integer>();
         }
      }

      public void addEdge(int first, int second) {
         adj[first].add(second);
         adj[second].add(first);
      }

      public int[] shortestReach(int startId) { // 0 indexed
         Queue<Integer> queue = new LinkedList<Integer>();
         boolean[] marked = new boolean[V];
         queue.add(startId);
         int[] distances = new int[V];
         for(int v = 0; v < V; ++v) {
            distances[v] = Integer.MAX_VALUE / 2;
         }
         distances[startId] = 0;
         while(!queue.isEmpty()) {
            int v = queue.remove();
            marked[v] = true;
            List<Integer> adj_v = adj[v];
            for(Integer w : adj_v) {
               if(distances[w] > distances[v] + 6) {
                  distances[w] = Math.max(0, distances[v]) + 6;
                  queue.add(w);
               }
            }
         }

         distances[startId] = -1;

         for(int v = 0; v < V; ++v) {
            if(distances[v] == Integer.MAX_VALUE / 2) {
               distances[v] = -1;
            }
         }

         return distances;
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(Solution.class.getClassLoader().getResourceAsStream("bfs/shortestpaths/input06.txt"));
      Scanner out = new Scanner(Solution.class.getClassLoader().getResourceAsStream("bfs/shortestpaths/output06.txt"));

      int queries = scanner.nextInt();

      for (int t = 0; t < queries; t++) {

         // Create a graph of size n where each edge weight is 6:
         Graph graph = new Graph(scanner.nextInt());
         int m = scanner.nextInt();

         // read and set edges
         for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;

            // add each edge to the graph
            graph.addEdge(u, v);
         }

         // Find shortest reach from node s
         int startId = scanner.nextInt() - 1;
         int[] distances = graph.shortestReach(startId);

         for (int i = 0; i < distances.length; i++) {
            if (i != startId) {
               int my = distances[i];
               int their = out.nextInt();
               System.out.print(my);
               System.out.print(" ");
               System.out.print(their);
               System.out.println();
               if(my != their) {
                  System.out.print("wrong!");
               }
            }
         }

      }

      scanner.close();
   }
}
