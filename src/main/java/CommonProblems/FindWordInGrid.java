package CommonProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 After catching your classroom students cheating before, you realize your students are getting craftier and hiding words
 in 2D grids of letters. The word may start anywhere in the grid, and consecutive letters can be either immediately
 below or immediately to the right of the previous letter.

 Given a grid and a word, write a function that returns the location of the word in the grid as a list of coordinates.
 If there are multiple matches, return any one.

 grid1 = [
 ['c', 'c', 'x', 't', 'i', 'b'],
 ['c', 'c', 'a', 't', 'n', 'i'],
 ['a', 'c', 'n', 'n', 't', 't'],
 ['t', 'c', 's', 'i', 'p', 't'],
 ['a', 'o', 'o', 'o', 'a', 'a'],
 ['o', 'a', 'a', 'a', 'o', 'o'],
 ['k', 'a', 'i', 'c', 'k', 'i'],
 ]
 word1 = "catnip"
 word2 = "cccc"
 word3 = "s"
 word4 = "bit"
 word5 = "aoi"
 word6 = "ki"
 word7 = "aaa"
 word8 = "ooo"

 grid2 = [['a']]
 word9 = "a"

 find_word_location(grid1, word1) => [ (1, 1), (1, 2), (1, 3), (2, 3), (3, 3), (3, 4) ]
 find_word_location(grid1, word2) =>
 [(0, 1), (1, 1), (2, 1), (3, 1)]
 OR [(0, 0), (1, 0), (1, 1), (2, 1)]
 OR [(0, 0), (0, 1), (1, 1), (2, 1)]
 OR [(1, 0), (1, 1), (2, 1), (3, 1)]
 find_word_location(grid1, word3) => [(3, 2)]
 find_word_location(grid1, word4) => [(0, 5), (1, 5), (2, 5)]
 find_word_location(grid1, word5) => [(4, 5), (5, 5), (6, 5)]
 find_word_location(grid1, word6) => [(6, 4), (6, 5)]
 find_word_location(grid1, word7) => [(5, 1), (5, 2), (5, 3)]
 find_word_location(grid1, word8) => [(4, 1), (4, 2), (4, 3)]
 find_word_location(grid2, word9) => [(0, 0)]

 Complexity analysis variables:

 r = number of rows
 c = number of columns
 w = length of the word

 */
public class FindWordInGrid {
    public static void main(String[] argv) {
        char[][] grid1 = {
                            {'c', 'c', 'x', 't', 'i', 'b'},
                            {'c', 'c', 'a', 't', 'n', 'i'},
                            {'a', 'c', 'n', 'n', 't', 't'},
                            {'t', 'c', 's', 'i', 'p', 't'},
                            {'a', 'o', 'o', 'o', 'a', 'a'},
                            {'o', 'a', 'a', 'a', 'o', 'o'},
                            {'k', 'a', 'i', 'c', 'k', 'i'}};
        String word1 = "catnip";
        String word2 = "cccc";
        String word3 = "s";
        String word4 = "bit";
        String word5 = "aoi";
        String word6 = "ki";
        String word7 = "aaa";
        String word8 = "ooo";

        char[][] grid2 = {{'a'}};
        String word9 = "a";
        System.out.println(findWords(grid1, word1));
        System.out.println(findWords(grid1, word2));
    }

    public static List<List<Integer>> answer = null;
    public static List<List<Integer>> findWords(char[][] matrix, String inputWord){
        for(int r=0; r<matrix.length; r++){
            for(int c =0; c< matrix[0].length; c++){
                List<List<Integer>> tempResult = new ArrayList<>();
                if(found(matrix, inputWord, r, c, tempResult, 0)){
                    return answer;
                }
            }
        }
        return Collections.emptyList();
    }

    public static boolean found(char[][] matrix, String inputWord, int r, int col, List<List<Integer>> result, int charIndex){
        if(r> matrix.length || col> matrix[0].length || r <0 || col <0){
            return false;
        }
        if(charIndex == inputWord.length()){
            answer = new ArrayList<>(result);
            return true;
        }
        if(matrix[r][col] != inputWord.charAt(charIndex)){
            return false;
        }
        result.add(new ArrayList<>(Arrays.asList(r, col)));
        if(found(matrix, inputWord, r+1, col, result, charIndex+1)){
            return true;
        }
        return found(matrix, inputWord, r, col+1, result, charIndex+1);
    }
}
