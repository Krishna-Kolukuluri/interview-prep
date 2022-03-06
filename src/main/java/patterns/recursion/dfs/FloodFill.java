package patterns.recursion.dfs;

import java.util.Arrays;

/*
* https://leetcode.com/problems/flood-fill/
* An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].
To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of
the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color),
and so on. Replace the color of all of the aforementioned pixels with newColor.
Return the modified image after performing the flood fill.
* Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by
a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
* Example 2:
Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
Output: [[2,2,2],[2,2,2]]
* Constraints:
m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], newColor < 216
0 <= sr < m
0 <= sc < n
*
* */
public class FloodFill {
    /*
    * Complexity Analysis:
        Time Complexity: O(N), where N is the number of pixels in the image. We might process every pixel.
        Space Complexity: O(N), the size of the implicit call stack when calling dfs.
    * */
    private static boolean[][] visited;
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        visited = new boolean[image.length][image[0].length];
        int color = image[sr][sc];
        if(color != newColor){
            dfs(image, sr, sc, color, newColor);
        }
        return image;
    }
    public static void dfs(int[][] image, int r, int c, int color, int newColor){
        if(r<0 || c<0 || r>= image.length || c>= image[0].length){
            return;
        }
        if(visited[r][c]){
            return;
        }
        visited[r][c] = true;
        if(image[r][c] == color){
            image[r][c] = newColor;
        }else{
            return;
        }
        dfs(image, r-1, c,color, newColor);
        dfs(image, r, c-1, color, newColor);
        dfs(image, r+1, c, color, newColor);
        dfs(image, r, c+1, color, newColor);
    }

    public static void main(String[] args) {
        int[][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        image = floodFill(image, 1,1,2);
        Arrays.stream(image).forEach(num-> {
            System.out.println("[");
            Arrays.stream(num).forEach(val -> System.out.println(val));
            System.out.println("]");
        });
    }
}
