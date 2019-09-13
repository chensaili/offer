package demo0605;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class b_FindNumsAppearOnce {
    public static void main(String[] args) {
        System.out.println(findFirst(8));
    }
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null||array.length<2){
            return;
        }
        int temp=0;
        for(int i=0;i<array.length;i++){
            temp^=array[i];//消除数组里面出现两次的元素，得到两个只出现一次元素的异或值
        }
        //根据两个只出现一次的数字的异或结果找到第一个为1的位置
        int index=findFirst(temp);
        for(int i=0;i<array.length;i++){
            if(isBit(array[i],index)){
                num1[0]^=array[i];
            }else {
                num2[0]^=array[i];
            }
        }
    }
    //从左向右移动，获取第一个为1的位数（这个位数的第一位是最右边）
    public static int findFirst(int num){
        int index=0;
        while((num&1)==0&&index<32){//考虑int类型的取值范围，如果int化为二进制，最多32位
            num=num>>1;//将num右移一位
            ++index;
        }
        return index;//返回第一个为1的位数
    }
    //判断这个数字的第N位是不是1，如果是1就返回true
    public static boolean isBit(int num,int index){
        num=num>>index;
        return (num&1)==1;
    }
}