package demo0603;

/**
 * 只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 空间换时间解法，假设一个数组存储好已经排序好的丑数，那么一个新的丑数的产生必定是数组里面的数乘以2,3或者乘以5
 */
public class c_GetUglyNumber {
    public static void main(String[] args) {
        System.out.println(getUglyNumber(7));
    }
    public static int getUglyNumber(int index){
        if(index<=0){
            return 0;
        }
        //1-7都是丑数
        if(index<7){
            return index;
        }
        //创建一个数组用来装丑数
        int[]res=new int[index];
        res[0]=1;//第一个丑数是1；
        int t2=0;
        int t3=0;
        int t5=0;
        for(int i=1;i<index;i++){
            res[i]=Math.min(res[t2]*2,Math.min(res[t3]*3,res[t5]*5));
            if(res[i]==res[t2]*2){
                t2++;
            }
            if(res[i]==res[t3]*3){
                t3++;
            }
            if(res[i]==res[t5]*5){
                t5++;
            }
        }
        return res[index-1];
    }
}
