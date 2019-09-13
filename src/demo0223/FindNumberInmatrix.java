package demo0223;

public class FindNumberInmatrix {
    public static void main(String[] args) {
        int[][]array= {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int number=7;
        System.out.println(findNumber(array,number));
    }
    public static boolean findNumber(int[][]array,int number) {
        int curRow=0;//当前行
        int curCol=array[0].length-1;//当前列
        while(curRow<=array.length-1&&curCol>=0) {
            if(number>array[curRow][curCol]) {
                curRow++;
            }else if(number<array[curRow][curCol]) {
                curCol--;
            }else {
                return true;
            }
        }
        return false;
    }
}

