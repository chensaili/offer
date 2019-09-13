package demo0530;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
 */
public class b_MoreThanHalfNum {
    public static void main(String[] args) {
        int[]array={4,1,2,4,2,4};
        System.out.println(findNum(array));
    }
    //复杂度为N^2
    /*public static int findNum(int[]array){
        //先排序
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        //如果一个数字出现的次数多于一半，那么肯定是位于中间的数字
        int count=0;
        int mid=array[array.length/2];
        for(int i=0;i<array.length;i++){
            if(array[i]==mid){
                count++;
            }
        }
        return count>array.length/2?mid:0;
    }*/
    /**
     * 采用阵地攻守思想：
     * 第一个数字作为第一个士兵，守阵地；count = 1；遇到相同元素，count++;遇到不相同元素，即为敌人，同归于尽,count--；
     * 当遇到count为0的情况，又以新的i值作为守阵地的士兵，继续下去，到最后还留在阵地上的士兵，有可能是主元素。
     * 复杂度为N
     */
    public static int findNum(int[]array){
        int len=array.length;
        if(len<=0||array==null){
            return 0;
        }
        //取第一个元素为士兵
        int result=array[0];
        int times=1;
        for(int i=1;i<len;i++){
            if(times==0){
                result=array[i];
                times=1;
            }else {
                if(array[i]==result){
                    times++;
                }else {
                    times--;
                }
            }
        }
        //再加一次循环，记录这个士兵的个数看是否大于数组一半。
        times=0;
        for(int i=0;i<len;i++){
            if(result==array[i]){
                times++;
            }
        }
        if(times*2<=len){
            result=0;
        }
        return result;
    }
}
