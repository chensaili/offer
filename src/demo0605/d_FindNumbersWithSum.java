package demo0605;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class d_FindNumbersWithSum {
    public static void main(String[] args) {
        int[]array={1,2,3,4,5,6,7};
        ArrayList<Integer>res=findNumbersWithSum(array,9);
        for(Integer in:res){
            System.out.println(in);
        }
    }
    /*public ArrayList<Integer> findNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer>res=new ArrayList<>();
        //设置两个指针
        int pmin=0;
        int pmax=1;
        int multipy=Integer.MAX_VALUE;//表示乘积
        for(pmin=0;pmin<pmax;pmin++) {
            for(pmax=1;pmax<array.length;pmax++) {
                if(array[pmin]+array[pmax]==sum) {
                    System.out.println("+");
                    int multi=array[pmin]*array[pmax];
                    if(multi<multipy){
                        res.add(array[pmin]);
                        res.add(array[pmax]);
                        multipy=multi;
                    }
                }
                if(array[pmin]+array[pmax]>sum) {
                    break;
                }
            }
        }
        return res;
    }*/
    public static ArrayList<Integer> findNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer>res=new ArrayList<>();
        int pMin=0;
        int pMax=array.length-1;
        while(pMax>pMin){
            if(array[pMin]+array[pMax]==sum){
                res.add(array[pMax]);
                res.add(array[pMin]);
                return res;
            }else if(array[pMin]+array[pMax]<sum){
                pMin++;
            }else{
                pMax--;
            }
        }
        return res;
    }
}
