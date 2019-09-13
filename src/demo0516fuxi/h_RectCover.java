package demo0516fuxi;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 当n大于3时，分为两种情况考虑：
 * 1：第一次摆放一块 2*1 的小矩阵，则摆放方法总共为f(target - 1)
 * 2：第一次摆放一块1*2的小矩阵，则摆放方法总共为f(target-2)，因为摆放了一块1*2的小矩阵，
 *    对应下方的1*2摆放方法就确定了，所以为f(targte-2)
 */
public class h_RectCover {
    public static void main(String[] args) {
        System.out.println(rectCover(3));
    }
    public static int rectCover(int target) {
        if(target<=0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        return rectCover(target-1)+rectCover(target-2);
    }
}
