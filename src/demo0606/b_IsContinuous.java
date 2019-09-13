package demo0606;

/**
 * 判断一组牌（5张牌）是否为顺子
 * 大\小王可以看成任何数字,并且A看作1,J为11,Q为12,K为13，0可以看成是任意数字
 */
public class b_IsContinuous {
    public static void main(String[] args) {

    }
    public static boolean isContinuous(int [] numbers){
        if(numbers.length==0){
            return false;
        }
        //用一个数组来表示所有的牌，大小王视为一张牌
        int[]array=new int[14];//A,2,3,4,5,6,7,8,9,10，J,Q,K，王
        int len=numbers.length;
        int max=-1;//用max记录最大值
        int min=14;//用min记录最小值
        for(int i=0;i<len;i++){
            array[numbers[i]]++;
            if(numbers[i]==0){
                continue;
            }
            //表示出现对子，那么肯定不是顺子了
            if(array[numbers[i]]>1){
                return false;
            }

            if(numbers[i]>max){
                max=numbers[i];
            }
            if(numbers[i]<min){
                min=numbers[i];
            }
        }
        //如果是顺子，那么最大值减最小值一定为5
        if(max-min<5){
            return true;
        }
        return false;
    }
}
