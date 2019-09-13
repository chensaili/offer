package dynamic;

import java.util.Scanner;

/**
 * 01背包问题练习
 * 输入：
 *    int knapsackMaxWeight = 5;
 *    int profit []= {200,240,140,​​150};
 *    int weight []= {1，3，2，5};
 * 输出：
 *    通过选择权重为1和3的项目，我们得到的最大利润是440。
 */
public class Demo4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            //输入最大可以承受的重量
            int maxWeight=sc.nextInt();
            //输入种类数
            int n=sc.nextInt();
            //不同种类的利润
            int[]profit=new int[n+1];
            //不同种类的重量
            int[]weight=new int[n+1];
            //输入利润和重量
            for(int i=1;i<=n;i++){
                profit[i]=sc.nextInt();
                weight[i]=sc.nextInt();
            }
            //用来存放结果
            int[][]res=new int[n+1][maxWeight+1];
            for(int j=1;j<=maxWeight;j++){
                 for(int i=1;i<=n;i++){
                    if(j<weight[i]){
                        //如果不可以进
                        res[i][j]=res[i-1][j];
                    }else {
                        if(res[i-1][j]>res[i-1][j-weight[i]]+profit[i]){
                            //如果可以进，但进去之后总结果比不进去少
                            res[i][j]=res[i-1][j];
                        }else {
                            //如果可以进，且进去之后总结果比不进去多
                            res[i][j]=res[i-1][j-weight[i]]+profit[i];
                        }
                    }
                }
            }
            System.out.println(res[n][maxWeight]);
        }
    }
}
