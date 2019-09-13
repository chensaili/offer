package demo0516fuxi;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 解题思路：
 * （1）要充分利用题目的条件每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序
 *      从右上角第一个数字开始比较
 * （2）虽然这个题目遍历数组也可以完成，但是复杂度过高
 */
public class a_FindNumberInMatrix {
    public static void main(String[] args) {
        int[][]array= {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int number=7;
        System.out.println(isNumberExit(array,number));
    }
    public static boolean isNumberExit(int[][]arr,int number){
        int row=arr.length;//行数
        int curRow=0;//当前行
        int curCol=arr[0].length-1;
        while(curRow<=row-1&&curCol>=0) {
            if(arr[curRow][curCol]<number){
                curRow++;
            }else if(arr[curRow][curCol]>number){
                curCol--;
            }else {
                return true;
            }
        }
        return false;
    }
}
