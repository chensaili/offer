package demo0308;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    public static void main(String[] args) {
        //int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
               // { 13, 14, 15, 16 } };
        int[][] matrix = {{1, 2, 3, 4, 5}};
       // int[][] matrix = {{1}};
        ArrayList<Integer> result = printMatrix(matrix);
        for (Integer in : result) {
            System.out.print(in + " ");
        }
    }
    static ArrayList<Integer> result = new ArrayList<Integer>();
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int startRow=0;
        int startCol=0;
        int endCol=matrix[0].length - 1;
        int endRow=matrix.length - 1;
        while(startRow<=endRow&&startCol<=endCol){
            print(matrix, startRow, startCol, endRow, endCol);
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
        return result;
    }
    public static void print(int[][] matrix, int startRow, int startCol, int endRow, int endCol) {
        if (startRow < endRow && startCol < endCol) {
            for (int j = startCol; j <= endCol; j++) {
                result.add(matrix[startRow][j]);
            }
            for (int i = startRow + 1; i <= endRow - 1; i++) {
                result.add(matrix[i][endCol]);
            }
            for (int j = endCol; j >= startCol; j--) {
                result.add(matrix[endRow][j]);
            }
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                result.add(matrix[i][startCol]);
            }
        } else if (startRow == endRow && startCol < endCol) {
            for (int j = startCol; j <= endCol; j++) {
                result.add(matrix[startRow][j]);
            }
        } else if (startRow < endRow && startCol == endCol) {
            for (int i = startRow; i <= endRow; i++) {
                result.add(matrix[i][endCol]);
            }
        } else if (startRow == endRow && startCol == endCol) {
            result.add(matrix[startRow][startCol]);
        } else {
            return;
        }
    }
}