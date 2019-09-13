package demo0520fuxi;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class h_PrintMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
    }
    public static void printMatrix(int[][]matrix){
        int row1=0;//左上角元素的行
        int col1=0;//左上角元素的列
        int row2=matrix.length-1;//右下角元素的行
        int col2=matrix[0].length-1;//右下角元素的列
        while(row1<row2&&col1<col2){
            print(matrix,row1,col1,row2,col2);
            row1++;
            col1++;
            row2--;
            col2--;
        }
    }
    public static void print(int[][]matrix,int row1,int col1,int row2,int col2){
        int curRow=row1;
        int curCol=col1;
        if(row1==row2){
            //只有一行的情况
            for(int i=0;i<col2;i++){
                System.out.print(matrix[0][i]);
            }
        }else if(col1==col2){
            //只有一列的情况
            for(int i=0;i<row2;i++){
                System.out.print(matrix[i][0]);
            }
        }else {
            //多行多列的情况
            //从左往右打印
            while(curCol!=col2){
                System.out.print(matrix[row1][curCol]+" ");
                curCol++;
            }
            //从上往下打印
            while (curRow!=row2){
                System.out.print(matrix[curRow][col2]+" ");
                curRow++;
            }
            //从右往左打印
            while(curCol!=col1) {
                System.out.print(matrix[row2][curCol]+" ");
                curCol--;
            }
            //从下往上打印
            while(curRow!=row1) {
                System.out.print(matrix[curRow][col1]+" ");
                curRow--;
            }
        }
    }
}
