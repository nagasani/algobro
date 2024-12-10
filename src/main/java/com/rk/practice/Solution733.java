package com.rk.practice;

public class Solution733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       
          int initialColor = image[sr][sc];
        if (initialColor != newColor) {
            dfs(image, sr, sc, initialColor, newColor);
        }
        return image;
        
     }

     private void dfs(int[][] image, int row, int col, int color, int newColor) {
        // Check for out of bounds or mismatched color
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != color) {
            return;
        }

        // Change the color
        image[row][col] = newColor;

        // Explore in all 4 directions
        dfs(image, row - 1, col, color, newColor); // Up
        dfs(image, row + 1, col, color, newColor); // Down
        dfs(image, row, col - 1, color, newColor); // Left
        dfs(image, row, col + 1, color, newColor); // Right
    }

 
}
