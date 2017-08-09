package com.github.chen0040.hackerrank.dfs.connectedcells;


/**
 * Created by xschen on 9/8/2017.
 *
 * https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
   static boolean[] marked;
   static int[] id;
   static int count = 0;
   static int rowCount;
   static int colCount;
   static int cellCount;
   static List<Integer> regionSize;
   public static int getBiggestRegion(int[][] matrix) {
      rowCount = matrix.length;
      colCount = matrix[0].length;
      cellCount = rowCount * colCount;
      marked = new boolean[cellCount];
      id = new int[cellCount];
      count = 0;
      regionSize = new ArrayList<Integer>();

      for(int v = 0; v < cellCount; ++v) {
         if(matrix[v / colCount][v % colCount] == 1 && !marked[v]) {
            regionSize.add(0);
            dfs(matrix, v);
            count++;
         }
      }
      int maxRegionSize = 0;
      for(int i = 0; i < count; ++i){
         int size = regionSize.get(i);
         maxRegionSize = Math.max(maxRegionSize, size);
      }
      return maxRegionSize;
   }

   private static void dfs(int[][] matrix, int v) {
      marked[v] = true;
      id[v] = count;
      regionSize.set(count, regionSize.get(count)+1);
      int row = v / colCount;
      int col = v % colCount;
      for(int i=-1; i<=1; ++i) {
         for(int j=-1; j <= 1; ++j) {
            if(i==0 && j==0) continue;
            int row_i = row + i;
            int col_j = col + j;
            if(row_i < 0 || row_i > rowCount-1 || col_j < 0 || col_j > colCount-1) continue;
            int w = row_i * colCount + col_j;
            if(matrix[row_i][col_j] == 1 && !marked[w]) {
               dfs(matrix, w);
            }
         }
      }
   }



   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int m = in.nextInt();
      int grid[][] = new int[n][m];
      for(int grid_i=0; grid_i < n; grid_i++){
         for(int grid_j=0; grid_j < m; grid_j++){
            grid[grid_i][grid_j] = in.nextInt();
         }
      }
      System.out.println(getBiggestRegion(grid));
   }
}
