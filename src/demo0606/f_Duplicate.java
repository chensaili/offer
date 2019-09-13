package demo0606;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * length是array的长度
 */
public class f_Duplicate {
    public static void main(String[] args) {
        int[]nums={5,3,1,0,2,5,3};
        int length=7;
        int[]d=new int[1];
        System.out.println(duplicate3(nums,length,d)+" "+d[0]);
    }
    //创建一个数组装原数组中元出现的次数，空间复杂度是N
    public static boolean duplicate1(int[]numbers,int length,int [] duplication){
        //判断数组里的元素是否符合题意，即大小位于0~n-1之间
        for(int i=0;i<length;i++){
            if(numbers[i]>=length||numbers[i]<0){
                return false;
            }
        }
        int[]arr=new int[length];
        for(int i=0;i<length;i++){
            arr[numbers[i]]++;
        }
        for(int i=0;i<length;i++){
            if(arr[i]>1){
                //注意赋值的是i
                duplication[0]=i;
                return true;
            }
        }
        return false;
    }
    //创建一个布尔数组，若元素出现，那么就把相应位置改为true
    public static boolean duplicate2(int[]numbers,int length,int [] duplication){
        boolean[]k=new boolean[length];
        for(int i=0;i<length;i++){
            if(k[numbers[i]]==true){
                duplication[0]=numbers[i];
                return true;
            }
            k[numbers[i]]=true;
        }
        return false;
    }
    //当一个数字被访问过后，可以设置对应位上的数 + n，之后再遇到相同的数时，会发现对应位上的数已经大于等于n了，那么直接返回这个数即可
    public static boolean duplicate3(int[]numbers,int length,int [] duplication){
        for(int i=0;i<length;i++){
            int index=numbers[i];
            if(index>=length){
                index=index-length;
            }
            if(numbers[index]>=length){
                duplication[0]=index;
                return true;
            }
            numbers[index]=numbers[index]+length;

        }
       return false;
    }
}
