package dynamic;

import java.util.Scanner;

/*
计算最少出列多少位同学，使得剩下的同学排成合唱队形
说明：
N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
动态规划
这里用到的求最长递增序列的方法看Demo6
 */
public class Demo5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            if (num <= 2) {
                System.out.println(0);
            }
            int[] members = new int[num];//存储每一个数据元素
            int[] left_queue = new int[num];//数据元素从左到右对应的最大递增子序列数
            int[] right_queue = new int[num];//数据元素从右到左对应的最大递增子序列数
            for (int i = 0; i < num; i++) {//初始化各个数组数据
                members[i] = in.nextInt();
                left_queue[i] = 1;
                right_queue[i] = 1;
            }
            //从左到右的最大递增序列
            for(int i=1;i<num;i++){
                for(int j=0;j<i;j++){
                    if(members[i]>members[j]&&left_queue[i]<left_queue[j]+1){
                        left_queue[i]=left_queue[j]+1;
                    }
                }
            }
            for(int i=0;i<left_queue.length;i++){
                System.out.print(left_queue[i]+"left  ");
            }
            //从右到左的最大递增序列
            for(int i=num-2;i>=0;i--){
                for(int j=num-1;j>i;j--){
                    if(members[i]>members[j]&&right_queue[i]<right_queue[j]+1){
                        right_queue[i]=right_queue[j]+1;
                    }
                }
            }
            for(int i=0;i<right_queue.length;i++){
                System.out.print(right_queue[i]+"right  ");
            }
            //寻找相加之后最大的值
            int max=0;
            for(int i=0;i<num;i++){
                if(left_queue[i]+right_queue[i]>max)
                    max=left_queue[i]+right_queue[i];
            }
            //总人数 - 该数所在队列人数+1 = 需要出队的人数
            System.out.println(num-max+1);
        }
    }
}
